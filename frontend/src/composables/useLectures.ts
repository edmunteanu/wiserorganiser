import { getLectureDetails } from '@/api/lectures';
import { getAllLectures } from '@/api/lectures';
import { Lecture } from '@/model/lecture';
import { ref } from 'vue';

export function useLectures() {
    const lecture = ref<Lecture>();
    const lectures = ref<Lecture[]>([]);

    const getLecture = async (lectureId: number) => {
        try {
            lecture.value = await getLectureDetails(lectureId);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    const getLectures = async (timetableId: number) => {
        try {
            lectures.value = await getAllLectures(timetableId);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    return {
        lecture,
        lectures,
        getLecture,
        getLectures
    }
}