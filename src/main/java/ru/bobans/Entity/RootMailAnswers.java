package ru.bobans.Entity;

import java.util.ArrayList;

/**
 * Created by boban on 12.12.2016.
 */
public class RootMailAnswers
{
    private String status;

    public String getStatus() { return this.status; }

    public void setStatus(String status) { this.status = status; }

    private int fresh;

    public int getFresh() { return this.fresh; }

    public void setFresh(int fresh) { this.fresh = fresh; }

    private ArrayList<Qst> qst;

    public ArrayList<Qst> getQst() { return this.qst; }

    public void setQst(ArrayList<Qst> qst) { this.qst = qst; }
}
