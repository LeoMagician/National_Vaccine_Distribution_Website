package com.leo.web.models.extension;

import java.util.List;
import java.util.ArrayList;

import com.infrastructure.project.base.model.models.ChainEntity;
import com.leo.web.models.TreeModel;

public class TreeModelExtension {
	
	/*public static <PKType extends Number, EntityType extends ChainEntity<PKType, EntityType>> List<EntityType> listChain(List<EntityType> allEntities){
		
		//List<EntityType> allEntities=listAll();
		List<EntityType> chainEntities =  Lambda.select(allEntities, Lambda.having(Lambda.on().getParent(), Matchers.equalTo(null)));
		toChain(chainEntities, allEntities);
		
		boolean ff3 = Lambda.exists(ff1,
				Lambda.having(Lambda.on(this.entityClass).getParent(), Matchers.equalTo(null)));
			
		return chainEntities;
			
	}*/

	public static <PKType extends Number, EntityType extends ChainEntity<PKType, EntityType>> List<TreeModel> ToTreeModels(List<EntityType> entities, PKType selectedId, List<PKType> checkedIdList, List<PKType> expandedIdList)
	{
		
		List<TreeModel> treeModels = new ArrayList<TreeModel>();
	    for (EntityType entity : entities)
	    {
	        boolean checked = false;
	        boolean selected = false;
	        boolean collpase = true;
	        List<TreeModel> children = null;
 
	        if (selectedId!=null && selectedId.equals(entity.getId()))
            	selected = true;
	        if(checkedIdList!=null && !checkedIdList.isEmpty())
	        	checked = checkedIdList.contains(entity.getId());
            if(expandedIdList!=null && !expandedIdList.isEmpty())
            	collpase = !expandedIdList.contains(entity.getId());
            if(entity.getChildren()!=null && !entity.getChildren().isEmpty())
            	children=ToTreeModels(entity.getChildren(), selectedId, checkedIdList, expandedIdList);
            
            
            treeModels.add(new TreeModel(entity.getId().toString(),
	        		entity.getId().toString(),
	        		entity.getName().toString(),checked, selected, collpase, children));
	        
	        /*if (expanded.IsNotNullOrEmpty())
	            collpase = !expanded.Contains(fd.Id);*/
	        //treeModels.Add(new TreeModel { id = fd.Id.ToString(), value = fd.TheValue, text = fd.Name.HtmlEncode(), selected = isSelected, collpase = collpase, @checked = isChecked, children = fd.Children.IsNotNullOrEmpty() ? ToTreeModels(fd.Children as IList<EntityType>, selected, checkedList, expanded) : null });
	    }
	    return treeModels;
	}
	
	/*public static <PKType extends Number, EntityType extends ChainEntity<PKType, EntityType>> List<TreeModel> ToTreeModels(List<EntityType> entities, PKType selectedId, List<PKType> checkedIdList)
	{
	    List<TreeModel> treeModels = new ArrayList<TreeModel>();
	    for (EntityType entity : entities)
	    {
	        boolean isChecked = false;
	        boolean isSelected = false;
	        List<TreeModel> children = null;
	        if (checkedIdList!=null && !checkedIdList.isEmpty())
	            isChecked = checkedIdList.contains(entity.getId());
	        if (selectedId!=null && selectedId.equals(entity.getId()))
                isSelected = true;
	        if(entity.getChildren()!=null && !entity.getChildren().isEmpty())
            	children=ToTreeModels(entity.getChildren(), selectedId, checkedIdList);
	        
	        treeModels.add(new TreeModel(entity.getId().toString(),
	        		entity.getTheValue().toString(),
	        		entity.getName().toString(), isChecked, isSelected));
	    }
	    return treeModels;
	}*/
	
}
