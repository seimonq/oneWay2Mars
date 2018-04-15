package oneway2mars.util.constants.classes;

public class Effect {

	private Float positive;
	private Float negative;

	public Effect(Float positive, Float negative) {

		this.positive = positive;
		this.negative = negative;
	}

	public Float getPositive() {
		return positive;
	}

	public void setPositive(Float positive) {
		this.positive = positive;
	}

	public Float getNegative() {
		return negative;
	}

	public void setNegative(Float negative) {
		this.negative = negative;
	}
}
