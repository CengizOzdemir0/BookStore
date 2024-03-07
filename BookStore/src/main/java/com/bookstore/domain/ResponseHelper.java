package com.bookstore.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bookstore.base.dto.BaseDto;
import com.bookstore.base.tipler.Mesaj;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseHelper {

  public static <T extends BaseDto> ResponseEntity<RestResponse<T>> responseEntityFromResponse(RestResponse<T> restResponse) {
    return new ResponseEntity<>(restResponse, restResponse.getHttpStatus().getSpringHttpStatus());
  }

  public static <T extends BaseDto> ResponseEntity<RestResponse<T>> responseEntityDataWithMesaj(Mesaj mesajEnum) {
    RestResponse res = new RestResponse();
    res.addMesaj(mesajEnum);
    return responseEntityFromResponse(res);
  }

  public static ResponseEntity responseEntityOkWithByteArray(byte[] belge, String belgeAdi) {
    InputStreamResource resource = null;
    resource = new InputStreamResource(new ByteArrayInputStream(belge));
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + belgeAdi)
        .header("Access-Control-Expose-Headers", "*")
        .header("File-Name", belgeAdi)
        .contentType(MediaType.MULTIPART_FORM_DATA)
        .contentLength(belge.length)
        .body(resource);
  }

}

