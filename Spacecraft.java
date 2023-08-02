import java.util.*;
public class Spacecraft {
    private int x, y, z;
    private char direction;

    public Spacecraft(int x, int y, int z, char direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }

    public void moveForward() {
        if (direction == 'N') {
            y++;
        } else if (direction == 'S') {
            y--;
        } else if (direction == 'E') {
            x++;
        } else if (direction == 'W') {
            x--;
        } else if (direction == 'U') {
            z++;
        } else if (direction == 'D') {
            z--;
        }
    }

    public void moveBackward() {
        if (direction == 'N') {
            y--;
        } else if (direction == 'S') {
            y++;
        } else if (direction == 'E') {
            x--;
        } else if (direction == 'W') {
            x++;
        } else if (direction == 'U') {
            z--;
        } else if (direction == 'D') {
            z++;
        }
    }

    public void turnLeft() {
        if (direction == 'N') {
            direction = 'W';
        } else if (direction == 'W') {
            direction = 'S';
        } else if (direction == 'S') {
            direction = 'E';
        } else if (direction == 'E') {
            direction = 'N';
        } else if (direction == 'U') {
            direction = 'N';
        } else if (direction == 'D') {
            direction = 'S';
        }
    }

    public void turnRight() {
        if (direction == 'N') {
            direction = 'E';
        } else if (direction == 'E') {
            direction = 'S';
        } else if (direction == 'S') {
            direction = 'W';
        } else if (direction == 'W') {
            direction = 'N';
        }
    }

    public void turnUp() {
        if (direction == 'N') {
            direction = 'U';
        } else if (direction == 'U') {
            direction = 'S';
        } else if (direction == 'S') {
            direction = 'D';
        } else if (direction == 'D') {
            direction = 'N';
        } else if (direction == 'E') {
            direction = 'N';
        } else if (direction == 'W') {
            direction = 'U';
        }
    }

    public void turnDown() {
        if (direction == 'N') {
            direction = 'D';
        } else if (direction == 'D') {
            direction = 'S';
        } else if (direction == 'S') {
            direction = 'U';
        } else if (direction == 'U') {
            direction = 'N';
        }
    }

    public void executeCommands(char[] commands) {
        for (char command : commands) {
            executeCommand(command);
        }
    }

    private void executeCommand(char command) {
        switch (command) {
            case 'f':
                moveForward();
                break;
            case 'b':
                moveBackward();
                break;
            case 'l':
                turnLeft();
                break;
            case 'r':
                turnRight();
                break;
            case 'u':
                turnUp();
                break;
            case 'd':
                turnDown();
                break;
            default:
                // Ignore invalid commands
                break;
        }
    }

    public String getCurrentPosition() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public char getCurrentDirection() {
        return direction;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startX = 0, startY = 0, startZ = 0;
        char initialDirection = 'N';

        System.out.println("Welcome to Chandrayaan 3 Control Program!");
        System.out.println("Enter commands (f - forward, b - backward, l - left, r - right, u - up, d - down) or type 'exit' to quit.");

        Spacecraft chandrayaan3 = new Spacecraft(startX, startY, startZ, initialDirection);

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting Chandrayaan 3 Control Program.");
                break;
            }

            char[] commands = input.toCharArray();
            chandrayaan3.executeCommands(commands);

            System.out.println("Current Position: " + chandrayaan3.getCurrentPosition());
            System.out.println("Current Direction: " + chandrayaan3.getCurrentDirection());
        }

        scanner.close();
    }
}
