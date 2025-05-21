window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.product = window.blockly.js.blockly.product || {};
window.blockly.js.blockly.product.ModalHandler = window.blockly.js.blockly.product.ModalHandler || {};

/**
 * @function openAddModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 11:10:10
 *
 */
window.blockly.js.blockly.product.ModalHandler.openAddModalArgs = [];
window.blockly.js.blockly.product.ModalHandler.openAddModal = async function() {

  //
  (await this.cronapi.client('blockly.js.blockly.product.ModalHandler.clearFields').run());
  //
  this.cronapi.screen.showModal("modalCreateProduct");
}

/**
 * @function closeAddModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 11:10:10
 *
 */
window.blockly.js.blockly.product.ModalHandler.closeAddModalArgs = [];
window.blockly.js.blockly.product.ModalHandler.closeAddModal = async function() {

  //
  (await this.cronapi.client('blockly.js.blockly.product.ModalHandler.clearFields').run());
  //
  this.cronapi.screen.hideModal("modalCreateProduct");
}

/**
 * @function clearFields
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 11:10:10
 *
 */
window.blockly.js.blockly.product.ModalHandler.clearFieldsArgs = [];
window.blockly.js.blockly.product.ModalHandler.clearFields = async function() {

  //
  this.cronapi.screen.changeValueOfField("vars.modalCreateAmount", '');
  //
  this.cronapi.screen.changeValueOfField("vars.modalCreateName", '');
  //
  this.cronapi.screen.changeValueOfField("vars.modalCreateMinQuantity", '');
  //
  this.cronapi.screen.changeValueOfField("vars.modalCreateMaxQuantity", '');
}
