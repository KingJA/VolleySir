package sample.kingja.volleysir;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.kingja.volleysir.GsonRequest;
import com.kingja.volleysir.VolleySir;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VolleySir.getDefault().init(this);
        setContentView(R.layout.activity_main);
        put();
    }

    private void get() {
        GsonRequest request = new GsonRequest.Builder<Result>()
                .setResponseType(Result.class)
                .setResponseListener(new Response.Listener<Result>() {
                    @Override
                    public void onResponse(Result response) {
                        Log.e(TAG, "onResponse: " + response.toString());
                    }
                })
                .setErrorListener(new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "onErrorResponse: " + error.toString());
                    }
                })
                .setUrl("http://10.1.6.107:3000/mock/11/tag")
                .setMethod(Request.Method.GET)
                .build();
        mQueue.add(request);
    }

    private void put() {
        Map<String, String> param = new HashMap<>();
        param.put("tagid", "10086");
        GsonRequest request = new GsonRequest.Builder<AddTag>()
                .setResponseType(AddTag.class)
                .setResponseListener(new Response.Listener<AddTag>() {
                    @Override
                    public void onResponse(AddTag response) {
                        Log.e(TAG, "onResponse: " + response.toString());
                    }
                })
                .setErrorListener(new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "onErrorResponse: " + error.toString());
                    }
                })
                .setUrl("http://10.1.6.107:3000/mock/11/tagFilter")
                .setMethod(Request.Method.PUT)
                .setParam(param)
                .build();
        VolleySir.getDefault().addRequest(request, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VolleySir.getDefault().cancle(this);
    }
}
