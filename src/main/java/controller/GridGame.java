package controller;

import gameBoard.Grid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import main.Game;
import player.Player;
import misc.Power;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

@RestController
public class GridGame {

    private static final String template = "Player %s chosen!";
    private Game game;

    public void commandLine() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Scanner sc = new Scanner(System.in);
        System.out.println(choosePlayer("NORMAL"));
        while (true) {
            String moveDir = sc.nextLine();
            System.out.println(move(moveDir));
        }
    }

    @RequestMapping("/")
    public String run() {
        return "Choose your player type: \nNormal\nGood\nBest\n";
    }

    @RequestMapping(value = "/{powerType}", method = RequestMethod.GET)
    private String choosePlayer(@PathVariable String powerType) {
        game = new Game(new Player(Power.valueOf(powerType.toUpperCase())), new Grid(5));
        return String.format(template, powerType);
    }

    @RequestMapping(value = "/{powerType}/{dir}", method = RequestMethod.GET)
    private String move(@PathVariable String dir) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Game.class.getMethod("move" + dir);
        return (String)method.invoke(game);
    }
}