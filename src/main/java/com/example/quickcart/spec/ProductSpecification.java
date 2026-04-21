package com.example.quickcart.spec;

import com.example.quickcart.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.Locale;

public class ProductSpecification {

    public static Specification<Product> hasCategory(String category) {
        return (root, query, cb) -> category == null ? null : cb.equal(root.get("category"),category);
    }

    public static Specification<Product> priceBetween(Double min, Double max){
        return (root, query, cb) -> {
            if(min == null && max == null)
                return null;

            if(min == null) return cb.lessThanOrEqualTo(root.get("price"),max);

            if(max == null) return cb.greaterThanOrEqualTo(root.get("price"),min);

            return cb.between(root.get("price"),min,max);
        };
    }

    public static Specification<Product> hasNameOrDescriptionLike(String keyWord){
        return (root, query, cb) -> {
            if (keyWord == null || keyWord.isEmpty()) return null;
            return cb.or(
                    cb.like(root.get("name"), "%" + keyWord.toLowerCase() + "%"),
                    cb.like(root.get("description"), "%" + keyWord.toLowerCase() + "%")
            );
        };

    }

    public static Specification<Product> ratingsGreaterThan(Double ratings){
        return (root,query,cb) -> {
            if (ratings == null) return null;
            return cb.greaterThanOrEqualTo(root.get("ratings"),ratings);
        };
    }
}
