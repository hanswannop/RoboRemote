// RoboRemote
// Hans Wannop 2014

import josx.platform.rcx.*;

public class RoboRemote {
	public static void main(String[] args) throws InterruptedException {
		TextLCD.print("REMOTE");
		Sensor.S1.setTypeAndMode(SensorConstants.SENSOR_TYPE_LIGHT,SensorConstants.SENSOR_MODE_PCT);
		Sensor.S3.setTypeAndMode(SensorConstants.SENSOR_TYPE_LIGHT,SensorConstants.SENSOR_MODE_PCT);
		Sensor.S1.activate();
		Sensor.S3.activate();

		while(true){
			int s1Val = Sensor.S1.readValue();
			int s3Val = Sensor.S3.readValue();

			if(s1Val > 50){
				if(s3Val > 50){
					// FORWARD
					Motor.A.setPower(7);
                			Motor.C.setPower(7);
					Motor.A.forward();
                			Motor.C.backward();
				} else {
					// RIGHT
					Motor.A.setPower(6);
					Motor.C.setPower(6);
					Motor.A.backward();
					Motor.C.backward();
				}
			} else {
				if(s3Val > 50){
					// left
					Motor.A.setPower(6);
                			Motor.C.setPower(6);
					Motor.A.forward();
					Motor.C.forward();
				} else {
					// STOP
					Motor.A.stop();
					Motor.C.stop();
}				

			}
		}
			//Button.RUN.waitForPressAndRelease();
	}
}
