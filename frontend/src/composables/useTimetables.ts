import { getAllTimetables } from '@/api/timetables';
import { Timetable } from '@/model/timetable';
import { onMounted, ref } from 'vue';

export function useTimetables() {

    const timetables = ref<Timetable[]>([]);

    const getTimetables = async () => {
        try {
            timetables.value = await getAllTimetables();
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getTimetables);

    return {
        timetables,
        getTimetables,
    }
}