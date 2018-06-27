import java.util.ArrayList;

/**
 * Created by ahmadi on 11/16/17.
 */
public class Q3 extends Problem{
    private State[][] states;
    boolean[][] playGround;
    int playGroundi,playGroundj;
    public Q3( boolean[][] playGround, int playGroundi, int playGroundj){
        super();
        finalStates = new ArrayList<State>();
        states = new State[playGroundi][playGroundj];
        this.playGround = playGround;
        this.playGroundi = playGroundi;
        this.playGroundj = playGroundj;
        for(int i = 0; i < playGroundi; i++)
            for (int j = 0; j < playGroundj; j++)
                states[i][j] = new State(i+""+j, false, Math.abs(playGroundi - i - 1) + Math.abs(playGroundj - j - 1));
        setFirstState(states[0][0]);
        states[playGroundi-1][playGroundj-1].makeGoal();
        finalStates.add(states[playGroundi-1][playGroundj-1]);
        connect();
    }
    private void connect(){
        for(int i = 0; i < playGroundi; i++)
            for (int j = 0; j < playGroundj; j++){
                up(i,j,states[i][j]);
                down(i,j,states[i][j]);
                right(i,j,states[i][j]);
                left(i,j,states[i][j]);
            }
    }
    private void up(int i, int j, State s){
        Action a;
        if((j > 1)&&(playGround[i][j]))
            a = new Action(states[i][j - 1], 1);
        else
            a = new Action(s, 1);
        s.addAction(a);
    }
    private void down(int i, int j, State s){
        Action a;
        if((j < playGroundj - 1)&&(playGround[i][j]))
            a = new Action(states[i][j + 1], 1);
        else
            a = new Action(s, 1);
        s.addAction(a);
    }
    private void right(int i, int j, State s){
        Action a;
        if((i < playGroundi - 1)&&(playGround[i][j]))
            a = new Action(states[i + 1][j], 1);
        else
            a = new Action(s, 1);
        s.addAction(a);
    }
    private void left(int i, int j, State s){
        Action a;
        if((i > 1)&&(playGround[i][j]))
            a = new Action(states[i - 1][j], 1);
        else
            a = new Action(s, 1);
        s.addAction(a);
    }
}
