<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-back-button></ion-back-button>
        </ion-buttons>
        <ion-title>Timetable</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Timetable</ion-title>
        </ion-toolbar>
      </ion-header>
      <div id="container" class="ion-padding">
        <h1>Timetable ID: {{ id }}</h1>
        <ion-slides pager="true" :options="slideOpts">
          <ion-slide
            v-bind:key="day"
            v-for="day in days"
            style="padding-bottom: 50px"
          >
            <ion-grid>
              <ion-row>
                <h2>{{ day }}</h2>
              </ion-row>
              <ion-row v-bind:key="lecture" v-for="lecture in lectures">
                <ion-col size="3">
                  <ion-card>
                    <ion-card-title
                      v-if="lecture.lectureAssignments[0].day == day"
                      >{{ lecture.lectureAssignments[0].startHour }} <br />
                      {{
                        lecture.lectureAssignments[0].endHour
                      }}</ion-card-title
                    >
                  </ion-card>
                </ion-col>
                <ion-col size="9">
                  <ion-card
                    v-bind:router-link="'/tabs/lectures/' + lecture.id"
                    button
                    v-if="lecture.lectureAssignments[0].day == day"
                  >
                    <ion-card-subtitle>{{ lecture.room }}</ion-card-subtitle>
                    <ion-card-title>{{ lecture.name }}</ion-card-title>
                  </ion-card>
                </ion-col>
              </ion-row>
            </ion-grid>
          </ion-slide>
        </ion-slides>
      </div>
    </ion-content>
  </ion-page>
</template>

<script>
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonCardTitle,
  IonCardSubtitle,
  IonContent,
  IonCol,
  IonRow,
  IonGrid,
  IonItem,
  IonList,
  IonButton,
  IonInput,
  IonCard,
  IonButtons,
  IonBackButton,
  IonSlides,
  IonSlide,
} from "@ionic/vue";
import { useLectures } from "@/composables/useLectures";
import { useRoute } from "vue-router";

export default {
  name: "TimetablesPage",
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonCardTitle,
    IonCardSubtitle,
    IonContent,
    IonPage,
    IonCard,
    IonGrid,
    IonRow,
    IonCol,
    IonButtons,
    IonBackButton,
    IonSlides,
    IonSlide,
  },
  data() {
    return {
      days: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"],
      times: [
        ["08:00", "10:00"],
        ["11:00", "12:00"],
        ["13:00", "14:00"],
        ["15:00", "17:00"],
      ],
    };
  },
  setup() {
    const route = useRoute();
    const { id } = route.params;
    const { lectures } = useLectures(id);

    const slideOpts = {
      initialSlide: 0,
      speed: 400,
    };

    return {
      id,
      lectures,
      slideOpts,
    };
  },
};
</script>