package com.example.bank.entity;

public class Zhxw {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZHXW.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZHXW.bt
     *
     * @mbggenerated
     */
    private String bt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ZHXW.zw
     *
     * @mbggenerated
     */
    private String zw;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZHXW.id
     *
     * @return the value of ZHXW.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZHXW.id
     *
     * @param id the value for ZHXW.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZHXW.bt
     *
     * @return the value of ZHXW.bt
     *
     * @mbggenerated
     */
    public String getBt() {
        return bt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZHXW.bt
     *
     * @param bt the value for ZHXW.bt
     *
     * @mbggenerated
     */
    public void setBt(String bt) {
        this.bt = bt == null ? null : bt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ZHXW.zw
     *
     * @return the value of ZHXW.zw
     *
     * @mbggenerated
     */
    public String getZw() {
        return zw;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ZHXW.zw
     *
     * @param zw the value for ZHXW.zw
     *
     * @mbggenerated
     */
    public void setZw(String zw) {
        this.zw = zw == null ? null : zw.trim();
    }
}