public class Engine {

	//F(motor) = 0,001

	public void calculate() throws EngineException {
		if (new Tools().randomBetweenInt(1, 10) == 1) //TODO: 10 > 1000
			throw new EngineException();
	}

}
