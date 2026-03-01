1. Apa keuntungan menggunakan Thymeleaf Fragment untuk navbar dan footer?
Keuntungannya adalah kode bisa digunakan ulang (reuse). Navbar dan footer cukup dibuat sekali, lalu dipakai di banyak halaman. Jadi kode lebih rapi, mudah dirawat, dan kalau ingin mengubah navbar/footer cukup di satu file saja.



2. Apa bedanya file di static dan templates? Kenapa CSS ada di static bukan template?

* templates: berisi file HTML Thymeleaf yang diproses oleh server.
* static:berisi file tatis seperti CSS, JavaScript, gambar.

CSS ada di static karena CSS tidak perlu diproses Thymeleaf, cukup dikirim langsung ke browser.


3. Apa yang dimaksud dengan th:replace dan bedanya dengan th:insert?

* th:replace:mengganti seluruh tag dengan fragment.
* `h:insert:menyisipkan isi fragment di dalam tag** yang sudah ada.

Jadi:

* replace = tag lama hilang diganti fragment.
* insert = tag lama tetap ada, fragment masuk ke dalamnya.



4. Kenapa pakai @{} untuk URL di Thymeleaf, bukan langsung tulis path?
Karena @{} membuat URL otomatis menyesuaikan context path aplikasi.
Jadi link tetap benar walaupun aplikasi dijalankan di path atau server yang berbeda.



5. Apa jadinya kalau Controller tidak pakai DI dan langsung new ProductService?
Kalau tidak pakai Dependency Injection:

* kode jadi lebih sulit diuji (testing),
* sulit mengganti implementasi service,
* tidak mengikuti prinsip Spring (loose coupling),


