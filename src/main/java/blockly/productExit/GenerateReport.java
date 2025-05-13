package blockly.productExit;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class GenerateReport {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 13/05/2025, 10:43:19
 *
 */
public static Var generate() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.util.openReport"),
    Var.valueOf("reports/Productexit.report"), cronapi.list.Operations.newList());
    return Var.VAR_NULL;
   }
 }.call();
}

}

