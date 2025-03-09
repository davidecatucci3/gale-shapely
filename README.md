# gale-shapley
This Java project implements a stable matching algorithm between two sets of entities (e.g., men and women, students and schools, or hospitals and residents). The algorithm follows a proposal-acceptance pattern as the the Gale-Shapley algorithm, adapted for custom preference handling

## Runtime
The time complexity of the algorithm is 0(n^2) where n is the number of proposeres that is equal to the number of acceptors, this algorithm do not implement some more efficient
data structures as double linked list and other things to speed up the runtime of the algoeithm, they will be implemented in the future 

## Files
- Main.java: implementation of the algorithm
- TestMain.java: use the algorithm

## How it works
The algorithm works through iterative proposals:
1. Unmatched entities propose to their next preferred choice
2. Targets accept or refuse proposals based on their own rankings
3. Process continues until all entities are matched

### Key Components
- `apref`: Preference list for proposers (1-based indices)
- `ranking`: Preference rankings for acceptors (1-based indices)
- `matchings`: Stores final matches (1-based in output)

## Input format
Both input arrays should be matrices with 1-based indices:

1. `apref`: Proposer preferences
```java
int[][] apref = {
    {4, 1, 2, 3},  // Proposer 1's preferences
    {3, 1, 4, 2},  // Proposer 2's preferences
    // ... etc
};
```
2. `ranking`: Acceptor rankings
```java
int[][] ranking = {
    {2, 3, 4, 1},  // Acceptor 1's rankings
    {3, 1, 4, 2},  // Acceptor 2's rankings
    // ... etc
};
```

## How to use it 
```java
Main algo = new Main(apref, ranking);

int[][] results = algo.run();

// Results format: [[proposer, acceptor], ...]
[[1, 4], [2, 3], [3, 2], [4, 1]]
```
