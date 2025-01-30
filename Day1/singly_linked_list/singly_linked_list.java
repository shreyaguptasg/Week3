package Day1.singly_linked_list;

class Student{
    String rollNumber;
    String name;
    int age;
    String grade;
    Student next;
    Student(String rollNumber, String name, int age, String grade){
        this.rollNumber= rollNumber;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.next =  null;
    }
}
public class singly_linked_list {
    private Student head;
    //adding node at first position
    public void addFirst(String rollNumber, String name, int age, String grade){
        Student newStudent = new Student(rollNumber,name,age,grade);
        if(head== null){
            head= newStudent;
            return;
        }
            head.next = newStudent;
            head = newStudent;

    }
    //adding the node at last position
    public void addLast(String rollNumber, String name, int age, String grade){
        Student newStudent = new Student(rollNumber,name,age,grade);
        if(head==null){
            head = newStudent;
            return;
        }
        Student currentStudent = head;
        while(currentStudent.next!=null){
            currentStudent= currentStudent.next;
        }
        currentStudent.next= newStudent;
    }
    //adding the node at specified index
    public void addSpecificPosition(int position,String rollNumber, String name, int age, String grade){
        if(position<0){
            System.out.println("Invalid position");
            return;
        }
        if(position==1){
            addFirst(rollNumber,name,age,grade);
            return;
        }
        Student newStudent = new Student(rollNumber,name,age,grade);
        Student currentStudent = head;
        for(int i=1; i<position -1; i++){
            if(currentStudent==null){
                System.out.println("Out of bound position");
                return;
            }
            currentStudent = currentStudent.next;
        }
        newStudent = currentStudent.next;
        currentStudent.next = newStudent;

    }
    //Deleting the node by rollnumber
    public void deleteByRollNumber(String rollNumber){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        if(head.rollNumber == rollNumber){
            head = head.next;
            System.out.println("Student with roll number " + rollNumber + " is deleted");
            return;
        }
        Student current = head;
        while(current.next!=null && current.next.rollNumber!=rollNumber){
            current = current.next;
        }
        if(current.next== null){
            System.out.println("Student with roll number " + rollNumber + " does not found");
            return;
        }
        else{
               current.next = current.next.next;
            System.out.println("Student with roll number " + rollNumber + " deleted") ;
        }
    }
    // search student with roll number
    public void searchByRollNumber(String rollNumber){
        Student current = head;
        while(current!=null){
            if(current.rollNumber==rollNumber){
                System.out.println("Student with roll number " + rollNumber + " found");
                return;
            }
            current= current.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found");
    }
    //priniting the list
    public void printStudent(){
        if(head==null) {
            System.out.println("List is empty");
        }
        Student currentStudent = head;
        while(currentStudent!=null){
            System.out.print(currentStudent.rollNumber + " " + currentStudent.name + " " + currentStudent.grade + " " + currentStudent.age + " -->");
            currentStudent = currentStudent.next;
        }
        System.out.println("NULL");
    }
    //updating the student grade by rollnumber
    public void updateGradeByRollNumber(String rollNumber, String grade){
        Student current = head;
      while(current!=null){
          if(current.rollNumber==rollNumber){
              current.grade = grade;
              System.out.println("Grade updated for rollnumber " + rollNumber);
          }
          current= current.next;
      }
        System.out.println("Student with roll number " + rollNumber + " not found");
    }
    public static void main(String[] args) {
        singly_linked_list student = new singly_linked_list();
        student.addFirst("0909","alix",23,"a");
        student.addFirst("779","bhem",25,"a");
        student.printStudent();
        student.addLast("01234","ram",23,"a");
        student.printStudent();
        student.addSpecificPosition(1,"8778","ramu", 23,"b");
        student.printStudent();
        student.searchByRollNumber("1779");
        student.updateGradeByRollNumber("3", "A+");
        student.printStudent();
        student.deleteByRollNumber("1779");
        student.printStudent();

    }
}
