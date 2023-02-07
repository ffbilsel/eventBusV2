import java.util.LinkedList;
import java.util.List;

public class EventBus {
	private List<Event> eventListeners = new LinkedList<>();
	
	public void emit(String eventName, Object payload) {
		for (Event event : eventListeners) {
			if(event.name.equals(eventName)) {
				event.executor.execute(payload);
			}
		}
	}
	
	public void on(String eventName, IExecutor executor) {
		eventListeners.add(new Event(eventName, executor));
	}
	
	class Event {
		private String name;
		private IExecutor executor;
		
		public Event(String name, IExecutor executor) {
			super();
			this.name = name;
			this.executor = executor;
		}
	}
}
