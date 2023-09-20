package serializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoclass.Student;

public class StudentSerialize {
	
	@Test
	public void serializeStudent() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper omap=new ObjectMapper();
		String sub[]= {"math","english","science"};
		Student s=new Student("rajhans",26,8409820806l,sub);
		File f=new File(".\\src\\test\\resources\\student.json");
		omap.writeValue(f,s);
	}

}
