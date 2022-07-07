<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-back-button></ion-back-button>
        </ion-buttons>
        <ion-title>Neuer Task</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Task</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-list class="ion-padding" stlye="padding-top: 80px">
        <h2><strong>Erfasse deinen Task</strong></h2>
        <ion-text>
          <h4><strong>Datum</strong></h4>
          <ion-datetime
            :show-default-buttons="true"
            minute-values="0"
          ></ion-datetime>
          <p></p>
          <ion-label
            ><h1><strong>Titel deines Tasks</strong></h1></ion-label
          >
          <ion-input placeholder="Do it"></ion-input>
          <ion-label
            ><h1><strong>Beschreibung</strong></h1></ion-label
          >
          <ion-textarea placeholder="Be productive"></ion-textarea>
        </ion-text>
        <ion-button shape="round" class="ion-margin">Ändern</ion-button>
        <ion-button shape="round" class="ion-margin">Speichern</ion-button>
      </ion-list>
    </ion-content>
  </ion-page>
</template>

<script>
import {
  IonContent,
  IonHeader,
  IonLabel,
  IonList,
  IonPage,
  IonTitle,
  IonToolbar,
  IonButtons,
  IonBackButton,
  IonDatetime,
} from "@ionic/vue";

import { defineComponent } from "vue";
import { useRoute } from "vue-router";

export default defineComponent({
  name: "CreateTaskPage",
  components: {
    IonContent,
    IonHeader,
    IonLabel,
    IonList,
    IonPage,
    IonTitle,
    IonToolbar,
    IonButtons,
    IonBackButton,
    IonDatetime,
  },
  setup() {
    const route = useRoute();
    const { id } = route.params;

    return {
      id,
    };
  },
});
</script>

<style scoped>
</style>