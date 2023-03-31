import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  resolve: {
    alias: {
      '@' : path.resolve(__dirname, './src')
    },
  },
  plugins: [vue()],
  server: {
    port: 3500,
    proxy: {
      '/api' : {
        target: 'http://localhost:7500',
        ws: true,
        changeOrigin: true
      }
    }
  }
})
