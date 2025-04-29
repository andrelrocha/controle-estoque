window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productExit = window.blockly.js.blockly.productExit || {};
window.blockly.js.blockly.productExit.BuildObject = window.blockly.js.blockly.productExit.BuildObject || {};

/**
 * @function buildAddProjectExit
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 29/04/2025, 09:57:12
 *
 */
window.blockly.js.blockly.productExit.BuildObject.buildAddProjectExitArgs = [];
window.blockly.js.blockly.productExit.BuildObject.buildAddProjectExit = async function() {
 var data, e;
  //
  try {
     //
    data = this.cronapi.json.createObjectFromString('{}');
    //
    if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.modalAddProductId"))) {
      //
      this.cronapi.util.throwException(this.cronapi.util.createException('Você deve selecionar um produto.'));
    } else {
      //
      this.cronapi.json.setProperty(data, 'product_id', this.cronapi.screen.getValueOfField("vars.modalAddProductId"));
    }
    //
    if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.modalAddAmount"))) {
      //
      this.cronapi.util.throwException(this.cronapi.util.createException('Você deve indicar a quantidade que está sendo removida do produto.'));
    } else {
      //
      this.cronapi.json.setProperty(data, 'amount', this.cronapi.screen.getValueOfField("vars.modalAddAmount"));
    }
   } catch (e_exception) {
        e = e_exception;
     //
    this.cronapi.util.throwException(e);
   }
  return data;
}
