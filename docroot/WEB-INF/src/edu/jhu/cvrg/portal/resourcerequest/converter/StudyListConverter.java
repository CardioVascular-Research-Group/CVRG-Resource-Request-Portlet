package edu.jhu.cvrg.portal.resourcerequest.converter;
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
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.liferay.portal.model.Team;

import edu.jhu.cvrg.portal.resourcerequest.utility.ResourceUtility;

@FacesConverter (value = "studyListConverter")
public class StudyListConverter implements Converter{

    public StudyListConverter() {
    }

    public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {

        return null;
   }

    public String getAsString(FacesContext ctx, UIComponent comp, Object value) {
     
    	String studies="";
    	if(value instanceof List<?>){
    		@SuppressWarnings("unchecked")
			List<Team> teamList = (List<Team>) value;
    		for(Team team : teamList)
    		{
    			if(ResourceUtility.checkApprover(team)){
    				studies = studies + team.getName() + " ";
    			}
    		}
    	}
        return studies;
    }    
}