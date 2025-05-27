package blockly.productExit;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class GetProductExit {

public static final int TIMEOUT = 300;

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 11:12:26
 *
 */
public static Var getAll() throws Exception {
 return new Callable<Var>() {

   private Var e = Var.VAR_NULL;
   private Var productExitsList = Var.VAR_NULL;

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

/**
 *
 * @param id
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 11:12:26
 *
 */
public static Var getById(@ParamMetaData(description = "id2", id = "72383069") @RequestBody(required = false) Var id2) throws Exception {
 return new Callable<Var>() {

   private Var e = Var.VAR_NULL;
   private Var productExit = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.logic.Operations.isNullOrEmpty(id2).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não foi passado ID para a busca de uma saída por ID.")));
        }
        productExit =
        cronapi.database.Operations.query(Var.valueOf("app.entity.ProductExit"),Var.valueOf("select \n	p \nfrom \n	ProductExit p  \nwhere \n	p.id = :id"),Var.valueOf("id",id2));
        if (
        cronapi.logic.Operations.isNullOrEmpty(productExit).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não foi encontrada saída com o ID informado.")));
        }
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
    return
cronapi.list.Operations.getFirst(productExit);
   }
 }.call();
}

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 11:12:26
 *
 */
public static Var getEveryId() throws Exception {
 return new Callable<Var>() {

   private Var productExitsIdsList = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         productExitsIdsList =
        cronapi.database.Operations.query(Var.valueOf("app.entity.ProductExit"),Var.valueOf("select \n	p.id \nfrom \n	ProductExit p"));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao obter todos os IDS das saídas no sistema.")));
     }
    return productExitsIdsList;
   }
 }.call();
}

}

