package tdt4250.studyprogramme.examples;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import tdt4250.studyprogramme.CourseCombination;
import tdt4250.studyprogramme.Programme;
import tdt4250.studyprogramme.StudyprogrammePackage;
import tdt4250.studyprogramme.UOD;

public class LoadResourceExample {

	public static void main(String[] args) {
		ResourceSet resSet = new ResourceSetImpl();
		// relate the RaPackage identifier used in XMI files to the RaPackage instance (EPackage meta-object) 
		resSet.getPackageRegistry().put(StudyprogrammePackage.eNS_URI, StudyprogrammePackage.eINSTANCE);
		// relate the XMI parser to the 'xmi' file extension
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		Resource resource = resSet.getResource(URI.createURI(LoadResourceExample.class.getResource("UOD.xmi").toString()), true);
		
		UOD uod = (UOD) resource.getContents().get(0);
		for (Programme programme : uod.getProgrammes()) {
			System.out.println(programme.getName() + "\n");	
			programme.getAcademicYears().get(0).getCourseCombinations().get(0)
				.getCourseGroups().forEach(cc -> {
					cc.getCourses().forEach(course -> {
						System.out.println(course.getName() + " " + course.getCredits());
					});
				});
		}
		
	}
}
