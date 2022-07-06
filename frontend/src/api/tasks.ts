import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Task } from '@/model/task';

export async function getAllTasks(timetableId: number): Promise<Task[]>   { 
    const config = {        
        withCredentials: true
    }

    try {
        const response = await axios.get(API_ROOT + '/api/timetables/' + timetableId + '/tasks', config);
        return response.data;
    } catch (error) {
        return <any>error;   
    }
}
