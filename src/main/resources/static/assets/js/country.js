
$('document').ready(function() {
	$('table #editButton').on('click', function(event) {
		//event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(country, status) {
			$('#idEdit').val(country.id);
			$('#descriptionEdit').val(country.description);
			$('#capitalEdit').val(country.capital);
			$('#codeEdit').val(country.code);
			$('#continentEdit').val(country.continent);
			$('#nationalityEdit').val(country.nationality);
		});
		$('#editModel').modal('show');
	});


	$('.table #detailsButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(country, status) {
			$('#idDetails').val(country.id);
			$('#descriptionDetails').val(country.description);
			$('#capitalDetails').val(country.capital);
			$('#codeDetails').val(country.code);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
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
		alert(input);
		$.ajax({
			type:"GET",
			url:"country/description/"+input,
			
		       success: function(input){
		alert(input);}
		})
		//alert(document.getElementById("byCapital").value);
           // var op = document.getElementById("byCapital").value;
          //  alert(op);

	});
});

