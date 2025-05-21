package blockly.product;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CreateOrUpdateFromCSV {

public static final int TIMEOUT = 300;

/**
 *
 * @param product
 * @param productsOnDB
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 10:48:58
 *
 */
public static Var checkIfHasChanged(@ParamMetaData(description = "product", id = "049a1ba5") @RequestBody(required = false) Var product, @ParamMetaData(description = "productsOnDB", id = "ace0b07d") Var productsOnDB) throws Exception {
 return new Callable<Var>() {

   private Var productOnDb = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;
   private Var status = Var.VAR_NULL;
   private Var nameChanged = Var.VAR_NULL;
   private Var amountChanged = Var.VAR_NULL;
   private Var minQuantityChanged = Var.VAR_NULL;
   private Var maxQuantityChanged = Var.VAR_NULL;

   public Var call() throws Exception {
    status =
    Var.VAR_FALSE;
    productOnDb =
    cronapi.list.Operations.get(productsOnDB,
    cronapi.list.Operations.findFirst(productsOnDB, product));
    nameChanged =
    Var.valueOf(!
    cronapi.text.Operations.normalize(
    cronapi.json.Operations.getJsonOrMapField(product,
    Var.valueOf("name"))).equals(
    cronapi.text.Operations.normalize(
    cronapi.json.Operations.getJsonOrMapField(productOnDb,
    Var.valueOf("name")))));
    amountChanged =
    Var.valueOf(!
    cronapi.json.Operations.getJsonOrMapField(product,
    Var.valueOf("amount")).equals(
    cronapi.json.Operations.getJsonOrMapField(productOnDb,
    Var.valueOf("amount"))));
    minQuantityChanged =
    Var.valueOf(!
    cronapi.json.Operations.getJsonOrMapField(product,
    Var.valueOf("minQuantity")).equals(
    cronapi.json.Operations.getJsonOrMapField(productOnDb,
    Var.valueOf("minQuantity"))));
    maxQuantityChanged =
    Var.valueOf(!
    cronapi.json.Operations.getJsonOrMapField(product,
    Var.valueOf("maxQuantity")).equals(
    cronapi.json.Operations.getJsonOrMapField(productOnDb,
    Var.valueOf("maxQuantity"))));
    if (
    Var.valueOf(amountChanged.getObjectAsBoolean() || nameChanged.getObjectAsBoolean() || minQuantityChanged.getObjectAsBoolean() || maxQuantityChanged.getObjectAsBoolean()).getObjectAsBoolean()) {
        status =
        Var.VAR_TRUE;
    }
    return status;
   }
 }.call();
}

/**
 *
 * @param productsList
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 10:48:58
 *
 */
public static Var manage(@ParamMetaData(description = "productsList", id = "cd44578b") @RequestBody(required = false) Var productsList) throws Exception {
 return new Callable<Var>() {

   private Var products = Var.VAR_NULL;
   private Var productsIds = Var.VAR_NULL;
   private Var product = Var.VAR_NULL;
   private Var productOnDb = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         products =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Product"),Var.valueOf("select \n	p \nfrom \n	Product p"));
        productsIds =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Product"),Var.valueOf("select \n	p.id \nfrom \n	Product p"));
        for (Iterator it_product = productsList.iterator(); it_product.hasNext();) {
            product = Var.valueOf(it_product.next());
            if (
            Var.valueOf(!
            cronapi.list.Operations.findFirst(productsIds,
            cronapi.json.Operations.getJsonOrMapField(product,
            Var.valueOf("id"))).equals(
            Var.valueOf(0))).getObjectAsBoolean()) {
                if (
                Var.valueOf(checkIfHasChanged(product, products)).getObjectAsBoolean()) {
                    productOnDb =
                    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.UpdateProduct:updateFromJSON"), Var.valueOf("2cc85c57", product));
                }
            } else {
                productOnDb =
                cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.CreateProduct:createFromJSON"), Var.valueOf("0822b2e3", product));
            }
        } // end for
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao gerenciar o processo de criação/atualização de produtos a partir do csv")));
     }
    return Var.VAR_NULL;
   }
 }.call();
}

}

