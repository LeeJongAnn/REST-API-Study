import { createApp } from 'vue'
import App from './App.vue'
import Home from "@/components/Home.vue";
import Login from "@/components/pages/Login.vue";
import {createRouter,createWebHistory} from 'vue-router';

const routes = [
    {path: '/',component: Home},
    {path: '/login',component: Login},

]


const router = createRouter({
    history: createWebHistory(),
    routes

})
createApp(App).use(router).mount('#app')
