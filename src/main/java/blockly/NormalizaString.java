package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class NormalizaString {

public static final int TIMEOUT = 300;

/**
 *
 * @param input
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 16/05/2025, 11:48:02
 *
 */
public static Var normalizar(@ParamMetaData(description = "input2", id = "4c46508f") @RequestBody(required = false) Var input2) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    System.out.println(
    cronapi.text.Operations.normalize(input2).getObjectAsString());
    return
cronapi.text.Operations.normalize(input2);
   }
 }.call();
}

}

