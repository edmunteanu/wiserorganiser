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
            <div id="container" class="ion-padding">
                <p><strong>Choose your timetable</strong></p>
                <ion-list :key="timetable" v-for="timetable in timetables">
                    <ion-item>
                        <ion-label>{{ timetable.name }}</ion-label>
                    </ion-item>
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
    IonList,
    IonItem,
    IonLabel
} from "@ionic/vue";
import { useTimetables } from "@/composables/useTimetables";

export default {
    name: "TimetablesPage",
    components: {
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonPage,
        IonList,
        IonItem,
        IonLabel
    },
    setup() {
        const { timetables } = useTimetables();

        return { timetables }
    }
};
</script>