----DATABASE----

Dalam folder database terdapat 2 file .sql dan .bak
File .sql digunakan untuk melihat Tables dan Stored Procedure apa saja yang digunakan juga digunakan
sebagai backup kedua apabila terjadi kesalahan dalam backup utama

Gunakan .bak untuk me-restore semua tables, data, dan SP yang tersimpan dalam database StugerDB. Caranya:
1. Jalankan SSMS dan buat Database baru bernama "StugerDB"
2. Taruh file StugerDB.bak di dalam directory berikut:
   C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\Backup
3. Klik kanan pada Database StugerDB (SSMS) lalu klik restore
4. Pilih menu Stuger DB, klik OK dan Database berhasil di restore

----API----

Dalam folder api terdapat folder-folder penting yang keseluruhan menjadi api
Karena saya menggunakan XAMPP untuk menjalankan PHP, maka taruh folder API di dalam folder htdocs XAMPP
Apabila saat menjalankan PHP anda menemukan error yang menyatakan bahwa PHP tidak menemukan file yang diperlukan
maka anda harus mencoba cara lain supaya PHP dapat menemukan file yang dicari.

Sebelum menjalankan api, anda harus terlebih dahulu menambahkan extension PDO_sqlsrv
Saya sudah menyediakan extension yang diperlukan sehingga anda tidak perlu lagi mendownloadnya dari internet

Pertama, copy extension yang sudah disediakan dan sesuiakan dengan sistem operasi anda, 32-bit atau 64-bit
Kedua, copy extension berikut ke dalam folder berikut C:\xampp\php\ext
Ketiga, apabila anda sudah menyalakan APACHE Web Server, matikan terlebih dahulu. Jika sudah lanjut ke langkah selanjutanya
Keempat, buka file "php.ini", lalu masuk ke bagian extension
Kelima, tambahkan extension tersebut dengan mengetik "extension=php_pdo_sqlsrv_72_ts_x*OS anda*" tanpa menggunakan titik koma
Keenam, nyalakan Web Server APACHE anda dan api bisa digunakan

Terakhir, edit pada file api\config\database.php bagian $servername. Masukkan servername yang anda gunakan untuk
connect ke database SQL anda.

Author: Anthony GT
Last Edit: Sunday, 20 January 2019, 11:54 AM