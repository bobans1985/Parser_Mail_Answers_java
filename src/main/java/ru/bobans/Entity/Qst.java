package ru.bobans.Entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;



/**
 * Created by boban on 12.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Qst
{
    private String waslead;

    public String getWaslead() { return this.waslead; }

    public void setWaslead(String waslead) { this.waslead = waslead; }

    private String qtext;

    public String getQtext() { return this.qtext; }

    public void setQtext(String qtext) { this.qtext = qtext; }

    private String filin;

    public String getFilin() { return this.filin; }

    public void setFilin(String filin) { this.filin = filin; }

    private String urlname;

    public String getUrlname() { return this.urlname; }

    public void setUrlname(String urlname) { this.urlname = urlname; }

    private int added;

    public int getAdded() { return this.added; }

    public void setAdded(int added) { this.added = added; }

    private String nick;

    public String getNick() { return this.nick; }

    public void setNick(String nick) { this.nick = nick; }

    private String brand;

    public String getBrand() { return this.brand; }

    public void setBrand(String brand) { this.brand = brand; }

    private String state;

    public String getState() { return this.state; }

    public void setState(String state) { this.state = state; }

    private int total_voted;

    public int getTotalVoted() { return this.total_voted; }

    public void setTotalVoted(int total_voted) { this.total_voted = total_voted; }

    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private int vip;

    public int getVip() { return this.vip; }

    public void setVip(int vip) { this.vip = vip; }

    private String polltype;

    public String getPolltype() { return this.polltype; }

    public void setPolltype(String polltype) { this.polltype = polltype; }

    private String anscnt;

    public String getAnscnt() { return this.anscnt; }

    public void setAnscnt(String anscnt) { this.anscnt = anscnt; }

    private String catname;

    public String getCatname() { return this.catname; }

    public void setCatname(String catname) { this.catname = catname; }

    private String cid;

    public String getCid() { return this.cid; }

    public void setCid(String cid) { this.cid = cid; }

    private String kpd;

    public String getKpd() { return this.kpd; }

    public void setKpd(String kpd) { this.kpd = kpd; }

    private String usrid;

    public String getUsrid() { return this.usrid; }

    public void setUsrid(String usrid) { this.usrid = usrid; }
}