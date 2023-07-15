<template>
      <!-- <md-app  md-waterfall md-mode="flexible">
        <md-app-toolbar class="md-primary md-large">
          <div class="md-toolbar-row">
            <md-button class="md-icon-button" @click="menuVisible = !menuVisible">
              <md-icon>menu</md-icon>
            </md-button>

            <span class="md-title">Account</span>
          </div>
        </md-app-toolbar>

        <md-app-drawer :md-active.sync="menuVisible">
          <md-toolbar class="md-transparent" md-elevation="0">Navigation</md-toolbar>

          <md-list>
            <md-list-item>
              <md-icon>move_to_inbox</md-icon>
              <span class="md-list-item-text"><router-link to="../account/">Basic Information</router-link></span>
            </md-list-item>

            <md-list-item>
              <md-icon>send</md-icon>
              <span class="md-list-item-text"><router-link to="../account/address">Address Information</router-link></span>
            </md-list-item>

            <md-list-item>
              <md-icon>delete</md-icon>
              <span class="md-list-item-text">Reset your password</span>
            </md-list-item>

          </md-list>
        </md-app-drawer>
        <md-app-content>
             <router-view></router-view>
      </md-app-content>

      </md-app> -->

      <div>
                     <router-view></router-view>

      </div>
</template>

<script>
export default {
  name: "Account",
  data: function() {
    return {
      user: {},
      states: [],
      countries: [],
      menuVisible: false
    };
  }
};
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
.md-app {
   height: 100vh;
}
</style>
