<template>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->

    <div id="main" style="width: 600px; height: 400px"></div>

    <v-chart class="chart" v-if="option" :option="option" />

    <vuetyped
      :strings="['9. 专利数量靠前公司排名']"
      :loop="false"
      :smart-backspace="true"
    >
      <div class="typing" />
    </vuetyped>
  </template>

  <script setup>
  import "echarts";

  import "echarts-wordcloud";

  import * as echarts from "echarts/core";

  import VChart, { THEME_KEY } from "vue-echarts";
  import { provide, ref, onMounted } from "vue";

  import { get9Data } from "../api/api.js";
  import { mapToValueMap9, proxyToArray } from "../utils/utils.js";

  var option;

  const charData = ref([]);
  provide(THEME_KEY, "light");

  // 随机颜色
  let randcolor = () => {
    let r = 100 + ~~(Math.random() * 100);
    let g = 135 + ~~(Math.random() * 100);
    let b = 100 + ~~(Math.random() * 100);
    return `rgb(${r}, ${g}, ${b})`;
  };

  onMounted(async () => {
    const { data } = await get9Data();
    charData.value = mapToValueMap9(data.data);

    console.log(charData.value);

    option = {
      series: [
        {
          type: "wordCloud",
          //maskImage: maskImage,
          sizeRange: [15, 80],
          rotationRange: [0, 0],
          rotationStep: 45,
          gridSize: 10,
          shape: "pentagon",
          width: "100%",
          height: "50%",
          textStyle: {
            color: (params) => {
              return randcolor();
            },
            emphasis: {
              shadowBlur: 10,
              shadowColor: "#333",
            },
          },
          data: proxyToArray(charData.value),
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