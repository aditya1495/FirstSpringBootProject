package player;

import misc.Direction;
import misc.Position;
import misc.Power;

public class Player {

    private int[] dx, dy;
    private int health;
    public Position position;

    public Player(Power power) {
        this.position = new Position(0, 0);
        this.health = power.getHealth();
        int jump = power.getJump();
        this.dx = new int[]{-jump, jump, 0, 0};
        this.dy = new int[]{0, 0, jump, -jump};
    }

    public void updatePosition(Position position) {
        this.position = position;
    }

    public Position move(Direction dir) {
        Position res = new Position(0, 0);
        int dVec = 0;
        switch (dir) {
            case UP:
                dVec = 0;
                break;
            case DOWN:
                dVec = 1;
                break;
            case RIGHT:
                dVec = 2;
                break;
            case LEFT:
                dVec = 3;
                break;
        }
        res.setX(dx[dVec] + this.position.getX());
        res.setY(dy[dVec] + this.position.getY());
        return res;
    }

    public boolean hitWallEffect() {
        return (--this.health > 0);
    }
}
