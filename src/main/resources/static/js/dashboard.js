/* globals Chart:false, feather:false */
var links = document.getElementsByClassName("category")
var contents = document.getElementsByClassName("content")
for(var i=0;i<links.length;i++){
  links[i].index = i;
  links[i].onclick = function(){　　　　　　　　　　//对当前点击的按钮赋予active类名及显示当前按钮对应的内容
    for(var j=0;j<links.length;j++){
      links[j].className = links[j].className.replace(' active', '').trim();
      contents[j].className = contents[j].className.replace(' show', '').trim();
    }
    this.className = this.className + ' active';
    contents[this.index].className = contents[this.index].className + ' show';
  };
}

(function () {
  'use strict'
  feather.replace()

  var timelist=[]//记录时间
  var bodyTempList=[]//记录体温
  var pulseRateList=[]//记录脉率
  var breathRateList=[]//记录呼吸频率
  var bloodPressureList=[]//记录血压
  var bloodOxygenList=[]//记录血氧
  var bloodSugarList=[]//记录血糖
  var datalist = document.getElementById('pickListModels').value;
  console.log(datalist);
  // datalist = eval(datalist);
  datalist = eval("(" + datalist + ")");

  for (var i in datalist) {
    var data = datalist[i];
    var date = new Date(parseInt(data.time)).toLocaleString();
    console.log(date);
    var n = date.length;
    timelist.push(date.substring(0,n-8))
    bodyTempList.push(data.bodyTemp)
    pulseRateList.push(data.pulseRate)
    breathRateList.push(data.breathRate)
    bloodPressureList.push(data.bloodPressure)
    bloodOxygenList.push(data.bloodOxygen)
    bloodSugarList.push(data.bloodSugar)
  }


  // Graphs
  var ctx = document.getElementById('myChart')
  // eslint-disable-next-line no-unused-vars
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: timelist,
      datasets: [{
        data: pulseRateList,
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })

  var ctx1 = document.getElementById('myChart1')
  // eslint-disable-next-line no-unused-vars
  var myChart1 = new Chart(ctx1, {
    type: 'line',
    data: {
      labels: timelist,
      datasets: [{
        data: bloodPressureList,
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })

  var ctx2 = document.getElementById('myChart2')
  // eslint-disable-next-line no-unused-vars
  var myChart2 = new Chart(ctx2, {
    type: 'line',
    data: {
      labels: timelist,
      datasets: [{
        data: breathRateList,
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })

  var ctx3 = document.getElementById('myChart3')
  // eslint-disable-next-line no-unused-vars
  var myChart3 = new Chart(ctx3, {
    type: 'line',
    data: {
      labels: timelist,
      datasets: [{
        data: bodyTempList,
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })

  var ctx4 = document.getElementById('myChart4')
  // eslint-disable-next-line no-unused-vars
  var myChart4 = new Chart(ctx4, {
    type: 'line',
    data: {
      labels: timelist,
      datasets: [{
        data: bloodOxygenList,
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })

  var ctx5 = document.getElementById('myChart5')
  // eslint-disable-next-line no-unused-vars
  var myChart5 = new Chart(ctx5, {
    type: 'line',
    data: {
      labels: timelist,
      datasets: [{
        data: bloodSugarList,
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })

})()
