all: DFA.class DFA_main.class Pair.class

run: all
	@java DFA_main

%.class: %.java
	javac $<

clean: FORCE
	rm -f *.class

FORCE:

