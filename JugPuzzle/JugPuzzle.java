package ca.utoronto.utm.assignment1.q1;

/**
 * 
 * @author Gagandeep Bhangal
 * 
 */
public class JugPuzzle {

	private Jug[] jugs;
	private int numMoves = 0;

	/**
	 * Construct a new JugPuzzle. A Jug Puzzle consists of three Jugs (numbered 0,1
	 * and 2) with capacities 8,5 and 3 respectively. To start, jug 0 is full and
	 * the other 2 are empty.
	 */
	public JugPuzzle() {
		jugs = new Jug[3];
		jugs[0] = new Jug(8);
		jugs[1] = new Jug(5);
		jugs[2] = new Jug(3);
		jugs[0].setAmount(8);
	}

	/**
	 * If jug 0 and jug 1 both have exactly 4 units of liquid in them, the puzzle is
	 * solved
	 * 
	 * @return whether the puzzle meets the conditions to be solved.
	 */
	public boolean isPuzzleSolved() {
		if (jugs[0].getAmount() == 4 && jugs[1].getAmount() == 4) {
			return true;
		}
		return false;
	}

	/**
	 * Spill liquid from jug a into jug b Update the new capacities
	 * 
	 * @param a is the jug you are spilling from
	 * @param b is the jug you are spilling to
	 */
	public void move(int a, int b) {
		int difference = jugs[b].getCapacity() - jugs[b].getAmount();
		int newAmount1 = difference;
		int diffA = jugs[a].getAmount() - difference;
		if (diffA < 0) {
			while (diffA < 0) {
				difference -= 1;
				diffA = jugs[a].getAmount() - difference;
			}
		}
		newAmount1 = jugs[a].getAmount() - difference;
		int newAmount2 = jugs[b].getAmount() + difference;
		jugs[a].setAmount(newAmount1);
		jugs[b].setAmount(newAmount2);
		numMoves += 1;
	}

	/**
	 * @return the number of moves carried out so far
	 */
	public int getMoves() {
		return numMoves;
	}

	/**
	 * @return a string representation of this
	 */
	public String toString() {
		return numMoves + "  0:(" + jugs[0].getAmount() + "/" + jugs[0].getCapacity() + ")  1:(" + jugs[1].getAmount()
				+ "/" + jugs[1].getCapacity() + ")  2:(" + jugs[2].getAmount() + "/" + jugs[2].getCapacity() + ")";
	}
}
