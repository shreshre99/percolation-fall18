import java.util.*;

public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	protected void dfs(int row , int col) { 
		int size = 0;
        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
		
        if (!inBounds(row,col)) return;
        
        if (isFull(row, col) || !isOpen(row, col))
			return;
        
        Queue<Integer> pq = new LinkedList<>(); 
        
		myGrid[row][col] = FULL;
		size++; 
		
		pq.add(myGrid[row][col]); 
		
		while(pq.size() != 0) { 
			
			Integer i = pq.remove(); 
			for(int k = 0; k < rowDelta.length; k++) { 
				row = row + rowDelta[k]; 
				col = col + colDelta[k]; 
				if(inBounds(row,col) && myGrid[row][col] == BLOCKED) { 
					pq.add(myGrid[row][col]); 
					myGrid[row][col] = FULL;
					size++;
				}
			}
	
		}
		
        

		
		
	}
	

}
