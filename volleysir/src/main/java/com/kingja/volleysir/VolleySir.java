package com.kingja.volleysir;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

/**
 * Description:TODO
 * Create Time:2017/7/31 16:15
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class VolleySir {

    private RequestQueue mQueue;
    private static VolleySir mInstance;

    private VolleySir() {

    }

    public static VolleySir getDefault() {
        if (mInstance == null) {
            synchronized (VolleySir.class) {
                if (mInstance == null) {
                    mInstance = new VolleySir();
                }
            }
        }
        return mInstance;
    }

    public void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        mQueue = Volley.newRequestQueue(applicationContext);
    }

    public RequestQueue getRequestQueue() {
        return mQueue;
    }


    public void addRequest(Request request) {
        mQueue.add(request);
    }

    public void cancle(Object tag) {
        mQueue.cancelAll(tag);
    }

    public <T> void createRequest(String url, int method, Class<T> clazz, Response.Listener<T> listener, Response
            .ErrorListener errorListener, Object tag) {
        GsonRequest request = new GsonRequest.Builder<T>()
                .setResponseType(clazz)
                .setResponseListener(listener)
                .setErrorListener(errorListener)
                .setUrl(url)
                .setMethod(method)
                .build();
        request.setTag(tag);
        mQueue.add(request);
    }

    public <T> void createRequest(String url, Class<T> clazz, Response.Listener<T> listener, Response
            .ErrorListener errorListener, Object tag) {
        createRequest(url, Request.Method.POST, clazz, listener, errorListener, tag);
    }

}
