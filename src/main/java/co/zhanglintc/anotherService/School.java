package co.zhanglintc.anotherService;

public class School {
    private String name;

    School() {
        name = "北京大学";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("School {name: %s}", name);
    }
}
