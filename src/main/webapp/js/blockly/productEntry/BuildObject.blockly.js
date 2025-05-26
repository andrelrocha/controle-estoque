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
 * @since 26/05/2025, 14:46:02
 *
 */
window.blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntryArgs = [];
window.blockly.js.blockly.productEntry.BuildObject.buildAddProjectEntry = async function() {
 var edit, status, productId, amount;
  //
  data = this.cronapi.json.createObjectFromString('{}');
  //
  if ((await this.cronapi.client('blockly.js.blockly.productEntry.BuildObject.validateFields').run(false))) {
    //
    this.cronapi.json.setProperty(data, 'product', this.cronapi.screen.getValueOfField("vars.modalAddProductId"));
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
 * @since 26/05/2025, 14:46:02
 *
 */
window.blockly.js.blockly.productEntry.BuildObject.buildUpdateProjectEntryArgs = [];
window.blockly.js.blockly.productEntry.BuildObject.buildUpdateProjectEntry = async function() {
 var edit, status, productId, amount;
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
 * @since 26/05/2025, 14:46:02
 *
 */
window.blockly.js.blockly.productEntry.BuildObject.validateFieldsArgs = [{ description: 'edit', id: 'd402b022' }];
window.blockly.js.blockly.productEntry.BuildObject.validateFields = async function(edit) {
 var status, productId, amount;
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
    this.cronapi.screen.notify('warning','Campo produto não pode ser vazio.');
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(amount)) {
    //
    status2 = false;
    //
    this.cronapi.screen.notify('warning','Campo quantidade não pode ser vazio.');
  } else if (amount < 0) {
    //
    status2 = false;
    //
    this.cronapi.screen.notify('warning','A quantidade de uma entrada não pode ser negativa.');
  }
  return status2;
}
