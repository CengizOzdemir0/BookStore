package com.bookstore.base.tipler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Mesaj {
  GNL_KAYIT_BULUNAMADI(HttpStatus.NO_CONTENT, "GNL1005", "Kayıt Bulunamadı", MesajSeviye.INFO),
  TKN_KULLANICI_BULUNAMADI(HttpStatus.INTERNAL_SERVER_ERROR, "TKN1001", "Token kullanıcı bilgisi alınamadı!!! (TKN1001)", MesajSeviye.ERROR),
  GNL_ISLEM_BASARILI(HttpStatus.OK, "GNL1009", "İşlem Başarılı", MesajSeviye.INFO),
  LGN_ERISIM_ENGELLENDI(HttpStatus.FORBIDDEN, "LGN1006", "Erişim yetkiniz bulunmamaktadır (LGN1006)", MesajSeviye.ERROR),
  LGN_CIKIS_BASARISIZ(HttpStatus.BAD_REQUEST, "LGN1008", "Çıkış işlemi yapılamamıştır. Lütfen öncelikle giriş yapınız. (LGN1008)", MesajSeviye.ERROR),
  LGN_CIKIS_BASARILI(HttpStatus.OK, "LGN1005", "Oturum başarılı olarak sonlandırıldı", MesajSeviye.INFO),
  GNL_BEKLENMEYEN_HATA_OLUSTU(HttpStatus.INTERNAL_SERVER_ERROR, "GNL1000",
      "Beklenmeyen hata oluştu. Lütfen yazılım ekibi ile irtibata geçiniz. (GNL1000)", MesajSeviye.ERROR),
  LGN_CACHE_OKUMA_YAZMA_HATASI(HttpStatus.INTERNAL_SERVER_ERROR, "LGN1007", "Cache bağlantı hatası. Lütfen daha sonra tekrar deneyin (LGN1007)",
      MesajSeviye.ERROR),
  LGN_KULLANICI_ADI_PAROLA_HATALI(HttpStatus.BAD_REQUEST, "LGN1003", "Kullanıcı adı ve/veya parola hatalı (LGN1003)", MesajSeviye.ERROR),
  LGN_KULLANICI_BULUNAMADI(HttpStatus.BAD_REQUEST, "LGN1002", "Kullanıcı bulunamadı (LGN1002)", MesajSeviye.ERROR),
  LGN_GIRIS_BILGILERI_EKSIK(HttpStatus.BAD_REQUEST, "LGN1001", "@@version (LGN1001)", MesajSeviye.ERROR),
  LGN_BASKA_YERDEN_GIRIS_YAPILMIS(HttpStatus.UNAUTHORIZED, "LGN2001", "Başka yerden giriş yaptığınızdan oturum sonlanmıştır. (LGN2001)",
      MesajSeviye.ERROR),
  LGN_OTURUM_SONLANMIS_TEKRAR_GIRIS_YAPINIZ(HttpStatus.UNAUTHORIZED, "LGN1004", "Oturumunuz sonlanmış tekrar giriş yapınız (LGN1004)",
      MesajSeviye.ERROR),
  LGN_TOKEN_GECERSIZ(HttpStatus.UNAUTHORIZED, "LGN2000", "Oturumunuz Sonlanmıştır. Tekrar giriş yapın. (LGN2000)", MesajSeviye.ERROR),
  DOSYA_BASARISIZ(HttpStatus.BAD_REQUEST, "LGN1019", "Dosya işlemi yapılamamıştır. (LGN1019)", MesajSeviye.ERROR),
  MODERATOR_YETKI_DOSYA(HttpStatus.BAD_REQUEST, "YTK1020", "Moderator olmadan dosya yükleyemezsiniz. (YTK1020)", MesajSeviye.ERROR),
  KRM_HEKIM_KAYITLI_DEGIL(HttpStatus.BAD_REQUEST, "KRM1032", "Girilen T.C. Kimlik Numarası sistemde hekim veya yetkili olarak kayıtlı değildir.",
      MesajSeviye.ERROR),
  KATILIMCI_BULUNMADI(HttpStatus.BAD_REQUEST, "KTLMCI01", "Katılımcı Tespit Edilemedi.",
      MesajSeviye.ERROR),
  GNL_TC_KIMLIK_NO_GECERSIZ(HttpStatus.PRECONDITION_REQUERED, "VT2006", "Lütfen Geçerli T.C. Kimlik No Giriniz.", MesajSeviye.ERROR),
  GNL_RULE_HATALI_CALISTI(HttpStatus.BAD_REQUEST, "GNL1019", "Kural hatalı çalıştı.", MesajSeviye.ERROR),
  VLD_CEP_TELEFON_FORMAT(HttpStatus.BAD_REQUEST, "VLD1019", "Lütfen Geçerli Cep Telefon Numarası Giriniz. Örnek(555XXXXXXX)", MesajSeviye.ERROR),
  YETKI_INSERT_BASARISIZ(HttpStatus.FORBIDDEN, "YTK1000", "Bu kişi için yetkilendirme yapamazsınız.", MesajSeviye.ERROR),
  YETKI_INSERT_YETKILI_MEVCUT(HttpStatus.FORBIDDEN, "YTK1001", "Sadece bir yetkili kişi tanımlayabilirsiniz.", MesajSeviye.ERROR),
  BELGE_SILME_YETKI_KONTROLU(HttpStatus.BAD_REQUEST, "BLG1001", "Yüklemediğiniz belgeyi silemezsiniz!", MesajSeviye.ERROR),
  VTN_HRN_TC_ESLESMESI_HATALI(HttpStatus.BAD_REQUEST, "VT10017",
      "T.C. Kimlik numarasına ait randevu kaydı bulunamamıştır. Lütfen T.C. kimlik Numarasını kontrol ediniz.(VT10017)", MesajSeviye.ERROR),
  GORUSME_NOTU_BULUNAMADI(HttpStatus.BAD_REQUEST, "GNOT1000", "Gorusme notu/Gorusme oda numarası boş olduğu için kayıt eklenemedi", MesajSeviye.ERROR),

  GNL_HASTA_TC_KIMLIK_NO_GECERSIZ(HttpStatus.BAD_REQUEST, "VT2006",
      "Geçersiz bir Hasta T.C. Kimlik Numarası girdiniz. (VT2006)", MesajSeviye.ERROR);
  private final HttpStatus httpStatus;
  private final String kodu;
  private final String mesajStr;
  private final MesajSeviye seviye;

}