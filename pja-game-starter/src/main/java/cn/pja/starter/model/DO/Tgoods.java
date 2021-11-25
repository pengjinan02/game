package cn.pja.starter.model.DO;

import java.io.Serializable;

public class Tgoods implements Serializable {
    /**
     * 主键id
     */
    private String gid;

    /**
     * 商品名
     */
    private String gname;

    /**
     * 商品类型
     */
    private String gtype;

    /**
     * 描述
     */
    private String gdescribe;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 图片路径
     */
    private String src;

    /**
     * tgoods
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     * @return gid 主键id
     */
    public String getGid() {
        return gid;
    }

    /**
     * 主键id
     * @param gid 主键id
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 商品名
     * @return gname 商品名
     */
    public String getGname() {
        return gname;
    }

    /**
     * 商品名
     * @param gname 商品名
     */
    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    /**
     * 商品类型
     * @return gtype 商品类型
     */
    public String getGtype() {
        return gtype;
    }

    /**
     * 商品类型
     * @param gtype 商品类型
     */
    public void setGtype(String gtype) {
        this.gtype = gtype == null ? null : gtype.trim();
    }

    /**
     * 描述
     * @return gdescribe 描述
     */
    public String getGdescribe() {
        return gdescribe;
    }

    /**
     * 描述
     * @param gdescribe 描述
     */
    public void setGdescribe(String gdescribe) {
        this.gdescribe = gdescribe == null ? null : gdescribe.trim();
    }

    /**
     * 价格
     * @return price 价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 价格
     * @param price 价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 图片路径
     * @return src 图片路径
     */
    public String getSrc() {
        return src;
    }

    /**
     * 图片路径
     * @param src 图片路径
     */
    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }
}