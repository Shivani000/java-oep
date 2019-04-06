/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.HibernateUtil;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.UserService;
import domain.Useroep;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import service.FacultyService;
import service.StudentService;

/**
 *
 * @author mrvataliya
 */
public class UserController extends SimpleFormController {
    
    private UserService userService;
    public UserController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Useroep.class);
        setCommandName("useroep");
        //setSuccessView("successView");
        //setFormView("formView");
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    /*
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }
*/
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
   
    /**
     *
     * @param request
     * @param response
     * @param command
     * @param errors
     * @return
     * @throws Exception
     */
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        
        Useroep user = (Useroep) command;

	boolean status=false;
        ModelAndView mv = null;
        if(user.getFaculty()== true && !user.getUname().isEmpty() && !user.getPassword().isEmpty()){
            status = userService.loginfaculty(user);
            if(status == true){
                mv = new ModelAndView("faculty");
                mv.addObject("uname",user.getUname());
                FacultyService fs  = new FacultyService();
                mv.addObject("submissions", fs.getsubmissions());
            }
            else{
               mv = new ModelAndView("errorlogin");
              
            }
        }
        else if(user.getFaculty()==false && !user.getUname().isEmpty() && !user.getPassword().isEmpty()){
            status = userService.loginstudent(user);
            if(status == true){
                //mv.addObject("message","Hello Student "+user.getUname()+"hOw are you");
                mv = new ModelAndView("student");
                mv.addObject("uname",user.getUname());
                 StudentService ss  = new StudentService();
                mv.addObject("assignments", ss.getassignments());
             
            }
            else{
               mv = new ModelAndView("errorlogin");
              
            }
        }
        else{
               mv = new ModelAndView("errorlogin");
            }
        System.out.println(mv.toString()+status);
         return mv;
        
    }
     
}
