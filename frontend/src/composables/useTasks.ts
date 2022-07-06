import { getAllTasks } from '@/api/tasks';
import { Task } from '@/model/task';
import { onMounted, ref } from 'vue';

export function useTasks(timetableId: number) {

    const tasks = ref<Task[]>([]);

    const getTasks = async (timetableId: number) => {
        try {
            tasks.value = await getAllTasks(timetableId);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(() => {
        getTasks(timetableId);
    });

    return {
        tasks,
        getTasks,
    }
}