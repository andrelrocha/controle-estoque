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
 * @since 21/05/2025, 13:08:21
 *
 */
window.blockly.js.blockly.product.UpdateProduct.updateArgs = [];
window.blockly.js.blockly.product.UpdateProduct.update = async function() {
 var objData, e, serverResponse;
  //
  try {
     //
    objData = (await this.cronapi.client('blockly.js.blockly.product.BuildObject.buildUpdateProduct').run());
    //
    if (!this.cronapi.logic.isNullOrEmpty(objData)) {
      //
      this.cronapi.util.callServerBlocklyAsynchronous('blockly.product.UpdateProduct:updateFromJSON', async function(sender_serverResponse) {
          serverResponse = sender_serverResponse;
        //
        if (!this.cronapi.logic.isNullOrEmpty(serverResponse)) {
          //
          this.cronapi.screen.notify('success','Produto atualizado com sucesso no sistema!');
          //
          this.cronapi.screen.refreshDatasource("Product", 'true');
          //
          (await this.cronapi.client('blockly.js.blockly.product.ModalHandler.closeUpdateModal').run());
        }
      }.bind(this), objData);
    }
   } catch (e_exception) {
        e = e_exception;
     //
    this.cronapi.screen.notify('error',e);
   }
}
