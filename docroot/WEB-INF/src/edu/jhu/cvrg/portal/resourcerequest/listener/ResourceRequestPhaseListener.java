package edu.jhu.cvrg.portal.resourcerequest.listener;
/*
Copyright 2011 Johns Hopkins University Institute for Computational Medicine

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
/**
* @author Chris Jurado
* 
*/
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.portletfaces.liferay.faces.context.LiferayFacesContext;

import edu.jhu.cvrg.portal.resourcerequest.model.MemberList;
import edu.jhu.cvrg.portal.resourcerequest.model.TransactionList;

public class ResourceRequestPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	private static LiferayFacesContext liferayFacesContext;
	
	public void afterPhase(PhaseEvent pe) {

		liferayFacesContext = LiferayFacesContext.getInstance();
		
		if (pe.getPhaseId() == PhaseId.PROCESS_VALIDATIONS) {

			FacesContext facesContext = FacesContext.getCurrentInstance();
			Iterator<FacesMessage> messages = facesContext.getMessages();
			while (messages.hasNext()) {
				FacesMessage message = messages.next();
				message.setSeverity(FacesMessage.SEVERITY_INFO);
			}
		}
	}

	public void beforePhase(PhaseEvent pe) {

		liferayFacesContext = LiferayFacesContext.getInstance();
		
		if(pe.getPhaseId() == PhaseId.RENDER_RESPONSE){

			MemberList membersList = (MemberList) liferayFacesContext
			.getApplication().getELResolver().getValue(
					liferayFacesContext.getELContext(), null, "memberList");
			membersList.initialize();
			
			sortTransactions();
		}
	}

	private void sortTransactions(){
	        TransactionList transactionList =
	                (TransactionList)liferayFacesContext
	    			.getApplication().getELResolver().getValue(
	    					liferayFacesContext.getELContext(), null, "transactionList");

	        if(transactionList != null){
	        if ((transactionList.isDescending() != transactionList.isOldDescending()) ||
	                (!transactionList.getColumnName().equals(transactionList.getOldColumnName()))){
	        	transactionList.init();

	        	transactionList.setOldDescending(transactionList.isDescending());
	        	transactionList.setOldColumnName(transactionList.getColumnName());
	        }
	    }
	}
	
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
