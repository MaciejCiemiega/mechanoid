/*
* generated by Xtext
*/
package com.robotoworks.mechanoid.ops.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;

public class AbstractOpServiceModelJavaValidator extends org.eclipse.xtext.validation.AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(com.robotoworks.mechanoid.ops.opServiceModel.OpServiceModelPackage.eINSTANCE);
		return result;
	}

}
