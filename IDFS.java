/**
 * Created by ahmadi on 12/4/17.
 */
public class IDFS {
    State initialState;
    public IDFS(State initialState){
        this.initialState = initialState;
    }
    public void run(){
        for(int i = 1; i < i + 1; i++){
            System.out.println("Checking for depth limit: " + i);
            BDFS bdfs = new BDFS(initialState, i);
            if(bdfs.run())
                break;
        }
    }
}
