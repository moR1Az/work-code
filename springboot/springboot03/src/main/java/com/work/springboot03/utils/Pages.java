package com.work.springboot03.utils;

import java.util.ArrayList;
import java.util.List;

public class Pages {

    private int currentPage; // 当前页
    private int pageSize; //页面容量
    private int totalCount; //总记录数
    private int totalPage; //总页数
    private int prePage; //上一页
    private int nextPage; //下一页

    private List<Integer> pageList;

    public List<Integer> getPageList() {
        pageList=new ArrayList<>();
        for (int i=1;i<=getTotalPage();i++){
            pageList.add(i);
        }
        return pageList;
    }

    public void setPageList(List<Integer> pageList) {
        this.pageList = pageList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    //计算总页数，总页数=总记录数/页面容量 （+1）
    public int getTotalPage() {
        if (getTotalCount()%getPageSize()==0){
            //判断总记录数是否能够完整显示
            totalPage=getTotalCount()/getPageSize();
        }else {
            totalPage=getTotalCount()/getPageSize()+1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    //计算上一页
    public int getPrePage() {
        if (getCurrentPage()<=1){
            prePage=1;
        }else {
            prePage=getCurrentPage()-1;
        }
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    //计算下一页
    public int getNextPage() {
        if (getCurrentPage()>=getTotalPage()){
            nextPage=getTotalPage();
        }else {
            nextPage=getCurrentPage()+1;
        }
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}
