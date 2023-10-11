import { createRouter, createWebHistory } from 'vue-router'
import echart from '../views/echart.vue'

// 创建一个空数组来存储路由配置
const routes = [];

// 循环从 '1' 到 '13'，生成路由配置
for (let i = 1; i <= 13; i++) {
  routes.push({
    path: `/${i}`,
    name: `${i}`,
    component: () => import(`../views/${i}.vue`)
  });
}


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
