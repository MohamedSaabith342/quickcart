package com.example.quickcart.seed;

import com.example.quickcart.entity.Product;
import com.example.quickcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception{
        if (productRepository.count() == 0) {

            List<Product> demoProducts = List.of(

                    new Product(null, "Samsung Galaxy S23", 749.99,
                            "Flagship smartphone with Snapdragon processor", "phones", 4.7, "Amazon", 15,List.of("/products/1.jpg")),

                    new Product(null, "Google Pixel 8", 699.00,
                            "Android phone with excellent camera", "phones", 4.6, "Flipkart", 20,List.of("/products/2.jpg")),

                    new Product(null, "Dell XPS 13", 999.99,
                            "Ultrabook laptop with Intel i7 processor", "laptops", 4.5, "Dell Store", 8,List.of("/products/3.jpg")),

                    new Product(null, "HP Pavilion 15", 649.50,
                            "Affordable laptop for students", "laptops", 4.3, "HP Store", 12,List.of("/products/4.jpg")),

                    new Product(null, "Sony WH-1000XM5", 349.99,
                            "Noise cancelling wireless headphones", "accessories", 4.8, "Amazon", 25,List.of("/products/5.jpg")),

                    new Product(null, "Apple AirPods Pro", 249.00,
                            "Wireless earbuds with active noise cancellation", "accessories", 4.7, "Apple Store", 30,List.of("/products/6.jpg")),

                    new Product(null, "Logitech MX Master 3", 99.99,
                            "Advanced wireless mouse for productivity", "accessories", 4.6, "Logitech", 18,List.of("/products/7.jpg")),

                    new Product(null, "Samsung 55\" QLED TV", 899.00,
                            "4K Smart TV with vibrant colors", "electronics", 4.5, "Best Buy", 5, List.of("/products/8.jpg")),

                    new Product(null, "Asus ROG Strix", 1299.00,
                            "Gaming laptop with high performance GPU", "laptops", 4.6, "Asus Store", 7, List.of("/products/9.jpg")),

                    new Product(null, "Amazon Echo Dot", 49.99,
                            "Smart speaker with Alexa voice assistant", "electronics", 4.4, "Amazon", 40, List.of("/products/10.jpg"))

            );
            productRepository.saveAll(demoProducts);
            System.out.println("Seeded demo products");

        }else{

            System.out.println("Product Already exist seeding skipped");
        }


    }
}
