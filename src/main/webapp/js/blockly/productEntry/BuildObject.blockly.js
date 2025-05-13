window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productEntry = window.blockly.js.blockly.productEntry || {};
window.blockly.js.blockly.productEntry.BuildObject = window.blockly.js.blockly.productEntry.BuildObject || {};

/**
 * @function buildAddProjectEntry
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 13/05/2025, 14:29:18
 *
 */
window.blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntryArgs = [];
window.blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntry = async function() {
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
      this.cronapi.util.throwException(this.cronapi.util.createException('Você deve indicar a quantidade que está sendo adicionada do produto.'));
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
