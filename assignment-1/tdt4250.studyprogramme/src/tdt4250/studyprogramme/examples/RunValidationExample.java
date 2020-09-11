package tdt4250.studyprogramme.examples;

import org.eclipse.acceleo.query.delegates.AQLValidationDelegate;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator.ValidationDelegate;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import tdt4250.studyprogramme.StudyprogrammePackage;
import tdt4250.studyprogramme.UOD;

public class RunValidationExample {

	public static void main(String[] args) {
		// register AQL (an OCL implementation) constraint support
		ValidationDelegate.Registry.INSTANCE.put("http://www.eclipse.org/acceleo/query/1.0", new AQLValidationDelegate());

		
		ResourceSet resSet = new ResourceSetImpl();
		// relate the RaPackage identifier used in XMI files to the RaPackage instance (EPackage meta-object) 
		resSet.getPackageRegistry().put(StudyprogrammePackage.eNS_URI, StudyprogrammePackage.eINSTANCE);
		// relate the XMI parser to the 'xmi' file extension
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		Resource resource = resSet.getResource(URI.createURI(LoadResourceExample.class.getResource("UOD.xmi").toString()), true);
		
		UOD uod = (UOD) resource.getContents().get(0);
		
		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(uod);
		if (diagnostics.getSeverity() != Diagnostic.OK) {
			printDiagnostic(diagnostics, "");
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * Prints diagnostics with indentation.
	 * <!-- end-user-doc -->
	 * @param diagnostic the diagnostic to print.
	 * @param indent the indentation for printing.
	 * @generated
	 */
	protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
		System.out.print(indent);
		System.out.println(diagnostic.getMessage());
		for (Diagnostic child : diagnostic.getChildren()) {
			printDiagnostic(child, indent + "  ");
		}
	}
}
