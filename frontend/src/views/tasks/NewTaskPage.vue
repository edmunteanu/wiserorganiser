<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-back-button></ion-back-button>
        </ion-buttons>
        <ion-title>New Task</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Task</ion-title>
        </ion-toolbar>
      </ion-header>
      <ion-list class="ion-padding" stlye="padding-top: 80px">
        <h2><strong>Create a new task</strong></h2>
        <ion-item>
          <ion-label position="floating">Name</ion-label>
          <ion-input v-model="newTask.name"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Description</ion-label>
          <ion-textarea v-model="newTask.description"></ion-textarea>
        </ion-item>
        <ion-item lines="none">
          <ion-label>Start hour</ion-label>
        </ion-item>
        <ion-item>
          <ion-datetime presentation="time" v-model="rawStartHour"></ion-datetime>
        </ion-item>
        <ion-item lines="none">
          <ion-label>End hour</ion-label>
        </ion-item>
        <ion-item>
          <ion-datetime presentation="time" v-model="rawEndHour"></ion-datetime>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Day</ion-label>
          <ion-select v-model="newTask.day">
            <ion-select-option value="Monday">Monday</ion-select-option>
            <ion-select-option value="Tuesday">Tuesday</ion-select-option>
            <ion-select-option value="Wednesday">Wednesday</ion-select-option>
            <ion-select-option value="Thursday">Thursday</ion-select-option>
            <ion-select-option value="Friday">Friday</ion-select-option>
            <ion-select-option value="Saturday">Saturday</ion-select-option>
            <ion-select-option value="Sunday">Sunday</ion-select-option>
          </ion-select>
        </ion-item>
        <ion-button shape="round" class="ion-margin" @click="addNewTask(id)">Submit</ion-button>
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
  IonInput,
  IonItem,
  IonTextarea,
  IonSelect,
  IonSelectOption,
  IonButton
} from "@ionic/vue";

import { defineComponent, ref } from "vue";
import { useRoute } from "vue-router";
import { useTasks } from "@/composables/useTasks";

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
    IonInput,
    IonItem,
    IonTextarea,
    IonSelect,
    IonSelectOption,
    IonButton
  },
  setup() {
    const rawStartHour = ref();
    const rawEndHour = ref();
    const route = useRoute();
    const { id } = route.params;
    const { newTask, addTask } = useTasks();
    
    const addNewTask = (timetableId) => {
      newTask.value.startHour = rawStartHour.value.split('T')[1].split(':').slice(0, 2).join(':');
      newTask.value.endHour = rawEndHour.value.split('T')[1].split(':').slice(0, 2).join(':');
      addTask(timetableId);
    };

    return { id, newTask, addTask, rawStartHour, rawEndHour, addNewTask };
  },
});
</script>

<style scoped>
</style>