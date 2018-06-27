import java.util.ArrayList;

/**
 * Created by ahmadi on 11/27/17.
 */
public class BiBFS {
    ArrayList<ArrayList<State>> fronts;
    ArrayList<ArrayList<State>> ends;
    ArrayList<State> mainFront;
    ArrayList<State> mainEnd;
    State initialState;
    public BiBFS(State initialState, ArrayList<State> finalStates){
        fronts = new ArrayList<ArrayList<State>>();
        ends = new ArrayList<ArrayList<State>>();
        mainFront = new ArrayList<State>();
        mainEnd = new ArrayList<State>();
        mainFront.add(initialState);
        for(int i = 0; i < finalStates.size(); i++) {
            fronts.add(new ArrayList<State>());
            fronts.get(i).add(finalStates.get(i));
            ends.add(new ArrayList<State>());
        }
        this.initialState = initialState;
        initialState.setG(0);
    }
    public void run(){
        while(true){
            State iterator;
            ArrayList<Action> actions;
            if(mainFront.isEmpty()){
                System.out.println("NOT FOUND!");
                break;
            }
            int counter = 0;
            for(int i = 0; i < fronts.size(); i++)
                if (fronts.get(i).isEmpty())
                    counter++;
            if(counter == fronts.size()){
                System.out.println("NOT FOUND!");
                break;
            }
            boolean breakCondition = false;
            iterator = mainFront.get(0);
            actions = iterator.getActions();
            /////////gostareshe init va check bara eshterak
            for (int i = 0; i < actions.size(); i++){
                if(!mainFront.contains(iterator.next(actions.get(i))))
                    if(!mainEnd.contains(iterator.next(actions.get(i)))){
                        mainFront.add(iterator.next(actions.get(i)));
                        for(int z = 0; z < fronts.size(); z++)
                            if (fronts.get(z).contains(iterator.next(actions.get(i)))){
                                System.out.println("Found the answer!");
                                foundIntersection(iterator, iterator.next(actions.get(i)));
                                int expanded = mainEnd.size();
                                for(int ex = 0; ex < ends.size(); ex++)
                                    expanded = expanded + ends.get(ex).size();
                                System.out.println("Expanded nodes: " + expanded);
                                int jolo = mainFront.size();
                                for (int jol = 0; jol < fronts.size(); jol++)
                                    jolo = jolo + fronts.get(jol).size();
                                System.out.println("Visited nodes: "+ (expanded + jolo));
                                int mem = jolo + expanded;
                                System.out.println("Maximum nodes saved in the main memory: " + (mem));
                                breakCondition = true;
                                break;
                            }
                        iterator.next(actions.get(i)).setFather(iterator);
                    }
                if(breakCondition)
                    break;
            }
            if(breakCondition)
                break;
            mainFront.remove(iterator);
            mainEnd.add(iterator);
            /////////gostareshe init va check bara eshterak
/**/
            /////////gostareshe final va check bara eshterak
            for(int i = 0; i < fronts.size(); i++) {
                if (!fronts.get(i).isEmpty()) {
                    iterator = fronts.get(i).get(0);
                    actions = iterator.getActions();
                    for (int j = 0; j < actions.size(); j++)
                        if (!fronts.get(i).contains(iterator.next(actions.get(j))))
                            if (!ends.get(i).contains(iterator.next(actions.get(j)))) {
                                fronts.get(i).add(iterator.next(actions.get(j)));
                                if (mainFront.contains(iterator.next(actions.get(j)))) {
                                    System.out.println("Found the answer!");
                                    foundIntersection(iterator.next(actions.get(j)), iterator);
                                    int expanded = mainEnd.size();
                                    for(int ex = 0; ex < ends.size(); ex++)
                                        expanded = expanded + ends.get(ex).size();
                                    System.out.println("Expanded nodes: " + expanded);
                                    int jolo = mainFront.size();
                                    for (int jol = 0; jol < fronts.size(); jol++)
                                        jolo = jolo + fronts.get(jol).size();
                                    System.out.println("Visited nodes: "+ (expanded + jolo));
                                    int mem = jolo + expanded;
                                    System.out.println("Maximum nodes saved in the main memory: " + (mem));
                                    breakCondition = true;
                                    break;
                                } else
                                    iterator.next(actions.get(j)).setFather(iterator);
                            }
                    if(breakCondition)
                        break;
                    fronts.get(i).remove(iterator);
                    ends.get(i).add(iterator);
                }
            }
            if (breakCondition)
                break;
            /**/
            /////////gostareshe final va check bara eshterak

        }
    }
    private void foundIntersection(State firstIterator, State secondIterator){
        ArrayList<State> secondHalfSolution = new ArrayList<State>();
        State it = secondIterator;
        int sec = 0;
        while(true){
            if(it != null){
                secondHalfSolution.add(it);
                sec++;
            }
            else
                break;
            it = it.getFather();
        }
        ArrayList<State> firstHalfSolution = new ArrayList<State>();
        it = firstIterator;
        int fir = 0;
        while (true){
            if(it != null) {
                firstHalfSolution.add(it);
                fir++;
            }
            else
                break;
            it = it.getFather();
        }
        for(int z = secondHalfSolution.size() - 1; z >= 0; z--)
            System.out.println(secondHalfSolution.get(z).getName()+"\nnext:");
        // inja menha yeko tokhmi gozashtam TODO
        for(int z = 0; z < firstHalfSolution.size()-1; z++)
            System.out.println(firstHalfSolution.get(z).getName()+"\nnext");
        System.out.println("Cost of path: "+ (fir+sec));
    }
}