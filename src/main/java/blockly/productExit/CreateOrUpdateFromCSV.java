package blockly.productExit;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CreateOrUpdateFromCSV {

public static final int TIMEOUT = 300;

/**
 *
 * @param productExit
 * @param productExitsOnDB
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 11:15:34
 *
 */
public static Var checkIfHasChanged(@ParamMetaData(description = "productExit", id = "049a1ba5") @RequestBody(required = false) Var productExit, @ParamMetaData(description = "productExitsOnDB", id = "ace0b07d") Var productExitsOnDB) throws Exception {
 return new Callable<Var>() {

   private Var status = Var.VAR_NULL;
   private Var productExitOnDB = Var.VAR_NULL;
   private Var productChanged = Var.VAR_NULL;
   private Var amountChanged = Var.VAR_NULL;

   public Var call() throws Exception {
    status =
    Var.VAR_FALSE;
    productExitOnDB =
    cronapi.list.Operations.get(productExitsOnDB,
    cronapi.list.Operations.findFirst(productExitsOnDB, productExit));
    productChanged =
    Var.valueOf(!
    cronapi.json.Operations.getJsonOrMapField(
    cronapi.json.Operations.getJsonOrMapField(productExit,
    Var.valueOf("product")),
    Var.valueOf("id")).equals(
    cronapi.json.Operations.getJsonOrMapField(
    cronapi.json.Operations.getJsonOrMapField(productExitOnDB,
    Var.valueOf("product")),
    Var.valueOf("id"))));
    amountChanged =
    Var.valueOf(!
    cronapi.json.Operations.getJsonOrMapField(productExit,
    Var.valueOf("amount")).equals(
    cronapi.json.Operations.getJsonOrMapField(productExitOnDB,
    Var.valueOf("amount"))));
    if (
    Var.valueOf(productChanged.getObjectAsBoolean() || amountChanged.getObjectAsBoolean()).getObjectAsBoolean()) {
        status =
        Var.VAR_TRUE;
    }
    return status;
   }
 }.call();
}

/**
 *
 * @param productExitsList
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 11:15:34
 *
 */
public static void manage(@ParamMetaData(description = "productExitsList", id = "cd44578b") @RequestBody(required = false) Var productExitsList) throws Exception {
  new Callable<Var>() {

   private Var productExitOnDB = Var.VAR_NULL;
   private Var productExit = Var.VAR_NULL;
   private Var productExitsOnDB = Var.VAR_NULL;
   private Var productExitsIds = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         productExitsOnDB =
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.productExit.GetProductExit:getAll"));
        productExitsIds =
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.productExit.GetProductExit:getEveryId"));
        for (Iterator it_productExit = productExitsList.iterator(); it_productExit.hasNext();) {
            productExit = Var.valueOf(it_productExit.next());
            if (
            Var.valueOf(!
            cronapi.list.Operations.findFirst(productExitsIds,
            cronapi.json.Operations.getJsonOrMapField(productExit,
            Var.valueOf("id"))).equals(
            Var.valueOf(0))).getObjectAsBoolean()) {
                if (
                Var.valueOf(checkIfHasChanged(productExit, productExitsOnDB)).getObjectAsBoolean()) {
                    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.productExit.UpdateProductExit:update"), Var.valueOf("6bd31f73", productExit));
                }
            } else {
                // Quanto a consulta na lista retornar 0, indica que não há naquela lista o elemento procurado
                productExitOnDB =
                cronapi.util.Operations.callBlockly(Var.valueOf("blockly.productExit.AddProductExit:saveFromCSV"), Var.valueOf("ce3ae7bf", productExit));
            }
        } // end for
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
   return Var.VAR_NULL;
   }
 }.call();
}

}

