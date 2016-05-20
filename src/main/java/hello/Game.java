package hello;

public class Game {

    private Player myPlayer;
    private Grid myGrid;
    private boolean alive, reached;

    public Game(Player myPlayer, Grid myGrid) {
        this.myPlayer = myPlayer;
        this.myGrid = myGrid;
        alive = true;
        reached = false;
    }

    private void move(Position newPos, Move myMove) {
        switch (myMove) {
            case VALID:
                myPlayer.updatePosition(newPos);
                break;

            case OUTOFBOUND:
                break;

            case HITWALL:
                alive = myPlayer.hitWallEffect();
                break;
        }
        reached = myGrid.hasReached(myPlayer.position);
    }

    private String status() {
        if (reached) return "Player has reached at is  destination";
        else if (!alive) return "Player is dead!";
        else return myPlayer.position.toString();
    }

    public String moveUp() {
        if (alive && !reached) {
            Position newPos = myPlayer.move(Direction.UP);
            Move myMove = myGrid.isValid(newPos);
            move(newPos, myMove);
        }
        return status();
    }

    public String moveDown() {
        if (alive && !reached) {
            Position newPos = myPlayer.move(Direction.DOWN);
            Move myMove = myGrid.isValid(newPos);
            move(newPos, myMove);
        }
        return status();
    }
    public String moveRight() {
        if (alive && !reached) {
            Position newPos = myPlayer.move(Direction.RIGHT);
            Move myMove = myGrid.isValid(newPos);
            move(newPos, myMove);
        }
        return status();
    }

    public String moveLeft() {
        if (alive && !reached) {
            Position newPos = myPlayer.move(Direction.LEFT);
            Move myMove = myGrid.isValid(newPos);
            move(newPos, myMove);
        }
        return status();
    }
}
