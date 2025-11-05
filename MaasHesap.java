//AD-SOYAD:EMİRE ŞEKER
//Öğrenci no:250541041
//Tarih:05.11.2025
//Görev 2: Geometrik Hesaplayıcı (Orta)


import java.util.Scanner;

public class GeometrikHesaplayici {
    public static void main(String[] args) {
        // PI sabiti tanımlanıyor
        final double PI = 3.14159;

        Scanner input = new Scanner(System.in);

        System.out.println("=== GEOMETRIK HESAPLAYICI ===");
        System.out.print("Dairenin yaricapini girin (cm): ");
        double r = input.nextDouble(); // yarıçapı alıyoruz

        // Hesaplamalar
        double daireAlani = PI * Math.pow(r, 2);
        double daireCevresi = 2 * PI * r;
        double daireCapi = 2 * r;
        double kureHacmi = (4.0 / 3.0) * PI * Math.pow(r, 3);
        double kureYuzeyAlani = 4 * PI * Math.pow(r, 2);

        // Sonuçları düzenli şekilde ekrana yazdırıyoruz
        System.out.println();
        System.out.println("SONUCLAR:");
        System.out.println("----------");
        System.out.printf("Daire Alani        : %.2f cm²%n", daireAlani);
        System.out.printf("Daire Cevresi      : %.2f cm%n", daireCevresi);
        System.out.printf("Daire Capi         : %.2f cm%n", daireCapi);
        System.out.printf("Kure Hacmi         : %.2f cm³%n", kureHacmi);
        System.out.printf("Kure Yuzey Alani   : %.2f cm²%n", kureYuzeyAlani);
        System.out.println("----------------------------------");
        System.out.println("Hesaplama tamamlandi");

        input.close();
    }
}
