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
                <ion-list class="ion-padding">
                    <h2><strong>Lecture Details zur Nr. {{ lecture.id }}</strong></h2>
                    <ion-text>
                        <h3>Lecture name</h3>
                        <p>{{ lecture.name }}</p>
                        <h3>Description</h3>
                        <p>{{ lecture.description }}</p>
                        <h3>Professor</h3>
                        <p>{{ lecture.professor }}</p>
                        <h3>Room</h3>
                        <p>{{ lecture.room }}</p>
                    </ion-text>
                 </ion-list>
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