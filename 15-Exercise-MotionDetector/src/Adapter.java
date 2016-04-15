import java.io.IOException;

import com.seavus.motiondetector.CapturingDevice;
import com.sedc.camera.Camera;

public class Adapter implements CapturingDevice {
	
	private Camera camera;

	@Override
	public String getImage() throws IOException {
		return camera.getData();
	}

}
