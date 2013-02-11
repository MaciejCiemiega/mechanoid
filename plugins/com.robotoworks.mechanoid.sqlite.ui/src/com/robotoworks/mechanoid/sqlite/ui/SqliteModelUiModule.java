/*
 * generated by Xtext
 */
package com.robotoworks.mechanoid.sqlite.ui;


import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;

import com.google.inject.Binder;
import com.robotoworks.mechanoid.ui.builder.MechanoidBuilderParticipant;

/**
 * Use this class to register components to be used within the IDE.
 */
public class SqliteModelUiModule extends com.robotoworks.mechanoid.sqlite.ui.AbstractSqliteModelUiModule {
	public SqliteModelUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		
//		binder.bind(String.class)
//		.annotatedWith(com.google.inject.name.Names.named(
//		(XtextContentAssistProcessor.COMPLETION_AUTO_ACTIVATION_CHARS)))
//		.toInstance(".");

	}
	
	@Override
	public Class<? extends IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return MechanoidBuilderParticipant.class;
	}
	
	@Override
	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
		// TODO Auto-generated method stub
		return super.bindIXtextEditorCallback();
	}
}