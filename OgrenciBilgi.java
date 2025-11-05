/*
 * Ad Soyad: Emire Şeker
 * Ogrenci No:250541041
 * Tarih:(05.11.2025)
 * Aciklama: Gorev 1 - Ogrenci Bilgi Sistemi
 * 
 * Bu program kullanicidan ogrenci bilgilerini alir ve
 * duzenli bir formatta ekrana yazdirir.
 * Diğer java dosyalarının başında da bu örnek formattaki gibi kısa bilgi giriniz
 */

import java.util.Scanner;

    public class OgrenciBilgi {
        public static void main(String[] args) {
            // Scanner objesi olusturun
            Scanner input = new Scanner(System.in);
            System.out.println("\n=== OGRENCI BILGI SISTEMI ===");
            // Degisken tanimlamalari
            // String ad, soyad;
            System.out.println("Adinizi Girin");
            String ad = input.nextLine();
            System.out.println(ad);
            System.out.println("Soyadi Girin");
            String soyad = input.nextLine();
            System.out.println(soyad);
            System.out.printf("Ad Soyad: %s %s", ad, soyad);
            // int ogrenciNo, yas;
            System.out.println("Yasiniz:");
            int yas = input.nextInt();
            System.out.println(yas);
            System.out.println("Ogrenci Numaranız:");
            int ogrNo = input.nextInt();
            System.out.println(ogrNo);
            // gpa;
            System.out.println("GPA:");
            double gpa = input.nextDouble();
            System.out.println(gpa);
            String durum;
                if (gpa < 1.8) {
                    durum = "Basarisiz Ogrenci";
                    System.out.println("KALDI"); // Eğer 1.8'den küçükse kaldı
                } else {
                    durum = "Basarili Ogrenci";
                    System.out.println("GECTI"); // Değilse (yani 1.8 veya daha büyükse) geçti
                }
            // Scanner'i kapatin (önemli pratik)
            input.close();
            // --- Çıktı Formatı ---
            System.out.println("\n=== OGRENCI BILGI SISTEMI ===");

            // printf() kullanarak düzenli çıktı alma ve GPA'yı 2 ondalık basamakla gösterme
            System.out.printf("Ad Soyad: %s %s%n", ad, soyad);
            System.out.printf("Ogrenci No: %d%n", ogrNo);
            System.out.printf("Yas: %d%n", yas);
            System.out.printf("GPA: %.2f%n", gpa); // %.2f ile 2 ondalık basamak garantilenir
            System.out.printf("Durum: %s%n", durum);
            System.out.println("=============================");
        }
    }
