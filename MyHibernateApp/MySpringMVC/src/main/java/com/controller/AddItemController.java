package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AddItemDao;
import com.model.AddItemModel;

@Controller
public class AddItemController {

	@RequestMapping(value ="loadAddItemPage",method = RequestMethod.GET)
	public ModelAndView loadAddItemPage() {
		ModelAndView modelAndView=new ModelAndView("addNewItem");
		return modelAndView;
	}
	
	@RequestMapping(value = "saveAddNewItem",method = RequestMethod.POST)
	public ModelAndView saveAddNewItem(@ModelAttribute("addItemModel") AddItemModel addItemModel) {
		ModelAndView modelAndView= new ModelAndView("addNewItem");
		AddItemDao addItemDao=new AddItemDao();
		String returnValue=addItemDao.save(addItemModel);
		modelAndView.addObject("addItemModel", addItemModel);
		if(returnValue.equalsIgnoreCase("Success"))
			modelAndView.addObject("message", "Entry Successfully Saved");
		else
			modelAndView.addObject("message", "Entry Not Successfully Saved");
		
		return modelAndView;
	}
	
	@RequestMapping(value="showItems")
	public ModelAndView showItems() 
	{
		ModelAndView modelAndView = new ModelAndView("showItem");
		AddItemDao addItemDao = new AddItemDao();
		List<AddItemModel> addItemModels= addItemDao.showItems();
		modelAndView.addObject("addItemModels", addItemModels);
		return modelAndView;
	}
	
	@RequestMapping("deleteItems/{id}")
	public ModelAndView deleteItems(@PathVariable("id") Long id)
	{
		ModelAndView modelAndView = new ModelAndView("showItem");
		AddItemDao addItemDao = new AddItemDao();
		String returnValue = addItemDao.deleteItems(id);
		if(returnValue.equalsIgnoreCase("success"))
			modelAndView.addObject("deleteMessage", "Entry Successfully Deleted");
		else
			modelAndView.addObject("deleteMessage", "Entry Not Successfully Deleted");
		
		List<AddItemModel> addItemModels = addItemDao.showItems();
		modelAndView.addObject("addItemModels", addItemModels);
		return modelAndView;
	}
	
	@RequestMapping("/getItem/{id}")
	public ModelAndView getItem(@PathVariable("id") Long id)
	{
		ModelAndView modelAndView = new ModelAndView("editItem"); 
		AddItemDao addItemDao = new AddItemDao();
		AddItemModel addItemModel = addItemDao.getItem(id);
		modelAndView.addObject("addItemModel", addItemModel);
		return modelAndView;
	}
	
	@RequestMapping("/updateItems/{id}")
	public ModelAndView updateItems(@PathVariable("id") Long id, 
			@ModelAttribute("addItemModel") AddItemModel addItemModel)
	{
		ModelAndView modelAndView = new ModelAndView("showItem");
		addItemModel.setId(id);
		AddItemDao addItemDao = new AddItemDao();
		String retunValue = addItemDao.updateItems(addItemModel);
		modelAndView.addObject("addItemModel", addItemModel);
		List<AddItemModel> addItemModels = addItemDao.showItems();
		modelAndView.addObject("addItemModels", addItemModels);
		if(retunValue.equalsIgnoreCase("success"))
			modelAndView.addObject("updateMessage","Entry Successfully Updated");
		else
			modelAndView.addObject("updateMessage","Entry Not Successfully Updated");
		return modelAndView;
	}
}
