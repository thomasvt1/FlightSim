public class Flap {

	//F(flap) = 0,0005

	public void calculate() throws FlapException {
		if (new Tools().randomBetweenInt(5, 10000) == 5)
			throw new FlapException();
	}
}
