package example.dao;

/**
 * @author 受人敬仰的Fm
 * @date 2019/3/15
 */
public class FlyId {
    private int id;
    private String takeoff;
    private String aerodrome;
    private String flight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public String getAerodrome() {
        return aerodrome;
    }

    public void setAerodrome(String aerodrome) {
        this.aerodrome = aerodrome;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }
}
