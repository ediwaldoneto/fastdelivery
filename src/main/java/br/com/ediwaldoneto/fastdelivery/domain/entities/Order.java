package br.com.ediwaldoneto.fastdelivery.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

	private Long id;
	private User user;
	private Restaurant restaurant;
	private LocalDateTime dateTime;
	private String status;
	private List<OrderedItem> items;
	private BigDecimal amount;
	private String paymentMethod;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderedItem> getItems() {
		return items;
	}

	public void setItems(List<OrderedItem> items) {
		this.items = items;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
