package blockly.productExit;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class GetProductExit {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 08:54:14
 *
 */
public static Var getAll() throws Exception {
 return new Callable<Var>() {

   private Var productExitsList = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         productExitsList =
        cronapi.database.Operations.query(Var.valueOf("app.entity.ProductExit"),Var.valueOf("select \n	p \nfrom \n	ProductExit p"));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao obter todas as saídas no sistema.")));
     }
    return productExitsList;
   }
 }.call();
}

}

