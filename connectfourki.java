package connectfour;

public class connectfourki {
    static int player;
    static String[][] field;

    public static int[] move() {
           int[] check;
           check = checkDangertoBlock();
           if (check[0] != 0) {
                int[] myint = new int[3];
                myint[0] = 1;
                myint[1] = check[1];
                myint[2] = check[2];
                return myint;
           }
           int[] myint = new int[1];
           myint[0] = 0;
           return myint;
    }

    private static int[] checkDangertoBlock() {
        if (checkHorizontdanger()[0] == 0
        && checkVerticaldanger()[0] == 0 
        && checkDiagonaldangerToleft()[0] == 0 
        && checkDiagonaldangerToright()[0] == 0) {
            int[] myint = new int[1];
            myint[0] = 0;
            return myint;
        } else if (checkDiagonaldangerToright()[0] == 1) {
            int[] check = checkdanger(checkDiagonaldangerToright()[1], checkDiagonaldangerToright()[2]);
            if (check[0] == 1) {
                return checkDiagonaldangerToright();
            }
        } else if (checkDiagonaldangerToleft()[0] == 1) {
            int[] check = checkdanger(checkDiagonaldangerToleft()[1], checkDiagonaldangerToleft()[2]);
            if (check[0] == 1) {
                return checkDiagonaldangerToleft();
            }
        } else if (checkHorizontdanger()[0] == 1) {
            return checkHorizontdanger();
        } else if (checkVerticaldanger()[0] == 1) {
            return checkVerticaldanger();
        }
        
        int[] myint = new int[1];
        myint[0] = 0;
        return myint;
    }

    private static int[] checkdanger(int slide, int row) {
        //check the danger by looking if the danger coordinate maybe already full from active player so its not detected but false alarm
        for (int i = 0; i < 6; i++) {
            if (!(field[i][row].equals(""))) {
                if (i == slide) {
                    int[] myint = new int[1];
                    myint[0] = 0;
                    return myint;
                } else if (i < slide) {
                    System.out.println("this should definitly not happen!");
                    int[] myint = new int[1];
                    myint[0] = 0;
                    return myint;
                } else if (i > slide) {
                    int[] myint = new int[1];
                    myint[0] = 1;
                    return myint;
                }
            } else {
                int[] myint = new int[1];
                myint[0] = 1;
                return myint;
            }
        }
        System.out.println("should definitly also not happen");
        int[] myint = new int[1];
        myint[0] = 0;
        return myint;
    }

    private static int[] checkDiagonaldangerToright() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                if (field[x][y].equals(Integer.toString(player))
                && field[x+1][y+1].equals(Integer.toString(player))
                && field[x+2][y+2].equals(Integer.toString(player))) {
                    int[] myint = new int[3];
                    myint[0] = 1;
                    myint[1] = x + 3;
                    myint[2] = y + 3;
                    return myint;
                }
            }
        }
        int[] myint = new int[1];
        myint[0] = 0;
        return myint;
    }
    private static int[] checkDiagonaldangerToleft() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                if (field[x][y].equals(Integer.toString(player))
                && field[x+1][y-1].equals(Integer.toString(player))
                && field[x+2][y-2].equals(Integer.toString(player))
                && field[x+3][y-3].equals(Integer.toString(player))) {
                    int[] myint = new int[3];
                    myint[0] = 1;
                    myint[1] = x + 3;
                    myint[2] = y - 3;
                    return myint;
                }
            }
        }
        int[] myint = new int[1];
        myint[0] = 0;
        return myint;
    }
    private static int[] checkVerticaldanger() {
        int verticalinarow = 0;
        for (int r = 0; r < 7; r++) {
            for (int w = 0; w < 6; w++) {
                if (field[w][r].equals(Integer.toString(player))) {
                    verticalinarow += 1;
                    if (verticalinarow >= 3) {
                        int[] myint = new int[3];
                        myint[0] = 1;
                        myint[1] = w;
                        myint[2] = r;
                    }
                } else {
                    verticalinarow = 0;
                }
            }
            verticalinarow = 0;
        }
        int[] myint = new int[1];
        myint[0] = 0;
        return myint;
    }
    private static int[] checkHorizontdanger() {
        int horizoninarow = 0;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 7; y++) {
                if (field[x][y].equals(Integer.toString(player))) {
                    horizoninarow += 1;
                    if (horizoninarow >= 3) {
                        int[] myint = new int[3];
                        myint[0] = 1;
                        myint[1] = x;
                        myint[2] = y;
                    }
                } else {
                    horizoninarow = 0;
                }

            }
            horizoninarow = 0;
        }
        int[] myint = new int[1];
        myint[0] = 0;
        return myint;
    }
}