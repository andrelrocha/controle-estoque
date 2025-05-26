package blockly.productEntry;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class GetProductEntry {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 11:55:40
 *
 */
public static Var getAll() throws Exception {
 return new Callable<Var>() {

   private Var e = Var.VAR_NULL;
   private Var productEntriesList = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         productEntriesList =
        cronapi.database.Operations.query(Var.valueOf("app.entity.ProductEntry"),Var.valueOf("select \n	p \nfrom \n	ProductEntry p"));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao obter todas as entradas no sistema.")));
     }
    return productEntriesList;
   }
 }.call();
}

/**
 *
 * @param id
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 11:55:40
 *
 */
public static Var getById(@ParamMetaData(description = "id2", id = "257982f0") @RequestBody(required = false) Var id2) throws Exception {
 return new Callable<Var>() {

   private Var productEntry = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         productEntry =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.ProductEntry"),Var.valueOf("select \n	p \nfrom \n	ProductEntry p  \nwhere \n	p.id = :id"),Var.valueOf("id",id2))));
        if (
        cronapi.logic.Operations.isNullOrEmpty(productEntry).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não foi encontrada entrada com o ID informado.")));
        }
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
    return productEntry;
   }
 }.call();
}

}

