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
 * @since 16/05/2025, 11:43:23
 *
 */
window.blockly.js.blockly.product.UploadSheet.readAndConvertArgs = [];
window.blockly.js.blockly.product.UploadSheet.readAndConvert = async function() {
 var productsList, fileJson, e, item;
  //
  try {
     //
    fileJson = (await this.cronapi.client('blockly.js.blockly.product.UploadSheet.buildFileAsJson').run());
    //
    if ((await this.cronapi.client('blockly.js.blockly.product.UploadSheet.validate').run(fileJson))) {
      //
      this.cronapi.util.callServerBlocklyAsynchronous('blockly.product.ConvertProductsOnSheet:handleProductsUpdateProcess', async function(sender_item) {
          item = sender_item;
        //
        this.cronapi.screen.refreshDatasource("Product", 'true');
      }.bind(this), fileJson);
    } else {
      //
      this.cronapi.util.throwException(this.cronapi.util.createException('Erro ao ler a planilha com os produtos atualizados.'));
    }
   } catch (e_exception) {
        e = e_exception;
     //
    this.cronapi.util.throwException(e);
   }
}

/**
 * @function buildFileAsJson
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 16/05/2025, 11:43:23
 *
 */
window.blockly.js.blockly.product.UploadSheet.buildFileAsJsonArgs = [];
window.blockly.js.blockly.product.UploadSheet.buildFileAsJson = async function() {
 var productsList, fileJson, e, item;
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
 * @since 16/05/2025, 11:43:23
 *
 */
window.blockly.js.blockly.product.UploadSheet.validateArgs = [{ description: 'fileData', id: 'b1d364dc' }];
window.blockly.js.blockly.product.UploadSheet.validate = async function(fileData) {
 var productsList, fileJson, e;
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
 * @since 16/05/2025, 11:43:23
 *
 */
window.blockly.js.blockly.product.UploadSheet.openModalArgs = [];
window.blockly.js.blockly.product.UploadSheet.openModal = async function() {
 var productsList, fileJson, e, item;
  //
  this.cronapi.screen.changeValueOfField("vars.excelFileToUpload", '');
  //
  this.cronapi.screen.showModal("modal97740");
}

/**
 * @function closeModal
 *
 *
 *
 *
 * @author Andre Lucio Rocha Wanderley
 * @since 16/05/2025, 11:43:23
 *
 */
window.blockly.js.blockly.product.UploadSheet.closeModalArgs = [];
window.blockly.js.blockly.product.UploadSheet.closeModal = async function() {
 var productsList, fileJson, e, item;
  //
  this.cronapi.screen.hideModal("modal97740");
  //
  this.cronapi.screen.changeValueOfField("vars.excelFileToUpload", '');
}
