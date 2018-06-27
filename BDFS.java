import java.util.ArrayList;

/**
 * Created by ahmadi on 12/4/17.
 */
public class BDFS{
    private int limit;
    ArrayList<State> fronts;
    ArrayList<State> ends;
    private int expanded;
    public BDFS(State initialState, int limit){
        fronts = new ArrayList<State>();
        ends = new ArrayList<State>();
        fronts.add(initialState);
        this.limit = limit;
        initialState.setG(0);
        expanded = 0;
    }
    public boolean run(){
        boolean returnValue = false;
        while (true){
            //quit
            if(fronts.isEmpty()){
                System.out.println("NOT FOUND!");
                break;
            }
            int no = 0;
            for(int i = 0; i < fronts.size(); i++)
                if (fronts.get(i).getG()>limit)
                    no++;
            if(no == fronts.size()) {
                System.out.println("NOT FOUND!");
                break;
            }

            //choose
            State iterator = fronts.get(fronts.size() - 1);
            for (int i = fronts.size() - 1; i >=0; i--)
                if (fronts.get(i).getG()<=limit)
                    iterator = fronts.get(i);

            ArrayList<Action> actions = iterator.getActions();
            expanded++;
            //goal test
            if(iterator.isGoal()){
                State goal = iterator;
                returnValue = true;
                System.out.println("Found the answer!");
                System.out.println(iterator.getName()+"\nnext:");
                while(true){
                    State father = iterator.getFather();
                    if(father == null){
                        System.out.println("Finished!");
                        break;
                    }
                    System.out.println(father.getName()+"\nnext:");
                    iterator = father;
                }
                System.out.println("Expanded nodes: " + expanded);
                System.out.println("Visited nodes: "+ (expanded + fronts.size() - 1));
                System.out.println("Cost of path: "+ goal.getG());
                System.out.println("Maximum nodes saved in the main memory: " + (fronts.size() + ends.size()));
                break;
            }
            //was not goal
            for (int i = 0; i < actions.size(); i++){
                if(!fronts.contains(iterator.next(actions.get(i))))
                    if(!ends.contains(iterator.next(actions.get(i)))){
                        fronts.add(iterator.next(actions.get(i)));
                        iterator.next(actions.get(i)).setFather(iterator);
                        iterator.next(actions.get(i)).setG(iterator.getG() + actions.get(i).getCost());
                    }
            }
            fronts.remove(iterator);
            ends.add(iterator);
        }
        return returnValue;
    }
}
