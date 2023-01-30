// ランダムな数を提供する

import java.util.Random;

public class Rannsuu {
    public static int rannsuu(){
        Random r = new Random();
        return r.nextInt(100);  // ０以上100未満のランダムな数を返す。
    }
}
