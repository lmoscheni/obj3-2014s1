/*
 * generated by Xtext
 */
package org.xtext.unq.planificador.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.xtext.unq.planificador.ui.internal.PdmActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class PdmExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return PdmActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return PdmActivator.getInstance().getInjector(PdmActivator.ORG_XTEXT_UNQ_PLANIFICADOR_PDM);
	}
	
}
