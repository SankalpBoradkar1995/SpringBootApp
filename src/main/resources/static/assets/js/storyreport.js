$.ajax({
	url: 'storydoughnut',
	success: function(pieResult){
		
		drawDonughtChart();
	}
});



function drawDonughtChart(){
	 document.addEventListener("DOMContentLoaded", () => {
                  echarts.init(document.querySelector("#trafficChart")).setOption({
                    tooltip: {
                      trigger: 'item'
                    },
                    legend: {
                      top: '5%',
                      left: 'center'
                    },
                    series: [{
                      name: 'Access From',
                      type: 'pie',
                      radius: ['40%', '70%'],
                      avoidLabelOverlap: false,
                      label: {
                        show: false,
                        position: 'center'
                      },
                      emphasis: {
                        label: {
                          show: true,
                          fontSize: '18',
                          fontWeight: 'bold'
                        }
                      },
                      labelLine: {
                        show: false
                      },
                      data: [{
                          value: 1048,
                          name: 'Search Engine'
                        },
                        {
                          value: 735,
                          name: 'Direct'
                        },
                        {
                          value: 580,
                          name: 'Email'
                        },
                        {
                          value: 484,
                          name: 'Union Ads'
                        },
                        {
                          value: 300,
                          name: 'Video Ads'
                        }
                      ]
                    }]
                  });
                });

}


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
    drilldown:{
	
}
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
	url: 'builtingraph',
	success: function(pieResult){
		
		//var member = JSON.parse(result).member;
		//var asset = JSON.parse(result).assettype;
		//drawLineChart(member, asset);
		//console.log(result);
		var series = [];
		var data = [];
		
		
		for(var i = 0; i < pieResult.length; i++){
			//console.log(i);
			var object = {};
			object.name = pieResult[i].assettype.toUpperCase();
			//console.log(object.name);
			object.y = pieResult[i].member;
			
			console.log(object.y);
			data.push(object);
		//	console.log(data);
		}
		var seriesObject = {
			name: 'Member',
			type: 'pie',
			radius: ['40%', '70%'],
			avoidLabelOverlap: false,
			label: {
                        show: false,
                        position: 'center'
                      },
                      emphasis: {
                        label: {
                          show: true,
                          fontSize: '18',
                          fontWeight: 'bold'
                        }
                      },
                      labelLine: {
                        show: false
                      },
			colorByPoint: true,
			data: data
		};
		series.push(seriesObject);
		
		//console.log(series);
		inbuildGraph(series);
	}
});


function inbuildGraph(series){
	document.addEventListener("DOMContentLoaded", () => {
                  echarts.init(document.querySelector("#trafficChart")).setOption({
                    tooltip: {
                      trigger: 'item'
                    },
                    legend: {
                      top: '5%',
                      left: 'center'
                    },
                    series: ser
                  });
                });
}