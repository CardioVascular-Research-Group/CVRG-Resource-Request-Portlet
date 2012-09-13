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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edu.jhu.cvrg.portal.resourcerequest.utility.ResourceUtility;

@FacesConverter (value = "nameConverter")
public class NameConverter implements Converter{

    public NameConverter() {
    }

    public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
    	String fullName="";
    	fullName = ResourceUtility.convertToUserName(Long.valueOf(value));
        return fullName;
   }

    public String getAsString(FacesContext ctx, UIComponent comp, Object value) {
     
    	String fullName="";
    	if(value instanceof Long){
    		fullName = ResourceUtility.convertToUserName((Long)value);
    	}
        return fullName;
    }    
}