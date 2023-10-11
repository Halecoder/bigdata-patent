<template>
  <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->

  <div id="main" style="width: 600px; height: 800px"></div>
  <el-container>
    <el-container>
      <el-main>
        <v-chart class="chart" v-if="option" :option="option" />
      </el-main>
    </el-container>
  </el-container>
  <el-aside width="200px">
    <vuetyped
      :strings="['面试官你好 我叫刘凯利', '来自天津']"
      :loop="false"
      :smart-backspace="true"
    >
      <div class="typing" /> </vuetyped
  ></el-aside>
</template>

<script setup>
import "echarts";

import * as echarts from "echarts/core";

import VChart, { THEME_KEY } from "vue-echarts";
import { provide, ref, onMounted } from "vue";

import { get4Data } from "../api/api.js";
import { mapToValueMap4, proxyToArray } from "../utils/utils.js";

var option;

const charData = ref([]);
provide(THEME_KEY, "light");

onMounted(async () => {
  const { data } = await get4Data();
  charData.value = mapToValueMap4(data.data);

  console.log(charData.value);

  option = {
    tooltip: {
      trigger: "item",
    },
    legend: {
      top: "5%",
      left: "center",
    },
    series: [
      {
        name: "Access From",
        type: "pie",
        radius: ["40%", "70%"],
        avoidLabelOverlap: false,
        itemStyle: {
          borderRadius: 10,
          borderColor: "#fff",
          borderWidth: 2,
        },
        label: {
          show: false,
          position: "center",
        },
        emphasis: {
          label: {
            show: true,
            fontSize: 40,
            fontWeight: "bold",
          },
        },
        labelLine: {
          show: false,
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
