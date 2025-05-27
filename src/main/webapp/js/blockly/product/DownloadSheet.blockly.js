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
 * @since 27/05/2025, 12:33:27
 *
 */
window.blockly.js.blockly.product.DownloadSheet.downloadCsvArgs = [];
window.blockly.js.blockly.product.DownloadSheet.downloadCsv = async function() {
 var serverResponse;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.product.ExportSheet:exportCsv', async function(sender_serverResponse) {
      serverResponse = sender_serverResponse;
    //
    if (this.cronapi.json.getProperty(serverResponse, 'success')) {
      //
      this.cronapi.screen.notify('success',this.cronapi.json.getProperty(serverResponse, 'message'));
    } else {
      //
      this.cronapi.screen.notify('error',this.cronapi.json.getProperty(serverResponse, 'message'));
    }
  }.bind(this));
}
