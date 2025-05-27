window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productExit = window.blockly.js.blockly.productExit || {};
window.blockly.js.blockly.productExit.ModalHandler = window.blockly.js.blockly.productExit.ModalHandler || {};

/**
 * @function openUpdateModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 09:09:55
 *
 */
window.blockly.js.blockly.productExit.ModalHandler.openUpdateModalArgs = [];
window.blockly.js.blockly.productExit.ModalHandler.openUpdateModal = async function() {

  //
  this.cronapi.screen.showModal("modalUpdateProductExit");
}

/**
 * @function openAddModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 09:09:55
 *
 */
window.blockly.js.blockly.productExit.ModalHandler.openAddModalArgs = [];
window.blockly.js.blockly.productExit.ModalHandler.openAddModal = async function() {

  //
  (await this.cronapi.client('blockly.js.blockly.productExit.ModalHandler.clearAddFields').run());
  //
  this.cronapi.screen.showModal("modalAddProductExit");
}

/**
 * @function closeAddModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 09:09:55
 *
 */
window.blockly.js.blockly.productExit.ModalHandler.closeAddModalArgs = [];
window.blockly.js.blockly.productExit.ModalHandler.closeAddModal = async function() {

  //
  (await this.cronapi.client('blockly.js.blockly.productExit.ModalHandler.clearAddFields').run());
  //
  this.cronapi.screen.hideModal("modalAddProductExit");
}

/**
 * @function closeUpdateModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 09:09:55
 *
 */
window.blockly.js.blockly.productExit.ModalHandler.closeUpdateModalArgs = [];
window.blockly.js.blockly.productExit.ModalHandler.closeUpdateModal = async function() {

  //
  this.cronapi.screen.hideModal("modalUpdateProductExit");
}

/**
 * @function clearAddFields
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 09:09:55
 *
 */
window.blockly.js.blockly.productExit.ModalHandler.clearAddFieldsArgs = [];
window.blockly.js.blockly.productExit.ModalHandler.clearAddFields = async function() {

  //
  this.cronapi.screen.changeValueOfField("vars.modalAddAmount", '');
  //
  this.cronapi.screen.changeValueOfField("vars.modalAddProductId", '');
}
