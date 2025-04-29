window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productEntry = window.blockly.js.blockly.productEntry || {};
window.blockly.js.blockly.productEntry.ModalHandler = window.blockly.js.blockly.productEntry.ModalHandler || {};

/**
 * @function openAddModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 29/04/2025, 09:55:10
 *
 */
window.blockly.js.blockly.productEntry.ModalHandler.openAddModalArgs = [];
window.blockly.js.blockly.productEntry.ModalHandler.openAddModal = async function() {

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
 * @since 29/04/2025, 09:55:10
 *
 */
window.blockly.js.blockly.productEntry.ModalHandler.closeAddModalArgs = [];
window.blockly.js.blockly.productEntry.ModalHandler.closeAddModal = async function() {

  //
  this.cronapi.screen.changeValueOfField("vars.modalAddProductId", '');
  //
  this.cronapi.screen.changeValueOfField("vars.modalAddAmount", '');
  //
  this.cronapi.screen.hideModal("modalAddProductEntry");
}
