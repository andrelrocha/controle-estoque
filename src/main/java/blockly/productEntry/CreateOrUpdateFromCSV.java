package blockly.productEntry;

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
 * @param productEntry
 * @param productEntriesOnDB
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 14:37:26
 *
 */
public static Var checkIfHasChanged(@ParamMetaData(description = "productEntry", id = "049a1ba5") @RequestBody(required = false) Var productEntry, @ParamMetaData(description = "productEntriesOnDB", id = "ace0b07d") Var productEntriesOnDB) throws Exception {
 return new Callable<Var>() {

   private Var productEntryOnDb = Var.VAR_NULL;
   private Var status = Var.VAR_NULL;
   private Var productChanged = Var.VAR_NULL;
   private Var amountChanged = Var.VAR_NULL;

   public Var call() throws Exception {
    status =
    Var.VAR_FALSE;
    productEntryOnDb =
    cronapi.list.Operations.get(productEntriesOnDB,
    cronapi.list.Operations.findFirst(productEntriesOnDB, productEntry));
    productChanged =
    Var.valueOf(!
    cronapi.json.Operations.getJsonOrMapField(
    cronapi.json.Operations.getJsonOrMapField(productEntry,
    Var.valueOf("product")),
    Var.valueOf("id")).equals(
    cronapi.json.Operations.getJsonOrMapField(
    cronapi.json.Operations.getJsonOrMapField(productEntryOnDb,
    Var.valueOf("product")),
    Var.valueOf("id"))));
    amountChanged =
    Var.valueOf(!
    cronapi.json.Operations.getJsonOrMapField(productEntry,
    Var.valueOf("amount")).equals(
    cronapi.json.Operations.getJsonOrMapField(productEntryOnDb,
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
 * @param productEntriesList
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 14:37:26
 *
 */
public static void manage(@ParamMetaData(description = "productEntriesList", id = "cd44578b") @RequestBody(required = false) Var productEntriesList) throws Exception {
  new Callable<Var>() {

   private Var productEntriesOnDB = Var.VAR_NULL;
   private Var productEntriesIds = Var.VAR_NULL;
   private Var productEntry = Var.VAR_NULL;
   private Var productEntryOnDb = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         productEntriesOnDB =
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.productEntry.GetProductEntry:getAll"));
        productEntriesIds =
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.productEntry.GetProductEntry:getEveryId"));
        for (Iterator it_productEntry = productEntriesList.iterator(); it_productEntry.hasNext();) {
            productEntry = Var.valueOf(it_productEntry.next());
            if (
            Var.valueOf(!
            cronapi.list.Operations.findFirst(productEntriesIds,
            cronapi.json.Operations.getJsonOrMapField(productEntry,
            Var.valueOf("id"))).equals(
            Var.valueOf(0))).getObjectAsBoolean()) {
                if (
                Var.valueOf(checkIfHasChanged(productEntry, productEntriesOnDB)).getObjectAsBoolean()) {
                    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.productEntry.UpdateProductEntry:update"), Var.valueOf("6bd31f73", productEntry));
                }
            } else {
                // Quanto a consulta na lista retornar 0, indica que não há naquela lista o elemento procurado
                productEntryOnDb =
                cronapi.util.Operations.callBlockly(Var.valueOf("blockly.productEntry.AddProductEntry:saveFromCSV"), Var.valueOf("ce3ae7bf", productEntry));
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

