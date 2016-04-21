import java.time.Instant;

import com.orientechnologies.orient.core.hook.ODocumentHookAbstract;
import com.orientechnologies.orient.core.hook.ORecordHook;
import com.orientechnologies.orient.core.record.ORecord;
import com.orientechnologies.orient.core.record.impl.ODocument;

public class DefaultOrientdbHook extends ODocumentHookAbstract implements ORecordHook {

	@Override
	public DISTRIBUTED_EXECUTION_MODE getDistributedExecutionMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RESULT onTrigger(TYPE iType, ORecord iRecord) {
		// TODO Auto-generated method stub
		if( iRecord instanceof ODocument ){

		      switch( iType ){
		        case BEFORE_CREATE: {
		        	
		        	String instant = Instant.now().toString();
				      
				    ((ODocument) iRecord).field("createdAt", instant);
				    ((ODocument) iRecord).field("updatedAt", instant);
				    
		            return RESULT.RECORD_CHANGED;
		              
			      }
		        
		          case BEFORE_UPDATE: {
		        	  
		        	  String instant = Instant.now().toString();
					    
					  ((ODocument) iRecord).field("updatedAt", instant);
					      
			          return RESULT.RECORD_CHANGED;
		          }
		        
					default:
						break;
		    }
		  }
        return RESULT.RECORD_NOT_CHANGED;
	}

	@Override
	public void onUnregister() {
		// TODO Auto-generated method stub
		
	}
	

}
