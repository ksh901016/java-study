package lamda.methodreferences;

public class Account {
    private String id;
    private String password;

    public Account(String id) {
        this.id = id;
    }

    public Account(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
