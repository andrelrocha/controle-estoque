window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productExit = window.blockly.js.blockly.productExit || {};
window.blockly.js.blockly.productExit.DownloadSheet = window.blockly.js.blockly.productExit.DownloadSheet || {};

/**
 * @function downloadCsv
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 16/05/2025, 13:16:41
 *
 */
window.blockly.js.blockly.productExit.DownloadSheet.downloadCsvArgs = [];
window.blockly.js.blockly.productExit.DownloadSheet.downloadCsv = async function() {
 var item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.productExit.ExportSheet:exportCsv', async function(sender_item) {
      item = sender_item;
  }.bind(this));
}
