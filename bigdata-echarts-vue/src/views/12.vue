<template>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->

    <div id="main" style="width: 600px; height: 600px"></div>

    <v-chart class="chart" v-if="option" :option="option" />

    <vuetyped
      :strings="['14. 查询2018年专利数量按事务类型分布情况']"
      :loop="false"
      :smart-backspace="true"
    >
      <div class="typing" />
    </vuetyped>
  </template>

  <script setup>
  import "echarts";

  import * as echarts from "echarts/core";

  import VChart, { THEME_KEY } from "vue-echarts";
  import { provide, ref, onMounted } from "vue";

  import { get14Data } from "../api/api.js";
  import { mapToValueMap14, proxyToArray } from "../utils/utils.js";

  var option;

  const charData = ref([]);
  provide(THEME_KEY, "light");

  onMounted(async () => {
    const { data } = await get14Data();
    charData.value = mapToValueMap14(data.data);

    console.log(charData.value);

    option = {
      title: {
        text: "2018年事务分布图",
        subtext: "事务分布",
        left: "center",
      },
      tooltip: {
        trigger: "item",
      },
      legend: {
        orient: "vertical",
        left: "left",
      },
      series: [
        {
          name: "Access From",
          type: "pie",
          radius: "50%",
          data: proxyToArray(charData.value),
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: "rgba(0, 0, 0, 0.5)",
            },
          },
        },
      ],

    };
    renderChart();
  });

  // 在这里定义渲染图表的函数
  function renderChart() {
    // 确保 option 有值后再渲染图表
    if (option) {
      // 在这里执行渲染图表的操作
      const chart = echarts.init(document.getElementById("main"));
      chart.setOption(option);
    }
  }
  </script>
  <style scoped>
  #main {
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
  }
  .typing {
    font-size: 30px;
    font-weight: 600;
    color: #409eff;
    margin-top: -200px;
    margin-left: 50px;
  }
  </style>