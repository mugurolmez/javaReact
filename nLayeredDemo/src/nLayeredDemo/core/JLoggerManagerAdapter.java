package nLayeredDemo.core;

import nLayeredDemo.jlogger.jloggerManager;

public class JLoggerManagerAdapter implements LoggerService {

	@Override
	public void logToStytem(String message) {
		jloggerManager manager=new jloggerManager();
		manager.log(message);
	}

}
