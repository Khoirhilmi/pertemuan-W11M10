package Aktivitas.abstrak;

abstract class Hewan {
    String nama;

    public Hewan(String nama) {
        this.nama = nama;
    }

    void makan() {
        System.out.println(nama + " sedang makan");
    }

    abstract void bersuara();
    
}