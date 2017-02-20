public class AirPlane {
	
	boolean crashed = false;

	int flapExceptions = 0;
	int outerEngineExceptions = 0;
	int innerEngineExceptions = 0;
	int pilotExceptions = 0;
	
	Flap[] flaps;
	Engine[] engines;
	Pilot[] pilots;

	/* PLANE ENGINE DESIGN
	[0] [1] <> [2] [3]
	 */
	
	public AirPlane() {
		this.flaps = new Flap[] {
				new Flap(),
				new Flap(),
		};

		this.engines = new Engine[] {
				new Engine(),
				new Engine(),
				new Engine(),
				new Engine(),
		};

		this.pilots = new Pilot[] {
				new Pilot(),
				new Pilot(),
		};
	}

	public void flight() throws CrashException {
		for (int i = 0; i < flaps.length; i++) {
			tryFlapCalculate(flaps[i]);
		}

		for (int i = 0; i < engines.length; i++) {
			tryEngineCalculate(i, engines[i]);
		}

		for (int i = 0; i < pilots.length; i++) {
			tryPilotCalculate(pilots[i]);
		}

		checkIfCrashed();
	}

	private void checkIfCrashed() throws CrashException {
		if (flapExceptions == 2) {
			crashed = true;
			throw new CrashException();
		}
		if (pilotExceptions == 3) {
			crashed = true;
			throw new CrashException();
		}
		if (innerEngineExceptions + outerEngineExceptions > 2 && innerEngineExceptions < 2) {
			crashed = true;
			throw new CrashException();
		}
	}

	private void tryFlapCalculate(Flap f) {
		try {
			f.calculate();
		} catch (FlapException e) {
			flapExceptions++;
		}
	}

	private void tryEngineCalculate(int i, Engine e) {
		try {
			e.calculate();
		} catch (EngineException e1) {
			if (i == 0 || i == 3)
				outerEngineExceptions++;
			else
				innerEngineExceptions++;
		}
	}

	int getTotalEnginesFailed() {
		return innerEngineExceptions + outerEngineExceptions;
	}

	private void tryPilotCalculate(Pilot p) {
		try {
			p.calculate();
		} catch (PilotException e) {
			pilotExceptions++;
		}
	}
}