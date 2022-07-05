import { getLectureDetails } from '@/api/lectures';
import { Lecture } from '@/model/lecture';
import { onMounted, ref } from 'vue';

export function useLectures(lectureId: number) {

    const lecture = ref<Lecture>();

    const getLecture = async () => {
        try {
            lecture.value = await getLectureDetails(lectureId);
        } catch (error) {
            console.log(error); // FIXME: Errorhandling
        }
    }

    onMounted(getLecture);

    return {
        lecture,
        getLecture,
    }
}