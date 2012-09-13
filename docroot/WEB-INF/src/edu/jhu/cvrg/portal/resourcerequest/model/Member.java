package edu.jhu.cvrg.portal.resourcerequest.model;
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
public class Member {

	private String memberName;
	private String userId;
	private String eMail;
	private String teams;

	public Member(String name, String id){
		memberName = name;
		userId = id;
	}
	
	public Member(String name, String id, String eMail){
		memberName = name;
		userId = id;
		this.eMail = eMail;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String geteMail() {
		return eMail;
	}

	public void setTeams(String teams) {
		this.teams = teams;
	}

	public String getTeams() {
		return teams;
	}
	
}
