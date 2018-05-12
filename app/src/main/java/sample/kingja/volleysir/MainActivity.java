package sample.kingja.volleysir;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.kingja.volleysir.GsonRequest;
import com.kingja.volleysir.VolleySir;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView tv_result;
    private TextView tv_method;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VolleySir.getDefault().init(this);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        tv_result = findViewById(R.id.tv_result);
        tv_method = findViewById(R.id.tv_method);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        VolleySir.getDefault().cancle(this);
    }

    public void doPost(View view) {
        progressDialog.show();
        tv_result.setText("");
        tv_method.setText("Post请求");
        Map<String, String> param = new HashMap<>();
        param.put("name", "postman");
        param.put("age", "19");
        GsonRequest request = new GsonRequest.Builder<Result>()
                .setResponseType(Result.class)
                .setResponseListener(new Response.Listener<Result>() {
                    @Override
                    public void onResponse(Result response) {
                        progressDialog.dismiss();
                        tv_result.setText(response.toString());

                    }
                })
                .setErrorListener(new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        tv_result.setText(error.toString());
                    }
                })
                .setUrl("http://10.1.3.189/api/post")
                .setMethod(Request.Method.POST)
                .setParam(param)
                .setTag(this)
                .build();
        request.setShouldCache(true);
        VolleySir.getDefault().addRequest(request);
    }

    public void doGet(View view) {
//        progressDialog.show();
//        tv_result.setText("");
//        tv_method.setText("Get请求");
//        VolleySir.getDefault().load("http://10.1.3.189/api/get?name=getman&age=16", Request.Method.GET, Result.class,
//                new Response.Listener<Result>() {
//                            @Override
//                            public void onResponse(Result response) {
//                                progressDialog.dismiss();
//                                tv_result.setText(response.toString());
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        progressDialog.dismiss();
//                        tv_result.setText(error.toString());
//                    }
//                }, this);

        progressDialog.show();
        Map<String, String> param = new HashMap<>();
        param.put("name", "getman");
        param.put("age", "11");
        GsonRequest request = new GsonRequest.Builder<Result>()
                .setResponseType(Result.class)
                .setResponseListener(new Response.Listener<Result>() {
                    @Override
                    public void onResponse(Result response) {
                        progressDialog.dismiss();
                        tv_result.setText(response.toString());

                    }
                })
                .setErrorListener(new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        tv_result.setText(error.toString());
                    }
                })
                .setUrl("http://10.1.3.189/api/get")
                .setMethod(Request.Method.GET)
                .setParam(param)
                .setTag(this)
                .build();
        VolleySir.getDefault().addRequest(request);
    }
}
