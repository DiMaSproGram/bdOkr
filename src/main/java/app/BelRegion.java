package app;

public class BelRegion {

    private Integer id;
    private String regionName;
    private String regionCenterName;
    private Double area;
    private Double popul;

    public BelRegion(Integer id, String regionName, String regionCenterName, Double area, Double popul) {
        this.id = id;
        this.regionName = regionName;
        this.regionCenterName = regionCenterName;
        this.area = area;
        this.popul = popul;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionCenterName() {
        return regionCenterName;
    }
    public void setRegionCenterName(String regionCenterName) {
        this.regionCenterName = regionCenterName;
    }

    public Double getArea() {
        return area;
    }
    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPopul() {
        return popul;
    }
    public void setPopul(Double popul) {
        this.popul = popul;
    }

    @Override
    public String toString() {
        return "BelRegion{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                ", regionCenterName='" + regionCenterName + '\'' +
                ", area=" + area +
                ", popul=" + popul +
                '}';
    }
}
