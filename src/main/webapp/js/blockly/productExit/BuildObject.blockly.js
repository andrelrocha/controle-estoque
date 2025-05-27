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
 * @since 27/05/2025, 09:36:28
 *
 */
window.blockly.js.blockly.productExit.BuildObject.buildAddProjectExitArgs = [];
window.blockly.js.blockly.productExit.BuildObject.buildAddProjectExit = async function() {
 var data;
  //
  data = this.cronapi.json.createObjectFromString('{}');
  //
  if ((await this.cronapi.client('blockly.js.blockly.productExit.BuildObject.validateFields').run(false))) {
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
 * @function buildUpdateProjectExit
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 09:36:28
 *
 */
window.blockly.js.blockly.productExit.BuildObject.buildUpdateProjectExitArgs = [];
window.blockly.js.blockly.productExit.BuildObject.buildUpdateProjectExit = async function() {
 var data;
  //
  data = this.cronapi.json.createObjectFromString('{}');
  //
  if ((await this.cronapi.client('blockly.js.blockly.productExit.BuildObject.validateFields').run(true))) {
    //
    this.cronapi.json.setProperty(data, 'product', this.cronapi.screen.getValueOfField("ProductExit.active.product"));
    //
    this.cronapi.json.setProperty(data, 'amount', this.cronapi.screen.getValueOfField("ProductExit.active.amount"));
    //
    this.cronapi.json.setProperty(data, 'date', this.cronapi.screen.getValueOfField("ProductExit.active.date"));
    //
    this.cronapi.json.setProperty(data, 'id', this.cronapi.screen.getValueOfField("ProductExit.active.id"));
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
 * @since 27/05/2025, 09:36:28
 *
 */
window.blockly.js.blockly.productExit.BuildObject.validateFieldsArgs = [{ description: 'edit', id: '0555efb9' }];
window.blockly.js.blockly.productExit.BuildObject.validateFields = async function(edit) {

  //
  status2 = true;
  //
  productId = edit ? this.cronapi.screen.getValueOfField("ProductExit.active.product") : this.cronapi.screen.getValueOfField("vars.modalAddProductId");
  //
  amount = edit ? this.cronapi.screen.getValueOfField("ProductExit.active.amount") : this.cronapi.screen.getValueOfField("vars.modalAddAmount");
  //
  if (this.cronapi.logic.isNullOrEmpty(productId)) {
    //
    status2 = false;
    //
    this.cronapi.screen.notify('warning','Você deve selecionar um produto.');
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(amount)) {
    //
    status2 = false;
    //
    this.cronapi.screen.notify('warning','Você deve indicar a quantidade que está saindo do produto.');
  } else if (amount < 0) {
    //
    status2 = false;
    //
    this.cronapi.screen.notify('warning','A quantidade de uma saída não pode ser negativa.');
  }
  return status2;
}
