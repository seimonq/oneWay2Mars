package oneway2mars.model.resource;

public abstract class AbstractNonAccumulableResource extends AbstractResource implements
		NonAccumulableResource {

	private Float unusedAmount;

	@Override
	public Float getUnusedAmount() {
		return unusedAmount;
	}

	@Override
	public void setUnusedAmount(Float unusedAmount) {
		this.unusedAmount = unusedAmount;
	}

	@Override
	public void add(Float addAmount) {
		setAmount(getAmount() + addAmount);
		if(getAmount() < 0) {
			setAmount(0f);
		}
	}
}
