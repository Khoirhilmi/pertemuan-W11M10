package Aktivitas.abstrak;

public class Main {
    public static void main(String[] args) {
        Kucing k = new Kucing("KUCING");
        Anjing a = new Anjing("dog");
        
        k.makan();
        k.bersuara();

        a.makan();
        a.bersuara();
    }
}
