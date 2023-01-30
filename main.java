import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Yuusya yuusya = new Yuusya();      // 勇者オブジェクト生成
        Majyo majyo = new Majyo();         // 魔女オブジェクト生成
        Souryo souryo = new Souryo();      // 僧侶オブジェクト生成
        Maou maou = new Maou();            // 魔王オブジェクト生成
        Scanner scanner = new Scanner(System.in);  // キーボード入力読み込み用
        int rannsuu;           // 魔王の攻撃先のランダム判定用
        int t = 0;             // 魔王の生死判定用
        int y = 0;             // 勇者の生死判定用
        int m = 0;             // 魔女の生死判定用
        int s = 0;             // 僧侶の生死判定用
        int turn = 1;          // ターン数の記憶
        int k;                 // 攻撃選択の記憶

        BufferedReader reader = new BufferedReader(new InputStreamReader(
        System.in));

        System.out.println(maou.getName()+"があらあれた！▼");
        // 勇者チームが三人倒れるか、魔王が倒れるまで無限ループ
        // 画面表示のコントロール用
        try {
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            System.out.println("");
            System.out.println("");
            // ターン数表示
            System.out.println(turn+"ターン目▼");
            System.out.println("");
            try {
                reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 勇者が生きている場合のみ実行する勇者のターン
            if(y != 1) {
                System.out.println("勇者のターン");
                // 攻撃方法の選択、実行
                System.out.println("1->通常攻撃　　2->必殺技");
                k = scanner.nextInt();
                // 「必殺技」選択時
                if (k == 2) {
                    yuusya.hissatuwaza(maou);
                }
                // 「通常攻撃」選択時
                else {
                    yuusya.tuujou(maou);
                }
                // 魔王の生死判定
                if (maou.getTairyoku() <= 0) {
                    t = 1;
                    break;
                }
                // 必殺技の自傷ダメージによる、勇者の生死判定
                if (yuusya.getTairyoku() <= 0 ) {
                    y = 1;
                    System.out.println("勇者は倒れてしまった....▼");
                    System.out.println("");
                    // 他の二人がすでに倒れていた場合、戦闘終了
                    if(m + s == 2)
                        break;
                }
                try {
                    reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // 魔女が生きている場合のみ実行する魔女のターン
            if(m != 1) {



                System.out.println("魔女のターン");
                // 攻撃方法の選択、実行
                System.out.println("1->通常攻撃　　2->魔法攻撃");
                k = scanner.nextInt();
                // 「魔法攻撃」選択時
                if (k == 2) {
                    majyo.mahoukougeki(maou);
                }
                // 「通常攻撃」選択時
                else {
                    majyo.tuujou(maou);
                }
                // 魔王の生死判定
                if (maou.getTairyoku() <= 0) {
                    t = 1;
                    break;
                }
            }

            // 魔王のターン
            System.out.println("魔王のターン▼");
            try {
                reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 攻撃方法選択用のランダム数
            rannsuu =  Rannsuu.rannsuu();

            // 「暗黒魔法」選択時
            if( rannsuu < 30 ) {
                // 攻撃先決定用のランダム数
                rannsuu = Rannsuu.rannsuu();

                // 勇者チーム全員生存時、全員の中からランダムで攻撃
                if (y + s + m == 0) {
                    if (rannsuu <= 30) {
                        maou.annkokumahou(souryo);
                    } else if (rannsuu <= 60)
                        maou.annkokumahou(majyo);
                    else
                        maou.annkokumahou(yuusya);
                }
                // 勇者チーム二名生存時
                else if(y + s + m == 1){
                    if(y==1){       // 勇者のみ死亡時、魔女、僧侶の中からランダムで攻撃
                        if (rannsuu <= 50)
                            maou.annkokumahou(souryo);
                        else
                            maou.annkokumahou(majyo);
                    }
                    if(s == 1){     // 僧侶のみ死亡時、勇者、魔女の中からランダムで攻撃
                        if (rannsuu <= 60)
                            maou.annkokumahou(yuusya);
                        else
                            maou.annkokumahou(majyo);
                    }
                    if(m == 1){     // 魔女のみ死亡時、勇者、僧侶の中からランダムで攻撃
                        if (rannsuu <= 60)
                            maou.annkokumahou(yuusya);
                        else
                            maou.annkokumahou(souryo);
                    }
                }
                // 勇者チーム一名生存時
                else{
                    if(y == 0)      // 勇者のみ生存時、勇者に攻撃
                        maou.annkokumahou(yuusya);
                    else if(s == 0) // 僧侶のみ生存時、僧侶に攻撃
                        maou.annkokumahou(souryo);
                    else            // 魔女のみ生存時、魔女に攻撃
                        maou.annkokumahou(majyo);
                }

            }
            // 「通常攻撃」選択時
            else if( rannsuu < 80 ){
                // 攻撃先決定用のランダム数
                rannsuu = Rannsuu.rannsuu();

                // 以下、「暗黒魔法」と同様
                if (y + s + m == 0) {
                    if (rannsuu <= 30) {
                        maou.tuujou(souryo);
                    } else if (rannsuu <= 60)
                        maou.tuujou(majyo);
                    else
                        maou.tuujou(yuusya);
                }
                else if(y + s + m == 1){
                    if(y==1){
                        if (rannsuu <= 50)
                            maou.tuujou(souryo);
                        else
                            maou.tuujou(majyo);
                    }
                    if(s == 1){
                        if (rannsuu <= 60)
                            maou.tuujou(yuusya);
                        else
                            maou.tuujou(majyo);
                    }
                    if(m == 1){
                        if (rannsuu <= 60)
                            maou.tuujou(yuusya);
                        else
                            maou.tuujou(souryo);
                    }
                }
                else{
                    if(y == 0)
                        maou.tuujou(yuusya);
                    else if(s == 0)
                        maou.tuujou(souryo);
                    else
                        maou.tuujou(majyo);
                }

            }
            else
                maou.kaihuku();
            // 勇者の死亡判定
            if(yuusya.getTairyoku() <= 0 && y == 0) {
                scanner.nextLine();

                y = 1;
                System.out.println("勇者は倒れてしまった....▼");
                System.out.println("");
            }
            // 魔女の死亡判定
            if(majyo.getTairyoku() <= 0 && m == 0) {
                scanner.nextLine();

                m = 1;
                System.out.println("魔女は倒れてしまった....▼");
                System.out.println("");
            }
            // 僧侶の死亡判定
            if(souryo.getTairyoku() <= 0 && s == 0) {
                scanner.nextLine();

                s = 1;
                System.out.println("僧侶は倒れてしまった....▼");
                System.out.println("");
            }
            // 勇者チーム全滅の場合、戦闘終了
            if(y + m + s == 3)
                break;

            // 僧侶のターン
            if(s != 1) {
                try {
                    reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("僧侶のターン");
                // 行動選択、実行
                System.out.println("1->通常攻撃　　2->回復魔法");
                k = scanner.nextInt();
                // 「回復魔法」選択時
                if (k == 2) {
                    // 回復先の選択
                    System.out.println("誰を回復しますか？");
                    System.out.println("1->勇者(体力："+yuusya.getTairyoku()+")　" +
                                        "2->魔女（体力："+majyo.getTairyoku()+"）　" +
                                        "3->僧侶（体力："+souryo.getTairyoku()+"）");
                    k = scanner.nextInt();
                    if (k == 1)
                        souryo.kaihukumahou(yuusya);
                    else if (k == 2)
                        souryo.kaihukumahou(majyo);
                    else
                        souryo.kaihukumahou(souryo);
                }
                // 「通常攻撃」選択時
                else
                    souryo.tuujou(maou);

                // 魔王の死亡判定
                if (maou.getTairyoku() <= 0) {
                    t = 1;
                    break;
                }
            }

            System.out.println("");
            // ターン終了時のリザルト（各体力、魔力残存量）表示
            try {
                reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("/^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println(" 勇者");
            System.out.println(" 残り体力"+yuusya.getTairyoku()+"、残り魔力"+yuusya.getMaryoku());
            System.out.println(" 魔女");
            System.out.println(" 残り体力"+majyo.getTairyoku()+"、残り魔力"+majyo.getMaryoku());
            System.out.println(" 僧侶");
            System.out.println(" 残り体力"+souryo.getTairyoku()+"、残り魔力"+ souryo.getMaryoku());
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^/");
            turn ++;
        }
        // 戦闘終了

        // 魔王死亡により、戦闘終了した場合
        if (t == 1){
            System.out.println("魔王は倒れた....▼");
            try {
                reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("");
            System.out.println("おめでとう！！世界に平和が戻った！");
        }
        // 勇者パーティー全滅により、戦闘終了した場合
        else{
            System.out.println("勇者達は魔王に敗れてしまった...▼");
            try {
                reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("魔王の残り体力:" + +maou.getTairyoku());
        }
    }
}
