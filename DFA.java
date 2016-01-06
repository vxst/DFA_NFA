import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class DFA{
	private Set<Integer> Q;
	private Set<Character> Alphabet;
	private Map<Pair<Integer, Character>, Integer> Delta;
	private int QInit;
	private Set<Integer> FinalQ;

	public DFA(Set<Integer> Q, Set<Character> Alphabet, Map<Pair<Integer, Character>, Integer> Delta, int QInit, Set<Integer> FinalQ){
		this.Q = new HashSet<Integer>(Q);
		this.Alphabet = new HashSet<Character>(Alphabet);
		this.Delta = new HashMap<Pair<Integer, Character>, Integer>(Delta);
		this.QInit = QInit;
		this.FinalQ = new HashSet<Integer>(FinalQ);
	}

	boolean accept(String s){
		int q = QInit;
		for(char choose: s.toCharArray()){
			if(Delta.get(new Pair<>(q, choose)) == null)
				return false;
			else
				q = Delta.get(new Pair<>(q, choose));
		}
		return FinalQ.contains(q);
	}
}
