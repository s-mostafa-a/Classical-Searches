
/**
 * Created by ahmadi on 11/27/17.
 */
public class Main {
    public static void main(String[] args) {
        boolean[][] divar = new boolean[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                divar[i][j] = true;
        divar[3][0] = false;
        divar[3][1] = false;
        //divar[3][2] = false;
        divar[3][3] = false;
        divar[3][4] = false;

        Problem soal = new Q3(divar,5,5);
        IDFS bfs = new IDFS(soal.getFirstState());
        bfs.run();
    }
}
