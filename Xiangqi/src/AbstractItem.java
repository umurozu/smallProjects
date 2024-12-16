
public abstract class AbstractItem  implements ItemInterface {
	
	private String position;  // tahtadaki konumu gösterir. Örneğin, a1
	private String name;

        public  String getPosition() {
        	return position;
        }
        public  String getName() {
        	return name;
        }
        public  void setName(String name) {
        	this.name = name;
        }
        public  void setPosition(String position) {
        	this.position = position;
        }
	
	
}
