package sample.kingja.volleysir;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.kingja.volleysir.GRequest;

/**
 * Description:TODO
 * Create Time:2018/5/12 13:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class HttpRequest<T> extends GRequest<HttpResult<T>> {
    private static final String TAG = "HttpRequest";

    private HttpRequest(int method, String url, Response.ErrorListener listener, Class<HttpResult<T>> clazz) {
        super(method, url, listener, clazz);
    }

    @Override
    protected void deliverResponse(HttpResult<T> httpResult) {
        if (httpResult.getStatus() == 0) {
            super.deliverResponse(httpResult);
        }else{
            Log.e(TAG, "错误状态码: "+httpResult.getStatus()+" | "+httpResult.getMessage() );
        }

    }
}
