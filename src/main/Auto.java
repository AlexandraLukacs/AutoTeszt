package main;

/* SPECIFIKÁCIÓ:
Ha egy autóval megyünk, akkor elfogy az üzemanyag. 
Ha tankoltunk, akkor újra tudunk menni, lesz üzemanyag.
Csak akkor tudunk menni, ha be van indítva az autó.
Csak akkor tudunk tankolni, ha le van állítva az autó.
TODO:
Van pótkerék, kaphatunk defektet, lehet kereket cserélni:
 - Meg lehet adni a pótkerekek számát (lehet 0 is), ha nem adjuk meg, akkor 1.
 - Ha megy az autó 20% eséllyel kaphat defektet!
 - Ha defektet kapott, nem fogy el az üzemanyag!
 - Nem csak defektes kereket cserélhetünk!
 - Ha lecseréltük a defektes kereket, csökken a pótkerekek száma!
 - Ha nincs több pótkerék, nem tudunk cserélni többet! 
 - Defekttel nem haladhatunk!
//// specifikáció vége */

public class Auto {
    /* ADATTAGOK */
    private static int objektumDb = 0; //osztály adattagja, lehet itt inicializálni
    
    /* objektum adattagokat a konstruktor inicializál: */
    private boolean uzemanyag; //példány v. másnéven az objektum adattagja
    private boolean beinditva; //példány v. másnéven az objektum adattagja
   
    private boolean defekt;
    private int potkerek;
    
    /* TAGFÜGGVÉNYEK */
    /* kstr hívási lánc: túlterhelt kstr hívja a másik kstr-t */
    public Auto(){
        /* semmi nem lehet a kstr. hívás előtt, mert nem fordul le! */
        //int i = 7;
        
        /* kstr csak kstr-ból hívunk, this kulcsszóval, nem a nevével */
        this(true, false);
    }
    
    public Auto(boolean beinditva){
        this(false, beinditva);
    }
    
    public Auto(boolean uzemanyag, boolean beinditva){
        this(uzemanyag, beinditva, 1);
    }
    
    public Auto(boolean uzemanyag, boolean beinditva, int potkerek){
        Auto.objektumDb++;
        this.uzemanyag = uzemanyag;
        this.beinditva = beinditva;
        this.defekt = false;
        if(potkerek < 0){
            potkerek = 0;
        }
        this.potkerek = potkerek;
    }
    
    public void setBeinditva(boolean beinditva){
        /* lehetne további ellenőrzés, pl.:
        csak akkor lehet beindítani, ha van üzemanyag
        */
        this.beinditva = beinditva;
        if(beinditva){
            System.out.println("A motor be van indítva.");
        }else{
            System.out.println("A motor le van állítva.");
        }
    }
    
    //setUzemanyag(false)
    public void megy(){
        if (beinditva && uzemanyag && !defekt) {
            this.uzemanyag = false;
            System.out.println("Haladtunk, az autó megérkezett, de üres a tank.");
        }else if(!beinditva){
            System.out.println("Nem haladtunk, az autó nincs beindítva.");
        }else if(!uzemanyag){
            System.out.println("Nem haladtunk, mert üres a tank.");
        }
    }
    
    //setUzemanyag(true)
    public void tankol(){
        if (!beinditva) {
            this.uzemanyag = true;
            System.out.println("Sikerült tankolni, tele a tank.");
        }else{
            System.out.println("Sikertelen tankolás, mert be van indítva a motor.");
        }
    }
    
    public void defektetKap(){
        this.defekt = true;
    }
    
    public void kerekCsere(){
        if (defekt && potkerek > 0){
            this.defekt = false;
            potkerek--;
        }
        
    }

    public int getPotkerek() {
        return potkerek;
    }
    
}