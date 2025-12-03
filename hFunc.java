import java.util.ArrayList;
import java.util.List;

public class hFunc {
    // heuristic function 
    public static int heuristic(State state, int M) {
        int peopleLeft = state.getMissionaries() + state.getCannibals();
        int result = (int) Math.ceil((double) peopleLeft/M) + state.getBoat();
        return result;
    }

    // create derivative states
    public static List<State> getDerStates(State state, int N, int M) {
        List<State> derStates = new ArrayList<>();
        int boatDirection;
        if (state.getBoat() == 0) boatDirection = 1;
        else boatDirection = -1;

        for (int m = 0; m <= M; m++) {
            for (int c = 0; c <= M; c++) {
                // None or too many people in boat
                if (m + c == 0 || m + c > M) continue;
                // More cannibals than missionaries in boat
                if (M>2 && m>0 && c>m) continue;

                State newState = new State(
                    state.getMissionaries() - m * boatDirection,
                    state.getCannibals() - c * boatDirection,
                    1 - state.getBoat(),
                    state.getCost() + 1,
                    state
                );
                if (newState.isValid(N)) {
                    derStates.add(newState);
                }
            }
        }

        return derStates;
    }
}
