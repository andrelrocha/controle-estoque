package blockly.product;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UpdateFromCSV {

public static final int TIMEOUT = 300;

/**
 *
 * @param productsList
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 16/05/2025, 11:44:06
 *
 */
public static Var manage(@ParamMetaData(description = "productsList", id = "cd44578b") @RequestBody(required = false) Var productsList) throws Exception {
 return new Callable<Var>() {

   private Var products = Var.VAR_NULL;
   private Var product = Var.VAR_NULL;
   private Var productOnDb = Var.VAR_NULL;
   private Var e = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         products =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Product"),Var.valueOf("select \n	p \nfrom \n	Product p"));
        for (Iterator it_product = productsList.iterator(); it_product.hasNext();) {
            product = Var.valueOf(it_product.next());
            if (
            Var.valueOf(!
            cronapi.list.Operations.findFirst(products, product).equals(
            Var.valueOf(0))).getObjectAsBoolean()) {
              {}
            } else {
                productOnDb =
                cronapi.util.Operations.callBlockly(Var.valueOf("blockly.product.CreateProduct:createFromJSON"), Var.valueOf("0822b2e3", product));
            }
        } // end for
     } catch (Exception e_exception) {
          e = Var.valueOf(e_exception);
         cronapi.util.Operations.throwException(
        cronapi.util.Operations.createException(
        Var.valueOf("Erro ao gerenciar o processo de criação/atualização de produtos a partir do csv")));
     }
    return Var.VAR_NULL;
   }
 }.call();
}

}

