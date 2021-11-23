package apiResult;

public class Competition {
    public String id;
    public Area area;
    public String name;
    public String code;
    public String plan;
    public String lastUpdated;

    public String getId() {
        return id;
    }

    public Area getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getPlan() {
        return plan;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
