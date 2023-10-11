import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),

    }
  },

  server: {
    host: '0.0.0.0',
    port: 8991,
    // 是否开启 https
    https: false,
  },
  // 设置反向代理，跨域
  proxy: {
    '/api': {
      // 后台地址
      target: 'http://localhost:8080/',
      changeOrigin: true,
      rewrite: path => path.replace(/^\/api/, '')
    },
  },


})
