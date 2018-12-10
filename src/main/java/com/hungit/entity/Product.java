/**
 * 
 */
package com.hungit.entity;

import java.util.*;

import javax.persistence.*;

import com.hungit.common.AbstractBaseModel;

import lombok.*;

/**
 * @author Kashiwagi
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
public class Product extends AbstractBaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "category_product", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	private Set<Category> categories = new HashSet<Category>();

	@Basic(optional = false)
	@Column(name = "name")
	private String name;

	@Basic(optional = false)
	@Column(name = "sale_price")
	private double salePrice;

	@Basic(optional = false)
	@Column(name = "list_price")
	private double listPrice;

	@Basic(optional = false)
	@Column(name = "default_image")
	private String defaultImage;

	@Basic(optional = false)
	@Column(name = "overview")
	private String overview;

	@Basic(optional = false)
	@Column(name = "quantity")
	private int quantity;

	@Column(name = "is_stock_controlled")
	private Boolean isStockControlled;

	@Basic(optional = false)
	@Column(name = "status")
	private int status = 1;

	@Column(name = "description")
	private String description;

	@Basic(optional = false)
	@Column(name = "rank")
	private int rank;

	@Basic(optional = false)
	@Column(name = "sku")
	private String sku;

}