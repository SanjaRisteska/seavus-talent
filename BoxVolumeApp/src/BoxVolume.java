
public class BoxVolume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box1 = new Box(3, 6, 2);
		Box box2 = new Box(5, 9, 4);

		if (box1.getVolume() > box2.getVolume()) {
			System.out.println(box1.toString());
		}

		else {
			System.out.println(box2.toString());
		}
	}

}
