/**
 * 
 */

$('document').ready(function() {
	
	$('table #editButton').on('click',function(event){		
		//event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(defect, status){
			$('#idEdit').val(defect.id);
			$('#summaryEdit').val(defect.summary);
			$('#priorityEdit').val(defect.priority);
			$('#storyEdit').val(defect.userstory.summary);
			$('#statusEdit').val(defect.status);
			$('#componentEdit').val(defect.component);
			$('#asigneeEdit').val(defect.asignee);
			$('#reporterEdit').val(defect.reporter);
			$('#sprintEdit').val(defect.sprint);
			$('#descriptionEdit').val(defect.description);
			$('#commentEdit').val(defect.comment);
		});			
		$('#editModel').modal('show');		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(defect, status){
			$('#idDetail').val(defect.id);
			$('#summaryDetail').val(defect.summary);
			$('#priorityDetail').val(defect.priority);
			$('#statusDetail').val(defect.status);
			$('#componentDetail').val(defect.component);
			$('#asigneeDetail').val(defect.asignee);
			$('#reporterDetail').val(defect.reporter);
			$('#sprintDetail').val(defect.sprint);
			$('#descriptionDetail').val(defect.description);
			$('#commentDetail').val(defect.comment);
			$('#lastModifiedByDetail').val(state.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('table #deleteButton').on('click',function(event){
	var href=$(this).attr('href');
	$('#confirmDeleteButton').attr('href',href);
	$('#deleteModel').model('show');
});
});