<template>
  <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->

  <div id="main" style="width: 600px; height: 400px"></div>

  <v-chart class="chart" v-if="option" :option="option" />

  <vuetyped
    :strings="['7. 了解不同学科领域下的专利数量分布？']"
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

import { get7Data } from "../api/api.js";
import { mapToValueMap7, proxyToArray } from "../utils/utils.js";

var option;

const charData = ref([]);
provide(THEME_KEY, "light");

onMounted(async () => {
  const { data } = await get7Data();
  charData.value = mapToValueMap7(data.data);

  console.log(charData.value);

  option = {
    dataset: [
      {
        dimensions: ["subjectCode","patentCount"],
        source: proxyToArray(charData.value),
      },
      {
        transform: {
          type: "sort",
          config: { dimension: "patentCount", order: "desc" },
        },
      },
    ],
    xAxis: {
      type: "category",
      axisLabel: { interval: 0, rotate: 30 },
    },
    yAxis: {},
    series: {
      type: "bar",
      encode: { x: "subjectCode", y: "patentCount" },
      datasetIndex: 1,
    },
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