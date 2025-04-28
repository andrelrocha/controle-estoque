
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
* Classe que representa a tabela PRODUCTEXIT
* @generated
*/
@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "\"PRODUCTEXIT\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.ProductExit")
@CronappTable(role=CronappTableRole.ASSOCIATION_CLASS)
public class ProductExit implements Serializable {
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
    @ManyToOne
    @JoinColumn(name="registeringUser", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private User registeringUser;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="product", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Product product;


    /**
    * @generated
    */
    @CronappColumn(attributeType="INTEGER", label="Amount")
    @Column(name = "amount", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer amount;


    /**
    * @generated
    */
    @Temporal(TemporalType.TIMESTAMP)
    @CronappColumn(attributeType="DATETIME", label="Date")
    @Column(name = "date", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.util.Date date;


    /**
    * Construtor
    * @generated
    */
    public ProductExit(){
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
    public ProductExit setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém registeringUser
    * return registeringUser
    * @generated
    */
    public User getRegisteringUser() {
        return this.registeringUser;
    }

    /**
    * Define registeringUser
    * @param registeringUser registeringUser
    * @generated
    */
    public ProductExit setRegisteringUser(User registeringUser) {
        this.registeringUser = registeringUser;
        return this;
    }
    /**
    * Obtém product
    * return product
    * @generated
    */
    public Product getProduct() {
        return this.product;
    }

    /**
    * Define product
    * @param product product
    * @generated
    */
    public ProductExit setProduct(Product product) {
        this.product = product;
        return this;
    }
    /**
    * Obtém amount
    * return amount
    * @generated
    */
    public java.lang.Integer getAmount() {
        return this.amount;
    }

    /**
    * Define amount
    * @param amount amount
    * @generated
    */
    public ProductExit setAmount(java.lang.Integer amount) {
        this.amount = amount;
        return this;
    }
    /**
    * Obtém date
    * return date
    * @generated
    */
    public java.util.Date getDate() {
        return this.date;
    }

    /**
    * Define date
    * @param date date
    * @generated
    */
    public ProductExit setDate(java.util.Date date) {
        this.date = date;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
ProductExit object = (ProductExit)obj;
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
