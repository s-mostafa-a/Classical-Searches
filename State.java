import java.util.ArrayList;

/**
 * Created by ahmadi on 11/15/17.
 */
public class State {
    private ArrayList<Action> actions;
    private boolean isGoal;
    private int predictedCostToDistination;
    private String name;
    private State father;
    private int g;
    public State(String name, boolean isGoal, int predictedCostToDistination){
        this.name = name;
        this.isGoal = isGoal;
        this.actions = new ArrayList<Action>();
        this.predictedCostToDistination = predictedCostToDistination;
        father = null;
    }
    public State next(Action action){
        for(int i = 0; i < actions.size(); i++)
            if(action == actions.get(i))
                return action.getSecond();
        System.out.printf("the Action does not exist in this State!");
        return null;
    }
    public boolean isGoal(){
        return isGoal;
    }

    public String getName() {
        return name;
    }

    public void makeGoal(){
        isGoal = true;
    }
    public void addAction(Action action){
        actions.add(action);
    }
    public int getCost (Action action){
        return action.getCost();
    }
    public void setPredictedCostToDistination(int cost){
        predictedCostToDistination = cost;
    }
    public int getPredictedCostToDestination(){
        return predictedCostToDistination;
    }
    public ArrayList<Action> getActions(){
        return actions;
    }

    public State getFather() {
        return father;
    }

    public void setFather(State father) {
        this.father = father;
    }
    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }
}