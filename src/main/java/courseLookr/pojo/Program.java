package courseLookr.pojo;

public class Program {
    private final int id;
    private final String name;
    private final String acronym;

    public Program(int id, String name, String acronym) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }
}
