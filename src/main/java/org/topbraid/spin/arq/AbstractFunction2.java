/*******************************************************************************
 * Copyright (c) 2009 TopQuadrant, Inc.
 * All rights reserved. 
 *******************************************************************************/
package org.topbraid.spin.arq;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.sparql.expr.NodeValue;
import com.hp.hpl.jena.sparql.function.FunctionEnv;


/**
 * An abstract superclass for Functions with 2 arguments.
 * 
 * @author Holger Knublauch
 */
public abstract class AbstractFunction2 extends AbstractFunction {

	@Override
	protected NodeValue exec(Node[] nodes, FunctionEnv env) {
		Node arg1 = nodes.length > 0 ? nodes[0] : null;
		Node arg2 = nodes.length > 1 ? nodes[1] : null;
		return exec(arg1, arg2, env);
	}
	
	
	protected abstract NodeValue exec(Node arg1, Node arg2, FunctionEnv env);
}
