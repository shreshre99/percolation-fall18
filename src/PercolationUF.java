
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
		
		
	}

	private boolean inBounds(int row, int col) {
		if(row >= myGrid.length || col >= myGrid.length) { 
			return false;
		}
		else { 
			return true; 
		}
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
