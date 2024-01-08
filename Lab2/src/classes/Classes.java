package classes;

public class Classes{
    public static void main(String[] args){
        Student[] students = new Student[]{new Student("Andrei", "Negoita", 2231, 6), new Student("Ion", "Mateescu", 4221,6)};
        Student student = new Student("Stefan", "Jica", 2231, 10);
        Professor prof = new Professor("Anton", "Panaitescu");

        Course course = new Course("Material Resistance", "Calculations of Reactions, \n" + "effort diagrams, calculations of geometric characteristics of\n" + "flat surfaces and calculations of resistance elements to simple stresses", prof, students);
        course.addStudent(student);

        CourseManager courseManager = new CourseManager();
        courseManager.addCourse(course);
        courseManager.displayCoursesToConsole();
        courseManager.listStudentsInCourse("Material Resistance");
        courseManager.MediaStudentiCursuri("Material Resistance");
        courseManager.MedieCursuriAnumitProf(prof);

    }
}