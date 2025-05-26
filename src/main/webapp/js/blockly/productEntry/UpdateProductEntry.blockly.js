window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productEntry = window.blockly.js.blockly.productEntry || {};
window.blockly.js.blockly.productEntry.UpdateProductEntry = window.blockly.js.blockly.productEntry.UpdateProductEntry || {};

/**
 * @function update
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 10:55:28
 *
 */
window.blockly.js.blockly.productEntry.UpdateProductEntry.updateArgs = [];
window.blockly.js.blockly.productEntry.UpdateProductEntry.update = async function() {
 var objData, e, serverResponse;
  //
  try {
     //
    objData = (await this.cronapi.client('blockly.js.blockly.productEntry.BuildObject.buildUpdateProjectEntry').run());
    //
    if (!this.cronapi.logic.isNullOrEmpty(objData)) {
      //
      this.cronapi.util.callServerBlocklyAsynchronous('blockly.productEntry.UpdateProductEntry:update', async function(sender_serverResponse) {
          serverResponse = sender_serverResponse;
        //
        if (this.cronapi.json.getProperty(serverResponse, 'success')) {
          //
          this.cronapi.screen.notify('success',this.cronapi.json.getProperty(serverResponse, 'message'));
          //
          this.cronapi.screen.refreshDatasource("ProductEntry", 'true');
          //
          (await this.cronapi.client('blockly.js.blockly.productEntry.ModalHandler.closeUpdateModal').run());
        } else {
          //
          this.cronapi.util.throwException(this.cronapi.json.getProperty(serverResponse, 'message'));
        }
      }.bind(this), objData);
    }
   } catch (e_exception) {
        e = e_exception;
     //
    this.cronapi.screen.notify('error',e);
   }
}
