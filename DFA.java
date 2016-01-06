class Pair<L,R> {
	private final L left;
	private final R right;

	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() { return left; }
	public R getRight() { return right; }

	@Override
	public int hashCode() { return left.hashCode() ^ right.hashCode(); }

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pair)) return false;
		Pair pairo = (Pair) o;
		return this.left.equals(pairo.getLeft()) &&
			this.right.equals(pairo.getRight());
	}
}

public class DFA{
	private Set<int> Q;
	private Set<char> Alphabet;
	private Map<Pair<int, char>, int> Delta;
	private int QInit;
	private Set<int> FinalQ;

	public DFA(Set<int> Q, Set<char> Alphabet, Map<Pair<int, char>, int> Delta, int QInit, Set<int> FinalQ){
		this.Q = new HashSet<int>(Q);
		this.Alphabet = new HashSet<char>(Alphabet);
		this.Delta = new HashMap<int, char>(Delta);
		this.QInit = QInit;
		this.FinalQ = new HashSet<int>(FinalQ);
	}

	boolean Accept(String s){
		int q = QInit;
		for(char choose: s){
			if(Delta.get(new Pair(q, choose)) == null)
				return false;
			else
				q = Delta.get(new Pair(q, choose));
		}
		return FinalQ.contains(q);
	}
}
