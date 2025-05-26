window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productEntry = window.blockly.js.blockly.productEntry || {};
window.blockly.js.blockly.productEntry.ModalHandler = window.blockly.js.blockly.productEntry.ModalHandler || {};

/**
 * @function openUpdateModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 10:24:34
 *
 */
window.blockly.js.blockly.productEntry.ModalHandler.openUpdateModalArgs = [];
window.blockly.js.blockly.productEntry.ModalHandler.openUpdateModal = async function() {

  //
  this.cronapi.screen.showModal("modalUpdateProductEntry");
}

/**
 * @function openAddModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 10:24:34
 *
 */
window.blockly.js.blockly.productEntry.ModalHandler.openAddModalArgs = [];
window.blockly.js.blockly.productEntry.ModalHandler.openAddModal = async function() {

  //
  (await this.cronapi.client('blockly.js.blockly.productEntry.ModalHandler.clearCreateFields').run());
  //
  this.cronapi.screen.showModal("modalAddProductEntry");
}

/**
 * @function closeAddModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 10:24:34
 *
 */
window.blockly.js.blockly.productEntry.ModalHandler.closeAddModalArgs = [];
window.blockly.js.blockly.productEntry.ModalHandler.closeAddModal = async function() {

  //
  (await this.cronapi.client('blockly.js.blockly.productEntry.ModalHandler.clearCreateFields').run());
  //
  this.cronapi.screen.hideModal("modalAddProductEntry");
}

/**
 * @function closeUpdateModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 10:24:34
 *
 */
window.blockly.js.blockly.productEntry.ModalHandler.closeUpdateModalArgs = [];
window.blockly.js.blockly.productEntry.ModalHandler.closeUpdateModal = async function() {

  //
  this.cronapi.screen.hideModal("modalUpdateProductEntry");
}

/**
 * @function clearCreateFields
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 10:24:34
 *
 */
window.blockly.js.blockly.productEntry.ModalHandler.clearCreateFieldsArgs = [];
window.blockly.js.blockly.productEntry.ModalHandler.clearCreateFields = async function() {

  //
  this.cronapi.screen.changeValueOfField("vars.modalAddProductId", '');
  //
  this.cronapi.screen.changeValueOfField("vars.modalAddAmount", '');
}
