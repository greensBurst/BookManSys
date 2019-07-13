public class BbInfo {
    private int id;
    private String borrowtime;
    private String backtime;
    private String who;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
    }

    public String getBacktime() {
        return backtime;
    }

    public void setBacktime(String backtime) {
        this.backtime = backtime;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public String toString() {
        return "BbInfo{" +
                "id=" + id +
                ", borrowtime='" + borrowtime + '\'' +
                ", backtime='" + backtime + '\'' +
                ", who='" + who + '\'' +
                '}';
    }
}
