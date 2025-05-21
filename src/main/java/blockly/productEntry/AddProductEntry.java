package blockly.productEntry;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Funcionario", get = "Funcionario", execute = "Funcionario", delete = "Funcionario", put = "Funcionario")
public class AddProductEntry {

public static final int TIMEOUT = 300;

/**
 *
 * @param data
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 12:52:12
 *
 */
public static Var save(@ParamMetaData(description = "data", id = "ce3ae7bf") @RequestBody(required = false) Var data) throws Exception {
 return new Callable<Var>() {

   private Var user = Var.VAR_NULL;
   private Var product = Var.VAR_NULL;
   private Var productEntryOnDB = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         user =
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.user.GetLoggedUser:getEntity"));
        product =
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.GetProduct:getEntity"), Var.valueOf("cbd6ae39",
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("product_id"))));
        productEntryOnDB =
        cronapi.database.Operations.insert(Var.valueOf("app.entity.ProductEntry"),Var.valueOf("amount",
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("amount"))),Var.valueOf("date",
        cronapi.dateTime.Operations.getNow()),Var.valueOf("product",product),Var.valueOf("registeringUser",user));
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.UpdateProduct:updateAmountAfterEntry"), Var.valueOf("63c5ce49", product), Var.valueOf("49cb6752",
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("amount"))));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.getExceptionMessage(e));
     }
    return productEntryOnDB;
   }
 }.call();
}

/**
 *
 * @param data
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 12:52:12
 *
 */
public static Var saveFromCSV(@ParamMetaData(description = "data", id = "ce3ae7bf") @RequestBody(required = false) Var data) throws Exception {
 return new Callable<Var>() {

   private Var product = Var.VAR_NULL;
   private Var productEntryOnDB = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         product =
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.GetProduct:getEntity"), Var.valueOf("cbd6ae39",
        cronapi.json.Operations.getJsonOrMapField(
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("product")),
        Var.valueOf("id"))));
        productEntryOnDB =
        cronapi.database.Operations.insert(Var.valueOf("app.entity.ProductEntry"),Var.valueOf("amount",
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("amount"))),Var.valueOf("date",
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("date"))),Var.valueOf("product",product),Var.valueOf("registeringUser",
        cronapi.json.Operations.getJsonOrMapField(
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("registeringUser")),
        Var.valueOf("id"))));
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.UpdateProduct:updateAmountAfterEntry"), Var.valueOf("63c5ce49", product), Var.valueOf("49cb6752",
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("amount"))));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao adicionar uma entrada a partir do csv.")));
     }
    return productEntryOnDB;
   }
 }.call();
}

}

