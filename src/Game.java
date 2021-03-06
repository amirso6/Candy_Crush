import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Game
{
	public static int BOARD_SIZE = 10;
	public static char[][] board = null;
	public static final char EMPTY_CHAR = '=';
    public static char[] sings = {'1','2','3','4'};
		

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
	
	public static char getRandomChar(){
        int i = ThreadLocalRandom.current().nextInt(0,4);
        return sings[i];
    }
	
	public static boolean isLegalLoc(int r, int c) {
		return (r>=0&&r<BOARD_SIZE&&c>=0&&c<BOARD_SIZE) ;
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
	
	public static void generateRandomBoard() {
		int CurrectBoardState=1;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				do {
					board[i][j]=getRandomChar( );
					if(checkTrioAddedChar(board[i][j],i ,j)) {
						CurrectBoardState=1;
					}else {
						CurrectBoardState=0;
					}
				}while(CurrectBoardState==0);
			}
		}
	}
	
	public static int countTriosInLocation(int r, int c) {
        int temp = 0;
        int counter = 0;
        //leftUp:
        for(int i = r - 2 ; i <= r; i++) {
            temp = 0;
            for(int z = 0; z < 2; z++) {

                if((isLegalLoc(i, c) && board[i + z][c] == board[r][c])) {
                    temp += 1;
                }
            }
            if(temp == 2) {
                counter += 1;
            }
        }
        temp = 0;
        //rightLeft:
        for(int i = c - 2; i <= c; i++) {
          temp = 0;
          for(int z = 0; z < 2; z++) {
              if((isLegalLoc(r, i) && board[r][i + z] == board[r][c])) {
                  temp += 1;
              }
          }
          if (temp == 2) {
              counter +=1;
          }
        }
        return counter;
    }
	
	public static boolean checkLegalMove(int r, int c, char direction) {
		int [] otherElement = getDest(r, c, direction);	
		if (otherElement[1] == -1)
			return false;
		//Perform swapping 
		preformSwap(r, c, otherElement[0], otherElement[1]);
		//Check:
		if (countTriosInLocation(r,c) == 0 && countTriosInLocation(otherElement[0], otherElement[1] )==0) {
			return false;
		}
		//Return to original state
		preformSwap(r, c, otherElement[0], otherElement[1]);
		return true;		
	}
	
	public static int[] getDest(int r, int c, char direction) {
		final int [] invalidArr = {-1,-1};
		int [] ret = {0,0};
		if (direction != 'u' && direction != 'd' && direction != 'l' && direction != 'r') {
			System.out.println("Illegal direction");
			return invalidArr;
		}
		switch (direction) {
		case 'u':
		//First check if index is valid 
		if (!isLegalLoc(r, c + 1))
			return invalidArr;
		//Secondly apply the changes
		ret[0] = r;
		ret[1] = c + 1;
		break;		
		case 'd' :
			//First check if index is valid 
			if (!isLegalLoc(r, c - 1))
				return invalidArr;
			//Secondly apply the changes
			ret[0] = r;
			ret[1] = c - 1;
			break;
		case 'r' :
			//First check if index is valid 
			if (!isLegalLoc(r + 1, c))
				return invalidArr;
			//Secondly apply the changes
			ret[0] = r + 1;
			ret[1] = c;
			break;
		case 'l':
			//First check if index is valid 
			if (!isLegalLoc(r - 1, c))
				return invalidArr;	
			//Secondly apply the changes
			ret[0] = r - 1;
			ret[1] = c;
			break;
		}
		return ret;
	}
	
    public static void preformSwap( int r1, int c1, int r2, int c2 ){
        char tempSwap = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = tempSwap;
    }
	
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int x,y;
		char dir;
		update_board0();
		generateRandomBoard();
		print_board();
		System.out.println("Enter point(1 int at a time)");
		x=input.nextInt();
		y=input.nextInt();
		System.out.println("Enter direction(u,d,l,r)");
		dir=input.next().charAt(0);
		System.out.println(countTriosInLocation(x,y));
		if(checkLegalMove(x,y,dir)) {
			System.out.println("Legal move");
		}else {
			System.out.println("Ilegal move");
		}
		
	}
}