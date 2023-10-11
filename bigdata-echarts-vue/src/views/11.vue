<template>
  <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->

  <div id="main" style="width: 600px; height: 600px"></div>
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

import { get11Data } from "../api/api.js";
import { mapToValueMap11, proxyToArray } from "../utils/utils.js";

var option;

const charData = ref([]);
provide(THEME_KEY, "light");

onMounted(async () => {
  const { data } = await get11Data();
  charData.value = mapToValueMap11(data.data);

  console.log(charData.value);

  option = {
    tooltip: {
      trigger: "item",
    },
    legend: {
      top: "5%",
      left: "center",
      // doesn't perfectly work with our tricks, disable it
      selectedMode: false,
    },
    series: [
      {
        name: "Access From",
        type: "pie",
        radius: ["40%", "70%"],
        center: ["50%", "70%"],
        // adjust the start angle
        startAngle: 180,
        label: {
          show: true,
          formatter(param) {
            // correct the percentage
            return param.name + " (" + param.percent * 2 + "%)";
          },
        },
        data: [
          //   proxyToArray(charData.value),

          { name: null, value: 1517 },

          { name: "1", value: 16 },

          { name: "2", value: 20 },

          { name: "3", value: 28 },

          { name: "4+", value: 1419 },
          {
            // make an record to fill the bottom 50%
            value: 1517 + 16 + 20 + 28 + 1419,
            itemStyle: {
              // stop the chart from rendering this piece
              color: "none",
              decal: {
                symbol: "none",
              },
            },
            label: {
              show: false,
            },
          },
        ],
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
