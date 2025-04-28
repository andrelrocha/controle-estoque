package blockly.productEntry;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Funcionario", get = "Funcionario", execute = "Funcionario", delete = "Funcionario", put = "Funcionario")
public class AddProductEntry {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 28/04/2025, 17:09:41
 *
 */
public static Var buildObject() throws Exception {
 return new Callable<Var>() {

   private Var e = Var.VAR_NULL;
   private Var addProductEntryData = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         addProductEntryData =
        cronapi.json.Operations.createObjectJson();
        if (
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("ProductEntry.active.product"))).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Você deve selecionar um produto.")));
        } else {
            cronapi.json.Operations.setJsonOrMapField(addProductEntryData,
            Var.valueOf("product_id"),
            cronapi.screen.Operations.getValueOfField(
            Var.valueOf("ProductEntry.active.product")));
        }
        if (
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("ProductEntry.active.amount"))).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Você deve indicar a quantidade que está sendo adicionada do produto.")));
        } else {
            cronapi.json.Operations.setJsonOrMapField(addProductEntryData,
            Var.valueOf("amount"),
            cronapi.screen.Operations.getValueOfField(
            Var.valueOf("ProductEntry.active.amount")));
        }
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
    return addProductEntryData;
   }
 }.call();
}

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 28/04/2025, 17:09:41
 *
 */
public static Var save() throws Exception {
 return new Callable<Var>() {

   private Var data = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;
   private Var errorMessage = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         data =
        Var.valueOf(buildObject());
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         errorMessage =
        cronapi.util.Operations.getExceptionMessage(e);
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), errorMessage);
     }
    return Var.VAR_NULL;
   }
 }.call();
}

}

