package sample.kingja.volleysir;

/**
 * Description：TODO
 * Create Time：2018/5/12 10:04
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class HttpResult<T> {

    private Integer status;
    private  String message;
    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
