# STALGCM_MP

An implementation of a 2-Stack Pushdown Automata Simulator in Java.


## How to run

1. Compile main.java
2. Run

## Usage

The program reads the definitions of the machine from a text file in the format:

```
5 /*number of states*/
A B C D E /*list of states*/
2 /*number of inputs*/
0 1 /*list of inputs*/
Z Z/*list of initial stack symbols*/
3 /*number of stack alphabet*/
X Y Z /*list of stack alphabet*/
2 /*number of transitions*/
A 1 Z Z B XZ XZ /*Transition such that <Current State> <Input> <Top of Stack 1> <Top of Stack 2> <Target State> <Replacement String for Top of Stack 1> <Replacement String for Top of Stack 2>
B 1 X X C XX XX /*& - lambda*/
A /*Start State*/
1 /*Number of Final States*/
B /*List of Final States*/
```

Once loaded, an input string can be placed in the bottom textbox and simulated after clicking the "Submit" button.
