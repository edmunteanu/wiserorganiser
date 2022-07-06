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
                <p><strong>Your Timetable</strong></p>
                <ion-grid>
                    <ion-row v-bind:key="lecture" v-for="lecture in lectures">
                        <ion-col size="3">
                            <ion-card>
                                <ion-card-title>{{ lecture.time }}</ion-card-title>
                            </ion-card>
                        </ion-col>
                        <ion-col size="9">
                            <ion-card v-bind:router-link="'/tabs/lectures/' + lecture.id" button>
                                <ion-card-subtitle>{{ lecture.room }}</ion-card-subtitle>
                                <ion-card-title>{{ lecture.name }}</ion-card-title>
                            </ion-card>
                        </ion-col>
                    </ion-row>
                </ion-grid>
                <!-- <ion-list>
                    <ion-card v-bind:router-link="'/tabs/lecture/' + lecture.name" button v-bind:key="lecture" v-for="lecture in lectures">
                        <ion-card-subtitle>{{ lecture.room }}</ion-card-subtitle>
                        <ion-card-title>{{ lecture.name }}</ion-card-title>
                    </ion-card>
                </ion-list> -->
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
    IonBackButton
} from "@ionic/vue";

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
        IonBackButton
    },
    data() {
        return {
            lectures: [
                {
                    id: 1,
                    time: "8:00 - 9:00",
                    name: "Web Engineering",
                    description: "We will build stuff",
                    professor: "Max Meisterhans",
                    room: "SW 303"
                },
                {
                    id: 2,
                    time: "9:00 - 10:00",
                    name: "GPI",
                    description: "We will build more stuff",
                    professor: "Peter Heinrich",
                    room: "SW 219"
                },
                {
                    id: 3,
                    time: "10:00 - 11:00",
                    name: "Statistik",
                    description: "We will calculate stuff",
                    professor: "Statistik Dozent",
                    room: "SW 012"
                }
            ]
        }
    }
};

</script>