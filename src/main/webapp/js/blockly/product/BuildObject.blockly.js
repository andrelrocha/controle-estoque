window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.product = window.blockly.js.blockly.product || {};
window.blockly.js.blockly.product.BuildObject = window.blockly.js.blockly.product.BuildObject || {};

/**
 * @function buildCreateProduct
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 11:49:09
 *
 */
window.blockly.js.blockly.product.BuildObject.buildCreateProductArgs = [];
window.blockly.js.blockly.product.BuildObject.buildCreateProduct = async function() {
 var data;
  //
  data = this.cronapi.json.createObjectFromString('{}');
  //
  if ((await this.cronapi.client('blockly.js.blockly.product.BuildObject.validateFields').run())) {
    //
    this.cronapi.json.setProperty(data, 'name', this.cronapi.screen.getValueOfField("vars.modalCreateName"));
    //
    this.cronapi.json.setProperty(data, 'amount', this.cronapi.screen.getValueOfField("vars.modalCreateAmount"));
    //
    this.cronapi.json.setProperty(data, 'minQuantity', this.cronapi.screen.getValueOfField("vars.modalCreateMinQuantity"));
    //
    this.cronapi.json.setProperty(data, 'maxQuantity', this.cronapi.screen.getValueOfField("vars.modalCreateMaxQuantity"));
  }
  return data;
}

/**
 * @function validateFields
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 11:49:09
 *
 */
window.blockly.js.blockly.product.BuildObject.validateFieldsArgs = [];
window.blockly.js.blockly.product.BuildObject.validateFields = async function() {
 var data;
  //
  status2 = true;
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.modalCreateName"))) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Campo nome não pode ser vazio'));
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.modalCreateAmount"))) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Você deve indicar a quantidade do produto.'));
  } else if (this.cronapi.screen.getValueOfField("vars.modalCreateAmount") < 0) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('A quantidade do produto não pode ser negativa.'));
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.modalCreateMinQuantity"))) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Você deve indicar a quantidade mínima do produto.'));
  } else if (this.cronapi.screen.getValueOfField("vars.modalCreateMinQuantity") < 0) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('A quantidade mínima do produto não pode ser negativa.'));
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.modalCreateMaxQuantity"))) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Você deve indicar a quantidade máxima do produto.'));
  } else if (this.cronapi.screen.getValueOfField("vars.modalCreateMaxQuantity") < 0) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('A quantidade máxima do produto não pode ser negativa.'));
  }
  return status2;
}
