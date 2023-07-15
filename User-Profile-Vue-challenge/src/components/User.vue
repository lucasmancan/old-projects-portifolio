<template>
  <md-content class="default-color">
    <md-card>
      <md-card-media-cover md-solid>
        <!-- <md-card-media md-ratio="16:9">
        <img src="https://http2.mlstatic.com/pintura-de-paisagem-em-tinta-acrilica-sobre-tela-100-x-60-cm-D_NQ_NP_632412-MLB26245677738_102017-F.jpg" />>-->
        <base64-upload
          v-if="user.coverImage"
          :imageStyle="coverStyle"
          :imageSrc="user.coverImage"
          @change="updateCoverImage"
        ></base64-upload>
        <!-- <base64-upload
        v-if="!user.coverImage"
          :imageStyle="coverStyle"
          imageSrc="https://lfmsyssotrage.blob.core.windows.net/cover-images/default.jpg"
          @change="updateCoverImage"
        > </base64-upload>-->
        <!-- </md-card-media> -->
        <md-card-area>
          <div class="md-layout md-alignment-center-center profile-image">
            <md-avatar class="md-large">
              <base64-upload
                v-if="user.profileImage"
                :imageSrc="user.profileImage"
                @change="updateProfileImage"
              ></base64-upload>
            </md-avatar>
          </div>
        </md-card-area>
        <md-card-actions class="mt-20"></md-card-actions>
      </md-card-media-cover>
    </md-card>
    <md-divider></md-divider>

    <div class="md-layout md-alignment-center-center mt-20">
      <div class="md-layout-item md-large-size-60 md-xlarge-size-60 md-small-size-100">
        <md-card>
          <div class="md-card-content">
            <form novalidate @submit.prevent="validateUser">
              <div class="md-layout md-gutter">
                <div class="md-layout-item md-small-size-100">
                  <md-field :class="getValidationClass('firstName')">
                    <label for="first-name">First Name</label>
                    <md-input
                      name="first-name"
                      id="first-name"
                      v-model="user.firstName"
                      :disabled="sending"
                    />
                    <span
                      class="md-error"
                      v-if="!$v.user.firstName.required"
                    >The first name is required</span>
                    <span
                      class="md-error"
                      v-else-if="!$v.user.firstName.minlength"
                    >Invalid first name</span>
                  </md-field>
                </div>

                <div class="md-layout-item md-small-size-100">
                  <md-field :class="getValidationClass('lastName')">
                    <label for="last-name">Last Name</label>
                    <md-input
                      name="last-name"
                      id="last-name"
                      v-model="user.lastName"
                      :disabled="sending"
                    />
                    <span
                      class="md-error"
                      v-if="!$v.user.lastName.required"
                    >The last name is required</span>
                    <span class="md-error" v-else-if="!$v.user.lastName.minlength">Invalid last name</span>
                  </md-field>
                </div>
              </div>

              <div class="md-layout md-gutter">
                <div class="md-layout-item md-small-size-100">
                  <md-field :class="getValidationClass('gender')">
                    <label for="gender">Gender</label>
                    <md-select
                      name="gender"
                      id="gender"
                      v-model="user.gender"
                      md-dense
                      :disabled="sending"
                    >
                      <md-option></md-option>
                      <md-option value="M">Male</md-option>
                      <md-option value="F">Female</md-option>
                      <md-option value="O">Others</md-option>
                    </md-select>
                    <span class="md-error">The gender is required</span>
                  </md-field>
                </div>
                <div class="md-layout-item md-small-size-100">
                  <md-datepicker required v-model="user.birthDate" name="birthDate"/>
                  <!-- <span class="md-error" v-if="!$v.user.birthDate.required">The Bith Date is required</span> -->
                </div>
              </div>

              <div class="md-layout-item md-small-size-100">
                <md-field :class="getValidationClass('bio')">
                  <label>About</label>
                  <md-textarea v-model="user.bio" md-counter="255"></md-textarea>
                </md-field>
              </div>
            </form>
          </div>
        </md-card>

        <md-card class="mt-10">
          <md-card-header>
            <md-card-header-text>
              <span class="md-title">
                <md-icon>home</md-icon>
              </span>
            </md-card-header-text>
            <md-menu md-size="big" md-direction="bottom-end">
              <md-button class="md-icon-button" @click="manageAddressModal">
                <md-icon>edit</md-icon>
              </md-button>
            </md-menu>
          </md-card-header>
          <md-card-content>
            <div class="md-layout-item md-alignment-center-center">
              <div v-if="!user.address">
                <md-subheader>You have no address information, please add by clicking on home icon.</md-subheader>
              </div>
              <div v-if="user.address">
                <div class="md-layout mt-10 md-alignment-center-center">
                  <div class="md-layout-item md-alignment-center-center">
                    <span>{{user.address.street}} nº {{user.address.number}}, {{user.address.neighborhood}} - {{user.address.city.name}}, {{user.address.city.state.name}}, {{user.address.city.state.country.name}}.</span>
                  </div>
                </div>
              </div>
            </div>
          </md-card-content>
        </md-card>

        <md-card class="mt-10">
          <md-card-header>
            <md-card-header-text>
              <span class="md-title">
                <md-icon>phone</md-icon>
              </span>
            </md-card-header-text>
            <md-menu md-size="big" md-direction="bottom-end">
              <md-button class="md-icon-button" @click="addPhone">
                <md-icon>add</md-icon>
              </md-button>
            </md-menu>
          </md-card-header>

          <md-card-content>
            <div class="md-layout-item">
              <div v-if="!user.phones || !user.phones.length > 0">
                <md-subheader>You have no contact information, please add a phone number by clicking on phone icon.</md-subheader>
              </div>
              <md-list v-if="user.phones.length > 0">
                <md-list-item v-for="(phone, index) in user.phones" v-bind:key="index">
                  <span class="md-list-item-text">+{{phone.ddi}} ({{phone.ddd}}) {{phone.phone}}</span>
                  <md-button v-on:click="removePhone(phone, index)" class="md-icon-button">
                    <md-icon>delete</md-icon>
                  </md-button>
                  <md-button v-on:click="editPhone(phone)" class="md-icon-button">
                    <md-icon>edit</md-icon>
                  </md-button>
                </md-list-item>
              </md-list>
            </div>
          </md-card-content>
        </md-card>
      </div>

      <md-progress-bar md-mode="indeterminate" v-if="sending"/>
      <md-snackbar :md-active.sync="saved">{{message}}</md-snackbar>
      <div>
        <md-dialog :md-active.sync="active">
          <md-dialog-title>Phone</md-dialog-title>
          <div class="md-layout md-alignment-center-center">
            <form novalidate @submit.prevent="validatePhone" class="md-layout-item md-size-80">
              <div class="md-layout md-gutter">
                <div class="md-layout-item">
                  <md-field :class="getValidationClass('ddi')">
                    <label for="ddi">Country Code</label>
                    <span class="md-prefix">+</span>
                    <md-input name="ddi" id="ddi" v-model="phone.ddi" :disabled="sending"/>
                    <span
                      class="md-error"
                      v-if="!$v.phone.ddi.required"
                    >The Country Code is required</span>
                    <span class="md-error" v-else-if="!$v.phone.ddi.maxlength">Invalid Country Code</span>
                  </md-field>
                </div>
                <div class="md-layout-item">
                  <md-field :class="getValidationClass('ddd')">
                    <label for="ddd">Area code</label>
                    <span class="md-prefix">(</span>

                    <md-input name="ddd" id="ddd" v-model="phone.ddd" :disabled="sending"/>
                    <span class="md-suffix">)</span>
                    
                    <span class="md-error" v-if="!$v.phone.ddd.required">The Area code is required</span>
                    <span class="md-error" v-else-if="!$v.phone.ddd.maxlength">Invalid Area code</span>
                  </md-field>
                </div>
              </div>

              <div class="md-layout-item">
                <md-field :class="getValidationClass('phone')">
                  <label for="phone">Phone Number</label>
                  <md-input name="phone" id="phone" v-model="phone.phone" :disabled="sending"/>
                  <span class="md-error" v-if="!$v.phone.phone.required">The ddd is required</span>
                </md-field>
              </div>

              <md-dialog-actions class="md-layout">
                <md-button class="md-button md-raised md-accent" @click="manageModal">Close</md-button>
                <md-button type="submit" class="md-button md-raised md-primary">Save</md-button>
              </md-dialog-actions>
            </form>
          </div>
        </md-dialog>

        <md-dialog class="md-dialog-address md-flex-100" :md-active.sync="activeAddress">
          <md-dialog-title>Address</md-dialog-title>
          <md-dialog-content>
            <div class="md-layout md-alignment-center-center">
              <form novalidate @submit.prevent="validateAddress" class="md-layout-item md-size-80">
                <div class="md-layout md-gutter">
                  <div class="md-layout-item md-small-size-100">
                    <md-field :class="getValidationClass('city')">
                      <label for="country">Country</label>
                      <md-select
                        v-model="address.city.state.country_id"
                        placeholder="Country"
                        name="name"
                        id="id"
                        @md-selected="getStatesByCountry(address.city.state.country_id)"
                      >
                        <md-option
                          v-for="country in countries"
                          v-bind:key="country.id"
                          v-bind:value="country.id"
                        >{{country.name}}</md-option>
                      </md-select>
                      <span
                        class="md-error"
                        v-if="!$v.address.city.required"
                      >The country is required</span>
                    </md-field>
                  </div>
                  <div class="md-layout-item md-small-size-100">
                    <md-field :class="getValidationClass('city')">
                      <label for="state">State</label>
                      <md-select
                        v-model="address.city.state_id"
                        name="name"
                        id="id"
                        placeholder="State"
                        @md-selected="getCitiesByState(address.city.state_id)"
                      >
                        <md-option
                          v-for="state in states"
                          v-bind:key="state.id"
                          v-bind:value="state.id"
                        >{{state.name}}</md-option>
                      </md-select>
                      <span class="md-error" v-if="!$v.address.city.required">The state is required</span>
                    </md-field>
                  </div>
                </div>
                <div class="md-layout-item">
                  <md-field :class="getValidationClass('city')">
                    <label for="city">City</label>
                    <md-select v-model="address.city_id" name="name" id="id" placeholder="City">
                      <md-option
                        v-for="city in cities"
                        v-bind:key="city.id"
                        v-bind:value="city.id"
                      >{{city.name}}</md-option>
                    </md-select>
                    <span class="md-error" v-if="!$v.address.city.required">The city is required</span>
                  </md-field>
                </div>
                <div class="md-layout md-gutter">
                  <div class="md-layout-item md-small-size-100">
                    <md-field :class="getValidationClass('number')">
                      <label for="number">Number</label>
                      <md-input
                        name="number"
                        id="number"
                        v-model="address.number"
                        :disabled="sending"
                      />
                      <span
                        class="md-error"
                        v-if="!$v.address.number.required"
                      >The number is required</span>
                      <span class="md-error" v-else-if="!$v.address.number.maxlength">Invalid number</span>
                    </md-field>
                  </div>
                  <div class="md-layout-item md-small-size-100">
                    <md-field :class="getValidationClass('zipCode')">
                      <label for="zipCode">Zip Code</label>
                      <md-input
                        name="zipCode"
                        id="zipCode"
                        v-model="address.zipCode"
                        :disabled="sending"
                      />
                      <span
                        class="md-error"
                        v-if="!$v.address.zipCode.required"
                      >The zipCode is required</span>
                      <span
                        class="md-error"
                        v-else-if="!$v.address.zipCode.maxlength"
                      >Invalid zipCode</span>
                    </md-field>
                  </div>
                </div>
                <div class="md-layout-item md-small-size-100">
                  <md-field :class="getValidationClass('street')">
                    <label for="last-name">Street</label>
                    <md-input
                      name="Street"
                      id="Street"
                      autocomplete="family-name"
                      v-model="address.street"
                      :disabled="sending"
                    />
                    <span class="md-error" v-if="!$v.address.street.required">The street is required</span>
                    <span class="md-error" v-else-if="!$v.address.street.maxlength">Invalid street</span>
                  </md-field>
                </div>

                <div class="md-layout-item md-small-size-100">
                  <md-field :class="getValidationClass('neighborhood')">
                    <label for="last-name">Neighborhood</label>
                    <md-input
                      name="neighborhood"
                      id="neighborhood"
                      autocomplete="family-name"
                      v-model="address.neighborhood"
                      :disabled="sending"
                    />
                    <span
                      class="md-error"
                      v-if="!$v.address.neighborhood.required"
                    >The neighborhood is required</span>
                    <span
                      class="md-error"
                      v-else-if="!$v.address.neighborhood.maxlength"
                    >Invalid neighborhood</span>
                  </md-field>
                </div>

                <md-dialog-actions>
                  <md-button class="md-raised md-accent" @click="activeAddress = false">Close</md-button>
                  <md-button class="md-raised md-primary" type="submit">Save</md-button>
                </md-dialog-actions>
              </form>
            </div>
          </md-dialog-content>
        </md-dialog>
        <div class="loading-overlay" v-if="loading"></div>
        <md-dialog-confirm
          :md-active.sync="confirmationDialog"
          md-title="Do you really wanna leave?"
          md-content="Save your changes before you go."
          md-confirm-text="Leave"
          md-cancel-text="Back"
          @md-cancel="confirmationDialog = false"
          @md-confirm="logout"
        />
      </div>

      <fab
        :position="position"
        :bg-color="bgColor"
        :actions="fabActions"
        @saveUser="validateUser"
        @logout="confirmationDialog = true"
      ></fab>
    </div>
    <div class="loading-overlay" v-if="loading">
      <md-progress-spinner :md-diameter="100" :md-stroke="10" md-mode="indeterminate"></md-progress-spinner>
    </div>
  </md-content>
</template>

<script>
import userService from "../services/user-service";
console.log("Import Statement: ", userService);
import fab from "vue-fab";
import { validationMixin } from "vuelidate";
import {
  required,
  email,
  minLength,
  maxLength
} from "vuelidate/lib/validators";
import Base64Upload from "vue-base64-upload";

export default {
  components: {
    fab,
    Base64Upload
  },
  name: "userValidation",
  mixins: [validationMixin],
  data: function() {
    return {
      user: {
        phones: []
      },
      sending: false,
      active: false,
      profileImage: {},
      coverImage: {},
      loading: false,
      countries: [],
      confirmationDialog: false,
      cities: [],
      states: [],
      coverStyle: {
        "max-width": "100%",
        "max-height": "200px",
        "object-fit": "cover",
        "object-position": "center"
      },
      activeAddress: false,
      phone: {},
      address: { city: { state: {} } },
      saved: false,
      message: true,
      bgColor: "#000000",
      position: "bottom-left",
      fabActions: [
        {
          name: "logout",
          icon: "exit_to_app"
        },
        {
          name: "saveUser",
          icon: "save"
        }
      ]
    };
  },
  validations: {
    state: {
      country: {
        required
      }
    },
    state: {
      country: {
        required
      }
    },
    address: {
      neighborhood: {
        required,
        maxLength: maxLength(255)
      },
      street: {
        required,
        maxLength: maxLength(255)
      },
      number: {
        required,
        maxLength: maxLength(20)
      },
      city: {
        required
      },
      zipCode: {
        required,
        maxLength: maxLength(20)
      }
    },
    phone: {
      ddd: {
        required,
        maxLength: maxLength(2)
      },
      ddi: {
        required,
        maxLength: maxLength(2)
      },
      phone: {
        required
      }
    },
    user: {
      firstName: {
        required,
        minLength: minLength(3)
      },
      lastName: {
        required,
        minLength: minLength(3)
      },
      birthDate: {
        required
      },
      gender: {
        required
      },
      bio: {
        minLength: minLength(3),
        maxLength: maxLength(255)
      },
      gender: {
        required
      }
    }
  },
  methods: {
    logout() {
      localStorage.removeItem("user-token");
      this.$router.replace("login");
    },
    updateProfileImage(evt) {
      console.log(evt);
      this.profileImage.profileImage = evt.base64;
      userService
        .updateProfileImage(this.user.id, this.profileImage)
        .then(res => {
          this.saved = true;
          this.message = res.message;
        });
    },
    updateCoverImage(evt) {
      console.log(evt);
      this.coverImage.coverImage = evt.base64;
      userService.updateCoverImage(this.user.id, this.coverImage).then(res => {
        this.saved = true;
        this.message = res.message;
      });
    },
    loadUser() {
      userService.get().then(res => {
        this.user = res.data;
        this.loading = false;
      });
    },
    saveAddress() {
      this.user.address = this.address;
      this.saveUser();
      this.activeAddress = false;
    },
    getCountries() {
      console.log("Carregando Paises");
      userService.getCountries().then(res => {
        this.countries = res.data;
        console.log(this.countries);
      });
    },
    getStatesByCountry(country) {
      let self = this;
      console.log("Parameter Country: ", country);
      userService
        .getStatesByCountry(country)
        .then(res => (self.states = res.data));
    },
    getCitiesByState(state) {
      console.log("Parameter State: ", state);
      let self = this;
      userService.getCitiesByState(state).then(res => {
        self.cities = res.data;
      });
    },
    removePhone(phone, index) {
      userService.removePhone(phone.id).then(res => {
        (this.message = res.message),
          (this.phoneSaved = true),
          this.user.phones.splice(index, 1);
      });
    },
    editPhone(phone) {
      this.phone = phone;
      this.manageModal();
    },
    addPhone() {
      this.phone = {};
      this.manageModal();
    },
    savePhone() {
      if (!this.phone.id) {
        this.phone.user_id = this.user.id;
        userService.postPhone(this.phone).then(res => {
          this.loadUser();
          this.manageModal();
          this.clearPhone();
          this.message = res.message;
          this.saved = true;
        });
      } else {
        userService.updatePhone(this.phone).then(res => {
          this.loadUser();
          this.manageModal();
          this.clearPhone();
          this.message = res.message;
          this.saved = true;
        });
      }
    },
    manageModal() {
      this.active = !this.active;
    },
    manageAddressModal() {
      console.log(this.user);
      if (this.user.address) {
        this.address = this.user.address;
        this.getCountries();
      } else {
        console.log(this.newAddress());
        this.address = this.newAddress();
        this.getCountries();
      }
      this.activeAddress = !this.activeAddress;
    },
    newAddress() {
      return {
        city: { id: null, state: { id: null, country: { id: null } } }
      };
    },
    clearPhone() {
      this.phone = {};
    },
    getValidationClass(fieldName) {
      let field = null;

      if (this.$v.user[fieldName]) {
        field = this.$v.user[fieldName];
      } else if (this.$v.phone[fieldName]) {
        field = this.$v.phone[fieldName];
      } else if (this.$v.address[fieldName]) {
        field = this.$v.address[fieldName];
      }

      if (field) {
        return {
          "md-invalid": field.$invalid && field.$dirty
        };
      }
    },
    saveUser() {
      this.sending = true;
      userService
        .update(this.user)
        .then(() => {
          this.loadUser();
          this.sending = false;
          this.message = res.message;
          this.saved = true;
          console.log("Salvando Usuário");
        })
        .catch(error => {
          this.sending = false;
          this.message = error.message;
          this.saved = true;
        });
    },
    validateUser() {
      this.$v.user.$touch();
      if (!this.$v.user.$invalid) {
        this.saveUser();
      }
    },
    validateAddress() {
      console.log("Validação!", this.$v.address);
      this.$v.address.$touch();
      if (!this.$v.address.$invalid) {
        this.saveAddress();
      }
    },
    validatePhone() {
      this.$v.phone.$touch();
      if (!this.$v.phone.$invalid) {
        this.savePhone();
      }
    }
  },
  mounted: function() {
    this.loading = true;
    this.loadUser();
  }
};
</script>

<style lang="scss" scoped>
.md-progress-bar {
  position: absolute;
  top: 0;
  right: 0;
  left: 0;
}
.md-dialog {
  // max-width: 768px !important;
  // .md-input {
  //   padding: 10px;
  // }
}
.md-content {
  justify-content: center;
  align-items: center;
}

.md-dialog-address {
  .md-field {
  }
}
.cover-image {
  max-height: 300px !important;
  padding: 1px;
}
.mt-10 {
  margin-top: 10px;
}
.md-card-area {
  background-color: rgba(0, 0, 0, 0) !important;
  // height: 100%;
}
.mt-20 {
  margin-top: 20px;
}
.loading-overlay {
  z-index: 9999;
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
.md-card-content{
  padding: 20px;
}

.default-color {
  background-color: whitesmoke;
}

.md-avatar.md-large {
  min-width: 110px;
  min-height: 110px;
  border-radius: 80px;
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.5);
  border: 5px solid white;
}

@media (min-width: 768px) {
  .md-avatar.md-large {
    min-width: 160px;
    min-height: 160px;
  }
}
</style>