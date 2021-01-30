package DatabaseActions;

public class Charter {


    @Override
    public String toString() {
        return "Charter{" +
                "yacht_id=" + yacht_id +
                ", client_id=" + client_id +
                ", charter_daterange='" + charter_daterange + '\'' +
                ", status_id=" + status_id +
                '}';
    }

    int yacht_id;
    int client_id;
    String charter_daterange;
    int status_id;



    public Charter(int yacht_id, int client_id, String charter_daterange, int status_id) {
        this.yacht_id = yacht_id;
        this.client_id = client_id;
        this.charter_daterange = charter_daterange;
        this.status_id = status_id;
    }


    public int getYacht_id() {
        return yacht_id;
    }

    public void setYacht_id(int yacht_id) {
        this.yacht_id = yacht_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getCharter_daterange() {
        return charter_daterange;
    }

    public void setCharter_daterange(String charter_daterange) {
        this.charter_daterange = charter_daterange;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }


}
