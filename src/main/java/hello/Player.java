package hello;
public class Player {

    private int[] dx, dy;
    private int health;
    public Position position;

    public Player(Power myPower) {
        this.position = new Position(0, 0);
        this.health = myPower.getHealth();
        int jump = myPower.getJump();
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
        res.X = dx[dVec] + this.position.X;
        res.Y = dy[dVec] + this.position.Y;
        return res;
    }

    public boolean hitWallEffect() {
        return (--this.health > 0);
    }
}
