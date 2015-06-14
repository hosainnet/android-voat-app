package net.hosain.voat.data;

import java.util.List;

public class Discussion {

    private List<Comment> data;
    private boolean success;

    public void setData(List<Comment> data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Comment> getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }


}
