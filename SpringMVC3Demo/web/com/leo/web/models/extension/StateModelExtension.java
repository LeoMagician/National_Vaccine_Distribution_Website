package com.leo.web.models.extension;

import com.leo.model.models.State;
import com.leo.web.models.StateEditModel;

public class StateModelExtension {

	public static State toState(StateEditModel editModel){
		State state = new State();
		state.setId(editModel.getId());
		state.setName(editModel.getName());
		state.setPopulation(editModel.getPopulation());
		return state;
	}
	
	public static StateEditModel toStateEdit(State state){
		StateEditModel sem = new StateEditModel();
		sem.setId(state.getId());
		sem.setName(state.getName());
		sem.setPopulation(state.getPopulation());
		return sem;
	}
	
}
