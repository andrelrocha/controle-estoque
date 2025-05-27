window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.product = window.blockly.js.blockly.product || {};
window.blockly.js.blockly.product.CreateProduct = window.blockly.js.blockly.product.CreateProduct || {};

/**
 * @function run
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 12:05:50
 *
 */
window.blockly.js.blockly.product.CreateProduct.runArgs = [];
window.blockly.js.blockly.product.CreateProduct.run = async function() {
 var e, objData, serverResponse;
  //
  objData = (await this.cronapi.client('blockly.js.blockly.product.BuildObject.buildCreateProduct').run());
  //
  if (!this.cronapi.logic.isNullOrEmpty(objData)) {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.product.CreateProduct:createFromJSON', async function(sender_serverResponse) {
        serverResponse = sender_serverResponse;
      //
      if (this.cronapi.json.getProperty(serverResponse, 'success')) {
        //
        this.cronapi.screen.notify('success',this.cronapi.json.getProperty(serverResponse, 'message'));
        //
        this.cronapi.screen.refreshDatasource("Product", 'true');
        //
        (await this.cronapi.client('blockly.js.blockly.product.ModalHandler.closeAddModal').run());
      } else {
        //
        this.cronapi.screen.notify('error',this.cronapi.json.getProperty(serverResponse, 'message'));
      }
    }.bind(this), objData);
  }
}
