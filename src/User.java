public class User {
    private String username;
    private String passwd;
    private String identity;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
