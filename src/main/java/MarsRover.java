public class MarsRover {

    private Position position = new Position(1,1);
    private String heading = "N";
    private Grid grid = new Grid(10);


    public MarsRover() {
    }

    public MarsRover(String heading) {
        this.heading = heading;
    }

    public MarsRover(String heading, int x, int y) {
        this.heading = heading;
        this.position = new Position(x,y);
    }

    public MarsRover(String heading, int x, int y, Grid grid) {
        this.heading = heading;
        this.position = new Position(x,y);
        this.grid = grid;
    }

    public String execute(java.lang.String commands) {
        String[] commandsArray = commands.split("(?!^)");

        for(String command:commandsArray) {
            switch (command) {
                case "M":
                    Position newPosition = calculateNextPosition();
                    Position validatedPosition = grid.wrapAcrossBoundsPosition(newPosition);
                    if(validatedPosition!=null)
                        this.position = validatedPosition;
                    break;
                case "L":
                    executeTurnLeft();
                    break;

                case "R":
                    executeTurnRight();
                    break;
            }
        }
        return String.format("%d:%d:%s",this.position.x,this.position.y,this.heading);
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

    private Position calculateNextPosition() {
        int x = this.position.x;
        int y = this.position.y;
        switch (heading) {
            case "N":
                 Position moveNorth = new Position(x,y+1);
                 return moveNorth;
            case "E":
                Position moveEast = new Position(x+1,y);
                return moveEast;
            case "S":
                Position moveSouth = new Position (x,y-1);
                return moveSouth;
            case "W":
                Position moveWest = new Position(x-1,y);
                return moveWest;
            default:
                return this.position;
        }
    }


}
