package Aktivitas.abstrak;

public class Anjing extends Hewan {

    public Anjing(String nama) {
        super(nama);
    }
    
    @Override
    void bersuara() {
        System.out.println("gong gong mulu");
    }
}
