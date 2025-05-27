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
 * @since 27/05/2025, 08:48:03
 *
 */
window.blockly.js.blockly.productExit.AddProductExit.runArgs = [];
window.blockly.js.blockly.productExit.AddProductExit.run = async function() {
 var e, objData, serverResponse;
  //
  objData = (await this.cronapi.client('blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntry').run());
  //
  if (!this.cronapi.logic.isNullOrEmpty(objData)) {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.productExit.AddProductExit:save', async function(sender_serverResponse) {
        serverResponse = sender_serverResponse;
      //
      if (this.cronapi.json.getProperty(serverResponse, 'success')) {
        //
        this.cronapi.screen.notify('success',this.cronapi.json.getProperty(serverResponse, 'message'));
        //
        this.cronapi.screen.refreshDatasource("ProductExit", 'true');
        //
        (await this.cronapi.client('blockly.js.blockly.productExit.ModalHandler.closeAddModal').run());
      } else {
        //
        this.cronapi.screen.notify('error',this.cronapi.json.getProperty(serverResponse, 'message'));
      }
    }.bind(this), objData);
  }
}
