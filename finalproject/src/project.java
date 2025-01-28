//MOHAMMAD SABIH UL HUDA || STUDENT ID
import java.util.Scanner;

public class project {

    public static void main(String[] args) {

// Creating an array consisting black and white
        char[] CheckerBoard = {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', '.', '.', '.', '.', '.',
                '.', '.', '.', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'};
        char[] PcheckerBoard = new char[32];
// Printing the checker board for the user
        arrayCopy(PcheckerBoard, CheckerBoard);
        printCheckerBoard(PcheckerBoard, CheckerBoard);

// Valid and possible moves
        String[][] CrossBoard = {{"1,5"}, {"2,6,9,13"}, {"3,7,10,14,17,21"}, {"4,8,11,15,18,22,25,29"},
                {"12,16,19,23,26,30"}, {"20,24,27,31"}, {"28,32"}, {"3,8,12"}, {"2,7,11,16,20"},
                {"1,6,10,15,19,24,28"}, {"5,9,14,18,23,27,32"}, {"13,17,22,26,31"}, {"21,25,30"}};

// Creating scanner and asking if black or white starts
        Scanner scan = new Scanner(System.in);
        System.out.println("Black or White to start");
        String start = scan.nextLine();

// Creating an if statement so the system does not crash reffering to black and white
        if (start.equals("Black") || start.equals("White") || start.equals("B") || start.equals("W")
                || start.equals("b") || start.equals("w")) {
            {
                // Allows the player to enter the amount of moves they want to make after selecting black or white
                if (start.toUpperCase().equals("B"))
                    start = "w";
                else
                    start = "b";

                System.out.println("Enter how many moves to make");
            }
        } else {
            System.out.println("Its not valid, try again");
        }
//Allows the player to enter the moves they want to make
        int noMoves = scan.nextInt();
        System.out.println("Enter the moves to make");
        for (int i = 1; i <= noMoves; i++) {
            scan = new Scanner(System.in);
            String moves = scan.nextLine();
//Checks if the first move is Black or White
            boolean isValid = validate(moves, CheckerBoard, start.charAt(0));
            if (isValid)
                if (start.toUpperCase().equals("B"))
                    start = "w";
                else
                    start = "b";
            boolean isJump = false;
            if (isValid) {
                if (moves.indexOf("x") > 0) {
                    isJump = true;
                }
//Check if the jump move is vaild
                if (isJump) {
                    int jumpNumber = crossboardValidate(isJump, moves, CrossBoard, CheckerBoard);
                    if (jumpNumber > 0) {
                        arrayCopy(PcheckerBoard, CheckerBoard);
                        coinMove(moves, CheckerBoard, isJump, jumpNumber);
                    } else {
                        System.out.println(" Invalid move, please try again!");
                        i--;
                    }
                } else {
                    int jumpNumber = crossboardValidate(isJump, moves, CrossBoard, CheckerBoard);
                    if (jumpNumber > 0) {
                        arrayCopy(PcheckerBoard, CheckerBoard);
                        coinMove(moves, CheckerBoard, false, 0);
                    } else {
                        System.out.println(" Invalid move, please try again!");
                        i--;
                    }
                }

                printCheckerBoard(PcheckerBoard, CheckerBoard);
            } else {
                System.out.println("Its not valid, try again");
                i -= 1;
            }
        }
    }

    // Prints the checker board
    public static void printCheckerBoard(char[] pBoard, char[] cBoard) {
        String ptmpString = "-";
        String ctmpString = "-";
        for (int i = 0; i < 32; i++) {
            if (i == 3 || i == 11 || i == 19 || i == 27) {
                ptmpString = ptmpString + pBoard[i];
                ctmpString = ctmpString + cBoard[i];
            } else if (i == 7 || i == 15 || i == 23 || i == 31) {
                ptmpString = ptmpString + pBoard[i] + "--";
                ctmpString = ctmpString + cBoard[i] + "--";
            } else {
                ptmpString = ptmpString + pBoard[i] + "-";
                ctmpString = ctmpString + cBoard[i] + "-";
            }
        }
//Creating spaces for the board
        int s = 0;
        for (int j = 0; j < 65; j = j + 8) {
            System.out.println("\t\t" + ptmpString.substring(s, j) + "\t" + ctmpString.substring(s, j));
            s = j;
        }
    }

    public static void arrayCopy(char[] pBoard, char[] cBoard) {
        for (int i = 0; i <= cBoard.length - 1; i++) {
            pBoard[i] = cBoard[i];
        }
    }

    //Identifying the moves from left to right and making sure if the coin reaches the other end, it turns to a KING
    public static void coinMove(String moves, char[] CheckerBoard, boolean isJump, int jumpNumber) {
        int x = moves.indexOf("-");
        if (x < 0)
            x = moves.indexOf('x');
        int left = (Integer.parseInt(moves.substring(0, x))) - 1;
        int right = (Integer.parseInt(moves.substring(x + 1, moves.length()))) - 1;
        char tmpChar = CheckerBoard[left];
        CheckerBoard[left] = '.';
        CheckerBoard[right] = tmpChar;
        if (isJump)
            CheckerBoard[jumpNumber] = '.';
        if (tmpChar == 'b' && right >= 28)
            CheckerBoard[right] = 'B';
        else if (tmpChar == 'w' && right <= 3)
            CheckerBoard[right] = 'W';
    }

    //Checking if the normal move is valid or not
    public static boolean validate(String moves, char[] CheckerBoard, char start) {
        int x = moves.indexOf("-");

        if (x < 0)
            x = moves.indexOf('x');

        int left = (Integer.parseInt(moves.substring(0, x))) - 1;
        int right = (Integer.parseInt(moves.substring(x + 1, moves.length()))) - 1;

        if (CheckerBoard[left] != '-' && CheckerBoard[left] != '.' && CheckerBoard[right] != '-'
                && CheckerBoard[right] == '.' && CheckerBoard[left] != CheckerBoard[right]
                && !("" + CheckerBoard[left]).equalsIgnoreCase("" + start)) {
            {
                return (CheckerBoard[left] != 'b' || left <= right) && (CheckerBoard[left] != 'w' || left >= right);
            }
        } else {
            return false;
        }
    }

    //After iterating the crossboard, it searches for the left value and the right value
    public static int crossboardValidate(boolean isJump, String moves, String[][] CrossBoard, char[] CheckerBoard) {
        int x = moves.indexOf("-");
        if (x < 0)
            x = moves.indexOf('x');
        String left = moves.substring(0, x);
        String right = moves.substring(x + 1, moves.length());
         String strFound = "";
        int tempResult = 0;
        if (Integer.parseInt(left) > Integer.parseInt(right)) {
            String tmpStr = left;
            left = right;
            right = tmpStr;
        }
        for (String[] strings : CrossBoard) {
            String cb = strings[0];
            if (cb.contains(left + ",")) {
                if (cb.contains("," + right)) {
                    strFound = cb.substring(cb.indexOf(left), cb.indexOf(right) + right.length());
                }
            }
        }

        return tempResult ;
    }
}




