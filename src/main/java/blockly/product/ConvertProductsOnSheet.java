package blockly.product;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ConvertProductsOnSheet {

public static final int TIMEOUT = 300;

/**
 *
 * @param fileData
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 13:03:13
 *
 */
public static Var convertFromCsv(@ParamMetaData(description = "fileData", id = "ba10b34b") @RequestBody(required = false) Var fileData) throws Exception {
 return new Callable<Var>() {

   private Var filePath = Var.VAR_NULL;
   private Var count = Var.VAR_NULL;
   private Var file2 = Var.VAR_NULL;
   private Var productsList = Var.VAR_NULL;
   private Var listIndex = Var.VAR_NULL;
   private Var line = Var.VAR_NULL;
   private Var listGeneratedByLines = Var.VAR_NULL;
   private Var product = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         filePath =
        Var.valueOf(
        cronapi.io.Operations.fileAppReclycleDir().getObjectAsString() +
        cronapi.io.Operations.fileSeparator().getObjectAsString() +
        cronapi.json.Operations.getJsonOrMapField(fileData,
        Var.valueOf("path")).getObjectAsString());
        count =
        Var.valueOf(1);
        file2 =
        cronapi.io.Operations.fileOpenToRead(filePath);
        productsList =
        cronapi.list.Operations.newListRepeat(
        cronapi.json.Operations.createObjectJson(),(
        cronapi.math.Operations.subtract(
        cronapi.io.Operations.fileGetNumberOfLines(filePath),
        Var.valueOf(1))));
        listIndex =
        Var.valueOf(1);
        cronapi.io.Operations.readLine(file2, (sender_line) -> {
            line = Var.valueOf(sender_line);
            if (
            Var.valueOf(
            cronapi.logic.Operations.isNullOrEmpty(line)
            .negate().getObjectAsBoolean() &&
            Var.valueOf(!
            Var.valueOf(1).equals(count)).getObjectAsBoolean()).getObjectAsBoolean()) {
                listGeneratedByLines =
                cronapi.list.Operations.getListFromText(line,
                Var.valueOf(","));
                if (
                cronapi.logic.Operations.isNullOrEmpty(listGeneratedByLines)
                .negate().getObjectAsBoolean()) {
                    product =
                    cronapi.database.Operations.newEntity(Var.valueOf("app.entity.Product"),Var.valueOf("id",
                    cronapi.list.Operations.get(listGeneratedByLines,
                    Var.valueOf(1))),Var.valueOf("name",
                    cronapi.list.Operations.get(listGeneratedByLines,
                    Var.valueOf(2))),Var.valueOf("amount",
                    cronapi.list.Operations.get(listGeneratedByLines,
                    Var.valueOf(3))),Var.valueOf("minQuantity",
                    cronapi.list.Operations.get(listGeneratedByLines,
                    Var.valueOf(4))),Var.valueOf("maxQuantity",
                    cronapi.list.Operations.get(listGeneratedByLines,
                    Var.valueOf(5))));
                    cronapi.list.Operations.set(productsList,(listIndex),product);
                }
                listIndex =
                cronapi.math.Operations.sum(listIndex,
                Var.valueOf(1));
            }
            count =
            cronapi.math.Operations.sum(count,
            Var.valueOf(1));
        });
        cronapi.io.Operations.fileClose(file2);
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao converter produtos da planilha.")));
     }
    return productsList;
   }
 }.call();
}

/**
 *
 * @param fileData
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 13:03:13
 *
 */
public static Var handleProductsUpdateProcess(@ParamMetaData(description = "fileData", id = "3b1cb5b6") @RequestBody(required = false) Var fileData) throws Exception {
 return new Callable<Var>() {

   private Var productsList = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         productsList =
        Var.valueOf(convertFromCsv(fileData));
        cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.CreateOrUpdateFromCSV:manage"), Var.valueOf("cd44578b", productsList));
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("success",
        Var.VAR_TRUE) , Var.valueOf("message",
        Var.valueOf("Produtos atualizados com sucesso no sistema a partir do CSV!")));
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

}

