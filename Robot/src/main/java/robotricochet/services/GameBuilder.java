package robotricochet.services;

import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import robotricochet.entity.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
public class GameBuilder {
    private static Logger logger = Logger.getAnonymousLogger();
    private static final boolean DEBUG = true;
    private Plateau plateau;
    private RobotBuilder robotBuilder;

    public GameBuilder() throws IOException, NoSuchAlgorithmException {
        this.plateau = new Plateau();
        this.robotBuilder = new RobotBuilder();
        this.initGame();
    }

    public Plateau getPlateau() {
        return plateau;
    }
    public RobotBuilder getRobotBuilder(){return this.robotBuilder;}
    public void initGame() {
        if (DEBUG) {
            Token.printTokensContent();
            this.plateau.printPlateau();
            this.robotBuilder.placeRobotOnStartingCases(this.plateau.getPlateau());
        }
    }

    public Robot currentRobot(CaseType token) {

        if (Token.redTokensList().contains(token)) {
            return robotBuilder.getRedRobot();
        }
        if (Token.greenTokensList().contains(token)) {
            return robotBuilder.getGreenRobot();
        }
        if (Token.blueTokensList().contains(token)) {
            return robotBuilder.getBlueRobot();
        }
        if (Token.yellowTokensList().contains(token)) {
            return robotBuilder.getYellowRobot();
        }
        if (token == CaseType.MULTICOLOR_VORTEX) {
            List<Robot> robotsList = new ArrayList<>();
            robotsList.add(robotBuilder.getBlueRobot());
            robotsList.add(robotBuilder.getGreenRobot());
            robotsList.add(robotBuilder.getRedRobot());
            robotsList.add(robotBuilder.getYellowRobot());
            Random random = new Random();
            return robotsList.get(random.nextInt(robotsList.size()));
        }

        return null;
    }

    public void play() {

        logger.info("start of game ");
        CaseType tokenCaseType = Token.getTokenCaseType();// to start the round we draw a token from the arraylistof tokens
        Robot currentRobot = currentRobot(tokenCaseType);
        currentRobot.injectCurrentGrid(this.plateau);
        Position targetPosition = getPlateau().searchPositionOf(tokenCaseType);
        logger.info("the current token is : " + tokenCaseType + "* position *" + targetPosition);
        logger.info("the current robot is  : " + currentRobot.getColor() + " *position * " + currentRobot.getPosition());
        List<Position> astarArray = currentRobot.aStar(currentRobot(tokenCaseType), tokenCaseType);
        logger.info("the path : " + astarArray);
        logger.info("final position of robot : " + currentRobot(tokenCaseType).getPosition());


        logger.info("end of game ");
    }

}
