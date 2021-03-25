package com.example.bank.dao;

import com.example.bank.entity.Zygg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZyggMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZYGG
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZYGG
     *
     * @mbggenerated
     */
    int insert(Zygg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZYGG
     *
     * @mbggenerated
     */
    int insertSelective(Zygg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZYGG
     *
     * @mbggenerated
     */
    Zygg selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZYGG
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Zygg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZYGG
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Zygg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ZYGG
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Zygg record);

    List<Zygg> selectAll();
    List<Zygg> selectAllFour();
}