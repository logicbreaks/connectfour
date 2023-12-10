package connectfour;
import java.util.Scanner;

public class Main {
    //declaring main variables
    static int activeplayer = 1;
    static Scanner myscanner = new Scanner(System.in);
    static String[][] playfield = {
        {"", "", "", "", "", "", ""},
        {"", "", "", "", "", "", ""},
        {"", "", "", "", "", "", ""},
        {"", "", "", "", "", "", ""},
        {"", "", "", "", "", "", ""},
        {"", "", "", "", "", "", ""}
    };

    public static void main(String[] args) {
        int myrow;
        int move;
        int check;
        welcome();
        renderPlayField();
        while ((checkiffull() == 0) && checkifwin(1) == 0 && checkifwin(2) == 0) {
            if ()
            check = 0;
            myrow = 1;
            while (check == 0) {
                try {
                    System.out.printf("Player %s, choose your row: ", Integer.toString(activeplayer));
                    myrow = myscanner.nextInt();
                    check = 1;
                } catch (Exception e) {
                    System.out.println("Please provide an valid number as input!");
                    myscanner.nextLine();
                }
            }
            System.out.println(checkifwin(1));
            move = playmove(activeplayer, myrow);
            if (move == 1) {
                System.out.println("Row is already full! Please choose different row.");
            } else if (move == 0) {
                System.out.println("Move was successful!");
                if (activeplayer == 1) {
                    activeplayer = 2;
                } else {
                    activeplayer = 1;
                }
                renderPlayField();
            } else if (move == 3) {
                System.out.println("Not a valid row! Please choose different row.");
            }

        }
        if (checkifwin(1) == 1) {
            System.out.println("Player 1 won!");
        } else if (checkifwin(2) == 1) {
            System.out.println("Player 2 won!");
        }

    }

    public static void welcome() {
        System.out.println("Four Connect for two Players\n\nInput Number of the row you want to choose.\n");
    }

    public static void renderPlayField() {
        System.out.println(" 1 2 3 4 5 6 7");
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 7; y++) {
                if (playfield[x][y] == "") {
                    System.out.printf("| ", playfield[x][y]);
                } else {
                    System.out.printf("|%s", playfield[x][y]);
                }
            }
            System.out.print("|");
            System.out.print("\n");
        }
    }

    public static int playmove(int player, int row) {
        if ((row < 1) || (row > 7)) {
            return 3;
        }
        row -= 1;
        for (int i = 0; i < 6; i++) {
            if ((playfield[i][row] != "") && (i == 0)) {
                return 1;
            } else if (playfield[i][row] != "") {
                playfield[i - 1][row] = Integer.toString(player);
                return 0;
            } else if ((playfield[i][row] == "") && (i == 5)) {
                playfield[i][row] = Integer.toString(player);
                return 0;
            }
        }
        return 2;
    }

    public static int checkiffull() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 7; y++) {
                if (playfield[x][y].equals("")) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static int checkifwin(int player) {
        int horizoninarow = 0;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 7; y++) {
                if (playfield[x][y].equals(Integer.toString(player))) {
                    horizoninarow += 1;
                    if (horizoninarow >= 4) {
                        return 1;
                    }
                } else {
                    horizoninarow = 0;
                }

            }
            horizoninarow = 0;
        }

        int verticalinarow = 0;
        for (int r = 0; r < 7; r++) {
            for (int w = 0; w < 6; w++) {
                if (playfield[w][r].equals(Integer.toString(player))) {
                    verticalinarow += 1;
                    if (verticalinarow >= 4) {
                        return 1; 
                    }
                } else {
                    verticalinarow = 0;
                }
            }
            verticalinarow = 0;
        }

        //check diagonal (top-left to bottom-right)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                if (playfield[row][col].equals(Integer.toString(player))
                        && playfield[row + 1][col + 1].equals(Integer.toString(player))
                        && playfield[row + 2][col + 2].equals(Integer.toString(player))
                        && playfield[row + 3][col + 3].equals(Integer.toString(player))) {
                    return 1;
                }
            }
        }

        //check diagonal (top-right to bottom-left)
        for (int row = 0; row < 3; row++) {
            for (int col = 3; col < 7; col++) {
                if (playfield[row][col].equals(Integer.toString(player))
                        && playfield[row + 1][col - 1].equals(Integer.toString(player))
                        && playfield[row + 2][col - 2].equals(Integer.toString(player))
                        && playfield[row + 3][col - 3].equals(Integer.toString(player))) {
                    return 1;
                }
            }
        }

        return 0;
    }
}