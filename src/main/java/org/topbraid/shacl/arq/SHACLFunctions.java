package org.topbraid.shacl.arq;

import org.topbraid.shacl.vocabulary.SHACL;
import org.topbraid.spin.arq.SPINFunctionDrivers;
import org.topbraid.spin.util.JenaUtil;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.function.FunctionFactory;
import com.hp.hpl.jena.sparql.function.FunctionRegistry;

/**
 * Manages globally registered SHACL functions, usually loaded from .shacl.* files.
 * 
 * @author Holger Knublauch
 */
public class SHACLFunctions {

	public static void registerFunctions(Model model) {
		Resource shaclFunctionClass = SHACL.Function.inModel(model);
		for(Resource resource : JenaUtil.getAllInstances(shaclFunctionClass)) {
			if(resource.isURIResource()) {
				registerFunction(resource);
			}
		}
	}

	
	public static void registerFunction(Resource resource) {
		FunctionFactory arqFunction = SPINFunctionDrivers.get().create(resource);
		if(arqFunction != null) {
			FunctionRegistry.get().put(resource.getURI(), arqFunction);
		}
	}
}
