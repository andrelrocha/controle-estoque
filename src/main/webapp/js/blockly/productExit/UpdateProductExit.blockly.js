window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productExit = window.blockly.js.blockly.productExit || {};
window.blockly.js.blockly.productExit.UpdateProductExit = window.blockly.js.blockly.productExit.UpdateProductExit || {};

/**
 * @function update
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 09:31:05
 *
 */
window.blockly.js.blockly.productExit.UpdateProductExit.updateArgs = [];
window.blockly.js.blockly.productExit.UpdateProductExit.update = async function() {
 var objData, serverResponse;
  //
  objData = (await this.cronapi.client('blockly.js.blockly.productExit.BuildObject.buildUpdateProjectExit').run());
  //
  if (!this.cronapi.logic.isNullOrEmpty(objData)) {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.productExit.UpdateProductExit:manageUpdate', async function(sender_serverResponse) {
        serverResponse = sender_serverResponse;
      //
      if (this.cronapi.json.getProperty(serverResponse, 'success')) {
        //
        this.cronapi.screen.notify('success',this.cronapi.json.getProperty(serverResponse, 'message'));
        //
        this.cronapi.screen.refreshDatasource("ProductExit", 'true');
        //
        (await this.cronapi.client('blockly.js.blockly.productExit.ModalHandler.closeUpdateModal').run());
      } else {
        //
        this.cronapi.screen.notify('error',this.cronapi.json.getProperty(serverResponse, 'message'));
      }
    }.bind(this), objData);
  }
}
