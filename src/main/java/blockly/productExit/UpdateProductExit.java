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
 * @since 20/05/2025, 14:10:53
 *
 */
public static Var update(@ParamMetaData(description = "data", id = "6bd31f73") @RequestBody(required = false) Var data) throws Exception {
 return new Callable<Var>() {

   private Var productExit = Var.VAR_NULL;
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
            productExit =
            cronapi.database.Operations.query(Var.valueOf("app.entity.ProductExit"),Var.valueOf("select \n	p \nfrom \n	ProductExit p  \nwhere \n	p.id = :id"),Var.valueOf("id",
            cronapi.json.Operations.getJsonOrMapField(data,
            Var.valueOf("id"))));
            if (
            cronapi.logic.Operations.isNullOrEmpty(productExit).getObjectAsBoolean()) {
                cronapi.util.Operations.throwException(
                cronapi.util.Operations.createException(
                Var.valueOf("Não foi encontrada uma saída com o id informado.")));
            }
            productId =
            cronapi.json.Operations.getJsonOrMapField(
            cronapi.json.Operations.getJsonOrMapField(data,
            Var.valueOf("product")),
            Var.valueOf("id"));
            productAmount =
            cronapi.database.Operations.getField(productExit,
            Var.valueOf("this[0].product.amount"));
            newExitAmount =
            cronapi.json.Operations.getJsonOrMapField(data,
            Var.valueOf("amount"));
            oldExitAmount =
            cronapi.database.Operations.getField(productExit,
            Var.valueOf("this[0].amount"));
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
            cronapi.database.Operations.getField(productExit,
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
 * @since 20/05/2025, 14:10:53
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
    cronapi.json.Operations.getJsonOrMapField(
    cronapi.json.Operations.getJsonOrMapField(data,
    Var.valueOf("product")),
    Var.valueOf("id"));
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

