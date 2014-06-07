function inicializadores(){
	inicializadores(null);
}

function inicializadores(args){
	
	/**
	Inicializando touchSpin            
	*/
	$(".sppiner").TouchSpin();	
	
	/**
		Inicializando Mascaras
	*/
	inicializaMascaras();
	
	/**
	 * Inicializando Calendario
	 * */
	$('.pickerDiaMesAno').datetimepicker({
		pickTime:false,
		language:'pt-BR'
	});
}

function inicializaMascaras(){
	
	// CORREÇÃO DO UI-DATAPICKER DO JQUERY, QUE NÃO TEM EVENTO afterShow 
//	$.datepicker._updateDatepicker_original = $.datepicker._updateDatepicker;
//	$.datepicker._updateDatepicker = function(inst) {
//		$.datepicker._updateDatepicker_original(inst);
//		var afterShow = this._get(inst, 'afterShow');
//		if (afterShow)
//			afterShow.apply((inst.input ? inst.input[0] : null));  // trigger custom callback
//	}
//	
//	$( ".mesAno" ).datepicker({
//		dateFormat: 'mm/yy',
//        dayNames: ['Domingo','Segunda','Ter&ccedil;a','Quarta','Quinta','Sexta','S&aacute;bado','Domingo'],
//        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
//        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','S&aacute;b','Dom'],
//        monthNames: ['Janeiro','Fevereiro','Mar&ccedil;o','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
//        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
//        closeText: "Confirmar",
//		prevText: "Ante",
//		nextText: "Pr&oacute;x",
//		currentText: "M&ecirc;s Atual",
//    	dateFormat: "mm/yy",
//		changeMonth: true,
//		changeYear: true,
//		showAnim: "slideDown",
//        showButtonPanel: true,
//        afterShow : function(event) {
//	        $(".ui-datepicker-calendar").css('display', 'none');
//	        $('.ui-datepicker-close').attr('onClick', "gravaDataMesAnoCampo('"+$(this).attr('id')+"')");
//        }
////		,onClose: function(dateText, inst) { 
////	        var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
////	        var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
////	        $(this).datepicker('setDate', new Date(year, month, 1));
////	    }
//    });
//	$( ".diaMesAno" ).datepicker({
//		dateFormat: 'dd/mm/yy',
//        dayNames: ['Domingo','Segunda','Ter&ccedil;a','Quarta','Quinta','Sexta','S&aacute;bado','Domingo'],
//        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
//        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','S&aacute;b','Dom'],
//        monthNames: ['Janeiro','Fevereiro','Mar&ccedil;o','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
//        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
//        closeText: "Confirmar",
//		prevText: "Ante",
//		nextText: "Pr&oacute;x",
//		currentText: "M&ecirc;s Atual",
//    	dateFormat: "dd/mm/yy",
//		changeMonth: true,
//		changeYear: true,
//		showAnim: "slideDown",
//        showButtonPanel: true,
//        setDate: new Date()
//    });
	$('.mesAno').mask('00/0000').attr('placeholder',"__/_____").addClass('iconeCalendario');
	$('.diaMesAno').mask('00/00/0000').attr('placeholder',"__/__/_____").addClass('iconeCalendario');
	$('.cep').mask('00000-000').attr('placeholder',"_____-___");
	$('.cpf').mask('000.000.000-00', {reverse: true}).attr('placeholder',"___.___.___-__");
	$('.cnpj').mask('00.000.000/0000-00', {reverse: true}).attr('placeholder',"__.___.___/____-__");
	$('.money2').mask('000.000.000,00', {reverse: true}).attr('placeholder',"_,__");
	$('.money3').mask('000.000.000,000', {reverse: true}).attr('placeholder',"_,___");
	$('.money5').mask('000.000.000,00000', {reverse: true}).attr('placeholder',"_,_____");
	$('.numero').mask('000000000');
	$('.telefoneComDdd').attr('placeholder',"(__) _____-____");
	$('.telefoneComDdd').on('keyup', function(e){
		
		var phone2 = $('.telefoneComDdd').val();
		phone2 = phone2.replace(/\D/g, '');
		
		var len =  phone2.length;
		var mask = "(d) i-f";
		
		if(e.keyCode == 8){
			if($('.telefoneComDdd').val().length <= 9)
				phone2 = phone2.substr(0,len-1);
		}
		if(len <= 10){
			somaum = 0;
		}else{
			somaum = 1;
		}
		
		if(phone2.trim() != ""){
			mask = mask.replace('d', phone2.substr(0,2));
			mask = mask.replace('i', phone2.substr(2,4+somaum));
			mask = mask.replace('f', phone2.substr(6+somaum,4));
		}else{
			mask = "";
		}
		$(this).val(mask);

	});
	
}