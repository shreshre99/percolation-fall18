import java.util.*;

public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	protected void dfs(int row , int col) { 
        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
		
        if (!inBounds(row,col)) return;
        
        if (isFull(row, col) || !isOpen(row, col))
			return;
        
        Queue<Integer> pq = new LinkedList<>(); 
        
		myGrid[row][col] = FULL;
		int sizeT = row * myGrid.length + col;  
		
		pq.add(sizeT); 
		
		while(pq.size() != 0) { 
			
			Integer i = pq.remove(); 
			for(int k = 0; k < rowDelta.length; k++) { 
				row = (i.intValue()/myGrid.length) + rowDelta[k]; 
				col = (i.intValue()%myGrid.length) + colDelta[k]; 
				if(inBounds(row,col) && isOpen(row, col) && myGrid[row][col] == BLOCKED) { 
					myGrid[row][col] = FULL;
					int sizeA = row * myGrid.length + col; 
					pq.add(sizeA); 
					
				}
			}
	
		}
		
        

		
		
	}
	

}
