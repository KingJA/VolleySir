package sample.kingja.volleysir;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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
//        get();
        post();
    }

    private void get() {

        VolleySir.getDefault().load("http://10.1.6.107:8001/tagFilter", Request.Method.GET, Result.class, new
                Response.Listener<Result>() {
                    @Override
                    public void onResponse(Result response) {
                        Log.e(TAG, "onResponse: " + response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: " + error.toString());
            }
        }, this);
    }

    private void post() {
        Map<String, String> param = new HashMap<>();
        param.put("tagid", "666");
        param.put("status", "1");
        GsonRequest request = new GsonRequest.Builder<AddTag>()
                .setResponseType(AddTag.class)
                .setResponseListener(new Response.Listener<AddTag>() {
                    @Override
                    public void onResponse(AddTag response) {
                        Log.e(TAG, "【成功响应】: " + response.toString());
                    }
                })
                .setErrorListener(new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "【失败响应】: " + error.toString());
                    }
                })
                .setUrl("http://10.1.6.107:8001/tagFilter/update")
                .setMethod(Request.Method.POST)
                .setParam(param)
                .setTag(this)
                .build();
        request.setShouldCache(true);
        VolleySir.getDefault().addRequest(request);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VolleySir.getDefault().cancle(this);
    }
}
