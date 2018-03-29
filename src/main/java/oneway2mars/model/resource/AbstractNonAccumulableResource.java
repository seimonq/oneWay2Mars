package oneway2mars.model.resource;

public class AbstractNonAccumulableResource extends AbstractResource implements NonAccumulableResource {

	private Float unusedAmount;

	@Override
	public Float getUnusedAmount() {
		return unusedAmount;
	}

	@Override
	public void setUnusedAmount(Float unusedAmount) {
		this.unusedAmount = unusedAmount;
	}
}
