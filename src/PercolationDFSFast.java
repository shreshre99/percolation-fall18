
public class PercolationDFSFast extends PercolationDFS{

	public PercolationDFSFast(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void updateOnOpen(int row , int col) { 
		
		if(row == 0) { 
			dfs(row , col); 
		}
		
		else if (row == myGrid.length -1) { 
			if(col == 0) {  
				if(isFull(row - 1, col) || isFull(row , col +1)) { 
					dfs(row,col); 
					}
				}
			
			else if(col == myGrid.length -1) {
				if(isFull(row - 1, col) || isFull(row , col -1)) { 
					dfs(row,col); 
					}
				}
			else { 
				if(isFull(row - 1 , col) || isFull(row , col -1) || isFull(row , col +1)) { 
					dfs(row , col);
					}
				}
			}
		
		else {  
			if(col == 0) { 
				if(isFull(row-1 , col) || isFull(row +1 , col) || isFull(row , col + 1)) { 
						dfs(row, col);
					}	
				}
			else if(col == myGrid.length -1) {
				if(isFull(row -1 , col) || isFull(row +1 , col) || isFull(row , col - 1)) { 
					dfs(row, col);
					}
				}
			else { 
				if(isFull(row - 1, col) || isFull(row , col - 1) || isFull(row + 1, col) || isFull(row , col +1)) { 
					dfs(row, col); 
				}

			}
			
				
			
			
			
			}
		
	}
	

}
