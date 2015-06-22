package net.hosain.voat.data;

import java.util.List;

public class Subverse {

    public static Subverse MAIN;

    private List<Submission> data;
    private boolean success;

    public void setData(List<Submission> data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Submission> getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public static Submission getThreadWithId(String id) {
        List<Submission> data = MAIN.data;
        for (int i = 0; i < data.size(); i++) {
            Submission submission = data.get(i);
            if (Integer.toString(submission.getId()).equals(id)) {
                return submission;
            }
        }
        return null;
    }

}
