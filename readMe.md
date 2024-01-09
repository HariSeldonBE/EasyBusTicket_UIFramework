# com.EasyBusTicket
### Team_2 Otomasyon Projesi ReadMe Dosyası
### 
***

1. Test dosyalarinin isimlendirmesi su sekildedir:
   "tests" package altında herkes kendi ismini gordugu package altında 
   sorumlu oldugu US icin ayri bir package acacak (ornek: US01) 
   ilgili US package altinda ise TC01 den baslayarak US icindeki
   tum TC'ler ayri class olarak tek tek hazırlanacak.
   


2. Locate alinan element nerenin elementi oldugu aciklama satiri ile aciklanmali
   || orn:  Homepage>> LoginLink>> Email Text Box ||

<br/>

### Git
***
1. Herkes kendi adina birer branch olusturur.
    * `git branch <isim>`

2. sag alt panelde branc ismimizin yazili oldugu kisimdan
    * main' e tikliyoruz
    * update'e tikliyoruz
    * sonra merge 'main' into 'brancismi' yazan kısma tikliyoruz
    * bu şekilde pull işlemini gerçekleştirmiş oluyoruz

3. Yaptigi degisiklikleri kucuk commitlerle kendi branchinda saklar. Burada tavsiye edilen sadece sizin yaptiginiz degisikliklerin eklenmesidir.
    * 'git add . kesinlikle kullanilMAMAli'
    * 'git add (degisiklik yapilan yerin  dosya yolu yani "pat from content root" u)
    * 'git commit -m "İsim/tarih/Yapilan Degisiklikler icin bir mesaj yazilir."'
      Örn >>> git commit -m "<Kendi isminiz>/02.07/loginClassEklendi"
4. git push

5. gelen linkten ustteki linke tiklanir ve github hesabi sayfasi acilir

6. Push ettigimiz kendi kodumuz icin **request** olusturulur ve is biter

7. Merge request islemi team lead tarfindan gerceklestirilir


### Isimlendirmelerde dikaat edilecekler
***
| Element Türü   | Variable name |
|----------------|--------------|
| Button         | signInButton |    
| Logo           | logoX         |
| icon           | iconX        |
| Sadece text    | labelX       |
| Drop down      | dropDownX    |
| Radio Button   | radioButtonX |
| Check box      | checkBoxX    |
| Tablo Sütünu   | columnX      |
| Tablo Satiri   | rowX         |
| Kisi Resimleri | imageProfileX |
| ürün resimleri | imageProductX |
| Linkler        | linkX        |