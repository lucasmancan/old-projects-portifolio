<template>
  <div class="main">
    <md-empty-state
      class="md-accent"
      md-icon="error"
      md-label="Page Not Found"
      md-description="Oops... You got lost, go to home page.">
    </md-empty-state>
    <router-link to=""></router-link>
  </div>
</template>

<script>
export default {
  name: 'NotFound'
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
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
.main{
  min-width: 100vw !important;
  min-height: 100vw !important;
}
</style>
