<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-back-button></ion-back-button>
        </ion-buttons>
        <ion-title>My Task</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Task</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-list class="ion-padding" v-if="task">
        <h2>
          <strong>Task Details for No. {{ task.id }}</strong>
        </h2>
        <ion-text>
          <h3>Scheduled on</h3>
          <p>{{ task.day }} from {{ task.startHour }} to {{ task.endHour }} </p>
          <h3>Title</h3>
          <p>{{ task.name }}</p>
          <h3>Description</h3>
          <p>{{ task.description }} </p>
        </ion-text>
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
  IonText
} from "@ionic/vue";

import { defineComponent, onMounted } from "vue";
import { useRoute } from "vue-router";
import { useTasks } from "@/composables/useTasks";

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
    IonText
  },
  setup() {
    const route = useRoute();
    const { id } = route.params;
    const { task, getTask } = useTasks();

    onMounted(getTask(id));

    return {
      id,
      task,
      getTask,
    };
  },
});
</script>

<style scoped>
</style>