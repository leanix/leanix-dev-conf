public class Parser {

    public static Coordinate parse(String input) {
        char letterChar = input.toLowerCase().charAt(0);
        char numberChar = input.charAt(1);
        int column= 0, row;
        switch (letterChar) {
            case 'a':
                column = 0;
                break;
            case 'b':
                column = 1;
                break;
            case 'c':
                column = 2;
                break;
        }
        row = Integer.parseInt(numberChar + "");

        return new Coordinate(column, row-1);
    }
}
