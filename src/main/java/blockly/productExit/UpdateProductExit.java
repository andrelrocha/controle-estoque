package blockly.productExit;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UpdateProductExit {

public static final int TIMEOUT = 300;

/**
 *
 * @param data
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 09:37:46
 *
 */
public static Var manageUpdate(@ParamMetaData(description = "data", id = "6bd31f73") @RequestBody(required = false) Var data) throws Exception {
 return new Callable<Var>() {

   private Var e = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         update(data);
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("success",
        Var.VAR_TRUE) , Var.valueOf("message",
        Var.valueOf("Saída atualizada com sucesso no sistema!")));
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

/**
 *
 * @param data
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 09:37:46
 *
 */
public static void update(@ParamMetaData(description = "data", id = "6bd31f73") @RequestBody(required = false) Var data) throws Exception {
  new Callable<Var>() {

   private Var productExitOnDb = Var.VAR_NULL;
   private Var productId = Var.VAR_NULL;
   private Var productAmount = Var.VAR_NULL;
   private Var newExitAmount = Var.VAR_NULL;
   private Var oldExitAmount = Var.VAR_NULL;
   private Var amountDifference = Var.VAR_NULL;
   private Var finalAmount = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        Var.valueOf(validateJsonFields(data)).getObjectAsBoolean()) {
            productExitOnDb =
            cronapi.util.Operations.callBlockly(Var.valueOf("blockly.productExit.GetProductExit:getById"), Var.valueOf("72383069",
            cronapi.json.Operations.getJsonOrMapField(data,
            Var.valueOf("id"))));
            productId =
            cronapi.json.Operations.getJsonOrMapField(data,
            Var.valueOf("product"));
            productAmount =
            cronapi.json.Operations.getJsonOrMapField(
            cronapi.json.Operations.getJsonOrMapField(productExitOnDb,
            Var.valueOf("product")),
            Var.valueOf("amount"));
            newExitAmount =
            cronapi.json.Operations.getJsonOrMapField(data,
            Var.valueOf("amount"));
            oldExitAmount =
            cronapi.json.Operations.getJsonOrMapField(productExitOnDb,
            Var.valueOf("amount"));
            amountDifference =
            cronapi.math.Operations.subtract(oldExitAmount,newExitAmount);
            if (
            Var.valueOf(productAmount.compareTo(amountDifference) < 0).getObjectAsBoolean()) {
                finalAmount =
                Var.valueOf(0);
                newExitAmount = productAmount;
            } else {
                finalAmount =
                cronapi.math.Operations.sum(productAmount,amountDifference);
            }
            cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.UpdateProduct:updateAmount"), Var.valueOf("322cf808", productId), Var.valueOf("6e06289c", finalAmount));
            cronapi.database.Operations.execute(Var.valueOf("app.entity.ProductExit"), Var.valueOf("update \n	ProductExit  \nset \n	product = :product, \n	amount = :amount \nwhere \n	id = :id"),Var.valueOf("product",productId),Var.valueOf("amount",newExitAmount),Var.valueOf("id",
            cronapi.database.Operations.getField(productExitOnDb,
            Var.valueOf("this[0].id"))));
        }
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param data
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 09:37:46
 *
 */
public static Var validateJsonFields(@ParamMetaData(description = "data", id = "aa7efe5a") @RequestBody(required = false) Var data) throws Exception {
 return new Callable<Var>() {

   private Var productId = Var.VAR_NULL;
   private Var status = Var.VAR_NULL;
   private Var newAmount = Var.VAR_NULL;
   private Var produtExitId = Var.VAR_NULL;

   public Var call() throws Exception {
    status =
    Var.VAR_TRUE;
    newAmount =
    cronapi.json.Operations.getJsonOrMapField(data,
    Var.valueOf("amount"));
    if (
    Var.valueOf(newAmount.compareTo(
    Var.valueOf(0)) < 0).getObjectAsBoolean()) {
        status =
        Var.VAR_FALSE;
        cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Foi passado um valor negativo como valor de uma saída.")));
    } else if (
    cronapi.logic.Operations.isNullOrEmpty(newAmount).getObjectAsBoolean()) {
        status =
        Var.VAR_FALSE;
        cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Foi passado um valor vazio como nova quantidade na atualização de saída.")));
    }
    productId =
    cronapi.json.Operations.getJsonOrMapField(data,
    Var.valueOf("product"));
    if (
    cronapi.logic.Operations.isNullOrEmpty(productId).getObjectAsBoolean()) {
        status =
        Var.VAR_FALSE;
        cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Deve ser passado um ID de produto para a atualização de saída.")));
    }
    produtExitId =
    cronapi.json.Operations.getJsonOrMapField(data,
    Var.valueOf("id"));
    if (
    cronapi.logic.Operations.isNullOrEmpty(produtExitId).getObjectAsBoolean()) {
        status =
        Var.VAR_FALSE;
        cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Deve ser passado um ID válido para a atualização de saída")));
    }
    return status;
   }
 }.call();
}

}

