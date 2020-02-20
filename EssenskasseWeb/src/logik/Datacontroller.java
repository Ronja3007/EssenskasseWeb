package logik;


public class Datacontroller {
	
	private static Datacontroller instance;
	private static Management manage;

	private Datacontroller () {
		manage = new Management();
	}
	
	public static Management getManage() {
		return manage;
	}

	public static Datacontroller getInstance () {
		if (Datacontroller.instance == null) {
			Datacontroller.instance = new Datacontroller ();
		}
		return Datacontroller.instance;
	}
}