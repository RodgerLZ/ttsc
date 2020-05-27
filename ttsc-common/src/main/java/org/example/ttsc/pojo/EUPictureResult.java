package org.example.ttsc.pojo;

/**
 * 后台管理，上传图片的返回结果
 */
public class EUPictureResult {

    private int error;
    private String url;
    private String message;

    public EUPictureResult(int error, String url, String message) {
        this.error = error;
        this.url = url;
        this.message = message;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
