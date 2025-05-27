package blockly.product;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CreateProduct {

public static final int TIMEOUT = 300;

/**
 *
 * @param product
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 12:04:48
 *
 */
public static Var createFromJSON(@ParamMetaData(description = "product", id = "0822b2e3") @RequestBody(required = false) Var product) throws Exception {
 return new Callable<Var>() {

   private Var productsAlreadyOnDB = Var.VAR_NULL;
   private Var productIsNotOnDB = Var.VAR_NULL;
   private Var productName = Var.VAR_NULL;
   private Var productOnDB = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         productsAlreadyOnDB =
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.GetProduct:getAllNames"));
        productIsNotOnDB =
        Var.VAR_TRUE;
        for (Iterator it_productName = productsAlreadyOnDB.iterator(); it_productName.hasNext();) {
            productName = Var.valueOf(it_productName.next());
            if (
            Var.valueOf(
            cronapi.text.Operations.normalize(productName).equals(
            cronapi.text.Operations.normalize(
            cronapi.json.Operations.getJsonOrMapField(product,
            Var.valueOf("name"))))).getObjectAsBoolean()) {
                productIsNotOnDB =
                Var.VAR_FALSE;
                break;
            }
        } // end for
        if (productIsNotOnDB.getObjectAsBoolean()) {
            productOnDB =
            cronapi.database.Operations.insert(Var.valueOf("app.entity.Product"),Var.valueOf("id",
            cronapi.util.Operations.generateUUID()),Var.valueOf("amount",
            cronapi.json.Operations.getJsonOrMapField(product,
            Var.valueOf("amount"))),Var.valueOf("maxQuantity",
            cronapi.json.Operations.getJsonOrMapField(product,
            Var.valueOf("maxQuantity"))),Var.valueOf("minQuantity",
            cronapi.json.Operations.getJsonOrMapField(product,
            Var.valueOf("minQuantity"))),Var.valueOf("name",
            cronapi.json.Operations.getJsonOrMapField(product,
            Var.valueOf("name"))));
            if (
            cronapi.logic.Operations.isNullOrEmpty(productOnDB).getObjectAsBoolean()) {
                cronapi.util.Operations.throwException(
                cronapi.util.Operations.createException(
                Var.valueOf("Ocorreu um erro ao criar um produto no banco.")));
            }
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("success",
            Var.VAR_TRUE) , Var.valueOf("message",
            Var.valueOf("Produto adicionado com sucesso no sistema!")));
        } else {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Já existe produto com o nome informado.")));
        }
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("success",
        Var.VAR_FALSE) , Var.valueOf("message",
        cronapi.util.Operations.getExceptionMessage(e)));
     }
    return response;
   }
 }.call();
}

}

