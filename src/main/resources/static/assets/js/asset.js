
$('document').ready(function() {
	$('table #editButton').on('click', function(event) {
		//event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(asset, status) {
			$('#idEdit').val(asset.id);
			$('#memberEdit').val(asset.member);
			$('#assettypeEdit').val(asset.assettype);
			$('#hardwarepurposeEdit').val(asset.hardwarepurpose);
			$('#macidEdit').val(asset.macid);
			$('#softwarepurposeEdit').val(asset.softwarepurpose);
			$('#licencetypeEdit').val(asset.licencetype);
			$('#licencedetailsEdit').val(asset.licencedetails);
			$('#expirydateEdit').val(asset.expirydate);
		});
		$('#editModel').modal('show');
	});


	$('.table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(asset, status) {
			$('#idDetail').val(asset.id);
			$('#memberDetail').val(asset.member);
			$('#assettypeDetail').val(asset.assettype);
			$('#hardwarepurposeDetail').val(asset.hardwarepurpose);
			$('#macidDetail').val(asset.macid);
			$('#softwarepurposeDetail').val(asset.softwarepurpose);
			$('#licencetypeDetail').val(asset.licencetype);
			$('#licencedetailsDetail').val(asset.licencedetails);
			$('#expirydateDetail').val(asset.expirydate);
			//$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$('#detailsModal').modal();
	});

	$('table #deleteButton').on('click', function(event) {
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModel').model('show');
	});

	
	$('#searchButton').on('click', function(event) {
		//var inputVal = document.getElementById("capital").value;
		// Displaying the value
		// alert(inputVal);
		//var inputVal = document.getElementById("capital").value;
		//document.getElementById("formID").submit();
		var input=$('#capital').val();
		//alert(input);
		$.ajax({
			type:"GET",
			url:"/country/description/"+input,
			
		       success: function(controllerData){
			alert(controllerData);
		}
		});
		//alert(document.getElementById("byCapital").value);
           // var op = document.getElementById("byCapital").value;
          //  alert(op);

	});
	
	//$('#example').DataTable();
});


