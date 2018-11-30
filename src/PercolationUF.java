
public class PercolationUF implements IPercolate{

	
	
	protected boolean[][] myGrid; 
	protected int myOpenCount;
	protected IUnionFind myFinder; 
	private final int VTOP; 
	private final int VBOTTOM;
	
	public PercolationUF(int size , IUnionFind finder) { 
		myGrid = new boolean[size][size]; 
		finder.initialize(size * size + 2);
		myFinder = finder; 
		VTOP = size * size; 
		VBOTTOM = size*size+1; 
	}
	
	
	
	@Override
	public void open(int row, int col) {
		// TODO Auto-generated method stub
		if(!inBounds(row,col)) { 
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		if(!isOpen(row, col)) { 
			return; 
		}
		
		int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
        
        myGrid[row][col] = true;
        myOpenCount++; 
        
        if(row == 0) { 
        	int temp = row * myGrid.length + col; 
        	myFinder.union(VTOP, temp); 
        }
        
        if(row == myGrid.length -1) { 
        	int temp = row * myGrid.length + col; 
        	myFinder.union(VBOTTOM, temp); 
        }
        
        for(int k = 0; k < rowDelta.length; k++) { 
        	int rowT = row + rowDelta[k]; 
        	int colT = col + colDelta[k]; 
        	
        	if(inBounds(rowT, colT)) { 
        		if(isOpen(rowT , colT)) { 
        			int tempO = row * myGrid.length + col; 
        			int tempP = rowT * myGrid.length + colT;
        			myFinder.union(tempO, tempP); 
        		}
        			
        	}
        		
        }
		
	}

	private boolean inBounds(int row, int col) {
		if(row >= myGrid.length || col >= myGrid.length || row < 0 || col < 0) { 
			return false;
		}
		return true; 
	}



	@Override
	public boolean isOpen(int row, int col) {
		if(!inBounds(row,col)) { 
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		if(myGrid[row][col] == true) { 
			return true;
		}
		return false; 
	}

	@Override
	public boolean isFull(int row, int col) {
		if(!inBounds(row,col)) { 
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		if(!isOpen(row , col)) { 
			return false; 
		}
		int temp = row * myGrid.length + col; 
		return myFinder.connected(VTOP, temp); 
	}

	@Override
	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM); 
	}

	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}

}
