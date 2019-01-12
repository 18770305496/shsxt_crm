<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 引入 echarts.js -->
    <script src="${ctx}/js/echarts.min.js"></script>
    <script src="${ctx}/jquery-easyui-1.3.3/jquery.min.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    var ctx = '${ctx}';
    $.ajax({
        url: ctx + '/report/queryServeType',
        success:function (data) {

            console.log(data);

            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            myChart.title = '客户服务分析';

            var nameArr = [];
            var valueArr = [];

            $(data).each(function () {
                nameArr.push(this.name);
                valueArr.push(this.value);
            });

            option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        crossStyle: {
                            color: '#999'
                        }
                    }
                },
                toolbox: {
                    feature: {
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                legend: {
                    data:['客户服务']
                },
                xAxis: [
                    {
                        type: 'category',
                        data: nameArr,
                        axisPointer: {
                            type: 'shadow'
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '数量',
                        min: 0,
                        max: 10,
                        interval: 1,
                        axisLabel: {
                            formatter: '{value} 人'
                        }
                    }
                ],
                series: [
                    {
                        name:'客户服务',
                        type:'pie',// bar 状图 line 折线图 pie 饼图
                        data:valueArr
                    }
                ]
            };



            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    });

</script>
</body>
</html>