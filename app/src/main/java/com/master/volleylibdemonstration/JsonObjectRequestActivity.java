package com.master.volleylibdemonstration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dhiraj on 20/2/18.
 */

public class JsonObjectRequestActivity extends AppCompatActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_layout);
        initViews();
    }

    private void initViews() {
        mSwipeRefreshLayout = findViewById(R.id.common_SwipeRefreshLayout);
        mRecyclerView = findViewById(R.id.common_recyclerView);
        mProgressBar = findViewById(R.id.progressBar);
        jsonObjRequestApiCall();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                jsonObjRequestApiCall();
            }
        });
    }

    private void jsonObjRequestApiCall() {
        mProgressBar.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setVisibility(View.GONE);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, ApiConstants.GET_COUNTRY_DATA_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mProgressBar.setVisibility(View.GONE);
                mSwipeRefreshLayout.setRefreshing(false);
                if (response != null) {
                    if (response.has("result")) {
                        if (response.optJSONObject("result").optJSONArray("list").length() > 0) {
                            mSwipeRefreshLayout.setVisibility(View.VISIBLE);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                            mRecyclerView.setLayoutManager(linearLayoutManager);
                            CustomDataAdapter customDataAdapter = new CustomDataAdapter(ApiResponseParser.parseData(response.optJSONObject("result").optJSONArray("list")));
                            mRecyclerView.setAdapter(customDataAdapter);
                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mProgressBar.setVisibility(View.GONE);
                mSwipeRefreshLayout.setRefreshing(false);
                String json;
                NetworkResponse response = error.networkResponse;
                int statusCode;
                if (response != null && response.data != null) {
                    json = new String(response.data);
                    statusCode = Integer.parseInt(trimMessage(json, "status_code"));
                    json = trimMessage(json, "message");
                    Log.d("ERROR", "" + statusCode + "," + json);
                } else {
                    Log.d("ERROR", "" + error.getLocalizedMessage());
                }
            }
        });
        RequestQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public String trimMessage(String json, String key) {
        String trimmedString;

        try {
            JSONObject obj = new JSONObject(json);
            trimmedString = obj.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return trimmedString;
    }
}
