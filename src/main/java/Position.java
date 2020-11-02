class Position  {
    int x;
    int y;
    Position(int x,int y){
        this.x =x;
        this.y =y;
    }


    @Override
    public boolean equals(Object o){
        Position position = (Position)o;
        return position.x==this.x && position.y==this.y;
    }
}