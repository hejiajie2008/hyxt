package com.jfxy.pojo;
/**
 * 礼品分类表
 * @author admin
 *
 */
public class Giftclass {
    private Integer giftclassid;

    private String giftclassname;

    private String giftclassremark;

    private Integer giftparentid;

    public Integer getGiftclassid() {
        return giftclassid;
    }

    public void setGiftclassid(Integer giftclassid) {
        this.giftclassid = giftclassid;
    }

    public String getGiftclassname() {
        return giftclassname;
    }

    public void setGiftclassname(String giftclassname) {
        this.giftclassname = giftclassname == null ? null : giftclassname.trim();
    }

    public String getGiftclassremark() {
        return giftclassremark;
    }

    public void setGiftclassremark(String giftclassremark) {
        this.giftclassremark = giftclassremark == null ? null : giftclassremark.trim();
    }

    public Integer getGiftparentid() {
        return giftparentid;
    }

    public void setGiftparentid(Integer giftparentid) {
        this.giftparentid = giftparentid;
    }
}