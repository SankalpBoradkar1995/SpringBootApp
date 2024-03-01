$('document').ready(function(){
	$('table #editButton').on('click',function(event){		
		//event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(location, status){
			$('#idEdit').val(location.id);
			$('#ddlCountryEdit').val(location.countryid);
			$('#ddlStateEdit').val(location.stateid);
			$('#descriptionEdit').val(location.description);
			$('#cityEdit').val(location.city);
			$('#addressEdit').val(location.address);
			$('#detailsEdit').val(location.details);
		});			
		$('#editModel').modal('show');		
	});
});