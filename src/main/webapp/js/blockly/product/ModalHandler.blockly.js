window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.product = window.blockly.js.blockly.product || {};
window.blockly.js.blockly.product.ModalHandler = window.blockly.js.blockly.product.ModalHandler || {};

/**
 * @function openUpdateModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 11:20:39
 *
 */
window.blockly.js.blockly.product.ModalHandler.openUpdateModalArgs = [];
window.blockly.js.blockly.product.ModalHandler.openUpdateModal = async function() {

  //
  this.cronapi.screen.showModal("modalUpdateProduct");
}

/**
 * @function openAddModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 11:20:39
 *
 */
window.blockly.js.blockly.product.ModalHandler.openAddModalArgs = [];
window.blockly.js.blockly.product.ModalHandler.openAddModal = async function() {

  //
  (await this.cronapi.client('blockly.js.blockly.product.ModalHandler.clearCreateFields').run());
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
 * @since 21/05/2025, 11:20:39
 *
 */
window.blockly.js.blockly.product.ModalHandler.closeAddModalArgs = [];
window.blockly.js.blockly.product.ModalHandler.closeAddModal = async function() {

  //
  (await this.cronapi.client('blockly.js.blockly.product.ModalHandler.clearCreateFields').run());
  //
  this.cronapi.screen.hideModal("modalCreateProduct");
}

/**
 * @function closeUpdateModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 11:20:39
 *
 */
window.blockly.js.blockly.product.ModalHandler.closeUpdateModalArgs = [];
window.blockly.js.blockly.product.ModalHandler.closeUpdateModal = async function() {

  //
  this.cronapi.screen.hideModal("modalUpdateProduct");
}

/**
 * @function clearCreateFields
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 21/05/2025, 11:20:39
 *
 */
window.blockly.js.blockly.product.ModalHandler.clearCreateFieldsArgs = [];
window.blockly.js.blockly.product.ModalHandler.clearCreateFields = async function() {

  //
  this.cronapi.screen.changeValueOfField("vars.modalCreateAmount", '');
  //
  this.cronapi.screen.changeValueOfField("vars.modalCreateName", '');
  //
  this.cronapi.screen.changeValueOfField("vars.modalCreateMinQuantity", '');
  //
  this.cronapi.screen.changeValueOfField("vars.modalCreateMaxQuantity", '');
}
