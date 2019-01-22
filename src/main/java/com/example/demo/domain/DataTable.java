package com.example.demo.domain;
import java.util.List;

/**
 * Created by WangXinbiao on 2019/01/04
 */

public class DataTable<T> {
    private List<T> data;
    private int iTotalDisplayRecords;
    private int iTotalRecords;
    private int sEcho;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public DataTable() {
    }

    public int getiTotalDisplayRecords() {
        return this.iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public int getiTotalRecords() {
        return this.iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public int getsEcho() {
        return this.sEcho;
    }

    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }
}
