class Grid {
    int size  = 10;

    Grid(int size){
        this.size = size;
    }

    public Position wrapAcrossBoundsPosition(Position position){
        Position standardisedPosition = new Position((position.x + size) % size,(position.y+size) % size);
        return standardisedPosition;
    }

    public boolean checkForObstacleAtPosition(Position position) {
        return false;
    }
}
