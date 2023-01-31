// 勇者特有の性質、攻撃について記述

public class Yuusya extends Human{
    public Yuusya(){
        super.setName("勇者");    // 名前
        super.setSei(1);         // 性別
        super.setKougeki(70);    // 攻撃力
        super.setTiryoku(300);   // 体力
        super.setMaryoku(10);    // 魔力
    }

    // 必殺技について(使用時に体力を消費)
    public void hissatuwaza(Human nerai){
        String name = super.getName();
        int rannsuu =  Rannsuu.rannsuu();        // 攻撃成功判定用のランダム数
        // 攻撃開始による体力消費
        super.setTiryoku(super.getTairyoku()-10);
        System.out.println(name+"の　必殺技‼！");
        // 攻撃失敗時
        if(rannsuu < 15){
            System.out.println("しかし、"+name+"の必殺技は外れてしまった！");
        }
        // 攻撃成功時
        else {
            System.out.println(name + "の必殺技がさくれつした！");
            // ダメージ計算
            nerai.setTiryoku(nerai.getTairyoku() - 120);
            System.out.println(nerai.getName() + "に120のダメージ");
            // 攻撃成功による体力消費
            super.setTiryoku(super.getTairyoku() - 30);
        }
        // 残存体力表示
        System.out.println(name+"の体力は"+super.getTairyoku()+"になった▼");
        System.out.println("");
    }
}
