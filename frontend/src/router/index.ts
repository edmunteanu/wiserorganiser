import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import Tabs from '../views/Tabs.vue'
import Login from '../views/Login.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login,
  },
  {
    path: '/tabs/',
    component: Tabs,
    children: [
      {
        path: '',
        redirect: 'timetable'
      },
      {
        path: 'timetable',
        component: () => import('@/views/TimetablePage.vue')
      },
      {
        path: 'tasks',
        component: () => import('@/views/TasksPage.vue')
      },
      {
        path: 'lecture/:name',
        component: () => import('@/views/LectureDetailsPage.vue'),
      },
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
