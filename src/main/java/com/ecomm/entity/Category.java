package com.ecomm.entity;

import com.ecomm.config.IdGenerated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    private String categoryId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    List<Product> products;

    @PrePersist
    public void generatedId(){
        if (this.categoryId==null){
            this.categoryId ="CAT"+String.
                    format("%05d", IdGenerated.generateCategoryId());
        }
    }

}
