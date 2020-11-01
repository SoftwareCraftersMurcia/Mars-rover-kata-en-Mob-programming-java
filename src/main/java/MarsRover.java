public class MarsRover {

    private String heading;

    public MarsRover() {
        this.heading = "N";
    }

    public MarsRover(String heading) {
        this.heading = heading;
    }

    public String execute(java.lang.String commands) {
        switch(commands){
            case "M":
                switch (heading) {
                    case "N":
                return "1:2:N";
                    case "E":
                return "2:1:E";
                    case "S":
                return "1:0:S";
                    case "W":
                return "0:1:W";
                }
                break;
            case "L":
                switch (heading) {
                    case "N":
                        return "1:1:W";
                    case "E":
                        return "1:1:N";
                    case "S":
                        return "1:1:E";
                    case "W":
                        return "1:1:S";
                }

            case "R":

                switch (heading) {
                    case "N":
                        return "1:1:E";
                    case "E":
                        return "1:1:S";
                    case "S":
                        return "1:1:W";
                    case "W":
                        return "1:1:N";
                }
        }
        return "";
    }


}
