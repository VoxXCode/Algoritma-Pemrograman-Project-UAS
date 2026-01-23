# 📚 Aplikasi Visualisasi Algoritma (UAS Project)

Proyek ini adalah aplikasi desktop berbasis Java yang mengimplementasikan visualisasi algoritma *Binary Search Tree (BST)* dan *Dijkstra's Shortest Path*.

---

# 🚀 Panduan Menjalankan Aplikasi

Ikuti panduan langkah demi langkah di bawah ini untuk menjalankan *Aplikasi Visualisasi Algoritma* menggunakan IntelliJ IDEA.

### 1. Prasyarat (Prerequisites)

* *JDK 24* atau versi yang lebih baru (Disarankan menggunakan *Amazon Corretto* atau *Oracle OpenJDK*).
* *IntelliJ IDEA* (Ultimate atau Community Edition).
* *JavaFX SDK* (Jika library tidak dikelola oleh Maven/Gradle).

## 2. Buka Proyek

1. Buka IntelliJ IDEA.
2. Klik *File* > *Open*.
3. Pilih folder utama: Algoritma-Pemrograman-Project-UAS.

## 3. Atur Struktur Folder (Penting)

Agar IntelliJ dapat mengenali kode dan resource Anda, pastikan folder ditandai dengan benar:

1. Klik kanan pada folder *src* > *Mark Directory as* > *Sources Root*.
2. Klik kanan pada folder *resources* > *Mark Directory as* > *Resources Root*.

## 4. Konfigurasi SDK (Java JDK)

Pastikan Anda menggunakan JDK 11 atau versi di atasnya:

1. Klik *File* > *Project Structure* (Ctrl+Alt+Shift+S).
2. Pada tab *Project, pastikan **SDK* sudah terisi (misal: JDK 17 atau 21).
3. Jika kosong, klik *Add SDK* > *Download JDK*.

## 5. Jalankan Aplikasi

1. Buka folder src/main/.
2. Temukan file bernama *MainApp.java*.
3. *Klik kanan* pada file tersebut.
4. Pilih *Run 'MainApp.main()'*.

## 🛠 Troubleshooting

Jika muncul error *"JavaFX runtime components are missing"*:

1. Klik menu *Run* > *Edit Configurations*.
2. Klik *Modify options* > *Add VM options*.
3. Tambahkan baris berikut (sesuaikan dengan lokasi folder lib JavaFX Anda):
text
--module-path "C:\path\to\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml


---

🖥️ Panduan Penggunaan (Interaktif)
Aplikasi ini bersifat interaktif sesuai permintaan tugas:

Input User: Gunakan kolom input yang tersedia di GUI untuk memasukkan angka ke dalam Tree atau titik koordinat pada Graph.

Visualisasi: Tekan tombol "Generate" atau "Solve" untuk melihat proses algoritma berjalan.

---
