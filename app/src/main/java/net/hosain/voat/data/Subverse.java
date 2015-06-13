package net.hosain.voat.data;

import java.util.List;

public class Subverse {

    private List<DataEntity> data;
    private boolean success;

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

}
