package br.com.ediwaldoneto.fastdelivery.domain.entities;

public class OrderedItem {

	private Dish dish;
	private Integer amount;
	private String observation;

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

}
