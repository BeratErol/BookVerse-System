# 📚 BookVerse System  
Monolit Mimarisinden Mikroservis Mimarisine Geçiş Örneği

Bu proje, geleneksel **Katmanlı Monolit (Layered Monolith)** mimarisinden **Mikroservis (Microservices)** mimarisine geçiş sürecini uygulamalı olarak göstermektedir.  
Geçiş sırasında **Strangler Fig Pattern** yaklaşımı benimsenmiş ve sistem kademeli olarak ayrıştırılmıştır.

Proje temel olarak **kitap yönetimi** ve **kullanıcı yönetimi** işlevlerini içermektedir.

---

## 🏗️ Mimari Dönüşüm Süreci

Proje iki ana aşamadan oluşmaktadır:

- **Monolitik Yapı:**  
  Tüm iş mantığı (Book ve User modülleri) tek bir Spring Boot uygulaması içerisinde yer almaktaydı.

- **Mikroservis Ayrıştırması:**  
  `User` modülü ana monolit yapıdan ayrılarak bağımsız bir **user-service** mikroservisi haline getirilmiştir.  
  Servisler arası iletişim **Senkron HTTP (REST)** üzerinden sağlanmaktadır.

---

## 🚀 Kullanılan Teknolojiler

- Java 17+
- Spring Boot 3.x
- Docker & Docker Compose
- Maven
- AWS EC2 (Ubuntu 22.04 LTS)

---

## 📁 Proje Yapısı

BookVerse-System

│

├── single-file-monolith/ # Kitap yönetimini yapan ana servis

├── user-service/ # Ayrıştırılmış kullanıcı mikroservisi

├── docker-compose.yml # Servisleri tek komutla ayağa kaldıran yapı

└── README.md

---

## 🛠️ Yerel Ortamda Çalıştırma

Projeyi yerel makinenizde çalıştırmak için Docker yüklü olması yeterlidir.

git clone https://github.com/BeratErol/BookVerse-System.git

cd BookVerse-System

docker-compose up --build

---

## 📌 Servis Erişim Adresleri

- Books API (Monolith):  
  http://localhost:8080/api/books

- User Service API:  
  http://localhost:8081/api/users

---

## ☁️ AWS Dağıtımı

Proje, AWS EC2 (Ubuntu 22.04 LTS) üzerinde Docker kullanılarak canlı ortama alınmıştır.  
Güvenlik grupları üzerinden aşağıdaki portlar dış erişime açılmıştır:

- 8080 → Monolith (Books API)
- 8081 → User Service API

---

## 🔗 Servisler Arası İletişim

Monolith servis, kullanıcı bilgilerine ihtiyaç duyduğunda **user-service** mikroservisini çağırır.  
İletişim Docker ağı içerisinde servis ismi kullanılarak sağlanır:

http://user-service:8081/api/users


Servisler arası haberleşme **Spring RestTemplate** kullanılarak gerçekleştirilmiştir.

---

## 🎯 Projenin Amacı

- Monolit mimariden mikroservis mimarisine geçiş sürecini göstermek
- Docker ve Docker Compose kullanımını uygulamalı olarak öğrenmek
- Mikroservisler arası senkron iletişimi deneyimlemek
- AWS üzerinde uygulama dağıtımı gerçekleştirmek

---

## 👤 Geliştirici

Berat Erol  
Yazılım Mühendisliği Öğrencisi  
Mikroservis Mimarileri ve Bulut Teknolojileri
