window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productEntry = window.blockly.js.blockly.productEntry || {};
window.blockly.js.blockly.productEntry.DownloadSheet = window.blockly.js.blockly.productEntry.DownloadSheet || {};

/**
 * @function downloadCsv
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 16/05/2025, 13:09:53
 *
 */
window.blockly.js.blockly.productEntry.DownloadSheet.downloadCsvArgs = [];
window.blockly.js.blockly.productEntry.DownloadSheet.downloadCsv = async function() {
 var downloadEndpoint, item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.productEntry.ExportSheet:exportCsv', async function(sender_item) {
      item = sender_item;
  }.bind(this));
}
