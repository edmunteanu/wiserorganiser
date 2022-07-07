export interface Task {
    id?: number;
    name?: string;
    description?: string;
    startHour?: string;
    endHour?: string;
    day?: string;
    done?: boolean;
}