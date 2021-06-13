package com.aidid.jwork_android;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
/**
 * Class RegisterRequest
 *
 * @author Bryan Oliver
 * @version 9.6.2021
 */

public class RegisterRequest extends StringRequest {
//192.168.1.103
//10.0.2.2
    private static final String URL = "http://192.168.1.105:8080/jobseeker/register";
    private Map<String, String> params;

    /**
     * Constructor for Register Request
     * @param name
     * @param email
     * @param password
     * @param listener
     */
    public RegisterRequest(String name, String email, String password, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);
    }

    /**
     * auth failure
     * @return
     * @throws AuthFailureError
     */
    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
