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
 * @since 21/05/2025, 12:27:01
 *
 */
window.blockly.js.blockly.product.CreateProduct.runArgs = [];
window.blockly.js.blockly.product.CreateProduct.run = async function() {
 var objData, e, serverResponse;
  //
  try {
     //
    objData = (await this.cronapi.client('blockly.js.blockly.product.BuildObject.buildCreateProduct').run());
    //
    if (!this.cronapi.logic.isNullOrEmpty(objData)) {
      //
      this.cronapi.util.callServerBlocklyAsynchronous('blockly.product.CreateProduct:createFromJSON', async function(sender_serverResponse) {
          serverResponse = sender_serverResponse;
        //
        if (!this.cronapi.logic.isNullOrEmpty(serverResponse)) {
          //
          this.cronapi.screen.notify('success','Produto adicionado com sucesso no sistema!');
          //
          this.cronapi.screen.refreshDatasource("Product", 'true');
          //
          (await this.cronapi.client('blockly.js.blockly.product.ModalHandler.closeAddModal').run());
        }
      }.bind(this), objData);
    }
   } catch (e_exception) {
        e = e_exception;
     //
    this.cronapi.screen.notify('error',e);
   }
}
