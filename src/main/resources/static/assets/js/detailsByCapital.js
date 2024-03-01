$('document').ready(function(){
	$('#searchButton').on('click',function(event){
		var inputVal = document.getElementById("capital").value;
            
            document.getElementById("formID").submit();
            
            alert(document.getElementById("byCapital").value);
            var op = document.getElementById("byCapital").value;
            alert(op);
	});
});