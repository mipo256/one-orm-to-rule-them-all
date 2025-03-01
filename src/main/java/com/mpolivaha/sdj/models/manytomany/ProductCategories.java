package com.mpolivaha.sdj.models.manytomany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@Table(schema = "sdj")
@Data
@ToString
@Accessors(chain = true)
@EqualsAndHashCode
// We'll introduce support for composite keys I promise 🙏🏾
// https://github.com/spring-projects/spring-data-relational/issues/574
public class ProductCategories {

//  @Id
//  private Long id;
  private AggregateReference<Product, Long> productId;
  private AggregateReference<Category, Long> categoryId;
}
