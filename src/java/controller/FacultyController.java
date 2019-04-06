/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.web.servlet.mvc.SimpleFormController;
import service.FacultyService;
import domain.Aspost;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author mrvataliya
 */
public class FacultyController extends SimpleFormController {

    FacultyService facultyService;
    @Override
    protected Object formBackingObject(HttpServletRequest request)
	throws Exception {

	Aspost cust = new Aspost();
	
        return cust;
}
    
    public FacultyController() {
        //Initialize controller properties here or 
        //in the Web Application Context
        
       //setCommandClass(Aspost.class);
       setCommandName("aspost");
        //setSuccessView("successView");
        //setFormView("faculty");
    }

    public void setFacultyService(FacultyService facultyService) {
        this.facultyService = facultyService;
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
        ModelAndView mv = new ModelAndView("apostsuccess");
        //Do something...
        System.out.println("----------**********----------");
        Aspost aspost = (Aspost)command;
        boolean insertstatus = false;
                //insertstatus = facultyService.postasmnt(aspost);
        String str;
        if(insertstatus == true)
        str = "Datasubmitted Successfully";
        else
           str = "Error In Insertion";
        mv.addObject("istatus",str);
        return mv;
    }
     
}
