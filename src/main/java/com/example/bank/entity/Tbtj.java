package com.example.bank.entity;

public class Tbtj {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TBTJ.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TBTJ.bt
     *
     * @mbggenerated
     */
    private String bt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TBTJ.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TBTJ.id
     *
     * @return the value of TBTJ.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TBTJ.id
     *
     * @param id the value for TBTJ.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TBTJ.bt
     *
     * @return the value of TBTJ.bt
     *
     * @mbggenerated
     */
    public String getBt() {
        return bt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TBTJ.bt
     *
     * @param bt the value for TBTJ.bt
     *
     * @mbggenerated
     */
    public void setBt(String bt) {
        this.bt = bt == null ? null : bt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TBTJ.url
     *
     * @return the value of TBTJ.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TBTJ.url
     *
     * @param url the value for TBTJ.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}