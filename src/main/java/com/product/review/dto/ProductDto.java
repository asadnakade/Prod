package com.product.review.dto;


public class ProductDto {


	    private String name;

	    private String category;
	    
	    private String description;
	    
	    private Integer rating;
	    
		private String feedback;
	    
	    private String rate;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
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

		public ProductDto(String name, String category, String description, Integer rating, String feedback,
				String rate) {
			super();
			this.name = name;
			this.category = category;
			this.description = description;
			this.rating = rating;
			this.feedback = feedback;
			this.rate = rate;
		}

		public ProductDto() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "ProductDto [name=" + name + ", Category=" + category + ", description=" + description + ", rating="
					+ rating + ", feedback=" + feedback + ", rate=" + rate + "]";
		}

		
}

