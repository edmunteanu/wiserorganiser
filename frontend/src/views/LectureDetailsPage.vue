<template>
    <ion-page>
        <ion-header :translucent="true">
            <ion-toolbar>
                <ion-buttons slot="start">
                    <ion-back-button></ion-back-button>
                </ion-buttons>
                <ion-title>Lecture</ion-title>
            </ion-toolbar>
        </ion-header>

        <ion-content :fullscreen="true">
            <ion-header collapse="condense">
                <ion-toolbar>
                    <ion-title size="large">Lecture</ion-title>
                </ion-toolbar>
            </ion-header>
            <div id="container" class="ion-padding" v-if="lecture">
                <p>Lecture ID: {{ lecture.id }}</p>
            </div>
 
        </ion-content>
    </ion-page>
</template>

<script>
import { IonContent, IonHeader, IonItem, IonLabel, IonList, IonPage, IonTitle, IonToolbar, IonButtons, IonBackButton } from '@ionic/vue';
import { useRoute } from "vue-router";
import { useLectures } from "@/composables/useLectures";

export default {
    name: 'LectureDetailsPage',
    components: {
        IonContent,
        IonHeader,
        IonPage,
        IonTitle,
        IonToolbar,
        IonButtons,
        IonBackButton
    },
    setup() {
        const route = useRoute()
        const { id } = route.params;
        const { lecture } = useLectures(id);

        return {
            id,
            lecture
        }
    }
};
</script>

<style scoped>
</style>