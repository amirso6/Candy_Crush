
public class Amir {
	public static int BOARD_SIZE = 10;
	public static char[][] board = null;

	
	public void generateRandomBoard() {
		boolean CurrectBoardState=true;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				do {
					board[i][j]=getRandomChar( );
					if(i>3 && j>3) {
						if(checkTrioAddedChar(board[i][j],i ,j)) {
							CurrectBoardState=true;
						}else {
							CurrectBoardState=false;
						}
					}
				}while(CurrectBoardState=false);
			}
		}
	}
	
	public boolean isLegalLoc(int r, int c) {
		return (r>0&&r<BOARD_SIZE&&c>0&&c<BOARD_SIZE) ;
	}
	
	public int countTriosInLocation(int r, int c) {
		return c;
	}


	private boolean checkTrioAddedChar(char ch, int r, int c){
		// TODO Auto-generated method stub
		return false;
	}


	private char getRandomChar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
