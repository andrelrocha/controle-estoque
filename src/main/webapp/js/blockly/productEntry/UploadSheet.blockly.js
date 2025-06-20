window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.productEntry = window.blockly.js.blockly.productEntry || {};
window.blockly.js.blockly.productEntry.UploadSheet = window.blockly.js.blockly.productEntry.UploadSheet || {};

/**
 * @function readAndConvert
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 14:46:19
 *
 */
window.blockly.js.blockly.productEntry.UploadSheet.readAndConvertArgs = [];
window.blockly.js.blockly.productEntry.UploadSheet.readAndConvert = async function() {
 var e, fileData, isValid, fileExtension;
  //
  fileJson = (await this.cronapi.client('blockly.js.blockly.productEntry.UploadSheet.buildFileAsJson').run());
  //
  if ((await this.cronapi.client('blockly.js.blockly.productEntry.UploadSheet.validate').run(fileJson))) {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.productEntry.ConvertProductEntriesOnSheet:handleProductsEntriesUpdateProcess', async function(sender_serverResponse) {
        serverResponse = sender_serverResponse;
      //
      if (this.cronapi.json.getProperty(serverResponse, 'success')) {
        //
        this.cronapi.screen.notify('success',this.cronapi.json.getProperty(serverResponse, 'message'));
        //
        this.cronapi.screen.refreshDatasource("ProductEntry", 'true');
        //
        (await this.cronapi.client('blockly.js.blockly.productEntry.UploadSheet.closeModal').run());
      } else {
        //
        this.cronapi.screen.notify('error',this.cronapi.json.getProperty(serverResponse, 'message'));
      }
    }.bind(this), fileJson);
  }
}

/**
 * @function buildFileAsJson
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 14:46:19
 *
 */
window.blockly.js.blockly.productEntry.UploadSheet.buildFileAsJsonArgs = [];
window.blockly.js.blockly.productEntry.UploadSheet.buildFileAsJson = async function() {
 var e, fileData, isValid, fileExtension;
  return this.cronapi.json.createObjectFromString(this.cronapi.screen.getValueOfField("vars.excelFileToUpload"));
}

/**
 * @function validate
 *
 *
 *
 * @param fileData
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 14:46:19
 *
 */
window.blockly.js.blockly.productEntry.UploadSheet.validateArgs = [{ description: 'fileData', id: 'b1d364dc' }];
window.blockly.js.blockly.productEntry.UploadSheet.validate = async function(fileData) {
 var e, isValid, fileExtension;
  //
  isValid = true;
  //
  if (this.cronapi.logic.isNullOrEmpty(fileData)) {
    //
    isValid = false;
    //
    this.cronapi.screen.notify('warning','Você deve enviar um arquivo.');
  }
  //
  fileExtension = this.cronapi.json.getProperty(fileData, 'fileExtension');
  //
  if (fileExtension != '.csv') {
    //
    isValid = false;
    //
    this.cronapi.screen.notify('warning','Você deve enviar uma planilha de extensão .csv');
  }
  return isValid;
}

/**
 * @function openModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 14:46:19
 *
 */
window.blockly.js.blockly.productEntry.UploadSheet.openModalArgs = [];
window.blockly.js.blockly.productEntry.UploadSheet.openModal = async function() {
 var e, fileData, isValid, fileExtension;
  //
  this.cronapi.screen.changeValueOfField("vars.excelFileToUpload", '');
  //
  this.cronapi.screen.showModal("modaUploadSheet");
}

/**
 * @function closeModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 26/05/2025, 14:46:19
 *
 */
window.blockly.js.blockly.productEntry.UploadSheet.closeModalArgs = [];
window.blockly.js.blockly.productEntry.UploadSheet.closeModal = async function() {
 var e, fileData, isValid, fileExtension;
  //
  this.cronapi.screen.hideModal("modaUploadSheet");
  //
  this.cronapi.screen.changeValueOfField("vars.excelFileToUpload", '');
}
