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
 * @param productEntriesList
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 19/05/2025, 14:39:01
 *
 */
public static Var manage(@ParamMetaData(description = "productEntriesList", id = "cd44578b") @RequestBody(required = false) Var productEntriesList) throws Exception {
 return new Callable<Var>() {

   private Var productEntriesIds = Var.VAR_NULL;
   private Var productEntry = Var.VAR_NULL;
   private Var productEntryOnDb = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         productEntriesIds =
        cronapi.database.Operations.query(Var.valueOf("app.entity.ProductEntry"),Var.valueOf("select \n	pe.id \nfrom \n	ProductEntry pe"));
        for (Iterator it_productEntry = productEntriesList.iterator(); it_productEntry.hasNext();) {
            productEntry = Var.valueOf(it_productEntry.next());
            if (
            Var.valueOf(!
            cronapi.list.Operations.findFirst(productEntriesIds,
            cronapi.json.Operations.getJsonOrMapField(productEntry,
            Var.valueOf("id"))).equals(
            Var.valueOf(0))).getObjectAsBoolean()) {
                productEntryOnDb =
                cronapi.util.Operations.callBlockly(Var.valueOf("blockly.productEntry.UpdateProductEntry:update"), Var.valueOf("6bd31f73", productEntry));
            } else {
                // Quanto a consulta na lista retornar 0, indica que não há naquela lista o elemento procurado
                productEntryOnDb =
                cronapi.util.Operations.callBlockly(Var.valueOf("blockly.productEntry.AddProductEntry:saveFromCSV"), Var.valueOf("ce3ae7bf", productEntry));
            }
        } // end for
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao gerenciar o processo de criação/atualização de entradas a partir do csv")));
     }
    return Var.VAR_NULL;
   }
 }.call();
}

}

