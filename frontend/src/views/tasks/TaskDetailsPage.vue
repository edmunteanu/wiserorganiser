<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-back-button></ion-back-button>
        </ion-buttons>
        <ion-title>Mein Task</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Task</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-list class="ion-padding">
        <h2>
          <strong>Task Details zur Nr. {{ id }}</strong>
        </h2>
        <ion-text>
          <h3>Terminiert am</h3>
          <p>12.10.2022 / 14.00 - 16.00 Uhr</p>
          <h3>Titel</h3>
          <p>Do something</p>
          <h3>Beschreibung</h3>
          <p>Blablabla</p>
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
  IonList,
  IonPage,
  IonTitle,
  IonToolbar,
  IonButtons,
  IonBackButton,
} from "@ionic/vue";

import { defineComponent } from "vue";
import { useRoute } from "vue-router";

export default defineComponent({
  name: "TaskDetailsPage",
  components: {
    IonContent,
    IonHeader,
    IonList,
    IonPage,
    IonTitle,
    IonToolbar,
    IonButtons,
    IonBackButton,
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