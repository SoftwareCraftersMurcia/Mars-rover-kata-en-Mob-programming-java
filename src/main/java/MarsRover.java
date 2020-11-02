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
        boolean noObstacleWasFound = true;

        for(String command:commandsArray) {
            if ("M".equals(command)) {
                boolean isThereAnObstacle =executeMovement();
                noObstacleWasFound = !isThereAnObstacle;
                if(isThereAnObstacle) break;
            } else if ("L".equals(command)) {
                executeTurnLeft();
            } else if ("R".equals(command)) {
                executeTurnRight();
            }
        }
        String formattedAnswer = noObstacleWasFound?"%d:%d:%s":"O:%d:%d:%s";
        return String.format(formattedAnswer,this.position.x,this.position.y,this.heading);
    }

    private boolean executeMovement() {
        Position newPosition = calculateNextPosition();
        Position wrappedAroundPosition = grid.wrapAcrossBoundsPosition(newPosition);
        if(wrappedAroundPosition!=null) newPosition = wrappedAroundPosition;
        boolean isThereAnObstacle =  grid.checkForObstacleAtPosition(newPosition);
        if(!isThereAnObstacle){
            this.position = newPosition;
        }
        return isThereAnObstacle;
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
