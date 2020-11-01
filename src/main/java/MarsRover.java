public class MarsRover {

    private int x = 1;
    private int y = 1;
    private String heading = "N";


    public MarsRover() {
    }

    public MarsRover(String heading) {
        this.heading = heading;
    }

    public MarsRover(String heading, int x, int y) {
        this.heading = heading;
        this.x = x;
        this.y = y;
    }

    public String execute(java.lang.String commands) {
        switch(commands){
            case "M":
                executeMovement();
                return String.format("%d:%d:%s",this.x,this.y,this.heading);
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

    private void executeMovement() {
        switch (heading) {
            case "N":
                 this.y++;
                 break;
            case "E":
                this.x++;
                break;
            case "S":
                this.y--;
                break;
            case "W":
                this.x--;
                break;
            default:
                break;
        }
    }


}
