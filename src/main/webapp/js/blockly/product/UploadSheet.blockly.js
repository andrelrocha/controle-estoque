window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.product = window.blockly.js.blockly.product || {};
window.blockly.js.blockly.product.UploadSheet = window.blockly.js.blockly.product.UploadSheet || {};

/**
 * @function readAndConvert
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 12:55:28
 *
 */
window.blockly.js.blockly.product.UploadSheet.readAndConvertArgs = [];
window.blockly.js.blockly.product.UploadSheet.readAndConvert = async function() {
 var e, fileJson, item, serverResponse;
  //
  fileJson = (await this.cronapi.client('blockly.js.blockly.product.UploadSheet.buildFileAsJson').run());
  //
  if ((await this.cronapi.client('blockly.js.blockly.product.UploadSheet.validate').run(fileJson))) {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.product.ConvertProductsOnSheet:handleProductsUpdateProcess', async function(sender_serverResponse) {
        serverResponse = sender_serverResponse;
      //
      if (this.cronapi.json.getProperty(serverResponse, 'success')) {
        //
        this.cronapi.screen.notify('success',this.cronapi.json.getProperty(serverResponse, 'message'));
        //
        this.cronapi.screen.refreshDatasource("Product", 'true');
        //
        (await this.cronapi.client('blockly.js.blockly.product.UploadSheet.closeModal').run());
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
 * @since 27/05/2025, 12:55:28
 *
 */
window.blockly.js.blockly.product.UploadSheet.buildFileAsJsonArgs = [];
window.blockly.js.blockly.product.UploadSheet.buildFileAsJson = async function() {
 var e, fileJson, item, serverResponse;
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
 * @since 27/05/2025, 12:55:28
 *
 */
window.blockly.js.blockly.product.UploadSheet.validateArgs = [{ description: 'fileData', id: 'b1d364dc' }];
window.blockly.js.blockly.product.UploadSheet.validate = async function(fileData) {
 var e, fileJson, item;
  //
  isValid = true;
  //
  if (this.cronapi.logic.isNullOrEmpty(fileData)) {
    //
    isValid = false;
    //
    this.cronapi.screen.notify('error','Você deve enviar um arquivo.');
  }
  //
  fileExtension = this.cronapi.json.getProperty(fileData, 'fileExtension');
  //
  if (fileExtension != '.csv') {
    //
    isValid = false;
    //
    this.cronapi.screen.notify('error','Você deve enviar uma planilha de extensão .csv');
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
 * @since 27/05/2025, 12:55:28
 *
 */
window.blockly.js.blockly.product.UploadSheet.openModalArgs = [];
window.blockly.js.blockly.product.UploadSheet.openModal = async function() {
 var e, fileJson, item, serverResponse;
  //
  this.cronapi.screen.changeValueOfField("vars.excelFileToUpload", '');
  //
  this.cronapi.screen.showModal("modalUploadSheet");
}

/**
 * @function closeModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 27/05/2025, 12:55:28
 *
 */
window.blockly.js.blockly.product.UploadSheet.closeModalArgs = [];
window.blockly.js.blockly.product.UploadSheet.closeModal = async function() {
 var e, fileJson, item, serverResponse;
  //
  this.cronapi.screen.hideModal("modalUploadSheet");
  //
  this.cronapi.screen.changeValueOfField("vars.excelFileToUpload", '');
}
