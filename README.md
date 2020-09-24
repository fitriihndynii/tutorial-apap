# Tutorial APAP
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