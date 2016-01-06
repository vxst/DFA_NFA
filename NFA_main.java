import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class NFA_main{
	public static void main(String[] s){
		// Introduction to the Theory of Computation, 1.2 NFA N2
		Set<Integer> Q = new HashSet<Integer>(Arrays.asList(0, 1, 2, 3));
		Set<Integer> FinalQ = new HashSet<Integer>(Arrays.asList(3));
		Set<Character> Alphabet = new HashSet<Character>(Arrays.asList('0', '1'));
		Map<Pair<Integer, Character>, Set<Integer>> Delta = new HashMap<Pair<Integer, Character>, Set<Integer>>();
		int QInit = 0;

		Delta.put(new Pair<>(0, '0'), new HashSet<Integer>(Arrays.asList(0)));
		Delta.put(new Pair<>(0, '1'), new HashSet<Integer>(Arrays.asList(0, 1)));
		Delta.put(new Pair<>(1, '0'), new HashSet<Integer>(Arrays.asList(2)));
		Delta.put(new Pair<>(1, '1'), new HashSet<Integer>(Arrays.asList(2)));
		Delta.put(new Pair<>(2, '0'), new HashSet<Integer>(Arrays.asList(3)));
		Delta.put(new Pair<>(2, '1'), new HashSet<Integer>(Arrays.asList(3)));

		NFA machineN2 = new NFA(Q, Alphabet, Delta, QInit, FinalQ);

		// Introduction to the Theory of Computation, 1.2 NFA N1
		Delta.clear();
		Delta.put(new Pair<>(0, '0'), new HashSet<Integer>(Arrays.asList(0)));
		Delta.put(new Pair<>(0, '1'), new HashSet<Integer>(Arrays.asList(0, 1)));
		Delta.put(new Pair<>(1, '0'), new HashSet<Integer>(Arrays.asList(2)));
		Delta.put(new Pair<>(1,  (Character)null),  new HashSet<Integer>(Arrays.asList(2)));
		Delta.put(new Pair<>(2, '1'), new HashSet<Integer>(Arrays.asList(3)));
		Delta.put(new Pair<>(3, '0'), new HashSet<Integer>(Arrays.asList(3)));
		Delta.put(new Pair<>(3, '1'), new HashSet<Integer>(Arrays.asList(3)));

		NFA machineN1 = new NFA(Q, Alphabet, Delta, QInit, FinalQ);

		if(machineN1.accept("hello"))
			System.out.printf("N1 accept hello\n");
		if(machineN1.accept("111111"))
			System.out.printf("N1 accept 111111\n");
		if(machineN1.accept("111011"))
			System.out.printf("N1 accept 111011\n");
		if(machineN1.accept("101010"))
			System.out.printf("N1 accept 101010\n");
		if(machineN1.accept("101110"))
			System.out.printf("N1 accept 101110\n");

		if(machineN2.accept("hello"))
			System.out.printf("N2 accept hello\n");
		if(machineN2.accept("111111"))
			System.out.printf("N2 accept 111111\n");
		if(machineN2.accept("111011"))
			System.out.printf("N2 accept 111011\n");
		if(machineN2.accept("101010"))
			System.out.printf("N2 accept 101010\n");
		if(machineN2.accept("101110"))
			System.out.printf("N2 accept 101110\n");
	}
}
