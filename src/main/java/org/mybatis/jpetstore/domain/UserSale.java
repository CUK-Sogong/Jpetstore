package org.mybatis.jpetstore.domain;

import net.sourceforge.stripes.action.FileBean;

import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;

public class UserSale implements Serializable {
    private static final long serialVersionUID = -2254024898221315127L;

    private int sid;
    private String suserid;
    private String scategory;
    private String sdesc;
    private String sgender;
    private int sage;
    private int scharge;
    private BigDecimal sprice;
    private String sarea;
    private FileBean simg1;
    private String simg2;
    private String simg3;
    private int sstatus;
    private String snote;


    public int getsid() {
        return sid;
    }

    public void setsid(int sid) { this.sid = sid; }

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

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
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

    public void setSarea(String sarea) {
        this.sarea = sarea;
    }

    public FileBean getSimg1() {
        return simg1;
    }

    public void setSimg1(FileBean simg1) {
        this.simg1 = simg1;
    }

    public String getSimg2() {
        return simg2;
    }

    public void setSimg2(String simg2) {
        this.simg2 = simg2;
    }

    public String getSimg3() {
        return simg3;
    }

    public void setSimg3(String simg3) {
        this.simg3 = simg3;
    }

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
}
