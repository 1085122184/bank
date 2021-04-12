package com.example.bank.service.impl;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.ftp.Ftp;
import com.example.bank.dao.FjMapper;
import com.example.bank.entity.Fj;
import com.example.bank.service.FjService;
import com.example.bank.utils.MultipartFileToFile;
import org.apache.catalina.connector.ClientAbortException;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.net.ftp.FtpClient;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FjServiceImpl implements FjService {
    @Autowired
    FjMapper fjMapper;

    @Override
    public List<Fj> getFjList(String ywkey) {
        return fjMapper.selectByYwKey(ywkey);
    }

    @Override
    public Map<String, Object> saveFj(MultipartFile multipartFile,String path,String ywkey) {
        Map<String,Object> map = new HashMap<>();
        try(Ftp ftp = new Ftp("59.110.113.232",21,"user","user")) {
            File file = MultipartFileToFile.multipartFileToFile(multipartFile);
            String[] split = multipartFile.getOriginalFilename().split("\\.");
            String kzm = split.length > 0 ? split[split.length - 1]
                    : "unknow";// 扩展名
            String ccmc = StrUtil.uuid()+"."+kzm;
            ftp.upload(path,ccmc,file);
            Fj fj = new Fj();
            fj.setCcmc(ccmc);
            fj.setFilename(multipartFile.getOriginalFilename());
            fj.setWjdx(multipartFile.getBytes().length/1024);
            fj.setXdpath(path);
            fj.setYwkey(ywkey);
            fjMapper.insert(fj);
            map.put("success",true);
            map.put("msg","文件上传成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","文件上传失败！");
        }
        return map;
    }

    public void downloadWj(Integer id, HttpServletResponse response) throws IOException {
        Fj fj = fjMapper.selectByPrimaryKey(id);
        String filePath = downLoadFj(fj);

        try(FileInputStream in = new FileInputStream(filePath);
            BufferedInputStream br = new BufferedInputStream(in);
            OutputStream out = response.getOutputStream()){
            byte[] buf = new byte[1024];
            int len = 0;
            String fileName="";
            response.reset(); // 非常重要
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String((StrUtil.isBlank(fileName)?fj.getFilename():fileName).getBytes("gb2312"),"ISO8859-1"));
            while ((len = br.read(buf)) > 0)
                out.write(buf, 0, len);
        }catch (ClientAbortException c){
            c.printStackTrace();
            System.out.println("用户刷新浏览器导致连接丢失，写流失败！");
        }finally{
            MultipartFileToFile.delteTempFile(new File(filePath));
        }
    }


    private String downLoadFj(Fj fj) {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1);
        try(Ftp ftp = new Ftp("59.110.113.232",21,"user","user")) {
            ftp.download(fj.getXdpath(),fj.getCcmc(), FileUtil.file(path+fj.getCcmc()));
        }catch (Exception e){
         e.printStackTrace();
        }
        return path+fj.getCcmc();
    }

    public static void main(String[] args) {
        MultipartFileToFile.delteTempFile(new File("D:/workspace/study/bank/target/classes/63335910-097e-494d-b003-1ba055cd89d5.jpg"));
    }
}
