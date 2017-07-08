package com.et.auth;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.et.constants.Constants;
import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	RestTemplate restTemplate ;
	public HomeController(){
		restTemplate = new RestTemplate();
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "index";
	}

	@RequestMapping(value="/submitLoginForm.html", method = RequestMethod.POST)
	public ModelAndView submitLoginForm(@RequestParam Map<String,String> reqPar,HttpServletRequest request) {

		String name = reqPar.get("name");
		String pwd = reqPar.get("pwd");

		System.out.println("name : "+name);	
		System.out.println("password : "+pwd);
		UserLogin usr = new UserLogin(name,pwd);
		ModelAndView model = new ModelAndView("register");
		//LOGIN
		try {

			//CALL REST WEBSERVICE
			Gson gson = new Gson();
			String data = gson.toJson(usr);

			ResponseEntity<String> p =  restTemplate.postForEntity(Constants.WSip+Constants.WSlogin, data, String.class);

			if(!p.getBody().equals("error"))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("token",p.getBody());
				session.setAttribute("name", usr.getEmail());
				model = new ModelAndView("home");
				model.addObject("user", usr.getEmail());
				System.out.println("RESPONSE FROM WEBservice : "+p.getBody());
			}
			else 
			{
				
				model.addObject("error","Details submitted by you is invalid");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView getRegister(@RequestParam Map<String,String> reqPar) {
		ModelAndView model = new ModelAndView("register");
		return model;
	}

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView model = new ModelAndView("success");

		ResponseEntity<String> p =  restTemplate.postForEntity(Constants.WSip+"/test", "hello", String.class);
		System.out.println("p :: "+p);
		return model;

	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(@RequestParam Map<String,String> reqPar,HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		String token = (String)session.getAttribute("token");
		System.out.println("logout token : "+token);
		ResponseEntity<String> p =  restTemplate.postForEntity(Constants.WSip+Constants.WSlogout, token, String.class);
		System.out.println("RESPONSE USER ADD :: "+p);
		session.setAttribute("token",null);
		session.setAttribute("name", null);
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	@RequestMapping(value="/submitRegisterForm.html", method = RequestMethod.POST)
	public ModelAndView addUser(@RequestParam Map<String,String> reqPar) {
		String name = reqPar.get("name");
		String pwd = reqPar.get("pwd");
		String email = reqPar.get("email");
		String mobile = reqPar.get("mobile");

		NewUser nu = new NewUser(name, email, pwd, pwd, mobile);

		Gson gson = new Gson();
		String data = gson.toJson(nu);
		System.out.println(data);
		System.out.println("name : "+name);	
		System.out.println("password : "+pwd);
		System.out.println("email : "+email);
		System.out.println("mobile : "+mobile);
		//Registration r = new Registration();
		//r.addUser();


		ResponseEntity<String> p =  restTemplate.postForEntity(Constants.WSip+Constants.WSregister, data, String.class);
		System.out.println("RESPONSE USER ADD :: "+p);

		System.out.println("AFTER ADD USER");
		ModelAndView model = new ModelAndView("register");
		return model;
	}


	public void login(String un, String pwd)
	{

	}

	public void logout()
	{

	}



}
