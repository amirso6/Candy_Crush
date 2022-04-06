
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
		
		
		public boolean checkLegalMove (int r, int c, char direction) {
			final int DISQ_VALUE = 0; //This value reflects the  creation of at least one trio


			boolean validity;
			boolean createTrio = countTriosInLocation(r, c) > DISQ_VALUE;
			// If the indexes are out of bound or there are no trios
			switch (direction) {
				
			
			case 'u':
				//First check if move is valid
				validity = isLegalLoc(r, c + 1);
				//Second check if a trio was created
				createTrio = createTrio || countTriosInLocation(r,c + 1) > DISQ_VALUE;
				break;
			
			
			case 'd' :
				//First check if move is valid
				validity = isLegalLoc(r, c + 1);
				//Second check if a trio was created
				createTrio = createTrio || countTriosInLocation(r,c - 1) > DISQ_VALUE;
				break;
	
			case 'r' :
				//First check if move is valid
				validity = isLegalLoc(r, c + 1);
				//Second check if a trio was created
				createTrio = createTrio || countTriosInLocation(r + 1,c) > DISQ_VALUE;
				break;
	
			case 'l':
				//First check if move is valid
				validity = isLegalLoc(r, c + 1);
				//Second check if a trio was created
				createTrio = createTrio || countTriosInLocation(r - 1,c) > DISQ_VALUE;
				break;
			
			default:
				validity = false;
				System.out.println("Invalid direction");
				break;
			}
			
			
			if (!validity) {
				System.out.println("The move is out of bound");
				return false;
			}
			
			if (!createTrio ) {
				System.out.println("No trio was created, try again");
			}
			
			
			//If both conditions fulfilled the move is valid
			return true;
		}
		
		
		private int countTriosInLocation(int r, int c) {
			// TODO Auto-generated method stub
			return 0;
		}

		public boolean isLegalLoc(int r, int c) {
			return (r>0&&r<BOARD_SIZE&&c>0&&c<BOARD_SIZE) ;
		}
		
		

}
