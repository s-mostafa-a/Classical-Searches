import java.util.ArrayList;

/**
 * Created by ahmadi on 11/15/17.
 */
public class Problem {
    private State firstState;
    protected ArrayList<State> finalStates;
    public Problem(){
    }
    protected void setFirstState(State firstState){
        this.firstState = firstState;
    }
    public State result(Action action, State state){
        return state.next(action);
    }
    public ArrayList<Action> getActionsOfState(State s){
        return s.getActions();
    }
    public boolean isGoal(State state){
        return state.isGoal();
    }
    public int cost(Action action, State state){
        return state.getCost(action);
    }
    public int predict(State state){
        return state.getPredictedCostToDestination();
    }
    public State getFirstState(){
        return firstState;
    }
    public ArrayList<State> getFinalStates() {
        return finalStates;
    }
}