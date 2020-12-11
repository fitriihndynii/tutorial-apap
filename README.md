## Tutorial APAP
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
- Perbedaan antara *GetMapping* dengan *RequestMapping*

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

## Tutorial 4
### What I have learned today
- Memahami konsep view pada Spring Boot
- Memahami apa itu Thymeleaf dan penggunaannya

### Pertanyaan
1. Jelaskan perbedaan th:include dan th:replace!

    Perbedaannya ialah:
    - th:include hanya akan memasukkan isi/konten dari sebuah fragment tanpa menyertakan tag yang ada pada file fragment.html
    - th:replace akan menggantikan tag yang berada pada file host dengan spesifik tag yang berada pada file fragment.html
    
2. Jelaskan fungsi dari th:object!
   
    Untuk menspesifikasi command object yang akan digunakan pada bagian tag tertentu
   
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
    
    Perbedaannya yaitu * dapat mengekspresikan sebagian variable object yang belum dispesifikasikan oleh selected objek, 
    sedangkan $ harus mengekpresikan variable objek secara lengkap. * dapat digunakan ketika membutuhkan informasi 
    dari 1 selected objek yang sudah dispesifikasikan (menggunakan 1 selected objek). Sedangkan $ dapat digunakan ketika 
    membutuhkan informasi dari objek lainnya yang tidak dispesifikasi sebagai selected objek (menggunakan >1 selected objek).
    
4. Bagaimana kamu menyelesaikan latihan nomor 3?
    
    Yang saya lakukan untuk menyelesaikan latihan nomor 3 yaitu dengan mentransfer atribut yang berupa String PageName 
    pada model di controller. Setelah itu, saya menggunakan atribut tersebut untuk ditulis di bagian navbar pada fragment.

### What I did not understand
- 

## Tutorial 5
### What I have learned today
- Fungsi *web service*, *postman*, dan *mock server*
- Cara membuat dan menggunakan method pada *web service*
- Cara menggunakan *web service* yang tersedia menggunakan library WebClient
- Cara membuat dan menggunakan *mock server*

### Pertanyaan
1. Apa itu Postman? Apa kegunaannya?

    **Postman** adalah aplikasi untuk melakukan proses development API(create, share, test, and document APIs). Kegunaannya 
    adalah untuk mengelompokan request API, digunakan untuk membuat Mockup API sebelum diimplementasikan ke proyek, 
    menyimpan attribute yang dapat digunakan ataupun dimanipulasi dalam proses request API.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.

    **@JsonIgnoreProperties** digunakan untuk menandai atribut atau properti dalam serialisasi dan deserialisasi JSON yang ingin diabaikan
    **@JsonProperty** digunakan untuk menandai atribut atau properti logis yang digunakan dalam serialisasi dan deserialisasi

3. Apa Kegunaan atribut WebClient?

    WebCient merupakan bagian dari WebFlux framework yang dapat digunakan untuk membangun dan mengirim setiap tipe URI.
    Untuk mengkonstruksi URIs, kita dapat menggunakan method uri() pada WebClientBuilder class yang menyediakan UriBuilder instance sebagai instance
    
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
   
   **ResponseEntity** merepresentasikan keseluruhan HTTP response, dapat digunakan untuk mengontrol/ memanipulasi yang termasuk dalam HTTP response, 
   seperti status code, headers, dan body. 
   **BindingResult** adalah object Spring yang menampung hasil dari validation, binding, dan contain errors yang mungkin saja muncul
   
### What I did not understand
- 

## Tutorial 6
### What I have learned today
- Perbedaan otentikasi dan otorisasi
- Cara mengimplementasikan Spring Boot Starter Security
- Cara membuat otorisasi fitur yang berbeda-beda untuk tiap role dari user
- Cara meng-*encrypt* password milik user

### Pertanyaan
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi? 

    Otentikasi adalah proses pengecekan pemverifikasian validitas seorang pengguna. Contohnya adalah pengecekan user pada form login.
    Otorisasi adalah proses pengecekan kekuasaan/ hak akses pengguna. Konsep ini diimplementasikan pada file WebSecurityConfig pada method 
    configure dimana ada pengaturan url yang hanya bisa diakses oleh role tertentu, contoh: .antMatchers("/user/addUser").hasAuthority("ADMIN")

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.

    BCryptPasswordEncoder merupakan kelas yang mengimplementasikan PasswordEncoder dan menyediakan fungsi untuk melakukan hashing pada password. 
    BcryptPasswordEncoder digunakan untuk melakukan encode pada password. BCryptPasswordEncoder secara otomatis akan membuat dan menggunakan *random salt* 
    untuk menghitung hash password yang dimasukkan.
   
3. Jelaskan secara singkat apa itu UUID beserta penggunaannya! 

    UUID adalah singkatan dari  universally unique identifier , artinya identifier ini secara global unik. Penggunaan UUID 
    untuk mengidentifikasi informasi  yang ada di sistem komputer atau mengidentifikasi informasi yang dapat ditambahkan dari berbagai sistem informasi. 
    
4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserServiceImpl.java? 

    UserDetailsServiceImpl merupakan class yang mengimplementasikan interface UserDetails dari Spring Security.
    UserDetailsServiceImpl.java dibuat agar kita dapat memiliki service mengenai user details kita sendiri , hal ini dilakukan 
    dengan cara mendefinisikan ulang fungsi loadUserByUsername yang merupakan fungsi pada UserDetailsService.
    Dengan class User Details kita dapat mengambil dan menyimpan segala bentuk informasi secara langsung untuk disimpan dan 
    dienkapsulasi menjadi Authentication Object. Sedangkan dengan class UserServiceImpl kita harus melakukan identifikasi informasi terlebih dahulu.
    
### What I did not understand
- 

## Tutorial 7
### What I have learned today
- Bersenang-senang dan mengenal teknologi *web development* baru
- Mengenal & menggunakan ReactJS
- Mengerti istilah, teknologi, arsitektur dan *design* di ReactJS
- Memahami perbedaan *class component* dan functional component
- Memahami perbedaan *state* dan *props*

### Pertanyaan
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
    
    Jawaban dapat dilihat di link berikut ini
    (https://docs.google.com/document/d/1M4BkbPKDA4L4J8Z8YCRASsrdX9DhHRTrEgkUQ0TObWU/edit?usp=sharing)
    
2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?

    Properti biasa digunakan untuk menyimpan fitur yang penting dalam React, selain itu props juga sering digunakan atau dipakai. 
    Property biasanya digunakan dengan cara melakukan passing nilai saja, serta properti biasa digunakan untuk berkomunikasi antar component. 
    State merupakan data yang tersimpan dalam sebuah component. State bersifat private dan hanya relevan terhadap component itu sendiri. 
    Berbeda dengan props yang valuenya dilempar dari component lain, state justru dapat menyimpan dan mengubah datanya sendiri dari dalam.
    
3. Apa keuntungan menggunakan component (e.g. List, Item) di React? Berikan contohnya!

    Dapat digunakan kembali, contohnya yaitu ketika kita ingin menampilkan List Movies dan list My Favorites dengan tampilan yang sama,
    maka kita menggunakan fungsi List yang ada pada component List

4. Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web

    - Reusable Component
    - Sudah banyak digunakan di seluruh perusahaan besar
    - React Native untuk Mobile App Development
    
5. Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web? 

    - Kesulitan dengan JavaScript, hal ini dikarenakan JavaScript memiliki perkembangan yang sangat cepat.
    - React hanya baru di support pada browser tertentu saja yaitu google chrome, mozilla firefox, dan internet explorer versi 8

### What I did not understand
- 

## Tutorial 8
### What I have learned today
- Memahami lifecycle yang ada di sebuah component
- Melakukan routing di react app
- Melakukan autentikasi pada react app
- Melakukan HTTP Request pada react app menggunakan library
- Memahami Axios dan cara untuk memproses request tersebut
- Melakukan deployment aplikasi berbasis react

### Pertanyaan
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut? 

    Langkah-langkah yang Saya lakukan adalah mengatur item-item pada state: namaHotel, alamat, dan nomorTelepon menjadi kosong kembali. Pengaturan ini dilakukan pada fungsi handleCancel. Saya melakukan langkah-langkah ini karena pada input-input yang ada di form, value-nya di assign dengan namaHotel,alamat, dan nomorTelepon pada state. Sehingga setelah input diisi, item-item harus dikosongkan lagi(diatur jadi string kosong). Pengaturan dilakukan di handleCancel karena pada fungsi handleSumbitAddHotel dan handleSubmitEditHotel akan memanggil handleCancel terlepas berhasil atau tidaknya submit.

2. Jelaskan fungsi dari async dan await! 

    Kedua fungsi digunakan untuk mempermudah penulisan kode promise-based yang dapat membuat hasil tugas asinkron mudah dibaca. Async dapat digunakan untuk mentrigger penggunaan await yang terdapat di dalam fungsi async. Ketika kita menggunakan async pada sebuah fungsi, maka kita dapat menggunakan await di dalam fungsi tersebut yang akan melakukan suatu tugas tertentu dan akan menghentikan sejenak proses fungsi async setelahnya. Ketika tugas tersebut telah selesai, maka fungsi async dapat dilanjutkan kembali hingga selesai.
    Contoh penggunaan kedua fungsi tersebut terdapat pada fungsi async handleSubmitAddHotel yang di dalamnya terdapat penggunaan await APIConfig.post("/hotel", data); yang dimana fungsi handleSubmitAddHotel akan terhenti sejenak hingga APIConfig.post berhasil dilakukan. Jika APIConfig.post berhasil dilakukan, fungsi handleSubmitAddHotel akan dilanjutkan kembali untuk menampilkan list hotel yang terdapat pada database dengan pemanggilan fungsi loadData.

3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 7 pada Component Lifecycle pada pertanyaan ini.

    Jawaban dapat dilihat di link berikut ini
    https://docs.google.com/document/d/1ayy8W_hEi4zEKjjBVRTrxzaVSJNUzWoh0pUh8a0_mL4/edit?usp=sharing

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount. Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”. 

    - **componentDidMount** dapat digunakan untuk menjalankan fungsi async segera setelah *components* ditampilkan. Fungsi ini dipanggil ketika *component* di-render untuk pertama kali. Contoh penggunaan lifecycle ini adalah ketika kita ingin menyambungkan aplikasi react kita dengan aplikasi luar seperti web APIs ataupun framework JavaScript

    - **shouldComponentUpdate** memutuskan apakah sebuah *component* harus di-render ulang atau tidak. Kegunaan utamanya adalah untuk optimasi kinerja. Fungsi dipanggil ketika props atau state dari sebuah *component* berubah. Salah satu contoh penggunaan lifecycle ini adalah ketika kita menampilkan form checkbox yang akan menyimpan info pilihan pengguna dari suatu *component* yang dimana satu aksi dari pengguna terhadap form tersebut dapat mentrigger *component* tersebut untuk menyimpan pilihan yang telah dipilih. Agar list form tidak dirender ulang, kita dapat menggunakan lifecycle ini.

    - **componentDidUpdate** dapat digunakan untuk melakukan beberapa action berdasarkan kondisional tertentu setelah props atau state berubah. Fungsi ini dipanggil setelah re-render dilakukan setelah adanya props atau state yang berubah. Contoh penggunaan lifecycle ini adalah ketika kita memanggil API dari luar dengan conditional state sebelum dan state sekarang sudah berubah.

    - **componentWillReceiveProps** dapat digunakan untuk mengubah state tanpa harus re-render. Fungsi ini dipanggil ketika  sebuah *component* menerima properti baru, tetapi sebelum *component* di-render.  Contoh penggunaan lifecycle ini adalah ketika ingin terjadi perubahan pada prop tertentu untuk memicu transisi state.

### What I did not understand
- 