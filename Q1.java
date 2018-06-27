import java.util.ArrayList;

/**
 * Created by ahmadi on 11/15/17.
 */
public class Q1 extends Problem {
    private State[][] states;
    public Q1(){
        super();
        finalStates = new ArrayList<State>();
        states = new State[4][5];
        for(int i = 0; i <= 3; i++)
            for (int j = 0; j <= 4; j++){
                states[i][j] = new State("Glass1: " + i + "\nGlass2: " + j, false, 0);
                if (j == 2){
                    states[i][j].makeGoal();
                    finalStates.add(states[i][j]);
                }

            }
        setFirstState(states[0][0]);
        connect();
    }
    private void connect(){
        for(int i = 0; i <= 3; i++)
            for (int j = 0; j <= 4; j++){
                empty4(i,j,states[i][j]);
                empty3(i,j,states[i][j]);
                threeTo4(i,j,states[i][j]);
                fourTo3(i,j,states[i][j]);
                fill4(i,j,states[i][j]);
                fill3(i,j,states[i][j]);
            }
    }
    private void empty4(int index3,int index4,State s){
        Action a = new Action(states[index3][0], 1);
        s.addAction(a);
    }
    private void empty3(int index3,int index4,State s){
        Action a = new Action(states[0][index4], 1);
        s.addAction(a);
    }
    private void threeTo4(int index3,int index4,State s){
        Action a;
        if(index4 + index3 <= 4)
            a = new Action(states[0][index3 + index4], 1);
        else
            a = new Action(states[index3 - (4 - index4)][4], 1);
        s.addAction(a);
    }
    private void fourTo3(int index3,int index4,State s){
        Action a;
        if(index4 + index3 <= 3)
            a = new Action(states[index3 + index4][0], 1);
        else
            a = new Action(states[3][index4 - (3 - index3)], 1);
        s.addAction(a);
    }
    private void fill4(int index3,int index4,State s){
        Action a = new Action(states[index3][4], 1);
        s.addAction(a);
    }
    private void fill3(int index3,int index4,State s){
        Action a = new Action(states[3][index4], 1);
        s.addAction(a);
    }


}
