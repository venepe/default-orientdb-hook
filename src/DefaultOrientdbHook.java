import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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
		        	
		        	Date in = new Date();
		        	LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		        	Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		        	
				      
				    ((ODocument) iRecord).field("createdAt", out);
				    ((ODocument) iRecord).field("updatedAt", out);
				    
		            return RESULT.RECORD_CHANGED;
		              
			      }
		        
		          case BEFORE_UPDATE: {
		        	  Date in = new Date();
		        	  LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		        	  Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
					    
					  ((ODocument) iRecord).field("updatedAt", out);
					      
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
