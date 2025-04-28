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
 * @param productId
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 28/04/2025, 18:45:13
 *
 */
public static Var getEntity(@ParamMetaData(description = "productId", id = "cbd6ae39") @RequestBody(required = false) Var productId) throws Exception {
 return new Callable<Var>() {

   private Var product = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

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

