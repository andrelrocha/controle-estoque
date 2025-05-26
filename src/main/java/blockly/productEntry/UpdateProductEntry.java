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
 * @since 26/05/2025, 10:55:27
 *
 */
public static Var update(@ParamMetaData(description = "data", id = "6bd31f73") @RequestBody(required = false) Var data) throws Exception {
 return new Callable<Var>() {

   private Var productEntry = Var.VAR_NULL;
   private Var productId = Var.VAR_NULL;
   private Var productAmount = Var.VAR_NULL;
   private Var newEntryAmount = Var.VAR_NULL;
   private Var oldEntryAmount = Var.VAR_NULL;
   private Var amountDifference = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        Var.valueOf(validateJsonFields(data)).getObjectAsBoolean()) {
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
            productId =
            cronapi.json.Operations.getJsonOrMapField(data,
            Var.valueOf("product"));
            productAmount =
            cronapi.database.Operations.getField(productEntry,
            Var.valueOf("this[0].product.amount"));
            newEntryAmount =
            cronapi.json.Operations.getJsonOrMapField(data,
            Var.valueOf("amount"));
            oldEntryAmount =
            cronapi.database.Operations.getField(productEntry,
            Var.valueOf("this[0].amount"));
            amountDifference =
            cronapi.math.Operations.subtract(newEntryAmount,oldEntryAmount);
            cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.UpdateProduct:updateAmount"), Var.valueOf("322cf808", productId), Var.valueOf("6e06289c",
            cronapi.math.Operations.sum(productAmount,amountDifference)));
            cronapi.database.Operations.execute(Var.valueOf("app.entity.ProductEntry"), Var.valueOf("update \n	ProductEntry  \nset \n	product = :product, \n	amount = :amount \nwhere \n	id = :id"),Var.valueOf("product",productId),Var.valueOf("amount",newEntryAmount),Var.valueOf("id",
            cronapi.database.Operations.getField(productEntry,
            Var.valueOf("this[0].id"))));
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("success",
            Var.VAR_TRUE) , Var.valueOf("message",
            Var.valueOf("Entrada atualizada com sucesso no sistema!")));
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

/**
 *
 * @param data
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 10:55:27
 *
 */
public static Var validateJsonFields(@ParamMetaData(description = "data", id = "aa7efe5a") @RequestBody(required = false) Var data) throws Exception {
 return new Callable<Var>() {

   private Var productId = Var.VAR_NULL;
   private Var status = Var.VAR_NULL;
   private Var newAmount = Var.VAR_NULL;
   private Var produtEntryId = Var.VAR_NULL;

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
        Var.valueOf("Foi passado um valor negativo como valor de uma entrada.")));
    } else if (
    cronapi.logic.Operations.isNullOrEmpty(newAmount).getObjectAsBoolean()) {
        status =
        Var.VAR_FALSE;
        cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Foi passado um valor vazio como nova quantidade na atualização de entrada.")));
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
        Var.valueOf("Deve ser passado um ID de produto para a atualização de entrada.")));
    }
    produtEntryId =
    cronapi.json.Operations.getJsonOrMapField(data,
    Var.valueOf("id"));
    if (
    cronapi.logic.Operations.isNullOrEmpty(produtEntryId).getObjectAsBoolean()) {
        status =
        Var.VAR_FALSE;
        cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Deve ser passado um ID de entrada para a atualização de entrada.")));
    }
    return status;
   }
 }.call();
}

}

