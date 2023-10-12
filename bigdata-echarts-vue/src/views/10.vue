<template>
  <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->

  <div id="main" style="width: 1000px; height: 400px"></div>

  <v-chart class="chart" v-if="option" :option="option" />

  <vuetyped
    :strings="['10. 专利法律状态随时间的变化如何？']"
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

import { get10Data } from "../api/api.js";
import { mapToValueMap10, proxyToArray } from "../utils/utils.js";

var option;

const charData = ref([]);
provide(THEME_KEY, "light");

onMounted(async () => {
  const { data } = await get10Data();
  charData.value = mapToValueMap10(data.data);

  console.log(charData.value);

  option = {
    legend: {},
    tooltip: {},
    dataset: {
      dimensions: ["legalStatus", "1911", "2017", "2018"],
      source: [
        { legalStatus: "US - Expired - Lifetime", 1911: 167, 2017: 150, 2018: 93.7 },
        { legalStatus: "AR - SI - Active ", 1911: 83.1, 2017: 73.4, 2018: 55.1 },
        { legalStatus: "AR - Active Active Active", 1911: 86.4, 2017: 65.2, 2018: 82.5 },
        { legalStatus: "AR - Pending  ", 1911: 72.4, 2017: 53.9, 2018: 39.1 },
      ],
    },
    xAxis: { type: "category" },
    yAxis: {},
    // Declare several bar series, each will be mapped
    // to a column of dataset.source by default.
    series: [{ type: "bar" }, { type: "bar" }, { type: "bar" }],
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
