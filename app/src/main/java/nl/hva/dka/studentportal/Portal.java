package nl.hva.dka.studentportal;

public class Portal {
    private String mName;
    private String mUrl;

    public Portal(String mName, String mUrl) {
        this.mName = mName;
        this.mUrl = mUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
