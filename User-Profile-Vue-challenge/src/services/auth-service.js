import Http from './http'; // não precisa de .js
// import obj from '../models/user'

export default{
    login : ({email, password}) => Http.post('/auth', {email, password}),

    isValid : () => localStorage.getItem('user-token') != null,

    resetPassword: (account) => Http.post('/auth/reset', account)
} 
