package com.controller;

import java.io.*;
import java.util.*;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserRegistrationDao;
import com.model.UserRegistrationModel;

@Controller
public class LoginController 
{
	@RequestMapping("/loadPageOnMenuClick/{pageName}")
	public ModelAndView loadPageOnMenuClick(@PathVariable("pageName")String pageName)
	{
		ModelAndView modelAndView = new ModelAndView(pageName);
		return modelAndView;
	}
	@RequestMapping("/signUp")
	public ModelAndView signUp()
	{
		ModelAndView modelAndView = new ModelAndView("userRegistration");
		return modelAndView;
	}
	@RequestMapping(value="/userRegistration",method=RequestMethod.POST)
	public ModelAndView userRegistration(@ModelAttribute("userRegistrationModel") 
	UserRegistrationModel userRegistrationModel, 
	BindingResult bindingResult , @RequestParam("photo") MultipartFile file)
	{
		System.out.println(file.getOriginalFilename());
		InputStream inputStream = null;
		byte[] bytes = null;
		try
		{
			bytes = file.getBytes();
			inputStream = new ByteArrayInputStream(bytes);
			inputStream.read();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(inputStream!=null)
				try
				{
					inputStream.close();
				}
				catch(Exception e){e.printStackTrace();}
		}
		UserRegistrationDao  userRegistrationDao = new UserRegistrationDao();
		userRegistrationDao.save(userRegistrationModel,inputStream,file);
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("message", "Your Registration Successfully Done");
		return modelAndView;
	}
	@RequestMapping(value="/logIn", method=RequestMethod.GET)
	public ModelAndView logIn(@RequestParam Map<String,String> map,
			HttpSession session)
	{
		ModelAndView modelAndView = null;
		String userName = map.get("userName");
		String password = map.get("password");
		if(userName.trim().equalsIgnoreCase(""))
		{
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("message", "Please Enter User Name");
		}
		else if(password.trim().equalsIgnoreCase(""))
		{
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("message", "Please Enter Password");
		}
		else
		{
			UserRegistrationDao  userRegistrationDao = new UserRegistrationDao();
			List<UserRegistrationModel>  userRegistrationModels = userRegistrationDao.verifyUser(userName, password);
			if(userRegistrationModels!=null && userRegistrationModels.size()>0)
			{
				modelAndView = new ModelAndView("dashboard");
				session.setAttribute("userName", userRegistrationModels.get(0).getName());
				session.setAttribute("email", userRegistrationModels.get(0).getEmail());
			}
			else
			{
				modelAndView = new ModelAndView("login");
				modelAndView.addObject("message", "Either User or Password is Wrong, Please Check");
			}
		}
		return modelAndView;
	}
}