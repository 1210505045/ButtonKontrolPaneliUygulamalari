# ButtonKontrolPaneliUygulamalari
#ButtonKontrolPaneliUygulamalari

#CustomButton uygulaması

Java kullanılarak geliştirilen bu uygulama özel tasarlanmış butonlar içeren bir gridi temsil eder. Her bir buton bir GraphqL schema adresi ve belirli bir metinle ilişkilidir kullanıcılar bu buton gridi üzerinden GraphqL mutationlarını çalıştırabilirler.

##Kullanımı

Butonlara tıkladığınızda ilgili butonun durumu değişir.
Eğer buton daha önce basıldıysa tüm butonlar pasif hale getirilir.
Eğer buton daha önce basılmamışsa sadece bu buton aktif hale gelir ve GraphqL mutation çalıştırılır.

##GraphQL Bağlantısı

Her buton, bir GraphQL schema adresi ile ilişkilidir. Bu adres CustomButton sınıfının kurucu metodunda belirlenir.
Her butonun basılmasıyla birlikte belirtilen GraphQL schema adresi üzerinden bir mutation çalıştırılır.

##Nasıl kullanılır

Projeyi İndirin
Proje dosyalarının bulunduğu dizinde terminali açın ve şu komutu çalıştırarak gerekli bağımlılıkları yükleyin
java CustomButton.java

##Uygulamayı çalıştırın

Derleme işleminden sonra aynı dizinde şu komutu çalıştırarak uygulamayı başlatın
java CustomButton

##Butonları kullanın

Oluşan pencerede 4x4 bir buton gridi görünecektir
İlgili butonlara tıklayarak uygulamayı kullanabilirsiniz

##Ek bilgiler

Butonların görünümü aktif veya pasif durumlarına bağlı olarak renk ve simgelerle değişir.
CustomButton sınıfının içinde bulunan executegraphqLmutation metodu her buton basıldığında çalışacak olan GraphqL mutation mantığını içerir.
