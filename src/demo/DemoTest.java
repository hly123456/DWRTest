package demo;

import java.util.Collection;

import javax.servlet.ServletException;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.WebContextFactory;

public class DemoTest {
	
	//设置接收的页面的Id，用于精确推送  
	public void onPageLoad(String userId){
		ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
		scriptSession.setAttribute("userId", userId);
		
		/*DwrScriptSessionManagerUtil dwrScriptSessionManagerUtil = new DwrScriptSessionManagerUtil();
		try {
			dwrScriptSessionManagerUtil.init();
		} catch (ServletException e) {
			e.printStackTrace();
		}*/
	}
	/**
	 *  推送信息到特定的页面 
	 * @param userid 推送到的页面
	 * @param message 消息
	 * @param jsFuc 前台调用 的JavaScript方法
	 * @param args 前台调用 的JavaScript方法的参数 
	 */
	public void sendMsg(final String userId, final String jsFuc,final Object... args) {
        //使用过滤器实现推送  
        Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
            public boolean match(ScriptSession session) {
                if (session.getAttribute("userId")==null){
                    return false;
                }else {
                    return (session.getAttribute("userId")).equals(userId);
                }
            }
        },new Runnable() {
            private ScriptBuffer script = new ScriptBuffer();
            public void run() {
            	 //设置要调用的 js及参数  
                script.appendCall(jsFuc,args);
                //得到所有ScriptSession  
                Collection<ScriptSession> sessions = Browser.getTargetSessions();
                //遍历每一个ScriptSession 
                for (ScriptSession scriptSession : sessions) {
                    scriptSession.addScript(script);
                }
            }
        });
    }
}
