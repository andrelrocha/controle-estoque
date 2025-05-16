package blockly.product;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ExportSheet {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 16/05/2025, 11:58:39
 *
 */
public static Var exportCsv() throws Exception {
 return new Callable<Var>() {

   private Var filePath = Var.VAR_NULL;
   private Var products = Var.VAR_NULL;
   private Var file2 = Var.VAR_NULL;
   private Var p = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         filePath =
        Var.valueOf(
        cronapi.io.Operations.fileAppReclycleDir().getObjectAsString() +
        cronapi.io.Operations.fileSeparator().getObjectAsString() +
        Var.valueOf("file.csv").getObjectAsString());
        cronapi.io.Operations.fileCreate(filePath);
        products =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Product"),Var.valueOf("select \n	p \nfrom \n	Product p"));
        file2 =
        cronapi.io.Operations.fileOpenToWrite(filePath,
        Var.valueOf(
        Var.valueOf("id,name,amount,minQuantity,maxQuantity").getObjectAsString() +
        cronapi.text.Operations.newline().getObjectAsString()));
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
            Var.valueOf("maxQuantity")).getObjectAsString() +
            Var.valueOf(",").getObjectAsString() +
            cronapi.json.Operations.getJsonOrMapField(p,
            Var.valueOf("minQuantity")).getObjectAsString() +
            cronapi.text.Operations.newline().getObjectAsString()));
        } // end for
        cronapi.io.Operations.fileClose(file2);
        cronapi.io.Operations.startDownload(filePath,
        Var.valueOf("produtos.csv"));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao gerar o CSV de produtos a serem exportados.")));
     }
    return
cronapi.util.Operations.createDownloadLink(file2);
   }
 }.call();
}

}

