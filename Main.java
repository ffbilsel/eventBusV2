public class Main {

    public static void main(String[] args) {
       EventBus bus = new EventBus();
       
       bus.on("button_clicked", (object) -> {
    	   System.out.printf("1. Listener Button click executed, %s\n", object.toString());
       });
       
       bus.on("button_clicked", (object) -> {
    	   System.out.printf("2. Listener Button click executed, %s\n", object.toString());
       });
       
       bus.on("record_deleted", (object) -> {
    	   System.out.printf("Record deleted, %s\n", object.toString());
       });
       
       
       bus.emit("record_deleted", "Record ID: " + Math.random());
       bus.emit("button_clicked", "Button ID: " + Math.random());
       
    }
}
