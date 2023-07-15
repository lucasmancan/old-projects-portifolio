import Router from 'vue-router'
import Home from './components/Home'
import Login from './components/Login'
import Register from './components/Register'
import Account from './components/Account'
import User from './components/User'
import NotFound from './components/NotFound'
import About from './components/About'
import authService from './services/auth-service'
import Password from './components/Password'

const router = new Router({
    mode: 'history',
    routes: [{
            path: '/',
            component: Home,
            meta: {
                requiresAuth: false
            }
        },
        {
            name: 'login',
            path: '/login',
            component: Login,
            meta: {
                requiresAuth: false
            }

        },
        {
            name: 'resetPassword',
            path: '/resetpassword',
            component: Password,
            meta: {
                requiresAuth: false
            }

        },
        {
            name: 'about',
            path: '/about',
            component: About,
            meta: {
                requiresAuth: false
            }

        },
        {
            name: 'register',
            path: '/register',
            component: Register,
            meta: {
                requiresAuth: false
            }

        },
        {
            name: 'profile',
            path: '/profile',
            component: Account,
            meta: {
                requiresAuth: true
            },
            children: [{
                    path: '',
                    component: User,
                    meta: {
                        requiresAuth: true
                    }
                },

            ]
        },
        {
            name: 'notfound',
            path: '/*',
            component: NotFound,
            meta: {
                requiresAuth: false
            }

        }

    ]
})
router.beforeResolve((to, from, next) => {

    if (!to.matched.length) {
        next('/notFound');
      }else{
        if (to.meta.requiresAuth) {
            if (authService.isValid()) {
                next();
            } else {
                next({
                    name: 'login'
                });
            }
        } else {
            if (authService.isValid()) {
                next('/profile');
            } else {
                next();
            }
        }
      }

  
})



export default router;