import java.util.*;

public class MissionariesCannibals {

    //A* implmentation
    public static State aStarSearch(int N, int M, int K) {
        PriorityQueue<State> openSet = new PriorityQueue<>(
            new Comparator<State>() {
                @Override
                public int compare(State s1, State s2) {
                    return (s1.getCost() + hFunc.heuristic(s1, M)) - (s2.getCost() + hFunc.heuristic(s2,M));
                }
            }
        );
        Set<State> closedSet = new HashSet<>();

        State initialState = new State(N, N, 0, 0, null);
        openSet.add(initialState);

        while (!openSet.isEmpty()) {
            State current = openSet.poll();

            // Return solution if found
            if (current.isGoal()) {
                return current;
            }

            closedSet.add(current);

            // Check for valid successors
            for (State newState : hFunc.getDerStates(current, N, M)) {
                // Skip if states alrd visited or if crossings more than limit 
                if (closedSet.contains(newState) || newState.getCost() > K) {
                    continue;
                }

                // Add valid state to the open set
                openSet.add(newState);
            }
        }

        return null; // No solution found
    }

    public static void printSolution(State state) {
        List<State> path = new ArrayList<>();
        while (state != null) {
            path.add(state);
            state = state.getParent();
        }

        Collections.reverse(path);
        int order = 1;
        for (State step : path) {
            System.out.println(order + ") " + step.toString());
            order++;
        }

        System.out.println("\nTotal boat crosses: " + (path.size()-1));
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // Number of missionaries/cannibals
        int M = Integer.parseInt(args[1]); // Boat capacity
        int K = Integer.parseInt(args[2]); // Max crossings

        long startT = System.currentTimeMillis();
        State solution = aStarSearch(N,M,K);
        long endT = System.currentTimeMillis();
        if (solution != null) {
            System.out.println("________________________________________________________");
            System.out.println("Solution found for Missionaries/Cannibals=" + N + ", Boat size=" + M + ", Max trips=" + K);
            printSolution(solution);
            System.out.println("\nTime taken: " + (double)(endT - startT) + "ms");
            System.out.println("________________________________________________________");
        } else {
            System.out.println("________________________________________________________");
            System.out.println("No solution found.");
            System.out.println("Time taken: " + (double)(endT - startT) + "ms");
            System.out.println("________________________________________________________");
        }
    }
}
