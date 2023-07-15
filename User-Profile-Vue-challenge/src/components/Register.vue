<template>
  <div class="centered-container">
    <md-content class="md-elevation-3">
      <form class="form" novalidate @submit.prevent="validateUser">
        <md-field :class="getValidationClass('firstName')">
          <label>First Name</label>
          <md-input v-model="user.firstName" autofocus></md-input>
          <span class="md-error" v-if="!$v.user.firstName.required">The first name is required.</span>
          <span class="md-error" v-else-if="!$v.user.firstName.maxLength">Invalid first name address.</span>
        </md-field>
        <md-field :class="getValidationClass('lastName')">
          <label>Last Name</label>
          <md-input v-model="user.lastName"></md-input>
          <span class="md-error" v-if="!$v.user.lastName.required">The last name is required.</span>
          <span class="md-error" v-else-if="!$v.user.lastName.maxLength">Invalid last name address.</span>
        </md-field>
        <md-field :class="getValidationClass('email')">
          <label>E-mail</label>
          <md-input v-model="user.email"></md-input>
          <span class="md-error" v-if="!$v.user.email.required">The e-mail is required.</span>
          <span class="md-error" v-else-if="!$v.user.email.email">Invalid e-mail address.</span>
        </md-field>

        <md-field  :class="getValidationClass('password')">
          <label>Password</label>
          <md-input v-model="user.password" type="password"></md-input>
          <span class="md-error" v-if="!$v.user.password.required">The password is required.</span>
        </md-field>
        <md-field  :class="getValidationClass('passwordConfirmation')">
          <label>Password Confirmation</label>
          <md-input v-model="user.passwordConfirmation" type="password"></md-input>
             <span
            class="md-error"
            v-if="!$v.user.passwordConfirmation.sameAsPassword"
          >The password didn't match.</span>
        </md-field>
        <div class="actions mt-10 md-layout md-alignment-center-center">
          <md-button class="md-raised md-primary" type="submit">Register</md-button>
        </div>
      </form>
      <md-snackbar :md-active.sync="saved">{{message}}</md-snackbar>

      <div class="actions md-layout md-alignment-center-space-between">
        <router-link to="/login">I've already an account</router-link>
      </div>
      <div class="loading-overlay" v-if="loading">
        <md-progress-spinner md-mode="indeterminate" :md-stroke="2"></md-progress-spinner>
      </div>
    </md-content>
    <div class="background"/>
  </div>
</template>

<script>
import userService from "../services/user-service";
import Vue from "vue";
import router from "vue-router";
import { validationMixin } from "vuelidate";
import { required, email, maxLength, minLength, sameAs } from "vuelidate/lib/validators";

export default {
  name: "register",
  mixins: [validationMixin],
  data: function() {
    return {
      user: {
        firstName: null,
        lastName: null,
        email: null,
        password: null,
        passwordConfirmation: null
      },
      loading: false,
      saved:false,
      message:null
    };
  },
  validations: {
    user: {
      firstName: {
        required,
        maxLength: maxLength(255)
      },
      lastName: {
        required,
        maxLength: maxLength(255)
      },
      email: {
        required
      },
       password: {
      required,
      minLength: minLength(6)
    },
    passwordConfirmation: {
      sameAsPassword: sameAs('password')
    }
    }
  },
    methods: {
    getValidationClass(fieldName) {
        let field = null;

        if (this.$v.user[fieldName]) {
          field = this.$v.user[fieldName];
        }

        if (field) {
          return {
            "md-invalid": field.$invalid && field.$dirty
          };
        }
      },
      validateUser() {
        this.$v.user.$touch();
        if (!this.$v.user.$invalid) {
          this.register();
        }
      },
      register() {
        this.loading = true;
        userService
          .create(this.user)
          .then(res => {
            if (res.success) {
              localStorage.setItem("user-token", res.data.token);
              this.message = res.message;
              this.saved = true;
              this.$router.push("/profile");
              this.loading = false;
            } else {
               this.message = res.message;
              this.saved = true;
              this.loading = false;
              localStorage.removeItem("user-token");
            }
          })
          .catch(error => {
            this.loading = false;
            this.errors.push(error);
             this.message = error.message;
              this.saved = true;
            console.log("ERROR ", error);
          });
      }
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

