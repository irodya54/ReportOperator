package Entity;

public class Operator {
    private String name;
    private String secondName;
    private Shift shift;

    public Operator(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public Operator(String name, String secondName, Shift shift) {
        this.name = name;
        this.secondName = secondName;
        this.shift = shift;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
