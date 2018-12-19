public class Parser {

    public static Coordinate parse(String input) {
        char letterChar = input.toLowerCase().charAt(0);
        char numberChar = input.charAt(1);
       if ( !Character.isLetter(letterChar)){
           letterChar = input.toLowerCase().charAt(1);
           numberChar = input.charAt(0);
       }

        return new Coordinate(letterToColumn(letterChar), numberToRow(numberChar));
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
