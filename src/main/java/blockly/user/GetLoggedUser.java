package blockly.user;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class GetLoggedUser {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 28/04/2025, 18:07:03
 *
 */
public static Var getEntity() throws Exception {
 return new Callable<Var>() {

   private Var loggedUser = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         loggedUser =
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
        cronapi.util.Operations.getCurrentUserName()));
        if (
        cronapi.logic.Operations.isNullOrEmpty(loggedUser).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não foi encontrado usuário, a partir do username logado")));
        }
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
    return loggedUser;
   }
 }.call();
}

}

