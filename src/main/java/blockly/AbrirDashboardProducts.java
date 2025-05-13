package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AbrirDashboardProducts {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 13/05/2025, 15:42:49
 *
 */
public static Var openDashboard() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.util.openDashboard"),
    Var.valueOf("dashboards/produtos-estoque.dashboard"), cronapi.list.Operations.newList());
    return Var.VAR_NULL;
   }
 }.call();
}

}

