package sample.kingja.volleysir;

/**
 * Description:TODO
 * Create Time:2018/2/5 13:13
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Result {


    /**
     * status : 0
     * message : 操作成功
     * data : {"name":"kingja","age":18}
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
        /**
         * name : kingja
         * age : 18
         */

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "{" +
                    "name:'" + name + '\'' +
                    ", age:" + age +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "{" +
                "status:" + status +
                ", message:'" + message + '\'' +
                ", user:" + data +
                '}';
    }
}
