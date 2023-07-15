<template class="template">
   <div id="home">
     <div class="home-content">
<img src="../assets/head_bob.gif">
    <h1>{{ msg }}</h1>
    <h2>Your online Profile</h2>
    <ul>
      <router-link to="/login"><md-button class="">Sign in</md-button></router-link>
      <router-link to="/register">      <md-button class="md-raised md-primary">Get Started</md-button></router-link>
    </ul>
    <h2>About the Project</h2>
    <ul>
      <router-link to="/about"><md-button class="">Read More</md-button></router-link>
    </ul>
     </div>
    
  </div>
</template>

<script>
export default {
  name: "Home",
  props:{
    msg:"Hello World"
  },
  data: function() {
    return {
      menuVisible: false
    };
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
#home {
  // font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  img{
    max-width: 50%;
  }
}
.template{
  background-color: whitesmoke;
}
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
