package main;

import gameBoard.Grid;
import misc.Direction;
import misc.Move;
import misc.Position;
import player.Player;

public class Game {

    private Player player;
    private Grid myGrid;
    private boolean alive, reached;

    public Game(Player player, Grid grid) {
        this.player = player;
        this.myGrid = grid;
        alive = true;
        reached = false;
    }

    private void move(Position newPos, Move myMove) {
        switch (myMove) {
            case VALID:
                player.updatePosition(newPos);
                break;

            case OUTOFBOUND:
                break;

            case HITWALL:
                alive = player.hitWallEffect();
                break;
        }
        reached = myGrid.hasReached(player.position);
    }

    private String status() {
        if (reached) return "Player has reached at is  destination";
        else if (!alive) return "Player is dead!";
        else return player.position.toString();
    }

    public String moveUp() {
        if (alive && !reached) {
            Position newPos = player.move(Direction.UP);
            Move myMove = myGrid.isValid(newPos);
            move(newPos, myMove);
        }
        return status();
    }

    public String moveDown() {
        if (alive && !reached) {
            Position newPos = player.move(Direction.DOWN);
            Move myMove = myGrid.isValid(newPos);
            move(newPos, myMove);
        }
        return status();
    }
    public String moveRight() {
        if (alive && !reached) {
            Position newPos = player.move(Direction.RIGHT);
            Move myMove = myGrid.isValid(newPos);
            move(newPos, myMove);
        }
        return status();
    }

    public String moveLeft() {
        if (alive && !reached) {
            Position newPos = player.move(Direction.LEFT);
            Move myMove = myGrid.isValid(newPos);
            move(newPos, myMove);
        }
        return status();
    }
}
