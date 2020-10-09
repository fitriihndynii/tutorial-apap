h# Tutorial APAP
## Authors
* **Fitri Handayani** - *1806146966* - *A*
---
## Tutorial 1
### What I have learned today
- Operasi penting dalam Git
- Fungsi Issue Tracker pada GitHub
- *Setup* Spring Boot menggunakan *maven*

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker? 

    Issue tracker merupakan fitur pada github yang dapat digunakan untuk mengatur pekerjaan sebuah project.
    Selain untuk mengatur pekerjaan, issue tracker juga dapat digunakan untuk melacak tugas, memberi notes, mengembangkan ide,
    dan mengatasi *bug*(masalah) para project. Dengan begitu, issue tracker dapat memudahkan project kolaborasi. 
    Issue tracker memiliki fitur judul, deskripsi, dan labeb yang dapat menjelaskan informasi terkait pekerjaan project tersebut.
    Dengan begitu, issue tracker dapat membantu kita dalam mengelola progress pengerjaan project.
 
2. Apa perbedaan dari git merge dan git merge --squash?

    **git merge** - untuk menggabungkan commit terakhir feature branch ke master branch 
    
    **git merge --squash** - menggabungkan feature branch ke master branch namun commit pada feature branch akan dijadikan satu commit

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatua plikasi?

    Keunggulannya ialah akan memudahkan developer dalam memelihara code secara efisien, dapat menjadi tempat back-up jika terjadi kehilangan data.
    Selain itu, Version Control System seperti Git juga sangat memberikan kemudahan untuk melakukan project kolaborasi dengan fitur-fitur yang dimilikinya
    seperti Issue Tracker yang dibahas pada nomor 1 diatas.

### Spring
4. Apa itu library & dependency?
    
    **Library** merupakan kumpulan fungsi atau program yang ada pada compiler untuk memudahkan pemrograman membuat program tanpa perlu mengakses sistem komputer secara langsung.
    
    **Dependency** adalah package-package terkait yang digunakan untuk membuat suatu program aplikasi.

5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
    
    Maven adalah Java Build Tools yang menggunakan konsep Project Object Model (POM). POM merupakan sebuah XML File yang terdapat pada project Maven yang di dalamnya terdapat
    konfigurasi dari project kita. POM berisi informasi an konfigurasi yang digunakan Maven untuk membuat project. Maven mendefinisikan struktur projectnya sendiri sehingga
    project tersebut dapat dibuka dengan berbagai macam IDE. Alternatif lain yang mungkin bisa digunakan ialah Ant atau Gradle.

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
    
    Spring framework dapat digunakan untuk:
    - Mengembangkan aplikasi menjadi yang dapat dieksekusi
    - Mengintegrasikan aplikasi dengan sosial media
    - Berkomunikasi dengan database
    - Melakukan testing
    - Menangani pekerjaan jangka panjang

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan@RequestParam atau @PathVariable?
    
    @PathVariables mengekstrak nilai value yang berasal dari path URI, sedangkan @RequestParam mengekstrak nilai value ataupun masukan input yang berasal dari string query.
    @PathVariable dapat digunakan untuk data yang diteruskan berasal dari path URI seperti RESTful web services, sementara @RequestParam digunakan untuk memfilter data berdasarkan
    string query yang diberikan.

### What I did not understand
-

## Tutorial 2
### What I have learned today
- *Model*, *service*, dan *controller* beserta fungsinya
- Membuat *model* dengan konsep MVC dalam *project* Spring Boot
- Membuat *service* untuk *create, read, dan delete* data menggunakan konsep MVC dalam *project* Spring Boot

### Pertanyaan
1. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
    http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxx
    Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
    
    Halaman tidak muncul. Hal itu terjadi karena belum terdapat file template html yang akan dikembalikan oleh *controller*
    kepada *view* untuk menampilkan laman yang diinginkan.

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan
   implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam
   konteks service dan controller yang telah kamu buat
   
   @Autowired merupakan hasil implementasi dari konsep Dependency, yang dimana HotelController bergantung pada HotelService.
   Cara @Autowired bekerja ialah dengan menginjeksi HotelService secara otomatis ke HotelController.
   
3. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
   http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom
   Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
   
   Akan memunculkan error yang disebabkan *missing parameter*. Hal tersebut terjadi karena masukan yang diberikan tidak sesuai
   dengan masukan yang diminta, yaitu tidak terdapat masukan untuk parameter No Telepon.
   
4. Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus
   diakses?
   
   http://localhost:8080/hotel/view?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxx
   
5. Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses
   http://localhost:8080/hotel/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
   
   - Sebelum menambahkan hotel baru ![Sebelum menambahkan hotel baru](https://i.ibb.co/TmJcsSb/Before.jpg)
   - Menambahkan hotel baru ![Menambahkan hotel baru](https://i.ibb.co/pxv7Qhj/1601556520307.jpg)
   - Melihat list hotel setelah penambahan hotel baru ![Viewall list hotel](https://i.ibb.co/S0ZKxps/1601556536845.jpg)
   
### What I did not understand
- Perbedaan anatra *GetMapping* dengan *RequestMapping*

## Tutorial 3
### What I have learned today
- Memahami *Create*, *Read*, *Update*, dan *Delete* (CRUD) pada basis data dengan menggunakan konsep MVC
dalam *project* Spring Boot.
- Membuat model yang terhubung dengan basis data
- Memahami penggunaan JPARepository untuk melakukan *query* pada basis data.
- Membuat sebuah *service* dengan fungsi *create* dan *read* data menggunakan konsep MVC dalam *project* Spring
Boot

### Pertanyaan
1. Pada class KamarDb, terdapat method findAllByHotelId, apakah kegunaan dari method tersebut?

    Method findAllByHotelId digunakan untuk mengembalikan list objek KamarModel yang dimiliki oleh hotel 
    tertentu dengan id yang di input oleh user.
    
2. Pada class HotelController, jelaskan perbedaan method addHotelFormPage dan addHotelSubmit? 
    
    **addHotelFormPage** - Controller yang digunakan untuk menampilkan halaman pendaftaran hotel yang harus diisi 
    oleh user dengan menggunakan method GetMapping.
    
    **addHotelSubmit** - Controller yang digunakan untuk melakukan operasi penambahan hotel baru pada database dengan 
    data yang telah diinput user dengan menggunakan method PostMapping. Jika pembuatan hotel baru berhasil, 
    maka sistem akan men-direct user ke halaman pemberitahuan pembentukan hotel berhasil.

3. Jelaskan kegunaan dari JPA Repository! 
    
    Java Persistence API (JPA) merupakan alat yang digunakan untuk mengelola objek java di dalam relational database. 
    JPA Repository dapat digunakan untuk menjalankan method-method untuk mengakses database sesuai dengan query pada 
    relational database (berperan sebagai datamapper kedalam relational database).

4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat? 
    
    Relasi antara HotelModel dan KamarModel dapat dilihat didalam kedua file tersebut. Pada file HotelModel, 
    terdapat list variable(listkamar) yang menyimpan beberapa objek KamarModel dengan relasi *one-to-many* yang 
    menunjukan bahwa sebuah objek HotelModel dapat memiliki relasi dengan beberapa objek KamarModel. 
    Sedangkan pada file KamarModel, terdapat variable(hotel) yang menyimpan objek HotelModel dengan relasi *many-to-one*
     yang menunjukkan bahwa objek KamarModel tersebut hanya dapat memiliki 1 relasi dengan sebuah objek HotelModel.

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER! 
    
    **FetchType.LAZY** - Hibernate(Java Framework yang digunakan untuk menyimpan objek java pada relational database) 
    tidak otomatis meload semua collection object ( child ) saat object parent di-fetch(diambil). Collection object 
    (child) hanya di-load jika secara eksplisit dibutuhkan via getter method (ketika objek dipanggil). 
    Penerapannya pada @OneToOne dan @ManyToOne
    
    **CascadeType.ALL** - Semua operasi(update,delete,dll) data berpengaruh ke entitas atau objek pada relasi tersebut. 
    Untuk menjaga persistensi semua operasi EntityManager(PERSIST, REMOVE, REFRESH, MERGE, DETACH) ke entitas terkait.
    
    **FetchType.EAGER** - Hibernate akan me-load semua collection object (child) sesaat setelah object parent di-fetch. 
    Default penerapan ini pada @OneToMany dan @ManyToMany

### What I did not understand
- 