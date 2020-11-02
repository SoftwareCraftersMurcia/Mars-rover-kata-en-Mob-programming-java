class Grid {
    int size  = 10;

    Grid(int size){
        this.size = size;
    }

    public Position wrapAcrossBoundsPosition(Position position){
        Position standardisedPosition = new Position(position.x % 10,position.y % 10);
        return standardisedPosition;
    }

}
