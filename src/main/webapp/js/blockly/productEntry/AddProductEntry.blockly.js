window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productEntry = window.blockly.js.blockly.productEntry || {};
window.blockly.js.blockly.productEntry.AddProductEntry = window.blockly.js.blockly.productEntry.AddProductEntry || {};

/**
 * @function add
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 14:27:19
 *
 */
window.blockly.js.blockly.productEntry.AddProductEntry.addArgs = [];
window.blockly.js.blockly.productEntry.AddProductEntry.add = async function() {
 var e, objData, serverResponse;
  //
  objData = (await this.cronapi.client('blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntry').run());
  //
  if (!this.cronapi.logic.isNullOrEmpty(objData)) {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.productEntry.AddProductEntry:save', async function(sender_serverResponse) {
        serverResponse = sender_serverResponse;
      //
      if (this.cronapi.json.getProperty(serverResponse, 'success')) {
        //
        this.cronapi.screen.notify('success',this.cronapi.json.getProperty(serverResponse, 'message'));
        //
        this.cronapi.screen.refreshDatasource("ProductEntry", 'true');
        //
        (await this.cronapi.client('blockly.js.blockly.productEntry.ModalHandler.closeAddModal').run());
      } else {
        //
        this.cronapi.util.throwException(this.cronapi.json.getProperty(serverResponse, 'message'));
      }
    }.bind(this), objData);
  }
}
