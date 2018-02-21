package com.master.volleylibdemonstration;

import org.json.JSONArray;

import java.util.ArrayList;

public class ApiResponseParser {

    public static ArrayList<CountryCodeModel.DataList> parseData(JSONArray jsonArray) {
        ArrayList<CountryCodeModel.DataList> dataModelArrayList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            CountryCodeModel.DataList dataList = new CountryCodeModel.DataList();
            dataList.setName(jsonArray.optJSONObject(i).optString("name"));
            dataList.setDial(jsonArray.optJSONObject(i).optInt("dial"));
            dataList.setPrice(jsonArray.optJSONObject(i).optDouble("price"));
            dataModelArrayList.add(dataList);
        }
        return dataModelArrayList;
    }
}
