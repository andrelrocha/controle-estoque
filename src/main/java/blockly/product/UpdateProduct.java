package blockly.product;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UpdateProduct {

public static final int TIMEOUT = 300;

/**
 *
 * @param id
 * @param newAmount
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 20/05/2025, 14:09:56
 *
 */
public static void updateAmount(@ParamMetaData(description = "id2", id = "322cf808") @RequestBody(required = false) Var id2, @ParamMetaData(description = "newAmount", id = "6e06289c") Var newAmount) throws Exception {
  new Callable<Var>() {

   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.logic.Operations.isNullOrEmpty(id2).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não foi recebido ID válido para a atualização da quantidade do produto selecionado.")));
        }
        if (
        Var.valueOf(newAmount.compareTo(
        Var.valueOf(0)) < 0).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não pode ser passado um valor negativo como nova quantidade de um produto..")));
        }
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Product"), Var.valueOf("update \n	Product  \nset \n	amount = :amount \nwhere \n	id = :id"),Var.valueOf("amount",newAmount),Var.valueOf("id",id2));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param Consulta a Entidades<app.entity.Product>
 * @param entryAmount
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 20/05/2025, 14:09:56
 *
 */
public static Var updateAmountAfterEntry(@ParamMetaData(description = "Consulta_a_Entidades", id = "63c5ce49") @RequestBody(required = false) Var Consulta_a_Entidades, @ParamMetaData(description = "entryAmount", id = "49cb6752") Var entryAmount) throws Exception {
 return new Callable<Var>() {

   private Var oldAmount = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.logic.Operations.isNullOrEmpty(Consulta_a_Entidades).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Deve ser passado algum produto válido como parâmetro para a atualização da quantidade.")));
        }
        if (
        Var.valueOf(entryAmount.compareTo(
        Var.valueOf(0)) <= 0).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("A nova quantidade de produtos adicionados deve ser de pelo menos 1.")));
        }
        oldAmount =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.getColumn(Consulta_a_Entidades,
        Var.valueOf("amount"))));
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Product"), Var.valueOf("update \n	Product  \nset \n	amount = :amount \nwhere \n	id = :id"),Var.valueOf("amount",
        cronapi.math.Operations.sum(oldAmount,entryAmount)),Var.valueOf("id",
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.getColumn(Consulta_a_Entidades,
        Var.valueOf("id"))))));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
    return Consulta_a_Entidades;
   }
 }.call();
}

/**
 *
 * @param id
 * @param deletedAmount
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 20/05/2025, 14:09:56
 *
 */
public static Var updateAmountBeforeEntryDelete(@ParamMetaData(description = "id2", id = "322cf808") @RequestBody(required = false) Var id2, @ParamMetaData(description = "deletedAmount", id = "6e06289c") Var deletedAmount) throws Exception {
 return new Callable<Var>() {

   private Var e = Var.VAR_NULL;
   private Var productOldAmount = Var.VAR_NULL;
   private Var productNewAmount = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.logic.Operations.isNullOrEmpty(id2).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não foi recebido ID válido para a atualização da quantidade do produto selecionado.")));
        }
        productOldAmount =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.Product"),Var.valueOf("select \n	p.amount \nfrom \n	Product p  \nwhere \n	p.id = :id"),Var.valueOf("id",id2))));
        productNewAmount =
        cronapi.math.Operations.subtract(productOldAmount,deletedAmount);
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Product"), Var.valueOf("update \n	Product  \nset \n	amount = :amount \nwhere \n	id = :id"),Var.valueOf("amount",productNewAmount),Var.valueOf("id",id2));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param Consulta a Entidades<app.entity.Product>
 * @param exitAmount
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 20/05/2025, 14:09:56
 *
 */
public static Var updateAmountBeforeExit(@ParamMetaData(description = "Consulta_a_Entidades", id = "63c5ce49") @RequestBody(required = false) Var Consulta_a_Entidades, @ParamMetaData(description = "exitAmount", id = "49cb6752") Var exitAmount) throws Exception {
 return new Callable<Var>() {

   private Var oldAmount = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.logic.Operations.isNullOrEmpty(Consulta_a_Entidades).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Deve ser passado algum produto válido como parâmetro para a atualização da quantidade.")));
        }
        if (
        Var.valueOf(exitAmount.compareTo(
        Var.valueOf(0)) <= 0).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("A quantidade de produtos retirados deve ser de pelo menos 1.")));
        }
        System.out.println(
        Var.valueOf("CHAMOU NO UPDATE APÓS EXCCEÇÕES").getObjectAsString());
        oldAmount =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.getColumn(Consulta_a_Entidades,
        Var.valueOf("amount"))));
        System.out.println(
        Var.valueOf("OLD AMOUNT: ").getObjectAsString());
        System.out.println(oldAmount.getObjectAsString());
        if (
        Var.valueOf(exitAmount.compareTo(oldAmount) > 0).getObjectAsBoolean()) {
            System.out.println(
            Var.valueOf(
            Var.valueOf("O Usuário está tentando retirar mais itens do que há no estoque. ").getObjectAsString() +
            Var.valueOf("Quantidade em estoque: ").getObjectAsString() +
            oldAmount.getObjectAsString()).getObjectAsString());
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf(
            Var.valueOf("O Usuário está tentando retirar mais itens do que há no estoque. ").getObjectAsString() +
            Var.valueOf("Quantidade em estoque: ").getObjectAsString() +
            oldAmount.getObjectAsString())));
        } else {
            cronapi.database.Operations.execute(Var.valueOf("app.entity.Product"), Var.valueOf("update \n	Product  \nset \n	amount = :amount \nwhere \n	id = :id"),Var.valueOf("amount",
            cronapi.math.Operations.subtract(oldAmount,exitAmount)),Var.valueOf("id",
            cronapi.list.Operations.getFirst((
            cronapi.database.Operations.getColumn(Consulta_a_Entidades,
            Var.valueOf("id"))))));
        }
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         System.out.println(
        Var.valueOf("EXCEÇÃO FOI LANÇADA").getObjectAsString());
        cronapi.util.Operations.throwException(e);
     }
    return Consulta_a_Entidades;
   }
 }.call();
}

/**
 *
 * @param id
 * @param deletedAmount
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 20/05/2025, 14:09:56
 *
 */
public static Var updateAmountBeforeExitDelete(@ParamMetaData(description = "id2", id = "322cf808") @RequestBody(required = false) Var id2, @ParamMetaData(description = "deletedAmount", id = "6e06289c") Var deletedAmount) throws Exception {
 return new Callable<Var>() {

   private Var e = Var.VAR_NULL;
   private Var productOldAmount = Var.VAR_NULL;
   private Var productNewAmount = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.logic.Operations.isNullOrEmpty(id2).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não foi recebido ID válido para a atualização da quantidade do produto selecionado.")));
        }
        productOldAmount =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.Product"),Var.valueOf("select \n	p.amount \nfrom \n	Product p  \nwhere \n	p.id = :id"),Var.valueOf("id",id2))));
        productNewAmount =
        cronapi.math.Operations.sum(productOldAmount,deletedAmount);
        cronapi.database.Operations.execute(Var.valueOf("app.entity.Product"), Var.valueOf("update \n	Product  \nset \n	amount = :amount \nwhere \n	id = :id"),Var.valueOf("amount",productNewAmount),Var.valueOf("id",id2));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
    return Var.VAR_NULL;
   }
 }.call();
}

}

