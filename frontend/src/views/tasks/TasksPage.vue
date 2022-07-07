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
          <ion-item>
            <ion-title><strong>Klasse auswählen</strong></ion-title>
          </ion-item>
          <ion-item>
            <ion-label>Klasse</ion-label>
            <ion-select
              v-if="timetables.length > 0"
              :placeholder="timetables[0].name"
              interface="popover"
              @ionChange="getTasks($event.detail.value)"
            >
              <ion-select-option
                :key="timetable.id"
                v-for="timetable in timetables"
                :value="timetable.id"
                >{{ timetable.name }}</ion-select-option
              >
            </ion-select>
          </ion-item>
          <ion-card
            :router-link="'/tabs/tasks/' + task.id"
            button
            :key="task.id"
            v-for="task in tasks"
          >
            <ion-card-header>
              <ion-label>
                <ion-checkbox
                  style="float: right; vertical-align: middle"
                ></ion-checkbox>
                <ion-card-title>{{ task.name }}</ion-card-title>
                <ion-card-subtitle>{{ task.description }}</ion-card-subtitle>
              </ion-label>
            </ion-card-header>
          </ion-card>
          <ion-button
            v-bind:router-link="'tasks/new'"
            shape="round"
            class="ion-margin"
            >Neuer Task</ion-button
          >
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
  IonCardTitle,
  IonCardSubtitle,
  IonCardHeader,
  IonList,
  IonItem,
  IonLabel,
  IonButton,
  IonCheckbox,
  IonSelect,
  IonSelectOption,
} from "@ionic/vue";

import { defineComponent, ref } from "vue";
import { useTasks } from "@/composables/useTasks";
import { useTimetables } from "@/composables/useTimetables";

export default defineComponent({
  name: "TasksPage",
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonCard,
    IonCardTitle,
    IonCardSubtitle,
    IonCardHeader,
    IonList,
    IonItem,
    IonLabel,
    IonButton,
    IonCheckbox,
    IonSelect,
    IonSelectOption,
  },
  setup() {
    const selectedTimetableId = ref(1);
    const { timetables } = useTimetables();
    const { tasks, getTasks } = useTasks(selectedTimetableId.value);

    return { timetables, selectedTimetableId, tasks, getTasks };
  },
});
</script>