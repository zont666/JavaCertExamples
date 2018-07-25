package enthuware.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import enthuware.streams.CollectingAdvanced.Student.Grade;

public class CollectingAdvanced {

  public static void main( String[] args ) {
    List<Student> ls = Arrays.asList( new Student( "S1", Student.Grade.A ), new Student( "S2", Student.Grade.A ), new Student( "S3", Student.Grade.C ) );
    Map<Grade, List<String>> grouping = ls.stream().collect( //
            Collectors.groupingBy( Student::getGrade, //
            Collectors.mapping( Student::getName, Collectors.toList() ) ) );
    System.out.println( grouping );

  }

  static class Student {
    public static enum Grade {
      A, B, C, D, E, F;
    }

    private String name;
    private Grade grade;

    public Student( String name, Grade grade ) {
      this.name = name;
      this.grade = grade;
    }

    public String getName() {
      return name;
    }

    public void setName( String name ) {
      this.name = name;
    }

    public Grade getGrade() {
      return grade;
    }

    public void setGrade( Grade grade ) {
      this.grade = grade;
    }

    public String toString() {
      return name + ":" + grade;
    }
  }

}
