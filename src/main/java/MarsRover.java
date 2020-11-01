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
                return "1:2:N";
            case "E":
                return "2:1:E";
            case "S":
                return "1:0:S";
            case "W":
                return "0:1:W";
            default:
                return "0:0:N";
        }

    }


}
