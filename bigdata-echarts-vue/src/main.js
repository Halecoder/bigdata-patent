import './assets/main.css'
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// 导入打字机
import vuetyped from 'vue3typed'
import ElementPlus from 'element-plus'
import 'element-plus/theme-chalk/index.css'


// 设置Vue3的全局方法实例
// 代替Vue2的 Vue.use的全局方法
const app = createApp(App)
// 挂载打字机的全局方法 .use(vuetyped) 请无视.use(store).use(router)
app.use(vuetyped)
// 挂载实例
app.use(ElementPlus)

app.use(router)

app.mount('#app')
