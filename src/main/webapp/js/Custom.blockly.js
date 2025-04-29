(function() {
  'use strict';

  this.cronapi = this.cronapi || {};

   /**
   * @categoryName Custom Functions
   */
  this.cronapi.myfunctions = this.cronapi.myfunctions || {};

  let debounceTimeout;
  
  /**
   * @type function
   * @name Debouncer Chamada Servidor
   * @description método para realizar debounce
   * @multilayer false
   * @param {ObjectType.STRING} params O parâmetro de entrada a ser filtrado
   * @param {ObjectType.STRING} caminho Caminho do bloco a ser chamado
   * @param {ObjectType.STRING} metodo Nome do método a ser chamado no bloco
   * @returns {ObjectType.STRING}
   */
  this.cronapi.myfunctions.debounce = function(params, caminho, metodo) {
    clearTimeout(debounceTimeout);

    debounceTimeout = setTimeout(() => {
      this.cronapi.util.callServerBlocklyNoReturn(
        caminho,
        metodo, 
        [params]
      );

    }, 250);
    
    return params;
  };
  

}).bind(window)();