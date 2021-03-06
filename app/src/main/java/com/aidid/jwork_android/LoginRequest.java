package com.aidid.jwork_android;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;



import java.util.HashMap;
import java.util.Map;
/**
 * Class LoginRequest
 *
 * @author Bryan Oliver
 * @version 9.6.2021
 */

public class LoginRequest extends StringRequest {

    private static final String URL = "http://192.168.1.105:8080/jobseeker/login";
    private Map<String, String> params;

    /**
     * Login request constructor
     * @param email
     * @param password
     * @param listener
     */
    public LoginRequest(String email, String password, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }

    /**
     * Auth failure error
     * @return
     * @throws AuthFailureError
     */
    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}