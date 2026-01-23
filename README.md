# 📚 Aplikasi Visualisasi Algoritma (UAS Project)

Proyek ini adalah aplikasi desktop berbasis Java yang mengimplementasikan visualisasi algoritma **Binary Search Tree (BST)** dan **Dijkstra's Shortest Path**.

---

## ✨ Fitur Utama
Aplikasi ini menyediakan visualisasi untuk:
1. **Binary Search Tree (BST)**: 
   * Visualisasi penambahan (insert), pencarian (search), dan penghapusan (delete) node.
   * Membantu memahami struktur hierarki pohon biner secara visual.
   

2. **Dijkstra Algorithm**: 
   * Visualisasi pencarian rute terpendek (shortest path) pada graf.
   * Menampilkan bobot antar simpul dan rute yang terpilih.

---
## 📥 Clone Repository:
  Buka Terminal dan jalankan perintah:
```text
git clone https://github.com/VoxXCode/Algoritma-Pemrograman-Project-UAS.git
```

## 🚀 Panduan Menjalankan Aplikasi menggunakan IntelliJ IDEA.

Ikuti panduan langkah demi langkah di bawah ini untuk menjalankan **Aplikasi Visualisasi Algoritma** menggunakan IntelliJ IDEA.

### 1. Prasyarat (Prerequisites)

* **JDK 24** atau versi yang lebih baru (Disarankan menggunakan **Amazon Corretto** atau **Oracle OpenJDK**).
* **IntelliJ IDEA** (Ultimate atau Community Edition).
* **JavaFX SDK** (Jika library tidak dikelola oleh Maven/Gradle).


## 2. Buka Proyek

1. Buka IntelliJ IDEA.
2. Klik **File** > **Open**.
3. Pilih folder utama: `Algoritma-Pemrograman-Project-UAS`.

## 3. Atur Struktur Folder (Penting)

Agar IntelliJ dapat mengenali kode dan resource Anda, pastikan folder ditandai dengan benar:

1. Klik kanan pada folder **`src`** > **Mark Directory as** > **Sources Root**.
2. Klik kanan pada folder **`resources`** > **Mark Directory as** > **Resources Root**.

## 4. Konfigurasi SDK (Java JDK)

Pastikan Anda menggunakan JDK 11 atau versi di atasnya:

1. Klik **File** > **Project Structure** (Ctrl+Alt+Shift+S).
2. Pada tab **Project**, pastikan **SDK** sudah terisi (misal: JDK 17 atau 21).
3. Jika kosong, klik **Add SDK** > **Download JDK**.

## 5. Jalankan Aplikasi

1. Buka folder `/src/main/java/org/example/main`.
2. Temukan file bernama **`Main.java`**.
3. **Klik kanan** pada file tersebut.
4. Pilih **Run 'Main.main()'**.

## 🛠 Troubleshooting

Jika muncul error **"JavaFX runtime components are missing"**:

1. Klik menu **Run** > **Edit Configurations**.
2. Klik **Modify options** > **Add VM options**.
3. Tambahkan baris berikut pada **VM options** (sesuaikan dengan lokasi folder lib JavaFX Anda):

Example:
```text
--module-path "C:\path\to\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml
```

Text template:
```text
--module-path "..." --add-modules javafx.controls,javafx.fxml
```

---

## 📥 Link Download .jar:

 **[Download Project UAS v1.0 (.jar)](https://drive.google.com/file/d/1pnnH_WzoLBvedpzWbh9wG4Ho1F0MfSjF/view?usp=sharing)**


## 🚀 Panduan Menjalankan Aplikasi menggunakan .jar

Aplikasi ini membutuhkan **Java Runtime Environment (JRE)** atau **JDK** minimal versi 11 (disarankan versi 17 atau yang lebih baru).

* **JDK 17 atau versi terbaru** (Disarankan Amazon Corretto atau Azul Zulu karena sudah termasuk library JavaFX).
* **RAM:** Minimal 4GB.
* **OS:** Windows / Ubuntu (Linux) / macOS.

### 1. Cara Menjalankan di Windows
1. **Cek Java**: Buka Command Prompt (CMD) dan ketik `java -version`. 
   * *Jika belum terinstal, unduh di [Azul Zulu (Full JDK)](https://www.azul.com/downloads/?package=jdk) agar library JavaFX sudah termasuk.*
2. **Buka Folder**: Masuk ke direktori tempat file `.jar` berada.
3. **Jalankan**:
   * Klik kanan di area kosong folder sambil menahan tombol `Shift`, lalu pilih **"Open PowerShell window here"**.
   * Jalankan perintah:
```text
java -jar Algoritma Pemrograman Project UAS 1.0.jar
```

**Atau**
Bisa juga Klik 2x pada file:
```text
Algoritma Pemrograman Project UAS 1.0.jar
```


    
  ### 2. Cara Menjalankan di Ubuntu (Linux)
1. **Instalasi Java & JavaFX**:
   Buka Terminal dan jalankan perintah:
```text
sudo apt update
sudo apt install openjdk-17-jdk openjfx
```

2. **Menjalankan Aplikasi**:
   Masuk ke direktori tempat Anda menyimpan file tersebut (misalnya di folder `Downloads`), lalu jalankan perintah `java -jar`:
```text
cd ~/Downloads
java -jar Algoritma Pemrograman Project UAS 1.0.jar
```

---

🖥️ Panduan Penggunaan (Interaktif)
Aplikasi ini bersifat interaktif sesuai permintaan tugas:

Input User: Gunakan kolom input yang tersedia di GUI untuk memasukkan angka ke dalam Tree atau titik koordinat pada Graph.

Visualisasi: Tekan tombol "Generate" atau "Solve" untuk melihat proses algoritma berjalan.

---



