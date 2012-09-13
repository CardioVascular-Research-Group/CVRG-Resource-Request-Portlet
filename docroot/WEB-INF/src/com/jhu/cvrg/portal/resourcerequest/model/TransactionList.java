package com.jhu.cvrg.portal.resourcerequest.model;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.jhu.cvrg.portal.resourcerequest.service.TransactionLocalServiceUtil;
import com.jhu.cvrg.portal.resourcerequest.utility.ResourceUtility;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

@ManagedBean(name = "transactionList")
@RequestScoped
public class TransactionList{

	private ArrayList<Transaction> transactionHistoryList;
	private boolean descending = true;
	private boolean oldDescending = descending;
	private String columnName = "date";
	private String oldColumnName = columnName;

	public TransactionList(){
		init();
	}
	
	public void init(){
		transactionHistoryList = new ArrayList<Transaction>();
		User currentUser;

		try {
			currentUser = ResourceUtility.getCurrentUser();	
			
			if(currentUser != null){
			
			// Find all study names for which I am an approver or PI
			ArrayList<String> studyNames = ResourceUtility.getMyStudyNames(currentUser.getUserId());

			if (studyNames.size() > 0) {
				for (String studyName : studyNames) {
					long studyId = ResourceUtility.convertToStudyId(currentUser.getUserId(), studyName);
					transactionHistoryList.addAll(getSortedList(studyId));
				}
			}
			}
		} catch (NumberFormatException e) {
			ResourceUtility.printErrorMessage("Transaction List Bean");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Transaction> getSortedList(long studyId){
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		
		try {
			transactionList.addAll(TransactionLocalServiceUtil.findTransactionsByStudy(studyId));
			
			if(columnName.equals("date")){
				System.out.println("date");
				transactionList = sortByDate(transactionList);
			}
			if(columnName.equals("memberName")){
				System.out.println("memberName");
				transactionList = sortByRequester(transactionList);
			}
			if(columnName.equals("study")){
				System.out.println("study");
				transactionList = sortByStudy(transactionList);
			}
			if(columnName.equals("approver")){
				System.out.println("approver");
				transactionList = sortByApprover(transactionList);
			}
			if(columnName.equals("action")){
				System.out.println("action");
				transactionList = sortByAction(transactionList);
			}
			
		} catch (SystemException e) {
			ResourceUtility.printErrorMessage("Transaction List Bean");
			e.printStackTrace();
		}
		
		return transactionList;
		
	}

	public ArrayList<Transaction> sortByDate(ArrayList<Transaction> list){
		
        Collections.sort(list, new Comparator<Transaction>(){

        	int order;
        	
            public int compare(Transaction t1, Transaction t2) {
            	Date d1 = t1.getDate();
            	Date d2 = t2.getDate();

            	order = descending ? 1 : -1;
            		
            	return order * (d1.compareTo(d2));             
            }
        });
        
        return list;
	}
	
	public ArrayList<Transaction> sortByRequester(ArrayList<Transaction> list){
				
        Collections.sort(list, new Comparator<Transaction>(){

        	int order;	
            public int compare(Transaction t1, Transaction t2) {

            	User u1 = ResourceUtility.getUser(t1.getMemberId());
            	User u2 = ResourceUtility.getUser(t2.getMemberId());
            	order = descending ? 1 : -1;
         	
            	int result = u1.getFirstName().compareToIgnoreCase(u2.getFirstName());

            	return order * result;             
            }
        });
        
        return sortByRequesterLast(list);

	}
	
	public ArrayList<Transaction> sortByRequesterLast(ArrayList<Transaction> list){
		
        Collections.sort(list, new Comparator<Transaction>(){

        	int order;
        	
            public int compare(Transaction t1, Transaction t2) {
            	User u1 = ResourceUtility.getUser(t1.getMemberId());
            	User u2 = ResourceUtility.getUser(t2.getMemberId());

            	order = descending ? 1 : -1;
            	
            	return order * (u1.getLastName().compareToIgnoreCase(u2.getLastName()));             
            }
        });
        
        return list;
	}

	public ArrayList<Transaction> sortByStudy(ArrayList<Transaction> list){
        Collections.sort(list, new Comparator<Transaction>(){

        	int order;
        	
            public int compare(Transaction t1, Transaction t2) {
            	String team1 = ResourceUtility.convertToStudyName(t1.getStudyId());
            	String team2 = ResourceUtility.convertToStudyName(t2.getStudyId());

            	order = descending ? 1 : -1;
            	
            	return order * (team1.compareToIgnoreCase(team2));
            }
        });
        
        return list;
	}
	
	public ArrayList<Transaction> sortByApprover(ArrayList<Transaction> list){
        Collections.sort(list, new Comparator<Transaction>(){

        	int order;
        	
            public int compare(Transaction t1, Transaction t2) {
            	User u1 = ResourceUtility.getUser(t1.getApproverId());
            	User u2 = ResourceUtility.getUser(t2.getApproverId());
            	
            	order = descending ? 1 : -1;
            	
            	return order * (u1.getFirstName().compareToIgnoreCase(u2.getFirstName()));
            }
        });
        
        return sortByApproverLast(list);
	}
	
	public ArrayList<Transaction> sortByApproverLast(ArrayList<Transaction> list){
        Collections.sort(list, new Comparator<Transaction>(){

        	int order;
        	
            public int compare(Transaction t1, Transaction t2) {
            	User u1 = ResourceUtility.getUser(t1.getApproverId());
            	User u2 = ResourceUtility.getUser(t2.getApproverId());
            	
            	order = descending ? 1 : -1;
            	
            	return order * (u1.getLastName().compareToIgnoreCase(u2.getLastName()));
            }
        });
        
        return list;
	}
	
	public ArrayList<Transaction> sortByAction(ArrayList<Transaction> list){
        Collections.sort(list, new Comparator<Transaction>(){

        	int order;
        	
            public int compare(Transaction t1, Transaction t2) {
            	String action1 = t1.getAction();
            	String action2 = t2.getAction();
            	
            	order = descending ? 1 : -1;
            	
            	return order * (action1.compareToIgnoreCase(action2));
            }
        });
        
        return list;
	}
	
	public ArrayList<Transaction> getTransactionHistoryList() {
		return transactionHistoryList;
	}

	public void setDescending(boolean descending) {
        oldDescending = this.descending;
        this.descending = descending;
	}

	public boolean isDescending() {
		return descending;
	}

	public void setOldDescending(boolean oldDescending) {
		this.oldDescending = oldDescending;
	}

	public boolean isOldDescending() {
		return oldDescending;
	}

	public void setOldColumnName(String oldColumnName) {
		this.oldColumnName = oldColumnName;
	}

	public String getOldColumnName() {
		return oldColumnName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
        oldColumnName = this.columnName;
        this.columnName = columnName;
	}
}
