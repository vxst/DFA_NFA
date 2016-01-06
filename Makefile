all: DFA.class DFA_main.class Pair.class NFA.class NFA_main.class

run: all
	@echo "DFA"
	@java DFA_main
	@echo "NFA"
	@java NFA_main

%.class: %.java
	javac -Xlint:unchecked $<

clean: FORCE
	rm -f *.class

FORCE:

