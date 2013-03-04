package com.robotoworks.mechanoid.ops.generator

import com.robotoworks.mechanoid.ops.opServiceModel.Model
import com.robotoworks.mechanoid.ops.opServiceModel.UniqueDeclaration

import static extension com.robotoworks.mechanoid.text.Strings.*
import static extension com.robotoworks.mechanoid.ops.generator.Extensions.*

class ServiceBridgeGenerator {
		def CharSequence generate(Model model) '''
			�var svc = model.service�
			/*
			 * Generated by Robotoworks Mechanoid
			 */
			package �model.packageName�;
			
			import com.robotoworks.mechanoid.ops.OperationServiceBridge;
			import �model.packageName�.�svc.name.formatServiceName�;
			import android.content.Intent;
			import com.robotoworks.mechanoid.Mechanoid;			
			
			public abstract class Abstract�svc.name.formatServiceBridgeName� extends OperationServiceBridge {
				private static final Class<?> SERVICE_CLASS = �svc.name.formatServiceName�.class;

				public Abstract�svc.name.formatServiceBridgeName�(boolean enableLogging){
					super(enableLogging);
				}
							
				protected Class<?> getServiceClass() {
					return SERVICE_CLASS;
				}
			
				
				�FOR op : svc.ops�
				public int execute�op.name.pascalize�Operation(�FOR arg : op.args SEPARATOR ', '��arg.type.toTypeLiteral� �arg.name.camelize��ENDFOR�) {
					Intent intent = Abstract�op.name.pascalize�Operation.create�op.name.pascalize�Intent(�FOR arg : op.args SEPARATOR ', '��arg.name.camelize��ENDFOR�);
					
					�IF op.uniqueClause == null�
					Intent existingRequest = findPendingRequestByActionWithExtras(Abstract�op.name.pascalize�Operation.ACTION_�op.name.underscore.toUpperCase�, intent.getExtras());
					
					if(existingRequest != null) {
						return extractRequestId(existingRequest);
					}
					
					�ELSEIF op.uniqueClause instanceof UniqueDeclaration�
					�var uniqueDecl = op.uniqueClause as UniqueDeclaration�
					android.os.Bundle matcher = new android.os.Bundle();
					�FOR uarg : uniqueDecl.args�
					matcher.�uarg.type.toBundlePutMethodName�(Abstract�op.name.pascalize�Operation.EXTRA_�uarg.name.underscore.toUpperCase�, �uarg.name.camelize�);
					�ENDFOR�
					
					Intent existingRequest = findPendingRequestByActionWithExtras(Abstract�op.name.pascalize�Operation.ACTION_�op.name.underscore.toUpperCase�, matcher);

					if(existingRequest != null) {
						return extractRequestId(existingRequest);
					}
					
					�ENDIF�
					int requestId = createServiceRequest(intent);
					
					Mechanoid.startService(intent);
					
					return requestId;
				}
				�ENDFOR�
			}
			'''
			
		def CharSequence generateStub(Model model) '''
			�var svc = model.service�
			/*
			 * Generated by Robotoworks Mechanoid
			 */
			package �model.packageName�;
			
			public class �svc.name.formatServiceBridgeName� extends Abstract�svc.name.formatServiceBridgeName� {

				private static �svc.name.formatServiceBridgeName� instance;
				
				public static �svc.name.formatServiceBridgeName� getInstance() {
					if(instance == null) {
						instance = new �svc.name.formatServiceBridgeName�();
					} 
					return instance;
				}
				
				private �svc.name.formatServiceBridgeName�(){
					super(false);
				}
			
			}
			
		'''
}