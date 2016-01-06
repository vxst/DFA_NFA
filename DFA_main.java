import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class DFA_main{
	public static void main(String[] arguments){
		Set<Integer> Q = new HashSet<Integer>(Arrays.asList(0, 1, 2));
		Set<Integer> FinalQ = new HashSet<Integer>(Arrays.asList(1, 2));
		Set<Character> Alphabet = new HashSet<Character>(Arrays.asList('a', 'b'));
		Map<Pair<Integer, Character>, Integer> Delta = new HashMap<Pair<Integer, Character>, Integer>();
		int QInit = 0;

		//(a|b)a*b*
		Delta.put(new Pair<>(0, 'a'), 1);
		Delta.put(new Pair<>(0, 'b'), 1);
		Delta.put(new Pair<>(1, 'a'), 1);
		Delta.put(new Pair<>(1, 'b'), 2);
		Delta.put(new Pair<>(2, 'b'), 2);

		Automaton machine = new DFA(Q, Alphabet, Delta, QInit, FinalQ);

		if(machine.accept("hello"))
			System.out.printf("accept hello\n");
		if(machine.accept("abaaa"))
			System.out.printf("accept abaaa\n");
		if(machine.accept("baaaab"))
			System.out.printf("accept baaaab\n");
		if(machine.accept("baaaabbbb"))
			System.out.printf("accept baaaabbb\n");
	}
}
