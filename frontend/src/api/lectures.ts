import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { Lecture } from '@/model/lecture';

export async function getLectureDetails(lectureId: number): Promise<Lecture>   { 

    const config = {        
        withCredentials: true
    }
    try {
        const response = await axios.get(API_ROOT + '/api/lectures/' + lectureId, config);
        return response.data;
    } catch (error) {
        return <any>error;   
    }
}