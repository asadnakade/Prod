package com.product.review.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProductID")
    private Long productId;
    @Column(name="Name")
    private String name;
    @Column(name="Description")
    private String description;
    @Column(name="Rating")
    private Integer rating;
    @Column(name="FeedBack")
	private String feedback;
    @Column(name="Rate")
    private String rate;
    @Column(name="Category")
    private String category;  

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Product(Long productId, String name, String description, Integer rating, String feedback, String rate,
			String category) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.feedback = feedback;
		this.rate = rate;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", rating="
				+ rating + ", feedback=" + feedback + ", rate=" + rate + ", Category=" + category + "]";
	}

	public Product() {
		super();
	}


}




