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
 * @param Consulta a Entidades<app.entity.Product>
 * @param entryAmount
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 28/04/2025, 18:39:10
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
        cronapi.database.Operations.getColumn(Consulta_a_Entidades,
        Var.valueOf("amount"));
        cronapi.database.Operations.updateField(Consulta_a_Entidades,
        Var.valueOf("amount"),
        cronapi.math.Operations.sum(oldAmount,entryAmount));
        if (
        cronapi.logic.Operations.isNullOrEmpty(Consulta_a_Entidades).getObjectAsBoolean()) {
            cronapi.util.Operations.throwException(
            cronapi.util.Operations.createException(
            Var.valueOf("Não foi encontrado o Produto informado")));
        }
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(e);
     }
    return Consulta_a_Entidades;
   }
 }.call();
}

}

