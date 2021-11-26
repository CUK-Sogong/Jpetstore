package org.mybatis.jpetstore.domain;

import java.io.Serializable;
import java.util.Date;

public class UserAdopt implements Serializable {
    private static final long serialVersionUID = 7807012195727254896L;

    private int aid;
    private int asid;
    private String auserid;
    private String aarea;
    private int asalary;
    private String ahome;
    private int afamnum;
    private String apets;
    private int apetexp;
    private String anote;
    private int astatus;
    private Date date;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getAsid() {
        return asid;
    }

    public void setAsid(int asid) {
        this.asid = asid;
    }

    public String getAuserid() {
        return auserid;
    }

    public void setAuserid(String auserid) {
        this.auserid = auserid;
    }

    public String getAarea() {
        return aarea;
    }

    public void setAarea(String aarea) {
        this.aarea = aarea;
    }

    public int getAsalary() {
        return asalary;
    }

    public void setAsalary(int asalary) {
        this.asalary = asalary;
    }

    public String getAhome() {
        return ahome;
    }

    public void setAhome(String ahome) {
        this.ahome = ahome;
    }

    public int getAfamnum() {
        return afamnum;
    }

    public void setAfamnum(int afamnum) {
        this.afamnum = afamnum;
    }

    public String getApets() {
        return apets;
    }

    public void setApets(String apets) {
        this.apets = apets;
    }

    public int getApetexp() {
        return apetexp;
    }

    public void setApetexp(int apetexp) {
        this.apetexp = apetexp;
    }

    public String getAnote() {
        return anote;
    }

    public void setAnote(String anote) {
        this.anote = anote;
    }

    public int getAstatus() {
        return astatus;
    }

    public void setAstatus(int astatus) {
        this.astatus = astatus;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }
}
