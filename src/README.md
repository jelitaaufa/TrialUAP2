Contact Manager

Ikhtisar

Contact Manager adalah aplikasi desktop berbasis Java yang dirancang untuk mengelola informasi kontak. Aplikasi ini memungkinkan pengguna untuk menyimpan, melihat, dan mengelola detail kontak seperti nama, nomor telepon, dan gambar profil. Aplikasi ini dibangun menggunakan kerangka kerja Swing dan menampilkan konsep utama seperti pengembangan GUI, validasi data, penanganan file, dan manipulasi tabel di Java.

Fitur

1. Tambah Kontak

Kolom input untuk memasukkan Nama dan Nomor Telepon kontak.

Opsi untuk mengunggah gambar profil kontak.

Validasi meliputi:

Nama tidak boleh kosong.

Nomor telepon hanya boleh berisi angka dan memiliki panjang minimal 10.

Menampilkan kontak baru dalam tabel beserta detailnya.

2. Hapus Kontak

Memungkinkan pengguna untuk memilih kontak dari tabel dan menghapusnya.

Secara otomatis memperbarui data internal dan tampilan tabel setelah penghapusan.

3. Tampilkan Kontak

Kontak ditampilkan dalam tabel dengan kolom berikut:

Nama: Nama lengkap kontak.

Telepon: Nomor telepon kontak.

Gambar: Thumbnail gambar profil yang diunggah.

Mendukung pratinjau gambar dengan ukuran yang disesuaikan 100x100 piksel.

4. Unggah Gambar

Pengguna dapat mengunggah file gambar dari komputer mereka.

Gambar diubah ukurannya agar sesuai dengan dimensi maksimum 100x100 piksel untuk konsistensi.

Instalasi dan Pengaturan

Prasyarat

Java Development Kit (JDK) versi 8 atau lebih tinggi.

IDE Java seperti IntelliJ IDEA, Eclipse, atau NetBeans (opsional tetapi disarankan).

Langkah-langkah Menjalankan

Clone atau Unduh Proyek:

Jika proyek ada di GitHub, clone menggunakan:

git clone https://github.com/username/ContactManager.git

Atau unduh file ZIP dan ekstrak.

Kompilasi Aplikasi:

Navigasikan ke folder proyek melalui terminal atau command prompt.

Kompilasi file Java:

javac ContactManager.java

Jalankan Aplikasi:

Jalankan program yang sudah dikompilasi:

java ContactManager

Cara Menggunakan

Menambah Kontak

Masukkan Nama di kolom teks.

Masukkan Nomor Telepon di kolom teks.

(Opsional) Klik tombol Pilih Gambar untuk mengunggah gambar profil.

Klik tombol Tambah Kontak untuk menyimpan kontak. Kontak akan muncul di tabel.

Menghapus Kontak

Pilih kontak dari tabel dengan mengklik barisnya.

Klik tombol Hapus Kontak. Kontak akan dihapus dari tabel dan struktur data internal.

Struktur dan Sorotan Kode

Komponen Utama

Kelas Contact

Mewakili kontak dengan bidang-bidang berikut:

String name: Nama kontak.

String phone: Nomor telepon kontak.

String imagePath: Jalur file gambar profil kontak.

Kelas ContactManager

Kelas aplikasi utama yang mengelola GUI dan operasi kontak. Komponen utama:

Elemen GUI:

JTextField: Kolom input untuk nama dan nomor telepon.

JButton: Tombol untuk menambah, menghapus, dan memilih gambar.

JTable: Menampilkan daftar kontak.

DefaultTableModel: Mengelola data yang ditampilkan dalam tabel.

Metode Utama:

addContact(): Memvalidasi dan menambah kontak baru.

deleteContact(): Menghapus kontak yang dipilih.

uploadImage(): Menangani pemilihan gambar dan memperbarui label.

Penanganan Gambar

Menggunakan ImageIcon untuk menampilkan gambar di tabel.

Mengubah ukuran gambar menjadi 100x100 piksel menggunakan Image.SCALE_SMOOTH untuk tampilan yang konsisten.

Validasi Data

Memastikan kolom nama tidak kosong.

Memeriksa bahwa nomor telepon hanya berisi angka dan memenuhi persyaratan panjang minimum.

Contoh Tangkapan Layar

Antarmuka Utama

Antarmuka utama mencakup kolom input untuk nama dan telepon, tombol untuk menambah dan menghapus kontak, serta tabel yang menampilkan daftar kontak.

Menambah Kontak

Contoh menambah kontak dengan gambar.

Tabel Kontak

Tampilan tabel yang menunjukkan beberapa kontak dengan thumbnail gambar profil mereka.

(Tambahkan tangkapan layar di sini jika memungkinkan)

Struktur Proyek

ContactManager/
├── ContactManager.java  // File aplikasi utama
├── README.md            // Dokumentasi proyek

Perbaikan di Masa Depan

Penyimpanan Persisten: Menyimpan kontak ke file (misalnya, CSV atau database) dan memuatnya saat aplikasi dimulai.

Fungsi Pencarian: Menambahkan bilah pencarian untuk memfilter kontak berdasarkan nama atau nomor telepon.

Edit Kontak: Memungkinkan pengeditan detail kontak yang sudah ada.

UI yang Ditingkatkan: Meningkatkan antarmuka pengguna dengan pustaka modern seperti JavaFX.

Validasi Gambar: Membatasi unggahan hanya pada jenis file tertentu (misalnya, JPG, PNG).

Pemecahan Masalah

Masalah Umum

1. Kesalahan: "main method not found"

Pastikan file berisi metode main di kelas ContactManager:

public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
ContactManager manager = new ContactManager();
manager.setVisible(true;
});
}

2. GUI Tidak Ditampilkan dengan Benar

Verifikasi bahwa Anda menggunakan versi Java yang benar (8 atau lebih tinggi).

Pastikan semua dependensi (komponen Swing) diimpor dengan benar.

3. Gambar Tidak Ditampilkan di Tabel

Periksa bahwa file gambar yang dipilih ada dan dapat diakses.

Pastikan jalur gambar disimpan dengan benar di objek Contact.

Lisensi

Proyek ini dilisensikan di bawah Lisensi MIT. Anda bebas menggunakan, memodifikasi, dan mendistribusikan kode ini selama atribusi yang sesuai diberikan.

Penghargaan

Swing Framework: Untuk menyediakan komponen GUI.

Java Documentation: Dokumentasi resmi Oracle Java sebagai referensi.

Komunitas: Stack Overflow dan sumber daya lainnya untuk pemecahan masalah dan panduan.