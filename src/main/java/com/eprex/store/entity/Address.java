package com.eprex.store.entity;


import java.io.Serializable;
import java.util.Objects;

public class Address extends BaseEntity implements Serializable {

  private Integer aid;
  private Integer uid;
  private String name;
  private String provinceName;
  private String provinceCode;
  private String cityName;
  private String cityCode;
  private String areaName;
  private String areaCode;
  private String zip;
  private String address;
  private String phone;
  private String tel;
  private String tag;
  private Integer isDefault;

  public Address(Integer aid, Integer uid, String name, String provinceName, String provinceCode, String cityName, String cityCode, String areaName, String areaCode, String zip, String address, String phone, String tel, String tag, Integer isDefault) {
    this.aid = aid;
    this.uid = uid;
    this.name = name;
    this.provinceName = provinceName;
    this.provinceCode = provinceCode;
    this.cityName = cityName;
    this.cityCode = cityCode;
    this.areaName = areaName;
    this.areaCode = areaCode;
    this.zip = zip;
    this.address = address;
    this.phone = phone;
    this.tel = tel;
    this.tag = tag;
    this.isDefault = isDefault;
  }

  public Address() {
  }

  public Integer getAid() {
    return aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProvinceName() {
    return provinceName;
  }

  public void setProvinceName(String provinceName) {
    this.provinceName = provinceName;
  }

  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public Integer getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Integer isDefault) {
    this.isDefault = isDefault;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address1 = (Address) o;
    return Objects.equals(aid, address1.aid) && Objects.equals(uid, address1.uid) && Objects.equals(name, address1.name) && Objects.equals(provinceName, address1.provinceName) && Objects.equals(provinceCode, address1.provinceCode) && Objects.equals(cityName, address1.cityName) && Objects.equals(cityCode, address1.cityCode) && Objects.equals(areaName, address1.areaName) && Objects.equals(areaCode, address1.areaCode) && Objects.equals(zip, address1.zip) && Objects.equals(address, address1.address) && Objects.equals(phone, address1.phone) && Objects.equals(tel, address1.tel) && Objects.equals(tag, address1.tag) && Objects.equals(isDefault, address1.isDefault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aid, uid, name, provinceName, provinceCode, cityName, cityCode, areaName, areaCode, zip, address, phone, tel, tag, isDefault);
  }

  @Override
  public String toString() {
    return "Address{" +
            "aid=" + aid +
            ", uid=" + uid +
            ", name='" + name + '\'' +
            ", provinceName='" + provinceName + '\'' +
            ", provinceCode='" + provinceCode + '\'' +
            ", cityName='" + cityName + '\'' +
            ", cityCode='" + cityCode + '\'' +
            ", areaName='" + areaName + '\'' +
            ", areaCode='" + areaCode + '\'' +
            ", zip='" + zip + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", tel='" + tel + '\'' +
            ", tag='" + tag + '\'' +
            ", isDefault=" + isDefault +
            '}';
  }
}
