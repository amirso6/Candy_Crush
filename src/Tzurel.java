public class Tzurel {

    public static int BOARD_SIZE = 10;
    public static char[][] board = null;

    public static void print_board()
    {
        if (board == null)
            System.out.println("Null board");
        else
        {
            for (int i = 0; i < board.length; i++)
            {
                for (int j = 0; j < board[i].length; j++)
                {
                    System.out.print(" " + String.valueOf(board[i][j]) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void update_board0()
    {
        if (board == null)
        {
            board = new char[BOARD_SIZE][BOARD_SIZE];

            for (int i = 0; i < board.length; i++)
            {
                for (int j = 0; j < board[i].length; j++)
                {
                    board[i][j] = '=';
                }
            }
        }
    }



    public static void main(String[] args)
    {
        update_board0();
        print_board();
    }
    public static boolean isLegalLoc(int r, int c) {
        return (r > 0 && r < BOARD_SIZE && c > 0 && c < BOARD_SIZE);
    }

    public static boolean checkTrioAddedChar(char ch, int r, int c) {

        int counter = 0;
        //check for rows:
        for(int i = 1; i <= 2; i++) {
            if(isLegalLoc(r, c - i) && board[r][c - i] == ch) {
                counter += 1;
            }
        }
        //return false if the new char equal to 2 char in cols before:
        if(counter == 2)
            return false;

        counter = 0;

        for(int z = 1; z <= 2; z++) {
            if(isLegalLoc(r - z, c) && board[r - z][c] == ch) {
                counter += 1;
            }
        }
        if(counter == 2) {
            return false;
        }



        return true;

    }


}