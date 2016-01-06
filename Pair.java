public class Pair<L,R> {
	private final L left;
	private final R right;

	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}
	public R getRight() {
		return right;
	}

	@Override
	public int hashCode() {
		if(left != null && right != null)
			return left.hashCode() ^ right.hashCode();
		if(left != null)
			return left.hashCode();
		if(right != null)
			return right.hashCode();
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pair))
			return false;
		Pair otherPair = (Pair) obj;
		if(this.left != null && this.right != null)
			return this.left.equals(otherPair.getLeft()) &&
				this.right.equals(otherPair.getRight());
		if(this.left != null)
			return this.left.equals(otherPair.getLeft()) &&
				otherPair.getRight() == null;
		if(this.right != null)
			return otherPair.getLeft() == null &&
				this.right.equals(otherPair.getRight());
		return otherPair.getLeft() == null && otherPair.getRight() == null;
	}
}

