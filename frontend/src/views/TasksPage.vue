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
            <p>Tasks :)</p>
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
    name: "TasksPage",
    components: {
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        IonPage,
    },
    
};
</script>