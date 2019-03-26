package example.pojo;

/**
 * @author 受人敬仰的Fm
 * @date 2019/3/11
 * 航班类
 */
public class Flight {

    private String takeoff;//起飞机场
    private String aerodrome;//降落机场
    private String flightNum;//航班号

    public Flight() {
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

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }
}
