import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class DFA_main{
	public static void main(String[] s){
		Set Q = new HashSet<Integer>(Arrays.asList(0, 1, 2));
		Set FinalQ = new HashSet<Integer>(Arrays.asList(1, 2));
		Set Alphabet = new HashSet<Character>(Arrays.asList('a', 'b'));
		Map Delta = new HashMap<Pair<Integer, Character>, Integer>();
		int QInit = 0;
		Delta.put(new Pair(0, 'a'), 1);
		Delta.put(new Pair(0, 'b'), 1);
		Delta.put(new Pair(1, 'a'), 1);
		Delta.put(new Pair(1, 'b'), 2);
		Delta.put(new Pair(2, 'b'), 2);

		DFA machine = new DFA(Q, Alphabet, Delta, QInit, FinalQ);

		if(machine.Accept("hello"))
			System.out.printf("Accept hello\n");
		if(machine.Accept("abaaa"))
			System.out.printf("Accept abaaa\n");
		if(machine.Accept("baaaab"))
			System.out.printf("Accept baaab\n");
	}
}
