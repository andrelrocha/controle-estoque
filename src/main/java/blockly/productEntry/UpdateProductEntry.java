package blockly.productEntry;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UpdateProductEntry {

public static final int TIMEOUT = 300;

/**
 *
 * @param data
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 19/05/2025, 14:46:32
 *
 */
public static Var update(@ParamMetaData(description = "data", id = "6bd31f73") @RequestBody(required = false) Var data) throws Exception {
 return new Callable<Var>() {

   private Var productEntry = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         productEntry =
        cronapi.database.Operations.query(Var.valueOf("app.entity.ProductEntry"),Var.valueOf("select \n	p \nfrom \n	ProductEntry p  \nwhere \n	p.id = :id"),Var.valueOf("id",
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("id"))));
        if (
        cronapi.logic.Operations.isNullOrEmpty(productEntry).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não foi encontrada uma entrada com o id informado.")));
        }
        cronapi.database.Operations.execute(Var.valueOf("app.entity.ProductEntry"), Var.valueOf("update \n	ProductEntry  \nset \n	product = :product, \n	amount = :amount \nwhere \n	id = :id"),Var.valueOf("product",
        cronapi.json.Operations.getJsonOrMapField(
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("product")),
        Var.valueOf("id"))),Var.valueOf("amount",
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("amount"))),Var.valueOf("id",
        cronapi.database.Operations.getField(productEntry,
        Var.valueOf("this[0].id"))));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.database.Operations.rollbackTransaction(Var.valueOf("app"));
        cronapi.util.Operations.throwException(e);
     }
    return Var.VAR_NULL;
   }
 }.call();
}

}

