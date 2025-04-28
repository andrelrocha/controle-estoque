package app.entity;

import java.io.*;
import jakarta.persistence.*;
import java.util.*;
import jakarta.xml.bind.annotation.*;


/**
* @generated
*
**/
public class ProductExitPK implements Serializable {

  /**
  * @generated
  */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
   * @generated
   */
  private java.lang.String product;

  /**
   * Construtor
   * @generated
   */
  public ProductExitPK(){
  }

  /**
   * Obtém id
   * return id
   * @generated
   */
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public ProductExitPK setId(java.lang.String id){
    this.id = id;
    return this;
  }
  /**
   * Obtém product
   * return product
   * @generated
   */
  public java.lang.String getProduct(){
    return this.product;
  }

  /**
   * Define product
   * @param product product
   * @generated
   */
  public ProductExitPK setProduct(java.lang.String product){
    this.product = product;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
ProductExitPK object = (ProductExitPK)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    if (product != null ? !product.equals(object.product) : object.product != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    result = 31 * result + ((product == null) ? 0 : product.hashCode());
    return result;
  }

}
