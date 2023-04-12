package entity;

public class TechMaster {
    private static int autoId;
    private int id;
    private String managerName;
    private String teacherName;
    private Classroom classroom;

    public TechMaster(String managerName, String teacherName, Classroom classroom) {
        this.id = ++autoId;
        this.managerName = managerName;
        this.teacherName = teacherName;
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Khóa học thứ: " + id + "\n" +
                "Người quản lý: " + managerName + "\n" +
                "Giáo viên: " + teacherName + "\n" +
                "Lớp học: " + id + classroom;
    }
}
