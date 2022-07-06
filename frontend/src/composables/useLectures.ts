import { getLectureDetails } from '@/api/lectures';
import { getAllLectures } from '@/api/lectures';
import { Lecture } from '@/model/lecture';
import { onMounted, ref } from 'vue';

export function useLectures(id: number) {
    const lecture = ref<Lecture>();
    const lectures = ref<Lecture[]>([]);

    const getLecture = async () => {
        try {
            lecture.value = await getLectureDetails(id);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    const getLectures = async () => {
        try {
            lectures.value = await getAllLectures(id);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getLecture);
    onMounted(getLectures);

    return {
        lecture,
        lectures,
        getLecture,
        getLectures
    }
}