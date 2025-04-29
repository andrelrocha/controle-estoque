window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productExit = window.blockly.js.blockly.productExit || {};
window.blockly.js.blockly.productExit.ModalHandler = window.blockly.js.blockly.productExit.ModalHandler || {};

/**
 * @function openAddModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 29/04/2025, 09:58:16
 *
 */
window.blockly.js.blockly.productExit.ModalHandler.openAddModalArgs = [];
window.blockly.js.blockly.productExit.ModalHandler.openAddModal = async function() {

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
 * @since 29/04/2025, 09:58:16
 *
 */
window.blockly.js.blockly.productExit.ModalHandler.closeAddModalArgs = [];
window.blockly.js.blockly.productExit.ModalHandler.closeAddModal = async function() {

  //
  this.cronapi.screen.changeValueOfField("vars.modalAddAmount", '');
  //
  this.cronapi.screen.changeValueOfField("vars.modalAddProductId", '');
  //
  this.cronapi.screen.hideModal("modalAddProductExit");
}
