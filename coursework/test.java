import Character.*;
import Regular_Enemies.*;
import Game_Play.*;
import Bosses.*;

public class test {
    public static void main(String[] args) {
        Hero h1 = new Hero();
        Boss b1 = new Bramzark();
        BossFight f1 = new BossFight(h1, b1);
    }
}
