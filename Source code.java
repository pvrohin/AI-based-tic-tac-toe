import java.util.*;
public class TicTacToe {
	private static char board[][];
	public TicTacToe()
	{
		board=new char[3][3];
	}	
	public static void initializeboard()
	{
		int i,j;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				board[i][j]='-';
				
			}
		}
		
	}
	public static void printboard()
	{
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) 
		{ 
				System.out.print(" | "); 
				for (int j = 0; j < 3; j++)
				{
					System.out.print(board[i][j] + " | "); 
				}
		System.out.println(); 
		System.out.println("-------------"); 
		}
	}
	public static void makemove(char m,int r,int c)
	{
		board[r][c]=m;
	}
	public static boolean checkRowCol(char a,char b,char c)
	{
	return ((a != '-') && (a == b) && (b == c)); 
	}


	public static boolean checkRowsForWin()
	{
	for(int r=0;r<3;r++)
	{
	if(checkRowCol(board[r][0],board[r][1],board[r][2])==true)
	{
	return true;
	}
	}
	return false;
	}


	public static boolean checkColumnsForWin()
	{
	for(int c=0;c<3;c++)
	{
	if(checkRowCol(board[0][c],board[1][c],board[2][c])==true)
	{
	return true;
	}
	}
	return false;
	}


	public static boolean checkDiagonalsForWin()
	{
	return((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
	} 
 
	public static boolean checkForWin() 
	{ 
	return(checkRowsForWin() ||  checkColumnsForWin() || checkDiagonalsForWin());
	
	}
	public static int getRandom()
	{
		Random rand=new Random();
		int a=rand.nextInt(3);
		return a;
		
	}
	/*public static void checkRowsForDraw(char m)
	{
		for(int r=0;r<=2;r++)
		{
			if(board[r][0]==board[r][1])
			{
				makemove(m,r,2);
				break;
			}
			else if(board[r][1]==board[r][2])
			{	
				makemove(m,r,0);
				break;
			}
			else if(board[r][2]==board[r][0])
			{
				makemove(m,r,1);
				break;
			}
			else
			{
				checkColumnsForDraw(m);
			}
			
				
		
		}
	}
	public static void checkDiagonalsForDraw(char m)
	{
		if(board[0][0]==board[1][1])
		{
			makemove(m,2,2);
			
		}
		
		else if(board[0][0]==board[2][2])
		{
			makemove(m,1,1);
			
		}
		
		else if(board[1][1]==board[2][2])
		{
			makemove(m,0,0);
			
		}
		
		else if(board[0][2]==board[1][1])
		{
			makemove(m,2,0);
			
		}
		
		else if(board[0][2]==board[2][0])
		{
			makemove(m,1,1);
			
		}
		
		else if(board[1][1]==board[2][0])
		{
			makemove(m,0,2);
			
		}
		else
		{
			checkRowsForDraw(m);
			
		}
		
	}	
	public static void checkColumnsForDraw(char m)
	{
		for(int c=0;c<=2;c++)
		{
			if(board[0][c]==board[1][c])
			{
				makemove(m,2,c);
				break;
			}
			if(board[1][c]==board[2][c])
			{	
				makemove(m,0,c);
				break;
			}
			if(board[2][c]==board[0][c])
			{
				makemove(m,1,c);
				break;
			}
				
		
		}
	}*/
		
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to TicTacToe");
		System.out.println("Player,choose your symbol(X/O)");
		char p1=sc.next().charAt(0);
		char p2;
		boolean valid=true;
		if(p1=='X')
			p2='O';
		else
			p2='X';
		TicTacToe t=new TicTacToe();
		initializeboard();
		printboard();
		OUTER:
		while(valid)
		{
			int f=getRandom();
			int g=getRandom();
			if(f==0 && g==0)
			{
				makemove(p2,0,0);
				printboard();
				int r,c;
				System.out.println("Player,enter the position to place your symbol");
				r=sc.nextInt();
				c=sc.nextInt();
				makemove(p1,r,c);
				printboard();
				if((r==2 && c==0) || (r==2 && c==1))
				{
					
					makemove(p2,0,2);
					printboard();
					System.out.println("Player,enter the position to place your symbol");
					r=sc.nextInt();
					c=sc.nextInt();
					makemove(p1,r,c);
					printboard();
					if(r!=0 && c!=1)
					{
						makemove(p2,0,1);
						printboard();
						System.out.println("You lose");
						
					}
					else
					{
						makemove(p2,2,2);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r==1 && c==1)
						{
							makemove(p2,1,2);
							printboard();
							System.out.println("You lose");
						}
						else
						{
							makemove(p2,1,1);
							printboard();
							System.out.println("You lose");
							
						}
					
					}
				
				}
				else if((r==2 && c==2) || (r==1 && c==2))
				{
					makemove(p2,0,2);
					printboard();
					System.out.println("Player,enter the position to place your symbol");
					r=sc.nextInt();
					c=sc.nextInt();
					makemove(p1,r,c);
					printboard();
					if(r!=0 && c!=1)
					{
						makemove(p2,0,1);
						printboard();
						System.out.println("You lose");
						
					}
					else
					{
						makemove(p2,2,0);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r==1 && c==1)
						{
							makemove(p2,1,0);
							printboard();
							System.out.println("You lose");
						}
						else
						{
							makemove(p2,1,1);
							printboard();
							System.out.println("You lose");
							
						}
						
						
						
					}
					
				}
				else if((r==0 && c==2) || (r==0 && c==1))
				{
					makemove(p2,2,0);
					printboard();
					System.out.println("Player,enter the position to place your symbol");
					r=sc.nextInt();
					c=sc.nextInt();
					makemove(p1,r,c);
					printboard();
					if(r!=1 && c!=0)
					{
						makemove(p2,1,0);
						printboard();
						System.out.println("You lose");
					}
					else
					{
						makemove(p2,2,2);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r==1 && c==1)
						{
							makemove(p2,2,1);
							printboard();
							System.out.println("You lose");
						}
						else
						{
							makemove(p2,1,1);
							printboard();
							System.out.println("You lose");
							
						}
						
					}
					
					
				}
				else if((r==1 && c==0))
				{
					makemove(p2,0,2);
					printboard();
					System.out.println("Player,enter the position to place your symbol");
					r=sc.nextInt();
					c=sc.nextInt();
					makemove(p1,r,c);
					printboard();
					if(r!=0 && c!=1)
					{
						makemove(p2,0,1);
						printboard();
						System.out.println("You lose");
					}
					else
					{
						makemove(p2,2,2);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r==1 && c==1)
						{
							makemove(p2,1,2);
							printboard();
							System.out.println("You lose");
						}
						else
						{
							makemove(p2,1,1);
							printboard();
							System.out.println("You lose");
							
						}
						
					}
				}
				
					/*if(r!=1 && c!=2)
					{
						makemove(p2,2,2);
						printboard();
					
					}	
					else if(r!=0 && c!=2)
					{
						makemove(p2,0,0);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						
					}
					else
					{
						System.out.println("Draw game");
					}*/
				else
				{
					makemove(p2,2,2);
					printboard();
					System.out.println("Player,enter the position to place your symbol");
					r=sc.nextInt();
					c=sc.nextInt();
					makemove(p1,r,c);
					printboard();
					if(r==0 && c==2)
					{
						makemove(p2,2,0);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r!=2 && c!=1)
						{
							makemove(p2,2,1);
							printboard();
							System.out.println("You Lose");
						}
						else
						{
							makemove(p2,1,0);
							printboard();
							System.out.println("You Lose");
						}
						
					}
					/*else 
					{
						makemove(p2,0,0);
						printboard();
						
					}*/
					else if(r==2 && c==0)
					{
						makemove(p2,0,2);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r!=0 && c!=1)
						{
							makemove(p2,0,1);
							printboard();
							System.out.println("You Lose");
						}
						else
						{
							makemove(p2,1,2);
							printboard();
							System.out.println("You Lose");
						}
						
					}

					
					else if(r==1 && c==0)
				    {
				    	makemove(p2,1,2);
				    	printboard();
				    	System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r==0 && c==2)
						{
							makemove(p2,2,0);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==2 && c==1)
							{
								makemove(p2,0,1);
								printboard();
								System.out.println("Draw...");
							}
						}
						else
						{
							makemove(p2,0,2);
							printboard();
							System.out.println("You Lose");
						}
						
				    	
				    }
					else if(r==0 && c==1)
				    {
				    	makemove(p2,2,1);
				    	printboard();
				    	System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r==2 && c==0)
						{
							makemove(p2,0,2);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==1 && c==2)
							{
								makemove(p2,1,0);
								printboard();
								System.out.println("Draw...");
							}
								
						}
						else
						{
							makemove(p2,2,0);
							printboard();
							System.out.println("You Lose");
						}
				    	
				    }
					else if(r==2 && c==1)
				    {
				    	makemove(p2,0,1);
				    	printboard();
				    	System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r==0 && c==2)
						{
							makemove(p2,2,0);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==1 && c==0)
							{
								makemove(p2,1,2);
								printboard();
								System.out.println("Draw");
							}
							else
							{
								makemove(p2,1,0);
								printboard();
								System.out.println("You Lose");
							}
							
						}
						else
						{
							makemove(p2,0,2);
							printboard();
							System.out.println("You Lose");
						}
				    	
				    }
					else if(r==1 && c==2)
				    {
				    	makemove(p2,1,0);
				    	printboard();
				    	System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r!=2 && c!=0)
						{
							makemove(p2,2,0);
							printboard();
							System.out.println("You Lose");
						}
						else
						{

							makemove(p2,0,2);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==0 && c==1)
							{
								makemove(p2,2,1);
								printboard();
								System.out.println("Draw Game...");
							}
							else
							{
								makemove(p2,0,1);
								printboard();
								System.out.println("You Lose");
							}
						}
				    
				    
				    }
					else
					{
						System.out.println("The End");
					}
				
				    
				}
				break;
			}		

				else if(f==0 && g==2)
				{
					
					makemove(p2,0,2);
					printboard();
					int r,c;
					System.out.println("Player,enter the position to place your symbol");
					r=sc.nextInt();
					c=sc.nextInt();
					makemove(p1,r,c);
					printboard();
					if((r==2 && c==0) || (r==2 && c==1))
					{
						
						makemove(p2,2,2);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r!=1 && c!=2)
						{
							makemove(p2,1,2);
							printboard();
							System.out.println("You lose");
							
						}
						else
						{
							makemove(p2,0,0);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==1 && c==1)
							{
								makemove(p2,0,1);
								printboard();
								System.out.println("You lose");
							}
							else
							{
								makemove(p2,1,1);
								printboard();
								System.out.println("You lose");
								
							}
						
						}
					
					}
					else if((r==2 && c==2) || (r==1 && c==2))
					{
						makemove(p2,0,0);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r!=0 && c!=1)
						{
							makemove(p2,0,1);
							printboard();
							System.out.println("You lose");
							
						}
						else
						{
							makemove(p2,2,0);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==1 && c==1)
							{
								makemove(p2,1,0);
								printboard();
								System.out.println("You lose");
							}
							else
							{
								makemove(p2,1,1);
								printboard();
								System.out.println("You lose");
								
							}
							
							
							
						}
						
					}
					else if((r==0 && c==0) || (r==0 && c==1))
					{
						makemove(p2,2,2);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r!=1 && c!=2)
						{
							makemove(p2,1,2);
							printboard();
							System.out.println("You lose");
						}
						else
						{
							makemove(p2,2,0);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==1 && c==1)
							{
								makemove(p2,2,1);
								printboard();
								System.out.println("You lose");
							}
							else
							{
								makemove(p2,1,1);
								printboard();
								System.out.println("You lose");
								
							}
							
						}
						
						
					}
					else if((r==1 && c==0))
					{
						makemove(p2,0,0);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r!=0 && c!=1)
						{
							makemove(p2,0,1);
							printboard();
							System.out.println("You lose");
						}
						else
						{
							makemove(p2,2,2);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==1 && c==1)
							{
								makemove(p2,1,2);
								printboard();
								System.out.println("You lose");
							}
							else
							{
								makemove(p2,1,1);
								printboard();
								System.out.println("You lose");
								
							}
							
						}
					}
					
						/*if(r!=1 && c!=2)
						{
							makemove(p2,2,2);
							printboard();
						
						}	
						else if(r!=0 && c!=2)
						{
							makemove(p2,0,0);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							
						}
						else
						{
							System.out.println("Draw game");
						}*/
					else
					{
						makemove(p2,2,0);
						printboard();
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if(r==0 && c==0)
						{
							makemove(p2,2,2);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r!=2 && c!=1)
							{
								makemove(p2,2,1);
								printboard();
								System.out.println("You Lose");
							}
							else
							{
								makemove(p2,1,2);
								printboard();
								System.out.println("You Lose");
							}
							
						}
						/*else 
						{
							makemove(p2,0,0);
							printboard();
							
						}*/
						else if(r==2 && c==2)
						{
							makemove(p2,0,0);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r!=0 && c!=1)
							{
								makemove(p2,0,1);
								printboard();
								System.out.println("You Lose");
							}
							else
							{
								makemove(p2,1,0);
								printboard();
								System.out.println("You Lose");
							}
							
						}

						
						else if(r==1 && c==0)
					    {
					    	makemove(p2,1,2);
					    	printboard();
					    	System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==2 && c==2)
							{
								makemove(p2,0,0);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==0 && c==1)
								{
									makemove(p2,2,1);
									printboard();
									System.out.println("Draw...");
								}
							}
							else
							{
								makemove(p2,2,2);
								printboard();
								System.out.println("You Lose");
							}
							
					    	
					    }
						else if(r==0 && c==1)
					    {
					    	makemove(p2,2,1);
					    	printboard();
					    	System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==2 && c==2)
							{
								makemove(p2,0,0);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==1 && c==0)
								{
									makemove(p2,1,2);
									printboard();
									System.out.println("Draw...");
								}
									
							}
							else
							{
								makemove(p2,2,2);
								printboard();
								System.out.println("You Lose");
							}
					    	
					    }
						else if(r==2 && c==1)
					    {
					    	makemove(p2,0,1);
					    	printboard();
					    	System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==0 && c==0)
							{
								makemove(p2,2,2);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==1 && c==0)
								{
									makemove(p2,1,2);
									printboard();
									System.out.println("Draw");
								}
								else
								{
									makemove(p2,0,1);
									printboard();
									System.out.println("Draw");
								}
								
							}
							else
							{
								makemove(p2,0,0);
								printboard();
								System.out.println("You Lose");
							}
					    	
					    }
						else if(r==1 && c==2)
					    {
					    	makemove(p2,1,0);
					    	printboard();
					    	System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r!=0 && c!=0)
							{
								makemove(p2,0,0);
								printboard();
								System.out.println("You Lose");
							}
							else
							{

								makemove(p2,2,2);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==0 && c==1)
								{
									makemove(p2,2,1);
									printboard();
									System.out.println("You Lose");
								}
								else
								{
									makemove(p2,0,1);
									printboard();
									System.out.println("Draw Game...:");
								}
							}
					    
					    
					    }
						else
						{
							System.out.println("The End");
						}
					    
					}
					break;
				}	
					else if(f==2 && g==0)
					{
						makemove(p2,2,0);
						printboard();
						int r,c;
						System.out.println("Player,enter the position to place your symbol");
						r=sc.nextInt();
						c=sc.nextInt();
						makemove(p1,r,c);
						printboard();
						if((r==0 && c==1) || (r==0 && c==2))
						{
							
							makemove(p2,0,0);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r!=1 && c!=0)
							{
								makemove(p2,1,0);
								printboard();
								System.out.println("You lose");
								
							}
							else
							{
								makemove(p2,2,2);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==1 && c==1)
								{
									makemove(p2,2,1);
									printboard();
									System.out.println("You lose");
								}
								else
								{
									makemove(p2,1,1);
									printboard();
									System.out.println("You lose");
									
								}
							
							}
						
						}
						else if((r==0 && c==0) || (r==1 && c==0))
						{
							makemove(p2,2,2);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r!=2 && c!=1)
							{
								makemove(p2,2,1);
								printboard();
								System.out.println("You lose");
								
							}
							else
							{
								makemove(p2,0,2);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==1 && c==1)
								{
									makemove(p2,1,2);
									printboard();
									System.out.println("You lose");
								}
								else
								{
									makemove(p2,1,1);
									printboard();
									System.out.println("You lose");
									
								}
								
								
								
							}
							
						}
						else if((r==2 && c==1) || (r==2 && c==2))
						{
							makemove(p2,0,0);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r!=1 && c!=0)
							{
								makemove(p2,1,0);
								printboard();
								System.out.println("You lose");
							}
							else
							{
								makemove(p2,0,2);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==1 && c==1)
								{
									makemove(p2,0,1);
									printboard();
									System.out.println("You lose");
								}
								else
								{
									makemove(p2,1,1);
									printboard();
									System.out.println("You lose");
									
								}
								
							}
							
							
						}
						else if((r==1 && c==2))
						{
							makemove(p2,2,2);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r!=2 && c!=1)
							{
								makemove(p2,2,1);
								printboard();
								System.out.println("You lose");
							}
							else
							{
								makemove(p2,0,0);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==1 && c==1)
								{
									makemove(p2,1,0);
									printboard();
									System.out.println("You lose");
								}
								else
								{
									makemove(p2,1,1);
									printboard();
									System.out.println("You lose");
									
								}
								
							}
						}
						else
						{
							makemove(p2,0,2);
							printboard();
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if(r==0 && c==0)
							{
								makemove(p2,2,2);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r!=2 && c!=1)
								{
									makemove(p2,2,1);
									printboard();
									System.out.println("You Lose");
								}
								else
								{
									makemove(p2,1,2);
									printboard();
									System.out.println("You Lose");
								}
								
							}
							/*else 
							{
								makemove(p2,0,0);
								printboard();
								
							}*/
							else if(r==2 && c==2)
							{
								makemove(p2,0,0);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r!=0 && c!=1)
								{
									makemove(p2,0,1);
									printboard();
									System.out.println("You Lose");
								}
								else
								{
									makemove(p2,1,0);
									printboard();
									System.out.println("You Lose");
								}
								
							}

							
							else if(r==1 && c==0)
						    {
						    	makemove(p2,1,2);
						    	printboard();
						    	System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==2 && c==2)
								{
									makemove(p2,0,0);
									printboard();
									System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r==0 && c==1)
									{
										makemove(p2,2,1);
										printboard();
										System.out.println("Draw...");
									}
								}
								else
								{
									makemove(p2,2,2);
									printboard();
									System.out.println("You Lose");
								}
								
						    	
						    }
							else if(r==0 && c==1)
						    {
						    	makemove(p2,2,1);
						    	printboard();
						    	System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==2 && c==2)
								{
									makemove(p2,0,0);
									printboard();
									System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r==1 && c==0)
									{
										makemove(p2,1,2);
										printboard();
										System.out.println("Draw...");
									}
										
								}
								else
								{
									makemove(p2,2,2);
									printboard();
									System.out.println("You Lose");
								}
						    	
						    }
							else if(r==2 && c==1)
						    {
						    	makemove(p2,0,1);
						    	printboard();
						    	System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==0 && c==0)
								{
									makemove(p2,2,2);
									printboard();
									System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r==1 && c==2)
									{
										makemove(p2,1,0);
										printboard();
										System.out.println("Draw");
									}
									else
									{
										makemove(p2,1,2);
										printboard();
										System.out.println("You Lose");
									}
									
								}
								else
								{
									makemove(p2,0,0);
									printboard();
									System.out.println("You Lose");
								}
						    	
						    }
							else if(r==1 && c==2)
						    {
						    	makemove(p2,1,0);
						    	printboard();
						    	System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r!=0 && c!=0)
								{
									makemove(p2,0,0);
									printboard();
									System.out.println("You Lose");
								}
								else
								{

									makemove(p2,2,2);
									printboard();
									System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r==2 && c==1)
									{
										makemove(p2,0,1);
										printboard();
										System.out.println("Draw Game...");
									}
									else
									{
										makemove(p2,2,1);
										printboard();
										System.out.println("You Lose");
									}
								}
						    
						    
						    }
							else
							{
								System.out.println("The End");
							}
						    
						}
						break;
					}	

						else if(f==2 && g==2)
						{
							makemove(p2,2,2);
							printboard();
							int r,c;
							System.out.println("Player,enter the position to place your symbol");
							r=sc.nextInt();
							c=sc.nextInt();
							makemove(p1,r,c);
							printboard();
							if((r==0 && c==0) || (r==0 && c==1))
							{
								
								makemove(p2,0,2);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r!=1 && c!=2)
								{
									makemove(p2,1,2);
									printboard();
									System.out.println("You lose");
									
								}
								else
								{
									makemove(p2,2,0);
									printboard();
									System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r==1 && c==1)
									{
										makemove(p2,2,1);
										printboard();
										System.out.println("You lose");
									}
									else
									{
										makemove(p2,1,1);
										printboard();
										System.out.println("You lose");
										
									}
								
								}
							
							}
							else if((r==0 && c==2) || (r==1 && c==2))
							{
								makemove(p2,2,0);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r!=2 && c!=1)
								{
									makemove(p2,2,1);
									printboard();
									System.out.println("You lose");
									
								}
								else
								{
									makemove(p2,0,0);
									printboard();
									System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r==1 && c==1)
									{
										makemove(p2,1,0);
										printboard();
										System.out.println("You lose");
									}
									else
									{
										makemove(p2,1,1);
										printboard();
										System.out.println("You lose");
										
									}
									
									
									
								}
								
							}
							else if((r==2 && c==0) || (r==2 && c==1))
							{
								makemove(p2,0,2);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r!=1 && c!=2)
								{
									makemove(p2,1,2);
									printboard();
									System.out.println("You lose");
								}
								else
								{
									makemove(p2,0,0);
									printboard();
									System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r==1 && c==1)
									{
										makemove(p2,0,1);
										printboard();
										System.out.println("You lose");
									}
									else
									{
										makemove(p2,1,1);
										printboard();
										System.out.println("You lose");
										
									}
									
								}
								
								
							}
							else if((r==1 && c==0))
							{
								makemove(p2,2,0);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r!=2 && c!=1)
								{
									makemove(p2,2,1);
									printboard();
									System.out.println("You lose");
								}
								else
								{
									makemove(p2,0,2);
									printboard();
									System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r==1 && c==1)
									{
										makemove(p2,1,2);
										printboard();
										System.out.println("You lose");
									}
									else
									{
										makemove(p2,1,1);
										printboard();
										System.out.println("You lose");
										
									}
									
								}
							}
							
							else
							{
								makemove(p2,0,0);
								printboard();
								System.out.println("Player,enter the position to place your symbol");
								r=sc.nextInt();
								c=sc.nextInt();
								makemove(p1,r,c);
								printboard();
								if(r==0 && c==2)
								{
									makemove(p2,2,0);
									printboard();
									System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r!=2 && c!=1)
									{
										makemove(p2,2,1);
										printboard();
										System.out.println("You Lose");
									}
									else
									{
										makemove(p2,1,0);
										printboard();
										System.out.println("You Lose");
									}
									
								}
								/*else 
								{
									makemove(p2,0,0);
									printboard();
									
								}*/
								else if(r==2 && c==0)
								{
									makemove(p2,0,2);
									printboard();
									System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r!=0 && c!=1)
									{
										makemove(p2,0,1);
										printboard();
										System.out.println("You Lose");
									}
									else
									{
										makemove(p2,1,2);
										printboard();
										System.out.println("You Lose");
									}
									
								}

								
								else if(r==1 && c==0)
							    {
							    	makemove(p2,1,2);
							    	printboard();
							    	System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r==0 && c==2)
									{
										makemove(p2,2,0);
										printboard();
										System.out.println("Player,enter the position to place your symbol");
										r=sc.nextInt();
										c=sc.nextInt();
										makemove(p1,r,c);
										printboard();
										if(r==2 && c==1)
										{
											makemove(p2,0,1);
											printboard();
											System.out.println("Draw...");
										}
									}
									else
									{
										makemove(p2,0,2);
										printboard();
										System.out.println("You Lose");
									}
									
							    	
							    }
								else if(r==0 && c==1)
							    {
							    	makemove(p2,2,1);
							    	printboard();
							    	System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r==2 && c==0)
									{
										makemove(p2,0,2);
										printboard();
										System.out.println("Player,enter the position to place your symbol");
										r=sc.nextInt();
										c=sc.nextInt();
										makemove(p1,r,c);
										printboard();
										if(r==1 && c==2)
										{
											makemove(p2,1,0);
											printboard();
											System.out.println("Draw...");
										}
											
									}
									else
									{
										makemove(p2,2,0);
										printboard();
										System.out.println("You Lose");
									}
							    	
							    }
								else if(r==2 && c==1)
							    {
							    	makemove(p2,0,1);
							    	printboard();
							    	System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r==0 && c==2)
									{
										makemove(p2,2,0);
										printboard();
										System.out.println("Player,enter the position to place your symbol");
										r=sc.nextInt();
										c=sc.nextInt();
										makemove(p1,r,c);
										printboard();
										if(r==1 && c==0)
										{
											makemove(p2,1,2);
											printboard();
											System.out.println("Draw");
										}
										else
										{
											makemove(p2,1,0);
											printboard();
											System.out.println("You Lose");
										}
										
									}
									else
									{
										makemove(p2,0,2);
										printboard();
										System.out.println("You Lose");
									}
							    	
							    }
								else if(r==1 && c==2)
							    {
							    	makemove(p2,1,0);
							    	printboard();
							    	System.out.println("Player,enter the position to place your symbol");
									r=sc.nextInt();
									c=sc.nextInt();
									makemove(p1,r,c);
									printboard();
									if(r!=2 && c!=0)
									{
										makemove(p2,2,0);
										printboard();
										System.out.println("You Lose");
									}
									else
									{

										makemove(p2,0,2);
										printboard();
										System.out.println("Player,enter the position to place your symbol");
										r=sc.nextInt();
										c=sc.nextInt();
										makemove(p1,r,c);
										printboard();
										if(r==0 && c==1)
										{
											makemove(p2,2,1);
											printboard();
											System.out.println("Draw Game...");
										}
										else
										{
											makemove(p2,0,1);
											printboard();
											System.out.println("You Lose");
										}
									}
							    
							    
							    }
								else
								{
									System.out.println("The End");
								}
							    
							}
					
						break;
						}
						else
						{
							continue OUTER;
						
						}	

							
				}
						
						
						
		}
				
				
	
}
