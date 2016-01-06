import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class NFA implements Automaton{
	private Set<Integer> Q;
	private Set<Character> Alphabet;
	private Map<Pair<Integer, Character>, Set<Integer>> Delta;
	private int QInit;
	private Set<Integer> FinalQ;

	public NFA(Set<Integer> Q, Set<Character> Alphabet, Map<Pair<Integer, Character>, Set<Integer>> Delta, int QInit, Set<Integer> FinalQ){
		this.Q = new HashSet<Integer>(Q);
		this.Alphabet = new HashSet<Character>(Alphabet);

		// It needs deep copy as Set is not immuatable
		this.Delta = new HashMap<Pair<Integer, Character>, Set<Integer>>();
		for(Map.Entry<Pair<Integer, Character>, Set<Integer>> entry : Delta.entrySet())
			this.Delta.put(entry.getKey(), new HashSet<Integer>(entry.getValue()));

		this.QInit = QInit;
		this.FinalQ = new HashSet<Integer>(FinalQ);
	}

	public boolean accept(String s){
		Set<Integer> Qs = new HashSet<Integer>();
		Qs.add(QInit);
		for(char choose: s.toCharArray()){
			Set<Integer> NextQs = new HashSet<Integer>();

			int IncreasedSize;
			do{
				IncreasedSize = Qs.size();
				for(int q: Qs){
					Set<Integer> Pointers = Delta.get(new Pair<>(q, null));
				}
				IncreasedSize = Qs.size() - IncreasedSize;
			}while(IncreasedSize > 0);

			for(int q: Qs){
				Set<Integer> Pointers = Delta.get(new Pair<>(q, choose));
				if(Pointers != null)
					NextQs.addAll(Pointers);
			}

			if(NextQs.isEmpty())
				return false;

			Qs = NextQs;
		}
		for(int q: Qs){
			if(FinalQ.contains(q))
				return true;
		}
		return false;
	}
}
