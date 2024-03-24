import { createApp } from 'vue'
import App from './App.vue'
import Home from "@/components/Home.vue";
import Login from "@/components/pages/Login.vue";
import {createRouter,createWebHistory} from 'vue-router';
import CreateUser from "@/components/pages/CreateUser.vue";

const routes = [
    {path: '/',component: Home},
    {path: '/login',component: Login},
    {path: '/createUserPage',component: CreateUser}

]


const router = createRouter({
    history: createWebHistory(),
    routes

})
createApp(App).use(router).mount('#app')
