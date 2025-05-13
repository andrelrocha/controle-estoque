window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productExit = window.blockly.js.blockly.productExit || {};
window.blockly.js.blockly.productExit.AddProductExit = window.blockly.js.blockly.productExit.AddProductExit || {};

/**
 * @function run
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 09/05/2025, 17:33:54
 *
 */
window.blockly.js.blockly.productExit.AddProductExit.runArgs = [];
window.blockly.js.blockly.productExit.AddProductExit.run = async function() {
 var objData, e, serverResponse;
  //
  try {
     //
    objData = (await this.cronapi.client('blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntry').run());
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.productExit.AddProductExit:save', async function(sender_serverResponse) {
        serverResponse = sender_serverResponse;
      //
      this.cronapi.screen.notify('success','Saída do produto adicionada com sucesso no sistema!');
      //
      this.cronapi.screen.refreshDatasource("ProductExit", 'true');
      //
      (await this.cronapi.client('blockly.js.blockly.productExit.ModalHandler.closeAddModal').run());
    }.bind(this), objData);
   } catch (e_exception) {
        e = e_exception;
     //
    this.cronapi.screen.notify('error',e);
   }
}
