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
 * @since 27/05/2025, 08:46:09
 *
 */
window.blockly.js.blockly.productExit.BuildObject.buildAddProjectExitArgs = [];
window.blockly.js.blockly.productExit.BuildObject.buildAddProjectExit = async function() {
 var status;
  //
  data = this.cronapi.json.createObjectFromString('{}');
  //
  if ((await this.cronapi.client('blockly.js.blockly.productExit.BuildObject.validateFields').run())) {
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
 * @function validateFields
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 08:46:09
 *
 */
window.blockly.js.blockly.productExit.BuildObject.validateFieldsArgs = [];
window.blockly.js.blockly.productExit.BuildObject.validateFields = async function() {
 var status;
  //
  status2 = true;
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.modalAddProductId"))) {
    //
    status2 = false;
    //
    this.cronapi.screen.notify('warning','Você deve selecionar um produto.');
  }
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.modalAddAmount"))) {
    //
    status2 = false;
    //
    this.cronapi.screen.notify('warning','Você deve indicar a quantidade que está saindo do produto.');
  } else if (this.cronapi.screen.getValueOfField("vars.modalAddAmount") < 0) {
    //
    status2 = false;
    //
    this.cronapi.screen.notify('warning','A quantidade de uma saída não pode ser negativa.');
  }
  return status2;
}
