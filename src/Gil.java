import java.time.Period;

public class Gil {

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
		
		
		
		//TODO ___________________For Amir___________________
		public static boolean checkLegalMove(int r, int c, char direction) {
			int [] otherElement = getDest(r, c, direction);
			
			if (otherElement[1] == -1)
				return false;
			//Perform swapping 
			preformSwap(r, c, otherElement[0], otherElement[1]);
			//Check:
			if (!countTriosInLocation(r,c) == 0 && !countTriosInLocation(otherElement[0], otherElement[1])) {
				return false
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

			
			case 'd' :
				//First check if index is valid 
				if (!isLegalLoc(r, c - 1))
					return invalidArr;
				
				//Secondly apply the changes
				ret[0] = r;
				ret[1] = c - 1;
	
			case 'r' :
				//First check if index is valid 
				if (!isLegalLoc(r + 1, c))
					return invalidArr;
				
				//Secondly apply the changes
				ret[0] = r + 1;
				ret[1] = c;
	
			case 'l':
				//First check if index is valid 
				if (!isLegalLoc(r - 1, c))
					return invalidArr;
				
				//Secondly apply the changes
				ret[0] = r - 1;
				ret[1] = c;
				
			default:
				System.out.println("Illegal direction");
				
			}
			return ret;
		}
		
		//TODO ___________________For Amir___________________

		
		
		
		
		private int countTriosInLocation(int r, int c) {
			// TODO Auto-generated method stub
			return 0;
		}

		public static boolean isLegalLoc(int r, int c) {
			return (r>0&&r<BOARD_SIZE&&c>0&&c<BOARD_SIZE) ;
		}
		
		
        public static void preformSwap( int r1, int c1, int r2, int c2 ){
            char tempSwap = board[r1][c1];
            board[r1][c1] = board[r2][c2];
            board[r2][c2] = tempSwap;
        }
		
		

}
