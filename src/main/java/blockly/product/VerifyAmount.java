package blockly.product;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class VerifyAmount {

public static final int TIMEOUT = 300;

/**
 *
 * @param listaProdutos
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 14/05/2025, 17:01:00
 *
 */
public static void sendMail(@ParamMetaData(description = "listaProdutos", id = "7565d869") @RequestBody(required = false) Var listaProdutos) throws Exception {
  new Callable<Var>() {

   private Var produtos = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;
   private Var listaProdutosString = Var.VAR_NULL;
   private Var mensagem = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         listaProdutosString =
        cronapi.list.Operations.getTextFromList(listaProdutos,
        Var.valueOf(","));
        mensagem =
        Var.valueOf(
        Var.valueOf("Bom dia! Os seguintes produtos estão com estoque abaixo do ideal: ").getObjectAsString() +
        listaProdutosString.getObjectAsString());
        cronapi.email.Operations.sendEmail(
        cronapi.util.Operations.getSystemParameter(
        Var.valueOf("email")),
        Var.valueOf("andrerocha0911@gmail.com"),
        Var.valueOf(""),
        Var.valueOf(""),
        Var.valueOf("Produtos com estoque baixo"),
        Var.valueOf(
        Var.valueOf("Bom dia! Os seguintes produtos estão com estoque abaixo do ideal: ").getObjectAsString() +
        listaProdutosString.getObjectAsString()),
        Var.valueOf(""),
        Var.valueOf(""),
        cronapi.util.Operations.getSystemParameter(
        Var.valueOf("emailSmtp")),
        cronapi.util.Operations.getSystemParameter(
        Var.valueOf("emailPorta")),
        cronapi.util.Operations.getSystemParameter(
        Var.valueOf("email")),
        cronapi.util.Operations.getSystemParameter(
        Var.valueOf("passwordEmail")),
        Var.valueOf("TLSv1.2"));
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao enviar email para o administrador do sistema, sobre o estoque.")));
     }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 14/05/2025, 17:01:00
 *
 */
public static void verifyOnDB() throws Exception {
  new Callable<Var>() {

   private Var produtos = Var.VAR_NULL;
   private Var produtosEstoqueBaixo = Var.VAR_NULL;
   private Var p = Var.VAR_NULL;
   private Var listaProdutosEstoqueBaixo = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         produtos =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Product"),Var.valueOf("select \n	p \nfrom \n	Product p"));
        produtosEstoqueBaixo =
        Var.valueOf("");
        for (Iterator it_p = produtos.iterator(); it_p.hasNext();) {
            p = Var.valueOf(it_p.next());
            if (
            Var.valueOf(
            cronapi.json.Operations.getJsonOrMapField(p,
            Var.valueOf("amount")).compareTo(
            cronapi.json.Operations.getJsonOrMapField(p,
            Var.valueOf("minQuantity"))) < 0).getObjectAsBoolean()) {
                produtosEstoqueBaixo.append(cronapi.json.Operations.getJsonOrMapField(p,
                Var.valueOf("name")).getObjectAsString());
                produtosEstoqueBaixo.append(Var.valueOf(",").getObjectAsString());
            }
        } // end for
        listaProdutosEstoqueBaixo =
        cronapi.list.Operations.getListFromText(produtosEstoqueBaixo,
        Var.valueOf(","));
        if (
        cronapi.logic.Operations.isNullOrEmpty(produtosEstoqueBaixo)
        .negate().getObjectAsBoolean()) {
            sendMail(produtosEstoqueBaixo);
        }
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao verificar os produtos no banco")));
     }
   return Var.VAR_NULL;
   }
 }.call();
}

}

