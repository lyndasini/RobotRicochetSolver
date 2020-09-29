package robotricochet.utils;

import robotricochet.entity.Case;
import robotricochet.entity.CaseType;

import java.util.HashMap;
import java.util.Map;

public class PlateauUtil {

    private PlateauUtil() {

    }

    public static void parsePlaneCharacters(Case[][] subPlateau, int x, String[] charactersInLine, int y) {

        Map<String, Case> casesMap = loadTypeCases();
        subPlateau[x][y] = casesMap.get(charactersInLine[y]);

    }

    private static Map<String, Case> loadTypeCases() {
        Map<String, Case> casesMap = new HashMap<>();

        casesMap.put("#", new Case(CaseType.OBSTACLE));
        casesMap.put(" ", new Case(CaseType.EMPTYSPACE));
        casesMap.put("r", new Case(CaseType.RED_ROBOT_START));
        casesMap.put("g", new Case(CaseType.GREEN_ROBOT_START));
        casesMap.put("b", new Case(CaseType.BLUE_ROBOT_START));
        casesMap.put("y", new Case(CaseType.YELLOW_ROBOT_START));
        casesMap.put("0", new Case(CaseType.RED_CIRCLE));
        casesMap.put("1", new Case(CaseType.GREEN_CIRCLE));
        casesMap.put("2", new Case(CaseType.BLUE_CIRCLE));
        casesMap.put("3", new Case(CaseType.YELLOW_CIRCLE));
        casesMap.put("4", new Case(CaseType.RED_SQUARE));
        casesMap.put("5", new Case(CaseType.GREEN_SQUARE));
        casesMap.put("6", new Case(CaseType.BLUE_SQUARE));
        casesMap.put("7", new Case(CaseType.YELLOW_SQUARE));
        casesMap.put("8", new Case(CaseType.RED_TRIANGLE));
        casesMap.put("9", new Case(CaseType.GREEN_TRIANGLE));
        casesMap.put("A", new Case(CaseType.BLUE_TRIANGLE));
        casesMap.put("B", new Case(CaseType.YELLOW_TRIANGLE));
        casesMap.put("C", new Case(CaseType.RED_DIAMOND));
        casesMap.put("D", new Case(CaseType.GREEN_DIAMOND));
        casesMap.put("E", new Case(CaseType.BLUE_DIAMOND));
        casesMap.put("F", new Case(CaseType.YELLOW_DIAMOND));
        casesMap.put("G", new Case(CaseType.MULTICOLOR_VORTEX));
        casesMap.put("H", new Case(CaseType.ANTISLASH_RED));
        casesMap.put("I", new Case(CaseType.SLASH_RED));
        casesMap.put("J", new Case(CaseType.ANTISLASH_GREEN));
        casesMap.put("K", new Case(CaseType.SLASH_GREEN));
        casesMap.put("L", new Case(CaseType.ANTISLASH_BLUE));
        casesMap.put("M", new Case(CaseType.SLASH_BLUE));
        casesMap.put("N", new Case(CaseType.ANTISLASH_YELLOW));
        casesMap.put("O", new Case(CaseType.SLASH_YELLOW));
        return casesMap;
    }

    public static Map<String,Case> oppositeRicochetMap(){
        Map<String,Case> casesMap = new HashMap<>();

        casesMap.put("I", new Case(CaseType.ANTISLASH_RED));
        casesMap.put("H", new Case(CaseType.SLASH_RED));
        casesMap.put("K", new Case(CaseType.ANTISLASH_GREEN));
        casesMap.put("J", new Case(CaseType.SLASH_GREEN));
        casesMap.put("M", new Case(CaseType.ANTISLASH_BLUE));
        casesMap.put("L", new Case(CaseType.SLASH_BLUE));
        casesMap.put("O", new Case(CaseType.ANTISLASH_YELLOW));
        casesMap.put("N", new Case(CaseType.SLASH_YELLOW));

        return casesMap;
    }


    public static void subPlateauRotation(Case[][] subPlateau, int x, int y) {
        switch (subPlateau[x][y].toString()) {

            case "I":
                subPlateau[x][y] = new Case(CaseType.ANTISLASH_RED);
                break;
            case "M":
                subPlateau[x][y] = new Case(CaseType.ANTISLASH_BLUE);
                break;
            case "K":
                subPlateau[x][y] = new Case(CaseType.ANTISLASH_GREEN);
                break;
            case "O":
                subPlateau[x][y] = new Case(CaseType.ANTISLASH_YELLOW);
                break;

            case "H":
                subPlateau[x][y] = new Case(CaseType.SLASH_RED);
                break;
            case "L":
                subPlateau[x][y] = new Case(CaseType.SLASH_BLUE);
                break;
            case "J":
                subPlateau[x][y] = new Case(CaseType.SLASH_GREEN);
                break;
            case "N":
                subPlateau[x][y] = new Case(CaseType.SLASH_YELLOW);
                break;
        }


    }
}
