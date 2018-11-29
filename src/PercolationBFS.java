import java.util.*;

public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void dfs(int row , int col) { 
        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
		
        if (!inBounds(row,col)) return;
        
        if (isFull(row, col) || !isOpen(row, col))
			return;
        
        Queue<Integer> pq = new LinkedList<>(); 
        
		myGrid[row][col] = FULL;
		Integer sizeT = row * myGrid.length + col;  
		
		pq.add(sizeT); 
		while(pq.size() != 0) { 
			
			int i = pq.remove().intValue(); 
			for(int k = 0; k < rowDelta.length; k++) { 
				int rowT = (i/myGrid.length) + rowDelta[k]; 
				int colT = (i%myGrid.length) + colDelta[k]; 
				if(inBounds(rowT,colT) && isOpen(rowT, colT) && myGrid[rowT][colT] != FULL) { 
					
					myGrid[rowT][colT] = FULL;
					Integer sizeA = rowT * myGrid.length + colT; 
					pq.add(sizeA); 
					System.out.println(pq.size()); 
				}
			}
	
		}
		
	}
	

}
