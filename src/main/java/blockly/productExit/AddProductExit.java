package blockly.productExit;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Funcionario", get = "Funcionario", execute = "Funcionario", delete = "Funcionario", put = "Funcionario")
public class AddProductExit {

public static final int TIMEOUT = 300;

/**
 *
 * @param data
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 09/05/2025, 17:34:06
 *
 */
public static Var save(@ParamMetaData(description = "data", id = "ce3ae7bf") @RequestBody(required = false) Var data) throws Exception {
 return new Callable<Var>() {

   private Var user = Var.VAR_NULL;
   private Var product = Var.VAR_NULL;
   private Var productExitOnDB = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         System.out.println(
        Var.valueOf("1").getObjectAsString());
        user =
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.user.GetLoggedUser:getEntity"));
        System.out.println(
        Var.valueOf("2").getObjectAsString());
        product =
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.GetProduct:getEntity"), Var.valueOf("cbd6ae39",
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("product_id"))));
        System.out.println(
        Var.valueOf("3").getObjectAsString());
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.UpdateProduct:updateAmountBeforeExit"), Var.valueOf("63c5ce49", product), Var.valueOf("49cb6752",
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("amount"))));
        System.out.println(
        Var.valueOf("4").getObjectAsString());
        productExitOnDB =
        cronapi.database.Operations.insert(Var.valueOf("app.entity.ProductExit"),Var.valueOf("amount",
        cronapi.json.Operations.getJsonOrMapField(data,
        Var.valueOf("amount"))),Var.valueOf("date",
        cronapi.dateTime.Operations.getNow()),Var.valueOf("product",product),Var.valueOf("registeringUser",user));
        System.out.println(
        Var.valueOf("5").getObjectAsString());
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         System.out.println(
        Var.valueOf("ERRO FOI CHAMADO ").getObjectAsString());
        System.out.println(
        cronapi.util.Operations.getExceptionMessage(e).getObjectAsString());
        cronapi.util.Operations.throwException(e);
     }
    return Var.VAR_NULL;
   }
 }.call();
}

}

