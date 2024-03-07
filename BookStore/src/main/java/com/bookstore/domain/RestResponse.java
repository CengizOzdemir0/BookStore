package com.bookstore.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;




import com.bookstore.base.dto.BaseDto;
import com.bookstore.base.dto.RestMesajDTO;
import com.bookstore.base.tipler.Dil;
import com.bookstore.base.tipler.HttpStatus;
import com.bookstore.base.tipler.Mesaj;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@Data
@Slf4j
public class RestResponse<T extends BaseDto> {

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

  @JsonProperty("listData")
  @JsonInclude(Include.NON_NULL)
  private List<T> listData;

  private boolean success = true;

  public RestResponse<T> createWithMesajEnum(Mesaj mesaj) {
    this.addMesaj(mesaj);
    return this;
  }

  public void addMesaj(Mesaj mesaj) {
    this.httpStatus = mesaj.getHttpStatus();
    switch (mesaj.getSeviye()) {
      case WARN -> this.warningList.add(new RestMesajDTO(mesaj.getKodu(), mesaj.getMesajStr()));
      case ERROR -> {
        this.success = false;
        this.errorList.add(new RestMesajDTO(mesaj.getKodu(), mesaj.getMesajStr()));
      }
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

  public RestResponse<T> createOkWithData(T data) {
    RestResponse<T> restResponse = createOk();
    restResponse.data = data;
    return restResponse;
  }

  public RestResponse<T> createOk() {
    this.addMesaj(Mesaj.GNL_ISLEM_BASARILI);
    return this;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setListData(List<T> data) {
    listData = data;
  }
}
