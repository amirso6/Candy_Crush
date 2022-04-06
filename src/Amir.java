
public class Amir {
	public static int BOARD_SIZE = 10;
	public static char[][] board = null;

	
	public void generateRandomBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				do {
					board[i][j]=getRandomChar( );
					if(i>3 && j>3) {
						if(checkTrioAddedChar(board[i][j],i ,j)) {
						}else {
						}
					}
				}while(false);
			}
		}
	}
	
	public static boolean isLegalLoc(int r, int c) {
		return (r>0&&r<BOARD_SIZE&&c>0&&c<BOARD_SIZE) ;
	}
	
	public int countTriosInLocation(int r, int c) {
		return 0;
	}
	
	public static void makeMove(int r,int c,char direction) {
		int[] point2=getDest(r,c,direction);
		preformSwap(r,c,point2[0],point2[1]);
	}
	
	private static void preformSwap(int r, int c, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private static int[] getDest(int r,int c,char direction){
		int [] x=new int[2];
		x[0]=0;
		x[1]=0;
		return x;
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
