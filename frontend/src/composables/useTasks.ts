import { getAllTasks } from '@/api/tasks';
import { Task } from '@/model/task';
import { onMounted, ref } from 'vue';
import { getTaskDetails } from '@/api/tasks';

export function useTasks(id: number) {
    const task = ref<Task>();
    const tasks = ref<Task[]>([]);

    const getTask = async () => {
        try {
            task.value = await getTaskDetails(id);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    const getTasks = async () => {
        try {
            tasks.value = await getAllTasks(id);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }
    
    onMounted(getTask);
    onMounted(getTasks);

    return {
        task,
        tasks,
        getTask,
        getTasks,
    }
}