<template class="template">
  <div class="centered-container">
      
    <md-content class="md-elevation-3">
        <div class="title">
        <h2>E-mail verification</h2>
      </div>

      <form class="form" novalidate @submit.prevent="validateAccount">
        <md-field :class="getValidationClass('email')">
          <label>E-mail</label>
          <md-input v-model="account.email" autofocus></md-input>
          <span class="md-error" v-if="!$v.account.email.required">The e-mail is required.</span>
          <span class="md-error" v-else-if="!$v.account.email.email">Invalid e-mail address.</span>
        </md-field>
           <div class="actions mt-10 md-layout md-alignment-center-center">
          <md-button class="md-raised md-primary" type="submit">Get a new Password</md-button>
        </div>
      </form>
      <md-snackbar :md-active.sync="saved">{{message}}</md-snackbar>

      <div class="actions md-layout md-alignment-center-space-between">
        <router-link to="/login">Sign in</router-link>
        <router-link to="/register">Create a new Profile</router-link>
      </div>
      <div class="loading-overlay" v-if="loading">
        <md-progress-spinner md-mode="indeterminate" :md-stroke="2"></md-progress-spinner>
      </div>
    </md-content>
    <div class="background"/>
  </div>
</template>

<script>
import auth from "../services/auth-service";
import router from "vue-router";
import { validationMixin } from "vuelidate";
import { required, email } from "vuelidate/lib/validators";

export default {
  name: "password",
  mixins: [validationMixin],
  data: function() {
    return {
      account: {
        email: "lucasfmancan@hotmail.com",
        password: "Patrik123456"
      },
      loading: false,
      saved: false,
      message:false,
    };
  },
  validations: {
    account: {
      email: {
        required,
        email
      }
    }
  },
  methods: {
    getValidationClass(fieldName) {
      let field = null;
      if (this.$v.account[fieldName]) {
        field = this.$v.account[fieldName];
      }
      if (field) {
        return {
          "md-invalid": field.$invalid && field.$dirty
        };
      }
    },
    validateAccount() {
      this.$v.account.$touch();
      if (!this.$v.account.$invalid) {
        this.resetPassword();
      }
    },
    resetPassword() {
      this.loading = true;
      auth
        .resetPassword(this.account)
        .then(res => {
          console.log(this.account);
        this.message = res.message;
        this.saved = true;
        this.loading = false;

        })
        .catch(error => {
          console.log("ERROR ", error);
        this.message = error.message;
        this.saved = true;
        this.loading = false;


        });
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
.centered-container{
  background-color: whitesmoke;
}
.mt-10 {
  margin-bottom: 10px;
}
.centered-container {
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  height: 100vh;
  .title {
    text-align: center;
    margin-bottom: 10px;
    img {
      max-width: 150px;
    }
  }
  


  .actions {
    .md-button {
      margin: 0;
    }
  }
  .form {
    margin-bottom: 30px;
  }
  .background {
    position: absolute;
    height: 100%;
    width: 100%;
    top: 0;
    bottom: 0;
    right: 0;
    left: 0;
    z-index: 0;
  }
  .md-content {
    z-index: 1;
    padding: 40px;
    width: 100%;
    max-width: 400px;
    position: relative;
  }
  .loading-overlay {
    z-index: 10;
    top: 0;
    left: 0;
    right: 0;
    position: absolute;
    width: 100%;
    height: 100%;
    background: rgba(255, 255, 255, 0.9);
    display: flex;
    align-items: center;
    justify-content: center;
  }
}
</style>
