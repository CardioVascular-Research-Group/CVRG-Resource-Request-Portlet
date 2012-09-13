package com.jhu.cvrg.portal.resourcerequest.backing;
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import com.jhu.cvrg.portal.resourcerequest.model.Transaction;
import com.jhu.cvrg.portal.resourcerequest.service.TransactionLocalServiceUtil;
import com.jhu.cvrg.portal.resourcerequest.utility.ResourceUtility;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean(name = "transactionHistoryBacking")
@RequestScoped
public class TransactionHistoryBacking {

	private boolean showHistoryDetail;
	private boolean showHistoryMain;
	private Transaction viewingTransaction;
	private enum ShowPanel {MAIN, DETAIL}
	
	public TransactionHistoryBacking(){
		initialize();
	}
	
	public void initialize(){
		viewingTransaction = null;
		switchView(ShowPanel.MAIN);
	}

	private void switchView(ShowPanel panel){
		showHistoryMain = false;
		showHistoryDetail = false;
		
		switch (panel){
		case MAIN: 		showHistoryMain = true; 		break;
		case DETAIL: 	showHistoryDetail = true;		break;
		default:		switchView(ShowPanel.MAIN);		break;
		}
	}
	
	public void showHistory(ActionEvent event){
		initialize();
	}

	public void viewHistoryDetails(ActionEvent event){

		switchView(ShowPanel.DETAIL);

		long transactionId = ResourceUtility.getIdParameter("transactionId");
		
		try {
			viewingTransaction = TransactionLocalServiceUtil.getTransaction(transactionId);
		} catch (PortalException e) {
			ResourceUtility.printErrorMessage("History Bean");
			e.printStackTrace();
		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("History Bean");
			e.printStackTrace();
		}
	}

	public boolean isShowHistoryDetail() {
		return showHistoryDetail;
	}

	public Transaction getViewingTransaction() {
		return viewingTransaction;
	}

	public boolean isShowHistoryMain() {
		return showHistoryMain;
	}
}
