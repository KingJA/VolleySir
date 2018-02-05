package sample.kingja.volleysir;

/**
 * Description:TODO
 * Create Time:2018/2/5 14:29
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class AddTag {


    /**
     * status : 0
     * message : 请求完成
     * data : {}
     */

    private int status;
    private String message;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
    }

    @Override
    public String toString() {
        return "AddTag{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
