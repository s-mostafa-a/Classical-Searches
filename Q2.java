import java.util.ArrayList;

/**
 * Created by ahmadi on 11/16/17.
 */
public class Q2 extends Problem{
    private ArrayList<State> states;

    public Q2(){
        super();
        states = new ArrayList<State>();
        states.add(new State("102345678",false,2));
        finalStates = new ArrayList<State>();
        this.setFirstState(states.get(0));
        makeGraph();
    }
    private void makeGraph(){
        State it;
        int j = states.size();
        for(int i = 0; i < j; i++){
            it = states.get(i);
            if(it.getName().compareTo("012345678") == 0){
                System.out.println("goal darim");
                it.makeGoal();
                finalStates.add(it);
            }
            if(it.getActions().size() < 4){
                up(it);
                down(it);
                right(it);
                left(it);
            }
            j = states.size();
        }

    }
    private void up(State s){
        char[] ch = s.getName().toCharArray();
        int zeroIndex = -1;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '0')
                zeroIndex = i;
        }
        if (zeroIndex == -1)
            System.out.printf("zero index has not initialised!\n");
        Action action;
        if(zeroIndex >=3){
            ch[zeroIndex] = ch[zeroIndex - 3];
            ch[zeroIndex - 3] = '0';
            State next = new State(String.valueOf(ch),false, predict(String.valueOf(ch)));
            int flag = 0;
            for(int i = 0; i < states.size(); i++){
                if(states.get(i).getName().compareTo(String.valueOf(ch)) == 0){
                    next = states.get(i);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                states.add(next);
            }
            action = new Action(next,1);
        }
        else
            action = new Action(s, 1);
        s.addAction(action);
    }
    private void down(State s){
        char[] ch = s.getName().toCharArray();
        int zeroIndex = -1;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '0')
                zeroIndex = i;
        }
        if (zeroIndex == -1)
            System.out.printf("zero index has not initialised!\n");
        Action action;
        if(zeroIndex < 6){
            ch[zeroIndex] = ch[zeroIndex + 3];
            ch[zeroIndex + 3] = '0';
            State next = new State(String.valueOf(ch),false,predict(String.valueOf(ch)));
            int flag = 0;
            for(int i = 0; i < states.size(); i++){
                if(states.get(i).getName().compareTo(String.valueOf(ch)) == 0){
                    next = states.get(i);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                states.add(next);
            }
            action = new Action(next,1);
        }
        else
            action = new Action(s, 1);
        s.addAction(action);
    }
    private void right(State s){
        char[] ch = s.getName().toCharArray();
        int zeroIndex = -1;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '0')
                zeroIndex = i;
        }
        if (zeroIndex == -1)
            System.out.printf("zero index has not initialised!\n");
        Action action;
        if((zeroIndex !=2 )&&(zeroIndex !=5 )&&(zeroIndex !=8 )){
            ch[zeroIndex] = ch[zeroIndex + 1];
            ch[zeroIndex + 1] = '0';
            State next = new State(String.valueOf(ch),false,predict(String.valueOf(ch)));
            int flag = 0;
            for(int i = 0; i < states.size(); i++){
                if(states.get(i).getName().compareTo(String.valueOf(ch)) == 0){
                    next = states.get(i);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                states.add(next);
            }
            action = new Action(next,1);
        }
        else
            action = new Action(s, 1);
        s.addAction(action);
    }
    private void left(State s){
        char[] ch = s.getName().toCharArray();
        int zeroIndex = -1;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '0')
                zeroIndex = i;
        }
        if (zeroIndex == -1)
            System.out.printf("zero index has not initialised!\n");
        Action action;
        if((zeroIndex !=0 )&&(zeroIndex !=3 )&&(zeroIndex !=6 )){
            ch[zeroIndex] = ch[zeroIndex - 1];
            ch[zeroIndex - 1] = '0';
            State next = new State(String.valueOf(ch),false,predict(String.valueOf(ch)));
            int flag = 0;
            for(int i = 0; i < states.size(); i++){
                if(states.get(i).getName().compareTo(String.valueOf(ch)) == 0){
                    next = states.get(i);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                states.add(next);
            }
            action = new Action(next,1);
        }
        else
            action = new Action(s, 1);
        s.addAction(action);
    }
    int predict(String s){
        char[] ch = s.toCharArray();
        int zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0,eight = 0;
        for(int i = 0; i < ch.length; i ++){
            if(ch[i] == '0')
                zero = Math.abs(i - 0);
            if(ch[i] == '1')
                one = Math.abs(i - 1);
            if(ch[i] == '2')
                two = Math.abs(i - 2);
            if(ch[i] == '3')
                three = Math.abs(i - 3);
            if(ch[i] == '4')
                four = Math.abs(i - 4 );
            if(ch[i] == '5')
                five = Math.abs(i - 5);
            if(ch[i] == '6')
                six = Math.abs(i - 6);
            if(ch[i] == '7')
                seven = Math.abs(i - 7);
            if(ch[i] == '8')
                eight = Math.abs(i - 8);
        }

        return zero + one + two + three + four + five + six + seven + eight;
    }
}
