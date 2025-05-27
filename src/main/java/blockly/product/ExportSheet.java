package blockly.product;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ExportSheet {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 12:40:51
 *
 */
public static Var exportCsv() throws Exception {
 return new Callable<Var>() {

   private Var filePath = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         filePath =
        Var.valueOf(
        cronapi.io.Operations.fileAppReclycleDir().getObjectAsString() +
        cronapi.io.Operations.fileSeparator().getObjectAsString() +
        Var.valueOf("produtos.csv").getObjectAsString());
        writeDataToCsv(filePath);
        cronapi.io.Operations.startDownload(filePath,
        Var.valueOf("produtos.csv"));
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("success",
        Var.VAR_TRUE) , Var.valueOf("message",
        Var.valueOf("Download do .csv realizado com sucesso!")));
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
 * @param filePath
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 12:40:51
 *
 */
public static void writeDataToCsv(@ParamMetaData(description = "filePath", id = "2b79a2f4") @RequestBody(required = false) Var filePath) throws Exception {
  new Callable<Var>() {

   private Var e = Var.VAR_NULL;
   private Var file2 = Var.VAR_NULL;
   private Var products = Var.VAR_NULL;
   private Var p = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         file2 =
        cronapi.io.Operations.fileOpenToWrite(filePath,
        Var.valueOf(
        Var.valueOf("id,name,amount,minQuantity,maxQuantity").getObjectAsString() +
        cronapi.text.Operations.newline().getObjectAsString()));
        products =
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.GetProduct:getAll"));
        for (Iterator it_p = products.iterator(); it_p.hasNext();) {
            p = Var.valueOf(it_p.next());
            cronapi.io.Operations.fileAppend(file2,
            Var.valueOf(
            cronapi.json.Operations.getJsonOrMapField(p,
            Var.valueOf("id")).getObjectAsString() +
            Var.valueOf(",").getObjectAsString() +
            cronapi.json.Operations.getJsonOrMapField(p,
            Var.valueOf("name")).getObjectAsString() +
            Var.valueOf(",").getObjectAsString() +
            cronapi.json.Operations.getJsonOrMapField(p,
            Var.valueOf("amount")).getObjectAsString() +
            Var.valueOf(",").getObjectAsString() +
            cronapi.json.Operations.getJsonOrMapField(p,
            Var.valueOf("minQuantity")).getObjectAsString() +
            Var.valueOf(",").getObjectAsString() +
            cronapi.json.Operations.getJsonOrMapField(p,
            Var.valueOf("maxQuantity")).getObjectAsString() +
            cronapi.text.Operations.newline().getObjectAsString()));
        } // end for
        cronapi.io.Operations.fileClose(file2);
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao escrever os dados dos produtos no CSV a ser exportado.")));
     }
   return Var.VAR_NULL;
   }
 }.call();
}

}

