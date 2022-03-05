import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

public class UserBehavior {
    @JsonFormat
    private String action;

    @JsonFormat
    private String vertex_id;

    @JsonFormat
    private int repNum;

    @JsonFormat
    private int objClass;

    @JsonFormat
    private long timeStamp;

    @JsonFormat
    private double latitude;

    @JsonFormat
    private double longitude;

    @JsonFormat
    private double speed;

    @JsonFormat
    private double nextNodeX;

    @JsonFormat
    private double nextNodeY;

    public UserBehavior() {
    }

    public UserBehavior(String action, String vertex_id, int repNum, 
    int objClass, long timeStamp, double latitude, double  longitude,
     double speed, double nextNodeX, double nextNodeY) {
        this.action = action;
        this.vertex_id = vertex_id;
        this.repNum = repNum;
        this.objClass = objClass;
        this.timeStamp = timeStamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.nextNodeX = nextNodeX;
        this.nextNodeY = nextNodeY;
    }
}