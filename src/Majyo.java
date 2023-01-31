// 魔女特有の性質、攻撃について記述
public class Majyo extends Human{
    public Majyo(){
        super.setName("魔女");    // 名前
        super.setSei(2);         // 性別
        super.setKougeki(60);     // 攻撃力
        super.setTiryoku(250);   // 体力
        super.setMaryoku(200);   // 魔力
    }
    // 魔法攻撃について(使用時に魔力を消費)
    public void mahoukougeki(Human nerai){
        String name = super.getName();
        int rannsuu =  Rannsuu.rannsuu();       // 攻撃成功判定用のランダム数
        System.out.println(name+"の魔法攻撃");
        // 魔力が足りているか判定
        if( getMaryoku() < 50 ){
            System.out.println("しかし、"+name+"は魔力が足りないようだ");
        }
        // 足りていた場合実行
        else {
            // 詠唱開始による魔力消費
            super.setMaryoku(super.getMaryoku() - 20);
            // 詠唱失敗時
            if (rannsuu < 10) {
                System.out.println("しかし、"+name + "は呪文の詠唱に失敗してしまった！！");
            }
            // 詠唱成功時
            else {
                System.out.println(name + "の魔法がさくれつした！！");
                // ダメージ計算
                nerai.setTiryoku(nerai.getTairyoku() - 100);
                System.out.println(nerai.getName() + "に100のダメージ");
                // 魔法発動による魔力消費
                super.setMaryoku(super.getMaryoku() - 30);
            }
        }
        // 残存魔力消費
        System.out.println(name+"の魔力は"+super.getMaryoku() +"になった▼");
        System.out.println("");
    }
}
