<template>
    <ion-page>
        <ion-header>
            <ion-toolbar>
                <ion-title>Timetable</ion-title>
            </ion-toolbar>
        </ion-header>
        <ion-content :fullscreen="true">
            <ion-header collapse="condense">
                <ion-toolbar>
                    <ion-title size="large">Timetable</ion-title>
                </ion-toolbar>
            </ion-header>
            <div id="container">
                <p><strong>List of all Lectures</strong></p>
                <ion-list>
                    <ion-card v-bind:key="lecture" v-for="lecture in lectures">
                        <ion-card-subtitle>{{ lecture.room }}</ion-card-subtitle>
                        <ion-card-title>{{ lecture.name }}</ion-card-title>
                    </ion-card>
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
    IonCol,
    IonRow,
    IonGrid,
    IonItem,
    IonList,
    IonButton,
    IonInput,
    IonCard
} from "@ionic/vue";

export default {
    name: "TimetablePage",
    components: {
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonPage,
        IonList,
        IonCard
    },

    data() {
        return {
            lectures: [
                {
                    id: "1",
                    name: "Web Engineering",
                    description: "We will build stuff",
                    professor: "Max Meisterhans",
                    room: "SW 303"
                },
                {
                    id: "2",
                    name: "GPI",
                    description: "We will build more stuff",
                    professor: "Peter Heinrich",
                    room: "SW 219"
                },
                {
                    id: "3",
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