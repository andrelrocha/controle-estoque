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
 * @since 28/04/2025, 15:40:08
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
 * @since 28/04/2025, 15:40:08
 *
 */
window.blockly.js.blockly.productEntry.ModalHandler.closeAddModalArgs = [];
window.blockly.js.blockly.productEntry.ModalHandler.closeAddModal = async function() {

  //
  this.cronapi.screen.changeValueOfField("ProductEntry.active.amount", '');
  //
  this.cronapi.screen.changeValueOfField("ProductEntry.active.product", '');
  //
  this.cronapi.screen.hideModal("modalAddProductEntry");
}
