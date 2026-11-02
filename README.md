# ⚖️ Healthy BMI App — Aplikasi Kalkulator BMI (JavaFX MVC)






**Healthy BMI App** adalah aplikasi desktop berbasis **JavaFX (Maven)** dan **Scene Builder** untuk menghitung **Indeks Massa Tubuh / Body Mass Index (BMI)**, menentukan kategori kesehatan, menghitung rentang berat badan ideal, serta memberikan saran kesehatan secara interaktif. Aplikasi ini dibangun menggunakan pola arsitektur **MVC (Model-View-Controller)** sesuai standar pemrograman berorientasi objek.

## ✨ Fitur Unggulan

- **Navigasi Multi-Layar (Multi-Scene)**: Memiliki halaman sambutan (*Home Screen*) dan halaman kalkulator utama (*Form BMI*) dengan navigasi dua arah.
- **Perhitungan BMI Akurat & Rentang Berat Ideal**: Menghitung indeks massa tubuh sekaligus menampilkan target rentang berat badan ideal (kg) sesuai tinggi badan pengguna.
- **Indikator Visual & Warna Dinamis**: Kartu hasil otomatis berubah warna dan ikon ekspresi sesuai kategori BMI (Kuning untuk *Kurus*, Hijau untuk *Normal*, Oranye untuk *Gemuk*, dan Merah untuk *Obesitas*).
- **Saran Kesehatan Otomatis**: Menampilkan rekomendasi pola hidup sehat yang disesuaikan dengan kategori hasil perhitungan.
- **Validasi Input & Tombol Reset**: Dilengkapi penanganan kesalahan (*error handling*) jika input kosong atau bukan angka, serta tombol *Reset* untuk mengosongkan formulir dengan cepat.

## 🖼️ Tampilan Antarmuka (UI Preview)

# Halaman Utama
<img width="287" height="361" alt="image" src="https://github.com/user-attachments/assets/58507b9b-c5f4-47bf-8f6b-f72c1d50ec89" />

# Halaman Kalkulator
<img width="287" height="413" alt="image" src="https://github.com/user-attachments/assets/b283ae8d-c8d9-4119-bff8-4b614705874d" />

# Hasil Perhitungan BMI
<img width="287" height="413" alt="image" src="https://github.com/user-attachments/assets/4e3509be-cd5e-4c36-abcd-528f9865679c" />

## 📐 Klasifikasi Kategori BMI

Aplikasi ini menggunakan standar pengelompokan Indeks Massa Tubuh dengan rumus $\text{BMI} = \frac{\text{Berat Badan (kg)}}{\text{Tinggi Badan (m)}^2}$ sebagai berikut:

| Rentang Nilai BMI | Kategori | Indikator Visual | Rekomendasi Utama |
| :--- | :--- | :--- | :--- |
| `< 18.5` | **Kurus (Underweight)** | 🍽️ Kuning | Perbanyak asupan nutrisi dan protein |
| `18.5 – 24.9` | **Normal (Ideal)** | 🌟 Hijau | Pertahankan pola makan dan olahraga rutin |
| `25.0 – 29.9` | **Gemuk (Overweight)** | 🏃 Oranye | Kurangi makanan manis dan mulai olahraga ringan |
| `≥ 30.0` | **Obesitas** | 💪 Merah | Atur pola diet sehat dan rutin berolahraga |

## 🗂️ Struktur Project (Arsitektur MVC)

Project ini menerapkan prinsip **Satu Scene Satu Controller** dan memisahkan logika data (*Model*), tampilan (*View*), serta penghubung (*Controller*):

- **`src/main/java/model/BMI.java`**: Menyimpan atribut data pengguna (`nama`, `gender`, `beratBadan`, `tinggiBadan`) dan fungsi bisnis (`hitungBMI()`, `getKategori()`, `getRentangBeratIdeal()`, `getSaranKesehatan()`).
- **`src/main/java/controller/HomeController.java`**: Mengatur aksi perpindahan dari layar pembuka (`home.fxml`) menuju layar kalkulator (`form-bmi.fxml`).
- **`src/main/java/controller/BMIController.java`**: Mengambil input pengguna dari `form-bmi.fxml`, memproses data melalui objek `BMI`, serta memperbarui warna dan teks hasil pada tampilan.
- **`src/main/java/main/MainApp.java`**: Kelas utama (*Entry Point*) untuk memuat dan menjalankan aplikasi JavaFX.
- **`src/main/java/main/DemoTerminalMode.java`**: Kelas pengujian untuk memverifikasi fungsi pada `BMI.java` langsung melalui terminal/konsol sebelum dihubungkan ke UI.
- **`src/main/resources/view/home.fxml`**: File desain tampilan halaman utama yang dibuat menggunakan JavaFX Scene Builder.
- **`src/main/resources/view/form-bmi.fxml`**: File desain tampilan formulir kalkulator BMI yang dibuat menggunakan JavaFX Scene Builder.

## 🚀 Cara Menjalankan Aplikasi

1. **Buka Project di Apache NetBeans**:
   - Pilih menu **File > Open Project**, lalu arahkan ke folder **`BmiApp`**.
2. **Unduh Dependencies Maven**:
   - Klik kanan pada project **`BmiApp`** lalu pilih **Clean and Build**.
3. **Jalankan Aplikasi (Mode GUI JavaFX)**:
   - Tekan tombol **Run Project (`F6`)** pada toolbar NetBeans, atau jalankan melalui terminal dengan perintah:
     ```bash
     mvn clean javafx:run
     ```
4. **Jalankan Pengujian Model (Mode Terminal)**:
   - Klik kanan pada file `src/main/java/main/DemoTerminalMode.java` lalu pilih **Run File (`Shift + F6`)**.

## 👤 Identitas Pengembang

- **Nama**: Arief Rahman Prasetyo
- **NIM**: 2506048
- **Kelas / Mata Kuliah**: 3A / Pemrograman Lanjut
