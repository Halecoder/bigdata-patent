<template>
  <router-view class="router-view" v-slot="{ Component }">
    <transition name="fade">
        <component :is="Component" />
    </transition>
  </router-view>
</template>

<script setup>
import { onMounted, onBeforeUnmount, ref } from "vue";
import { useRoute, useRouter } from "vue-router";

// 定义一个变量来存储当前路由的索引
const currentRouteIndex = ref(1);

// 获取路由对象
const route = useRoute();
const router = useRouter();

// 定义滚轮事件处理函数
const handleMouseWheel = (event) => {
  if (event.deltaY > 0) {
    // 向下滚动，切换到下一个路由
    switchToNextRoute();
  } else if (event.deltaY < 0) {
    // 向上滚动，切换到上一个路由
    switchToPreviousRoute();
  }
};

// 定义切换到下一个路由的方法
const switchToNextRoute = () => {
  if (currentRouteIndex.value < 12) {
    const nextIndex = currentRouteIndex.value + 1;
    router.push(`/${nextIndex}`);
  }
};

// 定义切换到上一个路由的方法
const switchToPreviousRoute = () => {
  if (currentRouteIndex.value > 1) {
    const previousIndex = currentRouteIndex.value - 1;
    router.push(`/${previousIndex}`);
  }
};

// 监听滚轮事件
onMounted(() => {
  window.addEventListener("wheel", handleMouseWheel);
});

// 移除滚轮事件监听器
onBeforeUnmount(() => {
  window.removeEventListener("wheel", handleMouseWheel);
});

// 监听路由变化，更新当前路由的索引
router.afterEach((to) => {
  const index = to.meta.index;
  if (index) {
    currentRouteIndex.value = index;
  }
});
</script>

<style scoped>



</style>
