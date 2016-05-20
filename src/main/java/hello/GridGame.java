package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;

import static hello.Power.GOOD;

@RestController
public class GridGame {

    private static final String template = "Player %s chosen!";
    private Game game;

    public void choosePlayer(int playerType) {
        switch (playerType) {
            case 1:
                System.out.println(normalPlayer());
                break;
            case 2:
                System.out.println(goodPlayer());
                break;
            case 3:
                System.out.println(bestPlayer());
                break;
        }
    }

    public void commandLine() {
        Scanner sc = new Scanner(System.in);
        choosePlayer(sc.nextInt());
        while (true) {
            char c = sc.next().charAt(0);
            switch (c) {
                case 'U':
                    System.out.println(moveUp());
                    break;
                case 'D':
                    System.out.println(moveDown());
                    break;
                case 'R':
                    System.out.println(moveRight());
                    break;
                case 'L':
                    System.out.println(moveLeft());
                    break;
            }
        }
    }

    @RequestMapping("/")
    public String run() {
        return "Choose your player type: \nNormal\nGood\nBest\n";
    }

    @RequestMapping("/Normal")
    public String normalPlayer() {
        game = new Game(new Player(Power.NORMAL), new Grid(5));
        return String.format(template, "Normal");
    }

    @RequestMapping("/Good")
    public String goodPlayer() {
        game = new Game(new Player(GOOD), new Grid(5));
        return String.format(template, "Good");
    }

    @RequestMapping("/Best")
    public String bestPlayer() {
        game = new Game(new Player(Power.BEST), new Grid(5));
        return String.format(template, "Best");
    }

    @RequestMapping("MoveUp")
    public String moveUp() {
        return game.moveUp();
    }

    @RequestMapping("MoveDown")
    public String moveDown() {
        return game.moveDown();
    }

    @RequestMapping("MoveRight")
    public String moveRight() {
        return game.moveRight();
    }

    @RequestMapping("MoveLeft")
    public String moveLeft() {
        return game.moveLeft();
    }
}