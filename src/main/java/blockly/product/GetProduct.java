package blockly.product;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class GetProduct {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 11:59:59
 *
 */
public static Var getAll() throws Exception {
 return new Callable<Var>() {

   private Var products = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         products =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Product"),Var.valueOf("select \n	p \nfrom \n	Product p"));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao obter todos os produtos do sistema.")));
     }
    return products;
   }
 }.call();
}

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 11:59:59
 *
 */
public static Var getAllNames() throws Exception {
 return new Callable<Var>() {

   private Var e = Var.VAR_NULL;
   private Var productNames = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         productNames =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Product"),Var.valueOf("select \n	p.name \nfrom \n	Product p"));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao obter todos os nomes dos produtos do sistema.")));
     }
    return productNames;
   }
 }.call();
}

/**
 *
 * @param productId
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 11:59:59
 *
 */
public static Var getById(@ParamMetaData(description = "productId", id = "cbd6ae39") @RequestBody(required = false) Var productId) throws Exception {
 return new Callable<Var>() {

   private Var e = Var.VAR_NULL;
   private Var product = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.logic.Operations.isNullOrEmpty(productId).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("O ID do produto não pode ser nulo ou vazio.")));
        }
        product =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Product"),Var.valueOf("select \n	p \nfrom \n	Product p  \nwhere \n	p.id = :id"),Var.valueOf("id",productId));
        if (
        cronapi.logic.Operations.isNullOrEmpty(product).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não foi encontrado Produto com o ID informado")));
        }
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
    return
cronapi.list.Operations.getFirst(product);
   }
 }.call();
}

/**
 *
 * @param productId
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 11:59:59
 *
 */
public static Var getEntity(@ParamMetaData(description = "productId", id = "cbd6ae39") @RequestBody(required = false) Var productId) throws Exception {
 return new Callable<Var>() {

   private Var e = Var.VAR_NULL;
   private Var product = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.logic.Operations.isNullOrEmpty(productId).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("O ID do produto não pode ser nulo ou vazio.")));
        }
        product =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Product"),Var.valueOf("select \n	p \nfrom \n	Product p  \nwhere \n	p.id = :id"),Var.valueOf("id",productId));
        if (
        cronapi.logic.Operations.isNullOrEmpty(product).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não foi encontrado Produto com o ID informado")));
        }
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
    return product;
   }
 }.call();
}

}

