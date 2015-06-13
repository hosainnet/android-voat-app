package net.hosain.voat.data;

import java.util.List;

public class Subverse {

    public static Subverse MAIN;

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

    public static DataEntity getThreadWithId(String id) {
        List<DataEntity> data = MAIN.data;
        for (int i = 0; i < data.size(); i++) {
            DataEntity dataEntity = data.get(i);
            if (Integer.toString(dataEntity.getId()) == id) {
                return dataEntity;
            }
        }
        return null;
    }

}
