package com.example.smallapp;

import java.util.List;

public class ModelClssGetid {
    private List<ResponseBean> response;

    public List<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseBean> response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * skill : HTML,CSS,javaa,PHP
         * application_id : b3DjxXm6wyedvjgn3jvd7N2VAO1Jre
         * type : Full time
         * color : #47ede7
         * title : Education
         * source : 1
         * unique_source_id : null
         * last_date : 23-04-2021
         * organization_name : Ajay
         * logo : https://eycdn.ams3.digitaloceanspaces.com/test/images/organizations/logo/n06X3CGtUPP9UI64ABAK/fT6stwxyuGwj9aexFqxEcZXHsj3q1ptM/Y632Wx8amy3qdVmq0zJKl1JKzpXQPb..png
         * city : Bahbari Gaon
         * salary : ₹ 5000 p.m.
         */

        private String skill;
        private String application_id;
        private String type;
        private String color;
        private String title;
        private String source;
        private Object unique_source_id;
        private String last_date;
        private String organization_name;
        private String logo;
        private String city;
        private String salary;

        public String getSkill() {
            return skill;
        }

        public void setSkill(String skill) {
            this.skill = skill;
        }

        public String getApplication_id() {
            return application_id;
        }

        public void setApplication_id(String application_id) {
            this.application_id = application_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public Object getUnique_source_id() {
            return unique_source_id;
        }

        public void setUnique_source_id(Object unique_source_id) {
            this.unique_source_id = unique_source_id;
        }

        public String getLast_date() {
            return last_date;
        }

        public void setLast_date(String last_date) {
            this.last_date = last_date;
        }

        public String getOrganization_name() {
            return organization_name;
        }

        public void setOrganization_name(String organization_name) {
            this.organization_name = organization_name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }
    }
}
