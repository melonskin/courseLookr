package courseLookr.pojo;

public class Interest {
    private final int id;
    private final String name;

    public Interest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
