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

                    new Product(null, "Apple iPhone 15", 799.00,
                            "Smartphone with A16 chip", 4.8, "Amazon", 10),

                    new Product(null, "Samsung Galaxy S24", 699.00,
                            "Flagship Android phone", 4.6, "Samsung Store", 15),

                    new Product(null, "Sony WH-1000XM5", 349.00,
                            "Noise cancelling headphones", 4.7, "Sony", 20),

                    new Product(null, "Dell Inspiron 15", 950.00,
                            "Laptop with Intel i7 and 16GB RAM", 4.5, "Dell", 8),

                    new Product(null, "Apple MacBook Air M2", 1200.00,
                            "Lightweight laptop with M2 chip", 4.9, "Apple Store", 5),

                    new Product(null, "Logitech MX Master 3", 99.00,
                            "Advanced wireless mouse", 4.8, "Logitech", 25),

                    new Product(null, "HP LaserJet Printer", 200.00,
                            "High-speed monochrome printer", 4.3, "HP", 12),

                    new Product(null, "Amazon Echo Dot", 49.99,
                            "Smart speaker with Alexa", 4.4, "Amazon", 30),

                    new Product(null, "Canon EOS 1500D", 500.00,
                            "DSLR camera for beginners", 4.5, "Canon", 7),

                    new Product(null, "Asus ROG Gaming Laptop", 1500.00,
                            "High performance gaming laptop", 4.7, "Asus", 6)

            );
            productRepository.saveAll(demoProducts);
            System.out.println("Seeded demo products");

        }else{

            System.out.println("Product Already exist seeding skipped");
        }


    }
}
