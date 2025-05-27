window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.product = window.blockly.js.blockly.product || {};
window.blockly.js.blockly.product.UpdateProduct = window.blockly.js.blockly.product.UpdateProduct || {};

/**
 * @function update
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 12:49:16
 *
 */
window.blockly.js.blockly.product.UpdateProduct.updateArgs = [];
window.blockly.js.blockly.product.UpdateProduct.update = async function() {
 var e, objData, serverResponse;
  //
  objData = (await this.cronapi.client('blockly.js.blockly.product.BuildObject.buildUpdateProduct').run());
  //
  if (!this.cronapi.logic.isNullOrEmpty(objData)) {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.product.UpdateProduct:manageUpdateFromJSON', async function(sender_serverResponse) {
        serverResponse = sender_serverResponse;
      //
      if (this.cronapi.json.getProperty(serverResponse, 'success')) {
        //
        this.cronapi.screen.notify('success',this.cronapi.json.getProperty(serverResponse, 'message'));
        //
        this.cronapi.screen.refreshDatasource("Product", 'true');
        //
        (await this.cronapi.client('blockly.js.blockly.product.ModalHandler.closeUpdateModal').run());
      } else {
        //
        this.cronapi.screen.notify('error',this.cronapi.json.getProperty(serverResponse, 'message'));
      }
    }.bind(this), objData);
  }
}
