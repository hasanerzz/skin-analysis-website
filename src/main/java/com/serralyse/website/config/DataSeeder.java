package com.serralyse.website.config;

import com.serralyse.website.entity.MicroPod;
import com.serralyse.website.entity.PodStatus;
import com.serralyse.website.entity.RawMaterial;
import com.serralyse.website.repository.MicroPodRepository;
import com.serralyse.website.repository.RawMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final RawMaterialRepository rawMaterialRepository;
    private final MicroPodRepository microPodRepository;

    @Override
    public void run(String... args) throws Exception {
        seedRawMaterials();
        seedMicroPods();
    }

    private void seedRawMaterials() {
        if (rawMaterialRepository.count() == 0) {
            // 1. HERO INGREDIENT: Tip 3 Kolajen (Dökümandan: Recombinant Type III Collagen [cite: 101])
            RawMaterial r1 = new RawMaterial();
            r1.setName("Recombinant Collagen Type III");
            r1.setInciName("sh-Polypeptide-123");
            r1.setDescription("Cilt bariyerini onarır ve elastikiyeti artırır.");
            r1.setPurityPercentage(98.5); // Dökümandaki saflık oranı [cite: 62]
            r1.setBatchCode("BIO-2026-001");
            r1.setStockLevelMl(50000);
            r1.setUnitPriceMl(2.5);

            // 2. STABILIZATION: Lipozom Kılıfı (Dökümandan: Liposomal Encapsulation [cite: 63])
            RawMaterial r2 = new RawMaterial();
            r2.setName("Liposomal Lipid Bilayer");
            r2.setInciName("Phosphatidylcholine");
            r2.setDescription("Aktif maddeleri koruyan taşıyıcı kapsül.");
            r2.setPurityPercentage(99.0);
            r2.setBatchCode("LIP-2026-X1");
            r2.setStockLevelMl(100000);
            r2.setUnitPriceMl(0.8);

            // 3. RETINOL (Dökümandan: High Precision [cite: 156])
            RawMaterial r3 = new RawMaterial();
            r3.setName("Pure Retinol");
            r3.setInciName("Retinol");
            r3.setDescription("Hücre yenilenmesi ve kırışıklık karşıtı.");
            r3.setPurityPercentage(97.0);
            r3.setBatchCode("RET-2026-A");
            r3.setStockLevelMl(2000);
            r3.setUnitPriceMl(5.0);

            // 4. NIACINAMIDE
            RawMaterial r4 = new RawMaterial();
            r4.setName("Niacinamide Ultrapure");
            r4.setInciName("Niacinamide");
            r4.setDescription("Leke giderici ve sebum dengeleyici.");
            r4.setPurityPercentage(99.5);
            r4.setBatchCode("NIA-2026-B");
            r4.setStockLevelMl(5000);
            r4.setUnitPriceMl(1.2);

            // 5. SALISILIK ASIT (zaten var - değiştirme)
            RawMaterial r5 = new RawMaterial();
            r5.setName("Salicylic Acid Bio");
            r5.setInciName("Salicylic Acid");
            r5.setDescription("Gözenek temizleyici BHA.");
            r5.setPurityPercentage(99.0);
            r5.setBatchCode("SAL-2026-C");
            r5.setStockLevelMl(4000);
            r5.setUnitPriceMl(1.0);

// 6. HYALURONİK ASİT (DRY cilt için) - YENİ EKLE
            RawMaterial r6 = new RawMaterial();
            r6.setName("Hyaluronic Acid");
            r6.setInciName("Sodium Hyaluronate");
            r6.setDescription("Nem tutma ve hidrasyon.");
            r6.setPurityPercentage(98.0);
            r6.setBatchCode("HYA-2026-D");
            r6.setStockLevelMl(3000);
            r6.setUnitPriceMl(3.0);

// 7. GÜNEŞ KORUYUCU (herkese ekleniyor) - YENİ EKLE
            RawMaterial r7 = new RawMaterial();
            r7.setName("Titanium Dioxide SPF");
            r7.setInciName("Titanium Dioxide");
            r7.setDescription("Mineral güneş koruyucu.");
            r7.setPurityPercentage(99.5);
            r7.setBatchCode("SUN-2026-E");
            r7.setStockLevelMl(8000);
            r7.setUnitPriceMl(1.5);

            rawMaterialRepository.saveAll(List.of(r1, r2, r3, r4, r5, r6, r7)); // r6, r7 ekle

            rawMaterialRepository.saveAll(List.of(r1, r2, r3, r4, r5));
            System.out.println("----- BİYOTEKNOLOJİK HAMMADDELER YÜKLENDİ -----");
        }
    }

    private void seedMicroPods() {
        if (microPodRepository.count() == 0) {
            // Dökümanda geçen İstanbul Pilot Hub'ı [cite: 162]
            MicroPod pod1 = new MicroPod();
            pod1.setLocation("Istanbul Pilot Hub - Unit 1");
            pod1.setStatus(PodStatus.ACTIVE);
            pod1.setLastCleaningDate(LocalDateTime.now().minusHours(2)); // 2 saat önce temizlenmiş

            microPodRepository.save(pod1);
            System.out.println("----- MİKRO ÜRETİM ÜNİTESİ AKTİF -----");
        }
    }
}
