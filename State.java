import java.util.Objects;

public class State {
    public int missionaries; // Number of missionaries on the initial bank
    public int cannibals;    // Number of cannibals on the initial bank
    public int boat;         // Boat position (0 = initial side, 1 = opposite side)
    public int cost;         // Cost (g(n)): Number of crossings so far
    public State parent;     // Parent state (backtracking)

    public State(int missionaries, int cannibals, int boat, int cost, State parent) {
        this.missionaries = missionaries;
        this.cannibals = cannibals;
        this.boat = boat;
        this.cost = cost;
        this.parent = parent;
    }

    // Check if the state is valid
    public boolean isValid(int N) {
        // Invalid if missionaries or cannibals out of bounds
        if (missionaries < 0 || cannibals < 0 || missionaries > N || cannibals > N) {
            return false;
        }

        // Invalid if cannibals more than missionaries on some side
        if ((missionaries < cannibals && missionaries > 0) ||
            (N - missionaries < N - cannibals && N - missionaries > 0)) {
            return false;
        }

        return true;
    }

    // Check if the state is the goal
    public boolean isGoal() {
        return missionaries == 0 && cannibals == 0 && boat == 1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(missionaries, cannibals, boat);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof State)) return false;
        State other = (State) obj;
        return missionaries == other.missionaries &&
               cannibals == other.cannibals &&
               boat == other.boat;
    }

    @Override
    public String toString() {
        return String.format("Missionaries: %d, Cannibals: %d, Boat: %s",
            missionaries, cannibals, (boat == 0 ? "Left" : "Right"));
    }
    
    public int getCost() {return this.cost;}
    public int getMissionaries() {return this.missionaries;}
    public int getCannibals() {return this.cannibals;}
    public int getBoat() {return this.boat;}
    public State getParent() {return this.parent;}

}



