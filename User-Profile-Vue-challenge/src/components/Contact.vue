<template>
  <div>
    <form novalidate class="md-layout md-alignment-center-center" @submit.prevent="validateUser">
 <div v-if="!user.phones || !user.phones.length > 0">
  <div class="md-subhead">Add a new Phone</div>
</div>
      <div v-if="user.phones.length > 0">
<div v-for="phone in user.phones" v-bind:key="phone">
        <div class="md-layout md-gutter md-flex-100">
          <div class="md-layout-item md-small-size">
            <md-field>
              <label for="DDI">DDI</label>
              <md-input
                name="DDI"
                id="DDI"
                autocomplete="family-name"
                v-model="phone.ddi"
                :disabled="sending"
              />
            </md-field>
          </div>

          <div class="md-layout-item md-small-size">
            <md-field>
              <label for="DDD">DDD</label>
              <md-input
                name="DDD"
                id="DDD"
                autocomplete="family-name"
                v-model="phone.ddd"
                :disabled="sending"
              />
            </md-field>
          </div>

          <div class="md-layout-item md-small-size">
            <md-field>
              <label for="phone">Phone Number</label>
              <md-input
                name="phone"
                id="phone"
                autocomplete="family-name"
                v-model="phone.phone"
                :disabled="sending"
              />
            </md-field>
          </div>
        </div>
      </div>
      </div>
      <md-snackbar :md-active.sync="userSaved">The user {{ lastUser }} was saved with success!</md-snackbar>
    </form>
  </div>
</template>

<script>
  import { validationMixin } from 'vuelidate'
  import {
    required,
    email,
    minLength,
    maxLength
  } from 'vuelidate/lib/validators'
import userService from "../services/user-service";

  export default {
    name: 'FormValidation',
    mixins: [validationMixin],
    data: () => ({
      form: {
        firstName: null,
        lastName: null,
        gender: null,
        age: null,
        email: null,
      },
      userSaved: false,
      sending: false,
      lastUser: null
    }),
    validations: {
      form: {
        firstName: {
          required,
          minLength: minLength(3)
        },
        lastName: {
          required,
          minLength: minLength(3)
        },
        age: {
          required,
          maxLength: maxLength(3)
        },
        gender: {
          required
        },
        email: {
          required,
          email
        }
      }
    },
    methods: {
      getValidationClass (fieldName) {
        const field = this.$v.form[fieldName]

        if (field) {
          return {
            'md-invalid': field.$invalid && field.$dirty
          }
        }
      },
      clearForm () {
        this.$v.$reset()
        this.form.firstName = null
        this.form.lastName = null
        this.form.age = null
        this.form.gender = null
        this.form.email = null
      },
      saveUser () {
        this.sending = true

        // Instead of this timeout, here you can call your API
        window.setTimeout(() => {
          this.lastUser = `${this.form.firstName} ${this.form.lastName}`
          this.userSaved = true
          this.sending = false
          this.clearForm()
        }, 1500)
      },
      validateUser () {
        this.$v.$touch()

        if (!this.$v.$invalid) {
          this.saveUser()
        }
      }
    }
  }
</script>

<style lang="scss" scoped>
  .md-progress-bar {
    position: absolute;
    top: 0;
    right: 0;
    left: 0;
  }
</style>