package serializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoclass.Student;

public class StudentDeserialize {
	
    @Test
    public void deserializeStudent() throws JsonParseException, JsonMappingException, IOException {
   	 ObjectMapper omap=new ObjectMapper();
     File f=new File(".\\src\\test\\resources\\student.json");
     Student stud = omap.readValue(f,Student.class);
     System.out.println(stud.getName());
     System.out.println(stud.getAge());
     System.out.println(stud.getPhno());
     System.out.println(stud.getSubject()[0] );
     System.out.println(stud.getSubject()[1] );
     System.out.println(stud.getSubject()[2] );

     
     
    }

}
