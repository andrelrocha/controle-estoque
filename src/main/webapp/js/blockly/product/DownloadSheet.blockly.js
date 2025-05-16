window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.product = window.blockly.js.blockly.product || {};
window.blockly.js.blockly.product.DownloadSheet = window.blockly.js.blockly.product.DownloadSheet || {};

/**
 * @function downloadCsv
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 16/05/2025, 10:02:13
 *
 */
window.blockly.js.blockly.product.DownloadSheet.downloadCsvArgs = [];
window.blockly.js.blockly.product.DownloadSheet.downloadCsv = async function() {
 var downloadEndpoint;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.product.ExportSheet:exportCsv', async function(sender_downloadEndpoint) {
      downloadEndpoint = sender_downloadEndpoint;
  }.bind(this));
}
