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
        component: () => import('@/views/timetables/TimetablesPage.vue')
      },
      {
        path: 'timetables/:id',
        component: () => import('@/views/timetables/TimetableDetailsPage.vue'),
      },
      {
        path: 'tasks',
        component: () => import('@/views/tasks/TasksPage.vue')
      },
      { 
        path: 'tasks/:id',
        component: () => import('@/views/tasks/TaskDetailsPage.vue'),
      },
      {
        path: 'timetables/:id/tasks/new',
        component: () => import('@/views/tasks/NewTaskPage.vue'),
      },
      {
        path: 'lectures/:id',
        component: () => import('@/views/lectures/LectureDetailsPage.vue'),
      },
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
