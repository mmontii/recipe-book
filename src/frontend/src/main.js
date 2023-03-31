import { createApp } from 'vue'
import '@/assets/style.css'
import App from './App.vue'
import router from '@/router'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"
import "bootstrap-icons/font/bootstrap-icons.css"
import VueAxios from 'vue-axios';
import axios from 'axios'

const app = createApp(App)
app.use(VueAxios, axios)
app.use(router)
app.mount('#app')
