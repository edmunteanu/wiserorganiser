import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Timetable } from '@/model/timetable';

export async function getAllTimetables(): Promise<Timetable[]>   { 
    const config = {        
        withCredentials: true
    }
    try {
        const response = await axios.get(API_ROOT + '/api/timetables', config);
        return response.data;
    } catch (error) {
        return <any>error;   
    }
}
