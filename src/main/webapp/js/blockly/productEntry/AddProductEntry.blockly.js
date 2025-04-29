window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productEntry = window.blockly.js.blockly.productEntry || {};
window.blockly.js.blockly.productEntry.AddProductEntry = window.blockly.js.blockly.productEntry.AddProductEntry || {};

/**
 * @function run
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 28/04/2025, 19:02:43
 *
 */
window.blockly.js.blockly.productEntry.AddProductEntry.runArgs = [];
window.blockly.js.blockly.productEntry.AddProductEntry.run = async function() {
 var errorMessage, objData, e, serverResponse;
  //
  try {
     //
    objData = (await this.cronapi.client('blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntry').run());
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.productEntry.AddProductEntry:save', async function(sender_serverResponse) {
        serverResponse = sender_serverResponse;
      //
      this.cronapi.screen.notify('success','Entrada do produto adicionada com sucesso no sistema!');
      //
      this.cronapi.screen.refreshDatasource("ProductEntry", 'true');
      //
      (await this.cronapi.client('blockly.js.blockly.productEntry.ModalHandler.closeAddModal').run());
    }.bind(this), objData);
   } catch (e_exception) {
        e = e_exception;
     //
    this.cronapi.screen.notify('error',e);
   }
}
