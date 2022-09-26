class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
//        robot.stepForward(); // your implementation here
        int xStep = toX - robot.getX();
        int yStep = toY - robot.getY();
        if (xStep > 0) {
            if (robot.getDirection().dy() > 0) {
                robot.turnRight();
                System.out.println("robot.turnRight();");
            } else if (robot.getDirection().dy() < 0){
                robot.turnLeft();
                System.out.println("robot.turnLeft();");
            } else if (robot.getDirection().dx() < 0){
                robot.turnRight();
                robot.turnRight();
                System.out.println("robot.turnRight();");
                System.out.println("robot.turnRight();");
            }
            movement(robot, xStep);
        }
        if (xStep < 0){
            if (robot.getDirection().dy() > 0) {
                robot.turnLeft();
                System.out.println("robot.turnLeft();");
            } else if (robot.getDirection().dy() < 0){
                robot.turnRight();
                System.out.println("robot.turnRight();");
            } else if (robot.getDirection().dx() > 0) {
                robot.turnRight();
                robot.turnRight();
                System.out.println("robot.turnRight();");
                System.out.println("robot.turnRight();");
            }
            movement(robot, Math.abs(xStep));
        }

        if (yStep >0) {
            if (robot.getDirection().dx() > 0) {
                robot.turnLeft();
                System.out.println("robot.turnLeft();");
            } else if (robot.getDirection().dx() < 0){
                robot.turnRight();
                System.out.println("robot.turnRight();");
            } else if (robot.getDirection().dy() < 0){
                robot.turnRight();
                robot.turnRight();
                System.out.println("robot.turnRight();");
                System.out.println("robot.turnRight();");
            }
            movement(robot, yStep);
        }
        if (yStep < 0){
            if (robot.getDirection().dx() > 0) {
                robot.turnRight();
                System.out.println("robot.turnRight();");
            } else if (robot.getDirection().dx() < 0){
                robot.turnLeft();
                System.out.println("robot.turnLeft();");
            } else if (robot.getDirection().dy() > 0){
                robot.turnRight();
                robot.turnRight();
                System.out.println("robot.turnRight();");
                System.out.println("robot.turnRight();");
            }
            movement(robot, Math.abs(yStep));
        }

        System.out.println("destination X: " + robot.getX() + "Y: " + robot.getY());
    }

    static void movement(Robot robot, int step) {
        while (step > 0) {
            robot.stepForward();
            step--;
            System.out.println("robot.stepForward();");
        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        moveRobot(robot, 0, 10);

    }
}

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);
    private final int dx;

    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }
    public int dy() {
        return dy;
    }

}

//Don't change code below

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}