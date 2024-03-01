$(document).ready(function(){
    $.ajax({ url: "storycount",
        
        success: function(count){
           //alert(count);
            $("#storycount").append(JSON.stringify(count));
        }
    });
    
    $.ajax({ url: "defectcount",
        
        success: function(defectcount){
           //alert(count);
            $("#defectcount").append(JSON.stringify(defectcount));
        }
    });
});