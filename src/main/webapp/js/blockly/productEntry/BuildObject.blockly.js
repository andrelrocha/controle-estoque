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
 * @since 26/05/2025, 10:43:20
 *
 */
window.blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntryArgs = [];
window.blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntry = async function() {
 var id, data;
  //
  data = this.cronapi.json.createObjectFromString('{}');
  //
  if ((await this.cronapi.client('blockly.js.blockly.productEntry.BuildObject.validateFields').run(false))) {
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

/**
 * @function buildUpdateProjectEntry
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 10:43:20
 *
 */
window.blockly.js.blockly.productEntry.BuildObject.buildUpdateProjectEntryArgs = [];
window.blockly.js.blockly.productEntry.BuildObject.buildUpdateProjectEntry = async function() {
 var id, data;
  //
  data = this.cronapi.json.createObjectFromString('{}');
  //
  if ((await this.cronapi.client('blockly.js.blockly.productEntry.BuildObject.validateFields').run(true))) {
    //
    this.cronapi.json.setProperty(data, 'product', this.cronapi.screen.getValueOfField("ProductEntry.active.product"));
    //
    this.cronapi.json.setProperty(data, 'amount', this.cronapi.screen.getValueOfField("ProductEntry.active.amount"));
    //
    this.cronapi.json.setProperty(data, 'date', this.cronapi.screen.getValueOfField("ProductEntry.active.date"));
    //
    this.cronapi.json.setProperty(data, 'id', this.cronapi.screen.getValueOfField("ProductEntry.active.id"));
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
 * @param edit
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 10:43:20
 *
 */
window.blockly.js.blockly.productEntry.BuildObject.validateFieldsArgs = [{ description: 'edit', id: 'd402b022' }];
window.blockly.js.blockly.productEntry.BuildObject.validateFields = async function(edit) {
 var id;
  //
  status2 = true;
  //
  productId = edit ? this.cronapi.screen.getValueOfField("ProductEntry.active.product") : this.cronapi.screen.getValueOfField("vars.modalAddProductId");
  //
  amount = edit ? this.cronapi.screen.getValueOfField("ProductEntry.active.amount") : this.cronapi.screen.getValueOfField("vars.modalAddAmount");
  //
  if (this.cronapi.logic.isNullOrEmpty(productId)) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Você deve selecionar um produto.'));
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(amount)) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('Você deve indicar a quantidade que está sendo adicionada do produto.'));
  } else if (amount < 0) {
    //
    status2 = false;
    //
    this.cronapi.util.throwException(this.cronapi.util.createException('A quantidade de uma entrada não pode ser negativa.'));
  }
  return status2;
}
