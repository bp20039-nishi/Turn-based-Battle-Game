// 人間全員に共通する性質と攻撃を記述
public class Human {
    private String name = null;     // 名前
    private int sei = 0;            // 性別
    private int kougeki = 0;        // 攻撃力
    private int tairyoku = 0;       // 体力
    private int maryoku = 0;        // 魔力
    public Human(){
    }

    // 名前の設定と取得
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    // 性別の設定と取得
    public int getSei(){
        return this.sei;
    }
    public void setSei(int sei){
        this.sei = sei;
    }

    // 攻撃力の設定と取得
    public int getKougeki(){
        return kougeki;
    }
    public void setKougeki(int kougeki){
        this.kougeki = kougeki;
    }

    // 体力の設定と取得
    public int getTairyoku(){
        return tairyoku;
    }
    public void setTiryoku(int tairyoku){
        this.tairyoku = tairyoku;
    }

    // 魔力の設定と取得
    public int getMaryoku(){
        return maryoku;
    }
    public void setMaryoku(int maryoku) {
        this.maryoku = maryoku;
    }

    // 通常攻撃について
    public void tuujou( Human nerai){
        // 攻撃する人の表示
        System.out.println(name +"の　攻撃!!");
        // ダメージ計算
        nerai.setTiryoku(nerai.getTairyoku() - kougeki);
        System.out.println(nerai.getName() + "に"+kougeki+"のダメージ▼");
        System.out.println("");
    }
}

