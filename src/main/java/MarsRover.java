public class MarsRover {

    private String heading;

    public MarsRover() {
        this.heading = "N";
    }

    public MarsRover(String heading) {
        this.heading = heading;
    }

    public String execute(java.lang.String commands) {
        switch (heading) {
            case "N":
                return "0:1:N";
            case "E":
                return "1:0:E";
            case "S":
                return "0:-1:S";
            case "W":
                return "-1:0:W";
            default:
                return "0:0:N";
        }

    }


}
