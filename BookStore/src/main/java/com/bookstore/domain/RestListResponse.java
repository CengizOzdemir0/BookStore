package com.bookstore.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.bookstore.base.dto.BaseDto;
import com.bookstore.base.dto.RestMesajDTO;
import com.bookstore.base.tipler.Dil;
import com.bookstore.base.tipler.Mesaj;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-03-07T11:22:00.007Z
 */

@Data
@Slf4j
public class RestListResponse<T extends List<BaseDto>> {

  @JsonProperty("lang")
  private String dilEnum = Dil.TR.getUlkeKodu();

  @JsonProperty("infos")
  private List<RestMesajDTO> infoList = new ArrayList<>();

  @JsonProperty("warnings")
  private List<RestMesajDTO> warningList = new ArrayList<>();

  @JsonProperty("errors")
  private List<RestMesajDTO> errorList = new ArrayList<>();
  @JsonIgnore
  private HttpStatus httpStatus;

  @JsonProperty("data")
  private T data;

  public RestListResponse<T> createWithMesajEnum(Mesaj mesaj) {
    RestListResponse<T> restResponse = new RestListResponse<>();
    restResponse.addMesaj(mesaj);
    return restResponse;
  }

  public void addMesaj(Mesaj mesaj) {
    this.httpStatus = mesaj.getHttpStatus().getSpringHttpStatus();
    switch (mesaj.getSeviye()) {
      case WARN -> this.warningList.add(new RestMesajDTO(mesaj.getKodu(), mesaj.getMesajStr()));
      case ERROR -> this.errorList.add(new RestMesajDTO(mesaj.getKodu(), mesaj.getMesajStr()));
      default -> this.infoList.add(new RestMesajDTO(mesaj.getKodu(), mesaj.getMesajStr()));
    }
  }

  public String toJson() {
    ObjectMapper mapper = BeanUtil.getBean(ObjectMapper.class);
    try {
      return mapper.writeValueAsString(this);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return null;
  }

  public RestListResponse<T> createOkWithData(T data) {
    RestListResponse<T> restResponse = createOk();
    restResponse.data = data;
    return restResponse;
  }

  public RestListResponse<T> createOk() {
    this.addMesaj(Mesaj.GNL_ISLEM_BASARILI);
    return this;
  }

  public void setData(T data) {
    this.data = data;
  }
}

