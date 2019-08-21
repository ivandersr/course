package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus2;

public class Order2 {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus2 status;
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	public Order2() {
		
	}

	public Order2(Date moment, OrderStatus2 status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus2 getStatus() {
		return status;
	}

	public void setStatus(OrderStatus2 status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);		
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Double total() {
		double sum = 0;
		
		for (OrderItem item:items) {
			sum += item.subTotal();
		}
		return sum;	
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order Status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client.getName() + " (");
		sb.append(sdf.format(client.getBirthDate()) + ") - ");
		sb.append(client.getEmail() + "\n");
		sb.append("Order items: \n");
		for (OrderItem item:items) {
			sb.append(item.getProduct().getName());
			sb.append(", $" + item.getProduct().getPrice());
			sb.append(", Quantity: " + item.getQuantity());
			sb.append(", Subtotal: $" + String.format("%.2f", item.subTotal()) + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		
		return sb.toString();
	}
	
	
	
	
	
	

}
