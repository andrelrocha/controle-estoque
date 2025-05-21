window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productEntry = window.blockly.js.blockly.productEntry || {};
window.blockly.js.blockly.productEntry.BuildObject = window.blockly.js.blockly.productEntry.BuildObject || {};

/**
 * @function validateFields
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 12:12:53
 *
 */
window.blockly.js.blockly.productEntry.BuildObject.validateFieldsArgs = [];
window.blockly.js.blockly.productEntry.BuildObject.validateFields = async function() {
 var data;
  //
  status2 = true;
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.modalAddProductId"))) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Você deve selecionar um produto.'));
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.modalAddAmount"))) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Você deve indicar a quantidade que está sendo adicionada do produto.'));
  } else if (this.cronapi.screen.getValueOfField("vars.modalAddAmount") < 0) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('A quantidade de uma entrada não pode ser negativa.'));
  }
  return status2;
}

/**
 * @function buildAddProjectEntry
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 12:12:53
 *
 */
window.blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntryArgs = [];
window.blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntry = async function() {
 var data;
  //
  data = this.cronapi.json.createObjectFromString('{}');
  //
  if ((await this.cronapi.client('blockly.js.blockly.productEntry.BuildObject.validateFields').run())) {
    //
    this.cronapi.json.setProperty(data, 'product_id', this.cronapi.screen.getValueOfField("vars.modalAddProductId"));
    //
    this.cronapi.json.setProperty(data, 'amount', this.cronapi.screen.getValueOfField("vars.modalAddAmount"));
  } else {
    //
    data = null;
  }
  return data;
}
