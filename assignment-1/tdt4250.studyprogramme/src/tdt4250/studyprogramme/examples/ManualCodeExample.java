package tdt4250.studyprogramme.examples;

import tdt4250.studyprogramme.Course;
import tdt4250.studyprogramme.CourseCriterion;
import tdt4250.studyprogramme.StudyprogramFactory;

public class ManualCodeExample {

	public static void main(String[] args) {
		CourseCriterion courseCriterion = StudyprogramFactory.eINSTANCE.createCourseCriterion();
		
		Course tdt4175 = StudyprogramFactory.eINSTANCE.createCourse();
		tdt4175.setName("Informasjonssystemer");
		courseCriterion.getCourses().add(asd);
		System.out.println(courseCriterion.isMandatory());
		
		
	}
}
