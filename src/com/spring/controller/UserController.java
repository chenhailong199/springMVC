package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.UserException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.pojo.Student;
import com.spring.pojo.User;

@Controller
public class UserController{
	/**
	 * MVC推荐传参方式,通过@RequestParam
	 * 				@PathVariable rest风格
	 * value 参数名
	 * required 默认为true,必须传入参数,否则报错;
	 * defaultValue 当required=false时,非必传参数时,未传入参数指定用默认值
	 * 
	 * */

	
	//post方式解决中文乱码 
	@RequestMapping(value="userLogin.do", produces="text/html;charset=utf-8")
	public String login(@RequestParam(value="username",required=false,defaultValue="speingmvc") String username,
			             @RequestParam(value="password") String password, Model model,
			             HttpServletRequest request){
		System.out.println(username+"\n"+password);
		List<Student> studentlist = new ArrayList<Student>();
		studentlist.add(new Student("张三", "深圳", 23, 1703));
		studentlist.add(new Student("李四", "深圳", 23, 1703));
		studentlist.add(new Student("王五", "深圳", 23, 1703));
		request.setAttribute("studentlist", studentlist);
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("password", password);
		boolean flag = false;
		if ("admin".equals(username) && "admin".equals(password)){
			flag = true;	
		}
		if (!flag){
			throw new com.spring.pojo.UserException("用户名或密码错误");
		}
		return "success";		
	}
	
	/**
	 * 局部异常处理,只处理某一个controller
	 * @return
	 * 
	 * 改用 全局异常, spring
	 */
	/*	@ExceptionHandler(value={com.spring.pojo.UserException.class})
	public String handlerException(UserException e, HttpServletRequest request){
		request.setAttribute("e", e);
		return "error";	
	}*/
	
	/**
	 * model 作用域 和 request 一致
	 * */
	@RequestMapping(value="list.do", method=RequestMethod.GET)
	public String list(HttpServletRequest request){
		List<Student> studentlist = new ArrayList<Student>();
		studentlist.add(new Student("张三", "深圳", 23, 1703));
		studentlist.add(new Student("李四", "深圳", 23, 1703));
		studentlist.add(new Student("王五", "深圳", 23, 1703));
		request.setAttribute("studentlist", studentlist);
		return "success";
	}
	
	
	//隐式传参,未传入时值为null 
	//传值方式 model  map<string, object>
	@RequestMapping(value="userRegister.do", method=RequestMethod.GET)
	public ModelAndView save(String username, String password, String email){
		System.out.println(username+"\n"+password+"\n"+email);
		ModelAndView mad=new ModelAndView("error");
		mad.addObject("username", username);
		mad.addObject("password", password);
		mad.addObject("email", email);
		return mad;
		
	}
	@RequestMapping(value="addUser.do",method=RequestMethod.GET)
	public String addUser(@ModelAttribute("user") User user){
		return "addUser";
	}
	
	@RequestMapping(value="addUser",method=RequestMethod.POST)
	public String saveUser(User user){
		System.out.println(user);
		// return "success"  返回逻辑视图
		return "redirect:list.do"; //返回重定向
	}
	
	
	/**
	 * 单文件上传
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping("upload.do")
	public String upload(@RequestParam MultipartFile file,Model model,String userName,
			                   HttpServletRequest request){
		System.out.println("上传的用户名:"+userName);
		request.setAttribute("username", userName);
		//定义文件上传的路径
		String path=request.getSession().getServletContext().getRealPath("upload");
		String savePath = path.replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\", "");
		System.out.println(path);
		//定义写在服务器的文件
		File newFile=new File(savePath);
		if (!newFile.exists()){
			newFile.mkdir();
		}
		//判断是否有文件
		if (!file.isEmpty()){
			//得到文件名
			String fileName=file.getOriginalFilename();
			//将文件写在服务器里面
			try {
				file.transferTo(new File(newFile, fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "success";
	}
	
	/**
	 * 多文件上传
	 * @param file
	 * @param model
	 * @param userName
	 * @param request
	 * @return
	 */
	@RequestMapping("uploads.do")
	public String uploads(@RequestParam MultipartFile[] files,Model model,String userName,
            HttpServletRequest request){
		System.out.println("上传的用户名:"+userName);
		request.setAttribute("username", userName);
		//定义文件上传的路径
		String path=request.getSession().getServletContext().getRealPath("upload");
		String savePath = path.replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\", "");
		System.out.println(path+"\n"+savePath);
		//定义写在服务器的文件,若文件夹不存在则新建
		File newFile=new File(savePath);
		if (!newFile.exists()){
			newFile.mkdir();
			}
		//判断是否有上传文件
		System.out.println(files.length);
		System.out.println(files);
		for (MultipartFile file:files){
			if (!file.isEmpty()){
				//上传的文件名
				String fileName=file.getOriginalFilename();	
				//将文件写在服务器里面
				try {
					file.transferTo(new File(newFile, fileName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		return "success";
	}
			

}
