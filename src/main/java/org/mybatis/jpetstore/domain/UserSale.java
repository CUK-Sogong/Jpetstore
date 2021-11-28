package org.mybatis.jpetstore.domain;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserSale implements Serializable {
    private static final long serialVersionUID = -2254024898221315127L;

    private int sid;
    private String suserid;
    private String scategory;
    private String sdesc;
    private String sgender;
    private String sage;
    private int scharge;
    private BigDecimal sprice;
    private String sarea;
    private int sstatus;
    private String snote;
    private Date date;


    public int getsid() {
        return sid;
    }

    public void setsid(int sid) {
        this.sid = sid;
    }

    public String getsuserid() {
        return suserid;
    }

    public void setsuserid(String suserid) {
        this.suserid = suserid;
    }

    public String getScategory() {
        return scategory;
    }

    public void setScategory(String scategory) {
        this.scategory = scategory;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public int getScharge() {
        return scharge;
    }

    public void setScharge(int scharge) {
        this.scharge = scharge;
    }

    public String getSarea() {
        return sarea;
    }

    public void setSarea(String sarea) { this.sarea = sarea; }

    public int getSstatus() {
        return sstatus;
    }

    public void setSstatus(int sstatus) {
        this.sstatus = sstatus;
    }

    public String getSnote() {
        return snote;
    }

    public void setSnote(String snote) {
        this.snote = snote;
    }

    public BigDecimal getSprice() {
        return sprice;
    }

    public void setSprice(BigDecimal sprice) {
        this.sprice = sprice;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }
}
