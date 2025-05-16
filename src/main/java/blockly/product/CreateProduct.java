package blockly.product;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
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
 * @since 16/05/2025, 11:41:17
 *
 */
public static Var createFromJSON(@ParamMetaData(description = "product", id = "0822b2e3") @RequestBody(required = false) Var product) throws Exception {
 return new Callable<Var>() {

   private Var productOnDB = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
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
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro no processo de criação de produtos.")));
     }
    return productOnDB;
   }
 }.call();
}

}

