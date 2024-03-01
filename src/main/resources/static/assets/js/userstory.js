/**
 * 
 */

$('document').ready(function() {
	
	$('table #editButton').on('click',function(event){		
		//event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(story, status){
			$('#idEdit').val(story.id);
			$('#summaryEdit').val(story.summary);
			$('#descriptionEdit').val(story.description);
			$('#reporterEdit').val(story.reporter);
			$('#asigneeEdit').val(story.asignee);
			$('#priorityEdit').val(story.priority);
			$('#statusEdit').val(story.status);
			$('#storypointEdit').val(story.storypoint);
			$('#sprintEdit').val(story.sprint);
			$('#acceptancecriteriaEdit').val(story.acceptancecriteria);
			$('#commentEdit').val(story.comment);
		});			
		$('#editModel').modal('show');		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(story, status){
			$('#idDetail').val(story.id);
			$('#summaryDetail').val(story.summary);
			$('#descriptionDetail').val(story.description);
			$('#reporterDetail').val(story.reporter);
			$('#asigneeDetail').val(story.asignee);
			$('#priorityDetail').val(story.priority);
			$('#statusDetail').val(story.status);
			$('#storypointDetail').val(story.storypoint);
			$('#sprintDetail').val(story.sprint);
			$('#acceptancecriteriaDetail').val(story.acceptancecriteria);
			$('#commentDetail').val(story.comment);
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