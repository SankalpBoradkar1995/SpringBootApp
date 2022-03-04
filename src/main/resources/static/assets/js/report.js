$.ajax({
	url: 'piegraph',
	success: function(pieResult){
		
		//var member = JSON.parse(result).member;
		//var asset = JSON.parse(result).assettype;
		//drawLineChart(member, asset);
		//console.log(result);
		var series = [];
		var data = [];
		var drilldown = [];
		
		for(var i = 0; i < pieResult.length; i++){
			//console.log(i);
			var object = {};
			object.name = pieResult[i].assettype.toUpperCase()+' '+'Is assigned to '+pieResult[i].member.toUpperCase()+' '+'since ';
			//console.log(object.name);
			object.y = pieResult[i].asgdate;
			
			console.log(object.y);
			data.push(object);
		//	console.log(data);
		}
		var seriesObject = {
			name: 'Member',
			colorByPoint: true,
			data: data
		};
		series.push(seriesObject);
		
		console.log(series);
		drawPieChart(series);
	}
});


function drawPieChart(series){
	Highcharts.chart('chartContainer', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: 'Asset Allocation'
    },
    tooltip: {
        formatter: function() {
	    		return '<strong>'+this.key+': </strong>'+ this.y;
		    }
    },
    plotOptions: {
        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {point.y}'
	            }
	        }
    },
    series: series,
  
});
}

$.ajax({
	url: 'linegraphdata',
	success: function(lineResult){
		var member=JSON.parse(lineResult).member;
		var asset=JSON.parse(lineResult).assettype;
		drawLineChart(member, asset)
	}
	
});

function drawLineChart(member, asset){
	Highcharts.chart(assetline,{
	chart: {
		type: 'line',
		weidth: 500
	},
	title: {
		text: 'Line Graph'
	},
	xAxis: {
		categories: member
	},
	tooltip: {
		formatter: function(){
			//console.log(this);
			return '<strong>'+this.x+' '+'Assigned since'+': </strong>'+this.y;
		}
	},
	series: [{
		data: asset
	}]
});
}

$.ajax({
	url: 'pirgraphdata',
	success: function(pieResult){
		
		var series = [];
		var data = [];
		
		var obj = pieResult;
		const values = Object.keys(obj);
		for (const n of values){
			var object = {};
			object.name = n;
			object.y = obj[n];
			data.push(object);
			console.log(data);
		}
		
		var seriesObject = {
			name: 'Sprint',
			colorByPoint: true,
			data: data
		};
		series.push(seriesObject);
		storyGraph(series);
	}
});


function storyGraph(series){
	Highcharts.chart('storycontainer', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: 'Story Status per overall count'
	    },
	    tooltip: {
	    	formatter: function() {
	    		return '<strong>'+this.key+': </strong>'+ this.y;
		    }
	    },
	    accessibility: {
        point: {
            valueSuffix: ':'
        }
    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {point.y}'
	            }
	        }
	    },
	    series: series
	});
}


$.ajax({
	url: 'piechartbypriority',
	success: function(pieResult){
		
		var series = [];
		var data = [];
		
		var obj = pieResult;
		const values = Object.keys(obj);
		for (const n of values){
			var object = {};
			object.name = n;
			object.y = obj[n];
			data.push(object);
			console.log(data);
		}
		
		var seriesObject = {
			name: 'Sprint',
			colorByPoint: true,
			data: data
		};
		series.push(seriesObject);
		priorityGraph(series);
	}
});


function priorityGraph(series){
	Highcharts.chart('prioritycontainer', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: 'Story Status per priority'
	    },
	    tooltip: {
	    	formatter: function() {
	    		return '<strong>'+this.key+': </strong>'+ this.y;
		    }
	    },
	    accessibility: {
        point: {
            valueSuffix: ':'
        }
    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {point.y}'
	            }
	        }
	    },
	    series: series
	});
}
