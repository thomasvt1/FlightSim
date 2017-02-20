public class Recorder {
	
	AirPlane[] airPlane = new AirPlane[1000];

	public void simulate() {
		for (int i = 0; i < airPlane.length; i++) {
			airPlane[i] = new AirPlane();
			simulateAirPlane(i, airPlane[i]);
		}

		checkCrashedPlanes();
	}

	void simulateAirPlane(int i, AirPlane p) {
		try {
			p.flight();
		} catch (CrashException e) {
			//crashedAirPlanes[i] = p;
			System.out.println("OOH NOOW");
		}
	}

	void checkCrashedPlanes() {
		int flapCrashes = 0;
		int pilotCrashes = 0;
		int engineCrashes = 0;

		for (int i = 0; i < airPlane.length; i ++) {
			if (airPlane[i].crashed) {
				if (airPlane[i].flapExceptions == 2) {
					flapCrashes++;
				}
				if (airPlane[i].pilotExceptions == 3) {
					pilotCrashes++;
				}
				if (airPlane[i].getTotalEnginesFailed() > 2 && airPlane[i].innerEngineExceptions < 2) {
					engineCrashes++;
				}
			}
		}
		System.out.println("TOTAL PLANES CRASHES: " + (flapCrashes + pilotCrashes + engineCrashes));
		System.out.println("THIS WAS DUE TO THE FOLLOWING;");
		System.out.println("Engines: " + engineCrashes);
		System.out.println("Pilots: " + pilotCrashes);
		System.out.println("Flaps: " + flapCrashes);
	}
}