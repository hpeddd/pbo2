// Superclass KarakterGame
class KarakterGame {
    private String nama; // Nama karakter
    private int kesehatan; // Nilai kesehatan karakter

    // Konstruktor untuk inisialisasi nama dan kesehatan
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    // Getter untuk mendapatkan nama karakter
    public String getNama() {
        return nama;
    }

    // Getter untuk mendapatkan nilai kesehatan karakter
    public int getKesehatan() {
        return kesehatan;
    }

    // Setter untuk mengubah nilai kesehatan karakter
    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    // Metode serang yang akan di-override oleh subclass
    public void serang(KarakterGame target) {
        // Akan di-override oleh subclass
    }
}

// Subclass Pahlawan, mewarisi dari KarakterGame
class Pahlawan extends KarakterGame {
    // Konstruktor Pahlawan yang memanggil konstruktor superclass
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // Override metode serang dengan serangan khas Pahlawan
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Orbital Strike!");
        target.setKesehatan(target.getKesehatan() - 20); // Mengurangi kesehatan target sebanyak 20
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

// Subclass Musuh, mewarisi dari KarakterGame
class Musuh extends KarakterGame {
    // Konstruktor Musuh yang memanggil konstruktor superclass
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // Override metode serang dengan serangan khas Musuh
    @Override
    public void serang(KarakterGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake Bite!");
        target.setKesehatan(target.getKesehatan() - 15); // Mengurangi kesehatan target sebanyak 15
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}

// Kelas utama (Main) untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Membuat objek karakter
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        // Menampilkan status awal karakter
        System.out.println("Status awal:");
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());

        // Simulasi pertarungan antara Pahlawan dan Musuh
        brimstone.serang(viper); // Pahlawan menyerang Musuh
        viper.serang(brimstone); // Musuh menyerang Pahlawan
    }
}
