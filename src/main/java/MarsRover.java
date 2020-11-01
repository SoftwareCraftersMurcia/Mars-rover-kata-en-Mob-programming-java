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
                break;
            case "L":
                executeTurnLeft();
                break;

            case "R":
                executeTurnRight();
                break;
        }
        return String.format("%d:%d:%s",this.x,this.y,this.heading);
    }

    private void executeTurnRight() {
        switch (heading) {
            case "N":
                this.heading = "E";
                break;
            case "E":
                this.heading = "S";
                break;
            case "S":
                this.heading = "W";
                break;
            case "W":
                this.heading = "N";
                break;
        }
    }

    private void executeTurnLeft() {
        switch (this.heading) {
            case "N":
                this.heading = "W";
                break;
            case "E":
                this.heading = "N";
                break;
            case "S":
                this.heading = "E";
                break;
            case "W":
                this.heading = "S";
                break;
        }
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
