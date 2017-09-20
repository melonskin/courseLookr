package courseLookr.pojo;

public class Package {
    private final int id;
    private final String name;
    private final int program_id;
    private final String no_required;

    public Package(int id, String name, String no_required, int program_id) {
        this.id = id;
        this.name = name;
        this.no_required = no_required;
        this.program_id = program_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNo_required() {
        return no_required;
    }

    public int getProgram_id() {
        return program_id;
    }
}
