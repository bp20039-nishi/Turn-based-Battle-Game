// 僧侶特有の性質や攻撃を記述

public class Souryo extends Human{
    public Souryo(){
        super.setName("僧侶");    // 名前
        super.setSei(2);         // 性別
        super.setKougeki(60);     // 攻撃力
        super.setTiryoku(250);   // 体力
        super.setMaryoku(250);   // 魔力
    }

    // 回復魔法について(使用時に魔力を消費)
    public void kaihukumahou(Human nerai){
        String name = super.getName();
        int rannsuu =  Rannsuu.rannsuu();     // 詠唱成功判定用のランダム数
        System.out.println(name+"は回復呪文を唱えた");
        // 魔力が足りているか判定
        if( getMaryoku() < 50 ){
            System.out.println("しかし、"+name+"は魔力が足りないようだ");
        }
        // 足りていた場合
        else {
            // 詠唱開始による魔力消費
            super.setMaryoku(super.getMaryoku() - 20);
            // 詠唱失敗時
            if (rannsuu < 10) {
                System.out.println("しかし、"+name + "は呪文の詠唱に失敗してしまった！！");
            }
            // 詠唱成功時
            else {
                System.out.println(name + "の魔法が発動！！");
                // 体力回復計算
                nerai.setTiryoku(nerai.getTairyoku() + 40);
                System.out.println(nerai.getName() + "の体力は" + nerai.getTairyoku() + "になった");
                // 魔法発動による魔力消費
                super.setMaryoku(super.getMaryoku() - 30);
            }
        }
        // 残存魔力表示
        System.out.println(name+"の魔力は"+super.getMaryoku() +"になった▼");
        System.out.println("");
    }
}
