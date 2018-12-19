public class Parser {

    public static Coordinate parse(String input) {
        char firstChar = input.toLowerCase().charAt(0);
        char secondChar = input.toLowerCase().charAt(1);

        if (Character.isLetter(firstChar)) {
            return new Coordinate(letterToColumn(firstChar), numberToRow(secondChar));
        } else {
            return new Coordinate(letterToColumn(secondChar), numberToRow(firstChar));
        }
    }

    private static int letterToColumn(char letterChar) {
        switch (letterChar) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            default:
                throw new IllegalArgumentException("Letter must be A, B or C");
        }
    }

    private static int numberToRow(char numberChar) {
        return Integer.parseInt(numberChar + "") - 1;
    }
}
