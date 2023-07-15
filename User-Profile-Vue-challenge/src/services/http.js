import axios from 'axios';


const client = axios.create({
  baseURL: 'https://your-profile-api.herokuapp.com/',
  timeout: 8000,
  headers: {'Authorization':localStorage.getItem('user-token'), 'Content-type': 'application/json', 'Accept': 'application/json'}
});

client.interceptors.response.use((response) => {
    return response.data;
  },(error) => {
    if (error.response.status === 401) {     
      
      return error.response.data ;
    }
    return error.response.data ;
  });

  client.interceptors.request.use((request) => {
    request.headers.Authorization = "Bearer "+localStorage.getItem('user-token');
    return request;
  });
 
export default client; 