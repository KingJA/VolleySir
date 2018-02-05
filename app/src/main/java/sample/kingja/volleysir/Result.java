package sample.kingja.volleysir;

import java.util.List;

/**
 * Description:TODO
 * Create Time:2018/2/5 13:13
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Result {

    /**
     * status : 0
     * message : 请求完成
     * data : [{"tagId":9999,"tagDate":"2013-12-10 23:13:00","baseStation":484626,"content":"3LYQO0"}]
     */

    private int status;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * tagId : 9999
         * tagDate : 2013-12-10 23:13:00
         * baseStation : 484626
         * content : 3LYQO0
         */

        private int tagId;
        private String tagDate;
        private int baseStation;
        private String content;

        public int getTagId() {
            return tagId;
        }

        public void setTagId(int tagId) {
            this.tagId = tagId;
        }

        public String getTagDate() {
            return tagDate;
        }

        public void setTagDate(String tagDate) {
            this.tagDate = tagDate;
        }

        public int getBaseStation() {
            return baseStation;
        }

        public void setBaseStation(int baseStation) {
            this.baseStation = baseStation;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }


    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
