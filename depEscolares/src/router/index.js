import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // Nuevas rutas agregadas
    {
      path: '/login',
      name: 'login',
      component: () => import('@/components/autenticacion/loginFrom.vue'),
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('@/components/autenticacion/register.vue'),
    },
    {
      path: '/herramientas',
      name: 'herramientas',
      component: () => import('@/components/Herramientas/listaHerramientas.vue'),
    },
    {
      path: '/herramientas/admin',
      name: 'herramientasAdmin',
      component: () => import('@/components/herramientasAdmin/agregarHerramienta.vue'),
    },
    {
      path: '/prestamos',
      name: 'prestamos',
      component: () => import('@/components/prestamos/formularioPrestamos.vue'),
    },
    {
      path: '/usuarios',
      name: 'usuarios',
      component: () => import('@/components/Usuarios/listaUsuarios.vue'),
    },
  ],
})

export default router
