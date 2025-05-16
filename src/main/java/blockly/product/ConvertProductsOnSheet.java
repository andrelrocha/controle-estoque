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
 * @param file
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 15/05/2025, 16:22:02
 *
 */
public static Var convert(@ParamMetaData(description = "file2", id = "ba10b34b") @RequestBody(required = false) Var file2) throws Exception {
 return new Callable<Var>() {

   private Var count = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         System.out.println(
        Var.valueOf("chamou").getObjectAsString());
        count =
        Var.valueOf(1);
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao converter produtos da planilha.")));
     }
    return Var.VAR_NULL;
   }
 }.call();
}

}

