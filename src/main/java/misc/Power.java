package misc;

public enum Power {
    NORMAL(1, 10), GOOD(2, 11), BEST(3, 12);

    private int health, jump;

    Power(int jump, int health) {
        this.health = health;
        this.jump = jump;
    }

    public int getHealth() {
        return health;
    }

    public int getJump() {
        return jump;
    }
}