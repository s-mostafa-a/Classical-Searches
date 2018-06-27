import java.util.ArrayList;

/**
 * Created by ahmadi on 12/4/17.
 */
public class BFStree {
    ArrayList<State> fronts;
    private int expanded;
    public BFStree(State initialState){
        fronts = new ArrayList<State>();
        fronts.add(initialState);
        initialState.setG(0);
        expanded = 0;
    }
    public void run(){
        while (true){
            if(fronts.isEmpty()){
                System.out.println("NOT FOUND!");
                break;
            }
            State iterator = fronts.get(0);
            ArrayList<Action> actions = iterator.getActions();
            expanded++;
            if(iterator.isGoal()){
                State goal = iterator;
                System.out.println("Found the answer!");
                System.out.println(iterator.getName()+ "\nnext:");
                while(true){
                    State father = iterator.getFather();
                    if(father == null){
                        System.out.println("Finished!");
                        break;
                    }
                    System.out.println(father.getName()+ "\nnext:");
                    iterator = father;
                }
                System.out.println("Expanded nodes: " + expanded);
                System.out.println("Visited nodes: "+ (expanded + fronts.size() - 1));
                System.out.println("Cost of path: "+ goal.getG());
                System.out.println("Maximum nodes saved in the main memory: " + (fronts.size()));

                break;
            }
            for (int i = 0; i < actions.size(); i++){
                if(!fronts.contains(iterator.next(actions.get(i)))) {
                    fronts.add(iterator.next(actions.get(i)));
                    iterator.next(actions.get(i)).setFather(iterator);
                    iterator.next(actions.get(i)).setG(iterator.getG() + actions.get(i).getCost());
                    }
            }
            fronts.remove(iterator);
        }
    }
}
