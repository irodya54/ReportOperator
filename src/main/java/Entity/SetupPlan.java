package Entity;

import java.time.LocalTime;

public class SetupPlan {
    private String name;
    private Double timeSP;

    public SetupPlan() {
    }

    public SetupPlan(String name, Double timeSP) {
        this.name = name;
        this.timeSP = timeSP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTimeSP() {
        return timeSP;
    }

    public void setTimeSP(Double timeSP) {
        this.timeSP = timeSP;
    }
}
