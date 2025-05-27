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
 * @since 26/05/2025, 14:46:51
 *
 */
window.blockly.js.blockly.productEntry.DownloadSheet.downloadCsvArgs = [];
window.blockly.js.blockly.productEntry.DownloadSheet.downloadCsv = async function() {
 var e, serverResponse;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.productEntry.ExportSheet:exportCsv', async function(sender_serverResponse) {
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
