<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Tasks</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Tasks</ion-title>
        </ion-toolbar>
      </ion-header>
      <div id="container">
        <ion-list>
          <ion-title class="ion-padding"><strong>Übersicht</strong></ion-title>
          <ion-card v-bind:router-link="'/tabs/tasks/' + task.title" button v-bind:key="task" v-for="task in tasks">
            <ion-card-header>
              <ion-label>
                  <ion-checkbox style="float: right; vertical-align: middle" ></ion-checkbox>
                  <ion-card-title>{{ task.title }}</ion-card-title>
                  <ion-card-subtitle>{{ task.date }}</ion-card-subtitle>
                </ion-label>
            </ion-card-header>
          </ion-card>
          <ion-button shape="round" class="ion-margin">Neuer Task</ion-button>
        </ion-list>
      </div>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonCard,
  IonCol,
  IonRow,
  IonGrid,
  IonItem,
  IonList,
  IonButton,
  IonInput,
  IonCheckbox
} from "@ionic/vue";
import { squareOutline } from "ionicons/icons";

export default {
  name: "TasksPage",
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonCard,
    IonList,
    IonCheckbox,
  },
  setup() {
    return {
      squareOutline,
    };
  },

  data() {
    return {
      tasks: [
        {
          title: "Do something",
          date: "12.10.2022 / 14.00 - 16.00 Uhr",
        },
        {
          title: "Do another thing",
          date: "17.10.2022 / 15.00 - 16.00 Uhr",
        },
        {
          title: "Do some things",
          date: "18.12.2022 / 09.00 - 11.00 Uhr",
        },
        {
          title: "Do it",
          date: "22.12.2022 / 09.00 - 11.00 Uhr",
        },
      ],
    };
  },
};
</script>