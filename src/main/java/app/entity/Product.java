
package app.entity;

import java.io.*;
import jakarta.persistence.*;
import java.util.*;
import jakarta.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;



import cronapp.framework.core.persistence.*;

/**
* Classe que representa a tabela PRODUCT
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"PRODUCT\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Product")
@CronappTable(role=CronappTableRole.CLASS)
public class Product implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @CronappColumn(attributeType="STRING", label="Id", defaultValue = "UUID.randomUUID().toString().toUpperCase()")
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @CronappColumn(attributeType="STRING", label="Name")
    @Column(name = "name", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String name;


    /**
    * @generated
    */
    @CronappColumn(attributeType="LONG", label="Amount")
    @Column(name = "amount", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Long amount;


    /**
    * @generated
    */
    @CronappColumn(attributeType="INTEGER", label="Min Quantity")
    @Column(name = "minQuantity", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer minQuantity;


    /**
    * @generated
    */
    @CronappColumn(attributeType="LONG", label="Max Quantity")
    @Column(name = "maxQuantity", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Long maxQuantity;


    /**
    * Construtor
    * @generated
    */
    public Product(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Product setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém name
    * return name
    * @generated
    */
    public java.lang.String getName() {
        return this.name;
    }

    /**
    * Define name
    * @param name name
    * @generated
    */
    public Product setName(java.lang.String name) {
        this.name = name;
        return this;
    }
    /**
    * Obtém amount
    * return amount
    * @generated
    */
    public java.lang.Long getAmount() {
        return this.amount;
    }

    /**
    * Define amount
    * @param amount amount
    * @generated
    */
    public Product setAmount(java.lang.Long amount) {
        this.amount = amount;
        return this;
    }
    /**
    * Obtém minQuantity
    * return minQuantity
    * @generated
    */
    public java.lang.Integer getMinQuantity() {
        return this.minQuantity;
    }

    /**
    * Define minQuantity
    * @param minQuantity minQuantity
    * @generated
    */
    public Product setMinQuantity(java.lang.Integer minQuantity) {
        this.minQuantity = minQuantity;
        return this;
    }
    /**
    * Obtém maxQuantity
    * return maxQuantity
    * @generated
    */
    public java.lang.Long getMaxQuantity() {
        return this.maxQuantity;
    }

    /**
    * Define maxQuantity
    * @param maxQuantity maxQuantity
    * @generated
    */
    public Product setMaxQuantity(java.lang.Long maxQuantity) {
        this.maxQuantity = maxQuantity;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Product object = (Product)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
