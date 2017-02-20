public class Pilot {

	//F(piloot) = 0, 005

	public void calculate() throws PilotException {
		if (new Tools().randomBetweenInt(5, 10000) == 5)
			throw new PilotException();
	}
}
