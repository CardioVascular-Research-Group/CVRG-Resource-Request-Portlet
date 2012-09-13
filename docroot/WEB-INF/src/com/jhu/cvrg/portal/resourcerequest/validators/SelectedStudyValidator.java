package com.jhu.cvrg.portal.resourcerequest.validators;
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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.jhu.cvrg.portal.resourcerequest.validators.SelectedStudyValidator")
public class SelectedStudyValidator implements Validator{

	@Override
	public void validate(FacesContext facesContext, UIComponent component, Object value)
			throws ValidatorException {
		int val = Integer.parseInt(value.toString());
		
		if(val == 0){
			FacesMessage message = new FacesMessage("No Study Selected", "Please select a Study");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			throw new ValidatorException(message);
		}		
	}
}
