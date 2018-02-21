package com.master.volleylibdemonstration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CountryCodeModel {

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("result")
    public CountryCodeModel.Result result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {

        @SerializedName("list")
        public ArrayList<DataList> list = new ArrayList<>();

        public ArrayList<DataList> getList() {
            return list;
        }

        public void setList(ArrayList<DataList> list) {
            this.list = list;
        }
    }


    public static class DataList {
        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("dial")
        @Expose
        private int dial;

        @SerializedName("price")
        @Expose
        private double price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDial() {
            return dial;
        }

        public void setDial(int dial) {
            this.dial = dial;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }


}
