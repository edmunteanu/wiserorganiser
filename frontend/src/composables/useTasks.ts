import { getAllTasks, getTaskDetails, createNewTask } from '@/api/tasks';
import { Task } from '@/model/task';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

export function useTasks() {
    const task = ref<Task>();
    const tasks = ref<Task[]>([]);
    const newTask = ref<Task>({});
    const router = useRouter();

    const getTask = async (taskId: number) => {
        try {
            task.value = await getTaskDetails(taskId);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    const getTasks = async (timetableId: number) => {
        try {
            tasks.value = await getAllTasks(timetableId);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    const addTask = async (timetableId: number) => {
        try {
            await createNewTask(timetableId, newTask.value);
            router.push('/tabs/tasks');
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    return {
        task,
        tasks,
        newTask,
        getTask,
        getTasks,
        addTask
    }
}