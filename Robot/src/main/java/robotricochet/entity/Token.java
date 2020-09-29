package robotricochet.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.*;
import javafx.application.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import robotricochet.services.GameBuilder;

public class Token {

    public static List<CaseType> redTokensList() {
        List<CaseType> redTokens = new ArrayList<>();


        redTokens.add(CaseType.RED_CIRCLE);
        redTokens.add(CaseType.RED_SQUARE);
        redTokens.add(CaseType.RED_TRIANGLE);
        redTokens.add(CaseType.RED_DIAMOND);
        return redTokens;
    }

    public static List<CaseType> greenTokensList() {
        List<CaseType> greenTokens = new ArrayList<>();

        greenTokens.add(CaseType.GREEN_CIRCLE);
        greenTokens.add(CaseType.GREEN_SQUARE);
        greenTokens.add(CaseType.GREEN_TRIANGLE);
        greenTokens.add(CaseType.GREEN_DIAMOND);
        return greenTokens;
    }

    public static List<CaseType> yellowTokensList() {
        List<CaseType> yellowTokens = new ArrayList<>();

        yellowTokens.add(CaseType.YELLOW_CIRCLE);
        yellowTokens.add(CaseType.YELLOW_SQUARE);
        yellowTokens.add(CaseType.YELLOW_TRIANGLE);
        yellowTokens.add(CaseType.YELLOW_DIAMOND);
        return yellowTokens;
    }

    public static List<CaseType> blueTokensList() {
        List<CaseType> blueTokens = new ArrayList<>();
        blueTokens.add(CaseType.BLUE_CIRCLE);
        blueTokens.add(CaseType.BLUE_SQUARE);
        blueTokens.add(CaseType.BLUE_TRIANGLE);
        blueTokens.add(CaseType.BLUE_DIAMOND);
        return blueTokens;
    }

    public static CaseType getTokenCaseType() {
        List<CaseType> tokens = new ArrayList<>();
        tokens.addAll(blueTokensList());
        tokens.addAll(redTokensList());
        tokens.addAll(greenTokensList());
        tokens.addAll(yellowTokensList());
        Random rand = new Random();
        if (!tokens.isEmpty()) {
            int randomNumber = rand.nextInt(tokens.size());
            CaseType drawnToken = tokens.get(randomNumber);
            tokens.remove(randomNumber);
            return drawnToken;
        }
        return null;
    }

    public static void printTokensContent() {
        System.out.println("Content of tokens : ");

        for (CaseType caseType : redTokensList()) {
            System.out.println(caseType);
        }
        for (CaseType caseType : greenTokensList()) {
            System.out.println(caseType);
        }
        for (CaseType caseType : yellowTokensList()) {
            System.out.println(caseType);
        }
        for (CaseType caseType : blueTokensList()) {
            System.out.println(caseType);
        }
    }

    public static void focusEffect(GameBuilder game,CaseType drownToken,GridPane gridPane){
        Position position =game.getPlateau().searchPositionOf(drownToken);
        Rectangle rectangle=new Rectangle(33,33);
        rectangle.setStroke(Color.YELLOW);
        rectangle.setFill(Color.rgb(153,51,255,0.4));
        gridPane.add(rectangle,position.getY(),position.getX());
    }
}
