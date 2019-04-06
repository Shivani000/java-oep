/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Useroep;
import java.util.List;

public interface UserService {
	public boolean loginstudent(Useroep useroep);
        public boolean loginfaculty(Useroep useroep);
        public List getsubmissions();
}
