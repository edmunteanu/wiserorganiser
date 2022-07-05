<template>
  <ion-page>
    <ion-tabs>
      <ion-router-outlet></ion-router-outlet>
      <ion-tab-bar slot="bottom">
        <ion-tab-button tab="todo" href="/tabs/todo">
          <ion-icon :icon="calendarOutline" />
          <ion-label>Stundenplan</ion-label>
        </ion-tab-button>
          
        <ion-tab-button tab="projects" href="/tabs/projects">
          <ion-icon :icon="pencilOutline" />
          <ion-label>Tasks</ion-label>
        </ion-tab-button>
        
        <ion-tab-button tab="timerecord" href="/tabs/timerecord">
          <ion-icon :icon="settingsOutline" />
          <ion-label>Einstellungen</ion-label>
        </ion-tab-button>
      </ion-tab-bar>
    </ion-tabs>
  </ion-page>
</template>

<script lang="ts">
import { IonTabBar, IonTabButton, IonTabs, IonLabel, IonIcon, IonPage, IonRouterOutlet } from '@ionic/vue';
import { settingsOutline, pencilOutline, calendarOutline } from 'ionicons/icons';

export default {
  name: 'Tabs',
  components: { IonLabel, IonTabs, IonTabBar, IonTabButton, IonIcon, IonPage, IonRouterOutlet },
  setup() {
    return {
      settingsOutline,
      pencilOutline,
      calendarOutline
    }
  }
}
</script>