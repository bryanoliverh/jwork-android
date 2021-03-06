package com.aidid.jwork_android;

import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.*;
/**
 * Class ApplyJobRequest
 *
 * @author Bryan Oliver
 * @version 9.6.2021
 */
public class ApplyJobRequest extends StringRequest {
    private static final String URL_Ewallet = "http://192.168.1.105:8080/invoice/createEWalletPayment";
    private static final String URL_Bank = "http://192.168.1.105:8080/invoice/createBankPayment";
    private Map<String, String> params;


    /**
     *handle the request function for ewallet payment in apply job
     * @param jobList
     * @param jobseekerId
     * @param refferalCode
     * @param listener
     */
    public ApplyJobRequest(String jobList, String jobseekerId, String refferalCode, Response.Listener<String> listener) {
        super(Method.POST, URL_Ewallet, listener, null);
        params = new HashMap<>();
        params.put("jobIdList", jobList);
        params.put("jobseekerId", jobseekerId);
        params.put("referralCode", refferalCode);
    }



    /**
     * //handle the request function for bank payment in apply job
     * @param jobList
     * @param jobseekerId
     * @param listener
     */
    public ApplyJobRequest(String jobList, String jobseekerId, Response.Listener<String> listener) {
        super(Method.POST, URL_Bank, listener, null);
        params = new HashMap<>();
        params.put("jobIdList", jobList);
        params.put("jobseekerId", jobseekerId);
        params.put("adminFee", "5000");
    }

    /**
     * 
     * @return
     * @throws AuthFailureError
     */
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
