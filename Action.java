/**
 * Created by ahmadi on 11/15/17.
 */
public class Action {
    private State second;
    private int cost;
    public Action(State second, int cost){
        this.cost = cost;
        this.second = second;
    }
    public State getSecond() {
        return second;
    }
    public int getCost(){
        return cost;
    }
}
