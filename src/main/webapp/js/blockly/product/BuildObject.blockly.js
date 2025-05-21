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
 * @since 21/05/2025, 12:09:21
 *
 */
window.blockly.js.blockly.product.BuildObject.buildCreateProductArgs = [];
window.blockly.js.blockly.product.BuildObject.buildCreateProduct = async function() {
 var e, data;
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
  } else {
    //
    data = null;
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
 * @since 21/05/2025, 12:09:21
 *
 */
window.blockly.js.blockly.product.BuildObject.validateFieldsArgs = [];
window.blockly.js.blockly.product.BuildObject.validateFields = async function() {
 var e, data;
  //
  status2 = true;
  //
  name2 = this.cronapi.screen.getValueOfField("vars.modalCreateName");
  //
  amount = this.cronapi.screen.getValueOfField("vars.modalCreateAmount");
  //
  minQuantity = this.cronapi.screen.getValueOfField("vars.modalCreateMinQuantity");
  //
  maxQuantity = this.cronapi.screen.getValueOfField("vars.modalCreateMaxQuantity");
  //
  if (this.cronapi.logic.isNullOrEmpty(name2)) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Campo nome não pode ser vazio'));
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(amount)) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Você deve indicar a quantidade do produto.'));
  } else if (amount < 0) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('A quantidade do produto não pode ser negativa.'));
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(minQuantity)) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Você deve indicar a quantidade mínima do produto.'));
  } else if (minQuantity < 0) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('A quantidade mínima do produto não pode ser negativa.'));
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(maxQuantity)) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Você deve indicar a quantidade máxima do produto.'));
  } else if (0 < 0) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('A quantidade máxima do produto não pode ser negativa.'));
  }
  return status2;
}
