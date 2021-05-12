package com.example.smallapp;

import java.util.List;

public class SignLogResponce {
    /**
     * page : 1
     * per_page : 6
     * total : 12
     * total_pages : 2
     * data : [{"id":1,"name":"cerulean","year":2000,"color":"#98B2D1","pantone_value":"15-4020"},{"id":2,"name":"fuchsia rose","year":2001,"color":"#C74375","pantone_value":"17-2031"},{"id":3,"name":"true red","year":2002,"color":"#BF1932","pantone_value":"19-1664"},{"id":4,"name":"aqua sky","year":2003,"color":"#7BC4C4","pantone_value":"14-4811"},{"id":5,"name":"tigerlily","year":2004,"color":"#E2583E","pantone_value":"17-1456"},{"id":6,"name":"blue turquoise","year":2005,"color":"#53B0AE","pantone_value":"15-5217"}]
     * support : {"url":"https://reqres.in/#support-heading","text":"To keep ReqRes free, contributions towards server costs are appreciated!"}
     */

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private SupportBean support;
    private List<DataBean> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public SupportBean getSupport() {
        return support;
    }

    public void setSupport(SupportBean support) {
        this.support = support;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class SupportBean {
        /**
         * url : https://reqres.in/#support-heading
         * text : To keep ReqRes free, contributions towards server costs are appreciated!
         */

        private String url;
        private String text;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class DataBean {
        /**
         * id : 1
         * name : cerulean
         * year : 2000
         * color : #98B2D1
         * pantone_value : 15-4020
         */

        private int id;
        private String name;
        private int year;
        private String color;
        private String pantone_value;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getPantone_value() {
            return pantone_value;
        }

        public void setPantone_value(String pantone_value) {
            this.pantone_value = pantone_value;
        }
    }
}
