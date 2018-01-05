package demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.directwebremoting.servlet.DwrServlet;

import pojo.User;

public class DwrScriptSessionManagerUtil extends DwrServlet{

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		Container container = ServerContextFactory.get().getContainer();
		ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
		ScriptSessionListener listener = new ScriptSessionListener() {
			
			@Override
			public void sessionDestroyed(ScriptSessionEvent arg0) {
				System.out.println("a ScriptSession is distroyed!");
			}
			
			@Override
			public void sessionCreated(ScriptSessionEvent ev) {
				HttpSession session = WebContextFactory.get().getSession();
				String userId = ((User)session.getAttribute("userInfo")).getId()+"";
				System.out.println("a ScriptSession is created!");
				ev.getSession().setAttribute("userId", userId);
			}
		};
		manager.addScriptSessionListener(listener);
	}
}
