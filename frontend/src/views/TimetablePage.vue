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
            <p>Timetable :)</p>
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
} from "@ionic/vue";

export default {
    name: "TimetablePage",
    components: {
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonPage,
    },
};
</script>