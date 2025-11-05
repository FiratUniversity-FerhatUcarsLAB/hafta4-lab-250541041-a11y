//AD-SOYAD:Emire Şeker
//OGRENCİ NO:250541041
//TARİH:05.11.2025
// Görev 3: Maas Hesaplama Sistemi (Zor)


import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MaasHesap {
    public static void main(String[] args) {
        // Sabit (final) oranlar
        final double SGK_RATE = 0.14;        // %14
        final double INCOME_TAX_RATE = 0.15; // %15
        final double DAMGA_RATE = 0.00759;   // %0.759

        Scanner input = new Scanner(System.in);

        System.out.println("=== MAAS HESAPLAMA SISTEMI ===\n");

        // Kullanıcıdan verileri al
        System.out.print("Calisan adi soyadi: ");
        String isim = input.nextLine();

        System.out.print("Brut maas (TL): ");
        double brutMaas = input.nextDouble();

        System.out.print("Haftalik calisma saati: ");
        int haftalikSaat = input.nextInt();

        System.out.print("Mesai saati sayisi: ");
        int mesaiSaat = input.nextInt();

        // Ara hesaplamalar
        // Mesai ücreti = (Brut Maas / 160) × Mesai Saati × 1.5
        double saatlikUcret = brutMaas / 160.0;
        double mesaiUcreti = saatlikUcret * mesaiSaat * 1.5;

        // Toplam gelir
        double toplamGelir = brutMaas + mesaiUcreti;

        // Kesintiler
        double sgkKesinti = toplamGelir * SGK_RATE;
        double gelirVergisi = toplamGelir * INCOME_TAX_RATE;
        double damgaVergisi = toplamGelir * DAMGA_RATE;
        double toplamKesinti = sgkKesinti + gelirVergisi + damgaVergisi;

        // Net maas
        double netMaas = toplamGelir - toplamKesinti;

        // Istatistikler
        double kesintiOrani = (toplamKesinti / toplamGelir) * 100.0; // yüzde olarak
        // Gunluk net (22 iş günü varsayımıyla)
        final int IS_GUNU = 22;
        double gunlukNet = netMaas / IS_GUNU;

        // Saatlik net kazanc: haftalık çalışma saatine göre günlük çalışma saati = haftalikSaat / 5
        double gunlukCalismaSaat = (double) haftalikSaat / 5.0;
        // Güvenlik: eğer kullanıcı 0 ya da negatif haftalık saat verdiyse bölme hatası olmasın
        double saatlikNet;
        if (gunlukCalismaSaat <= 0.0) {
            saatlikNet = 0.0; // ya da Double.NaN tercih edilebilir
        } else {
            saatlikNet = gunlukNet / gunlukCalismaSaat;
        }

        // Tarih
        LocalDate bugun = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        // Profesyonel bordro çıktısı
        System.out.println();
        System.out.println("====================================");
        System.out.println("           MAAS BORDROSU");
        System.out.println("====================================");
        System.out.printf("Calisan : %s%n", isim);
        System.out.printf("Tarih   : %s%n", bugun.format(fmt));
        System.out.println();
        System.out.println("GELIRLER:");
        System.out.printf("  %-24s: %10.2f TL%n", "Brut Maas", brutMaas);
        System.out.printf("  %-24s: %10.2f TL%n", "Mesai Ucreti (" + mesaiSaat + " saat)", mesaiUcreti);
        System.out.println("  -------------------------------");
        System.out.printf("  %-24s: %10.2f TL%n", "TOPLAM GELIR", toplamGelir);

        System.out.println();
        System.out.println("KESINTILER:");
        System.out.printf("  %-24s (%4.1f%%): %10.2f TL%n", "SGK Kesintisi", SGK_RATE * 100.0, sgkKesinti);
        System.out.printf("  %-24s (%4.1f%%): %10.2f TL%n", "Gelir Vergisi", INCOME_TAX_RATE * 100.0, gelirVergisi);
        System.out.printf("  %-24s (%4.1f%%): %10.2f TL%n", "Damga Vergisi", DAMGA_RATE * 100.0, damgaVergisi);
        System.out.println("  -------------------------------");
        System.out.printf("  %-24s: %10.2f TL%n", "TOPLAM KESINTI", toplamKesinti);

        System.out.println();
        System.out.printf("%-30s: %10.2f TL%n", "NET MAAS", netMaas);

        System.out.println();
        System.out.println("ISTATISTIKLER:");
        System.out.printf("  %-24s: %6.1f%%%n", "Kesinti Orani", kesintiOrani);
        System.out.printf("  %-24s: %10.2f TL/saat%n", "Saatlik Net Kazanc", saatlikNet);
        System.out.printf("  %-24s: %10.2f TL/gun%n", "Gunluk Net Kazanc", gunlukNet);

        System.out.println("====================================");

        input.close();
    }
}
