package utils;

import java.util.Collection;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

@SuppressWarnings("deprecation")
public class DwrPush {
	 public static void Send(String msg){
	        WebContext webContext = WebContextFactory.get();
	        Collection<ScriptSession> sessions = webContext.getAllScriptSessions();

	        // 构建发送所需的JS脚本
	        ScriptBuffer scriptBuffer = new ScriptBuffer();
	        // 调用客户端的js脚本函数
	        scriptBuffer.appendScript("callback(");
	        // 这个msg可以被过滤处理一下，或者做其他的处理操作。这视需求而定。
	        scriptBuffer.appendData(msg);
	        scriptBuffer.appendScript(")");
	        // 为所有的用户服务
	        Util util = new Util(sessions);
	        util.addScript(scriptBuffer);
	    }
}
