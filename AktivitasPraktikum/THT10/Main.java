package THT10;

public class Main {
    //Abstract Class
    abstract static class Kendaraan {
        protected String platNomor;
        protected String merk;
        protected int tahunProduksi;

        public Kendaraan(String platNomor, String merk, int tahunProduksi) {
            this.platNomor = platNomor;
            this.merk = merk;
            this.tahunProduksi = tahunProduksi;
        }

        public void tampilkanInfo() {
            System.out.println("Plat Nomor: " + platNomor);
            System.out.println("Merk: " + merk);
            System.out.println("Tahun Produksi: " + tahunProduksi);
        }

        public abstract double hitungBiayaSewa(int hari);
        public abstract boolean perluSupir();
    }

    //Interface DapatDisewa
    interface DapatDisewa {
        double hitungBiayaSewa(int hari);
        boolean perluSupir();
    }

    //Interface Muatan
    interface Muatan {
        double kapasitasMuatan(); 
    }

    //Class MobilPribadi
    static class MobilPribadi extends Kendaraan implements DapatDisewa {
        public MobilPribadi(String platNomor, String merk, int tahunProduksi) {
            super(platNomor, merk, tahunProduksi);
        }

        @Override
        public double hitungBiayaSewa(int hari) {
            return hari * 300_000; 
        }

        @Override
        public boolean perluSupir() {
            return false; 
        }
    }

    //Class Bus
    static class Bus extends Kendaraan implements DapatDisewa {
        public Bus(String platNomor, String merk, int tahunProduksi) {
            super(platNomor, merk, tahunProduksi);
        }

        @Override
        public double hitungBiayaSewa(int hari) {
            return hari * 800_000;
        }

        @Override
        public boolean perluSupir() {
            return true;
        }
    }

    //Class Truk
    static class Truk extends Kendaraan implements DapatDisewa, Muatan {
        private double kapasitas;

        public Truk(String platNomor, String merk, int tahunProduksi, double kapasitas) {
            super(platNomor, merk, tahunProduksi);
            this.kapasitas = kapasitas;
        }

        @Override
        public double hitungBiayaSewa(int hari) {
            return hari * 600_000;
        }

        @Override
        public boolean perluSupir() {
            return true;
        }

        @Override
        public double kapasitasMuatan() {
            return kapasitas;
        }
    }

    //Main Method
    public static void main(String[] args) {
        Kendaraan[] daftarKendaraan = new Kendaraan[3];
        daftarKendaraan[0] = new MobilPribadi("B1234ABC", "Toyota Avanza", 2020);
        daftarKendaraan[1] = new Bus("B5678DEF", "Mercedes Bus", 2018);
        daftarKendaraan[2] = new Truk("B9012GHI", "Hino", 2019, 10000);

        for (Kendaraan k : daftarKendaraan) {
            System.out.println("== Info Kendaraan ==");
            k.tampilkanInfo();
            System.out.println("Biaya Sewa 3 hari: Rp " + k.hitungBiayaSewa(3));
            System.out.println("Perlu Supir: " + (k.perluSupir() ? "Ya" : "Tidak"));

            if (k instanceof Muatan) {
                Muatan m = (Muatan) k;
                System.out.println("Kapasitas Muatan: " + m.kapasitasMuatan() + " kg");
            }

            System.out.println();
        }
    }
}
