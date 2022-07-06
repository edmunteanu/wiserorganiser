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
        redirect: 'timetables'
      },
      {
        path: 'timetables',
        component: () => import('@/views/TimetablesPage.vue')
      },
      {
        path: 'tasks',
        component: () => import('@/views/TasksPage.vue')
      },
      { 
        path: 'tasks/:id',
        component: () => import('@/views/TaskDetailsPage.vue'),
      },
      {
        path: 'lectures/:id',
        component: () => import('@/views/LectureDetailsPage.vue'),
      },
      {
        path: 'timetables/:id',
        component: () => import('@/views/TimetableDetailsPage.vue'),
      },
      {
        path: 'tasks/createtask',
        component: () => import('@/views/CreateTaskPage.vue'),
      },
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
