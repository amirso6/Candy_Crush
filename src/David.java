import java.util.concurrent.ThreadLocalRandom;

public class David {
    public class Game {
        public static int BOARD_SIZE = 10;
        public static char[][] board = null;
        public static final char EMPTY_CHAR = '=';
        public static char[] sings = {'1','2','3','4'};

        public Game() {
        }
        public static void print_board() {
            if (board == null) {
                System.out.println("Null board");
            } else {
                for(int i = 0; i < board.length; ++i) {
                    for(int j = 0; j < board[i].length; ++j) {
                        System.out.print(" " + String.valueOf(board[i][j]) + " ");
                    }

                    System.out.println();
                }
            }

        }

        public static void update_board0() {
            if (board == null) {
                board = new char[BOARD_SIZE][BOARD_SIZE];

                for(int i = 0; i < board.length; ++i) {
                    for(int j = 0; j < board[i].length; ++j) {
                        board[i][j] = '=';
                    }
                }
            }

        }

        public static void main(String[] args) {
            update_board0();
            print_board();
        }

        public static char getRandomChar(){
            int i = ThreadLocalRandom.current().nextInt(1,4);
            return sings[i];
        }
    }

}
