<template>
  <ion-page>
    <ion-tabs>
      <ion-router-outlet></ion-router-outlet>
      <ion-tab-bar slot="bottom">
        <ion-tab-button tab="timetable" href="/tabs/timetable">
          <ion-icon :icon="calendarOutline" />
          <ion-label>Stundenplan</ion-label>
        </ion-tab-button>
          
        <ion-tab-button tab="tasks" href="/tabs/tasks">
          <ion-icon :icon="pencilOutline" />
          <ion-label>Tasks</ion-label>
        </ion-tab-button>
      </ion-tab-bar>
    </ion-tabs>
  </ion-page>
</template>

<script lang="ts">
import { IonTabBar, IonTabButton, IonTabs, IonLabel, IonIcon, IonPage, IonRouterOutlet } from '@ionic/vue';
import { pencilOutline, calendarOutline } from 'ionicons/icons';

export default {
  name: 'Tabs',
  components: { IonLabel, IonTabs, IonTabBar, IonTabButton, IonIcon, IonPage, IonRouterOutlet },
  setup() {
    return {
      pencilOutline,
      calendarOutline
    }
  }
}
</script>