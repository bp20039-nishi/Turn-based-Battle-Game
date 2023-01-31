// 魔王特有の性質と攻撃を記述
public class Maou extends Human{
    public Maou(){
        super.setName("魔王");      // 名前
        super.setSei(1);           // 性別
        super.setKougeki(110);     // 攻撃力
        super.setTiryoku(1000);   // 体力
        super.setMaryoku(500);     // 魔力
    }

    // 自己回復魔法について(使用時に魔力を消費)
    public void kaihuku(){
        String name = super.getName();
        System.out.println(name+"は回復魔法を唱えた");
        // 体力計算
        super.setTiryoku(super.getTairyoku() + 100);
        System.out.println(super.getName() + "の体力が200回復した！！");
        // 魔法発動による魔力消費
        super.setMaryoku(super.getMaryoku() - 30);
        // 残存魔力表示
        System.out.println(name+"の魔力は"+super.getMaryoku() +"になった");
        System.out.println("");
    }

    // 暗黒魔法について(使用時に魔力を消費)
    public void annkokumahou(Human nerai){
        String name = super.getName();
        int rannsuu =  Rannsuu.rannsuu();      // 攻撃成功判定用のランダム数

        System.out.println(name+"は暗黒魔法を唱えた");
        // 魔力が足りるか判定
        if(getMaryoku() < 70) {
            System.out.println("しかし、"+name+"は魔力が足りないようだ");
        }
        // 足りている場合
        else {
            // 詠唱開始による魔力消費
            super.setMaryoku(super.getMaryoku() - 40);
            // 詠唱失敗時
            if (rannsuu < 20) {
                System.out.println("しかし、"+name + "は呪文の詠唱に失敗した！！");
            }
            // 詠唱成功時
            else {
                System.out.println(name + "の魔法が発動！！");
                // ダメージ計算
                nerai.setTiryoku(nerai.getTairyoku() - 200);
                System.out.println(nerai.getName() + "は200のダメージを受けた！！");
                // 魔法発動による魔力消費
                super.setMaryoku(super.getMaryoku() - 60);
            }
        }
        // 残存魔力表示
        System.out.println(name+"の魔力は"+super.getMaryoku() +"になった▼");
        System.out.println("");
    }
}
