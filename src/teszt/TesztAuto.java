package teszt;

import main.Auto;

public class TesztAuto {
    public static void main(String[] args) {
        new TesztAuto().tesztesetek();
    }

    private void tesztesetek() {
        kerekCsereTeszt();
        tankolTeszt();
    }
    
    private void kerekCsereTeszt() {
        Auto auto = new Auto();
        auto.kerekCsere();
        int kapott = auto.getPotkerek();
        int vart = 0;
        assert kapott == vart : "kerékcsere hiba";
        
        auto = new Auto();
        auto.kerekCsere();
        kapott = auto.getPotkerek();
        vart = 1;
        assert kapott == vart : "kerékcsere hiba";
        
        auto = new Auto();
        auto.kerekCsere();
        kapott = auto.getPotkerek();
        vart = -2;
        assert kapott == vart : "kerékcsere hiba";
     
    }

    private void tankolTeszt() {
        Auto auto = new Auto();
        auto.tankol();
        kapott = ;
    }
    
}
