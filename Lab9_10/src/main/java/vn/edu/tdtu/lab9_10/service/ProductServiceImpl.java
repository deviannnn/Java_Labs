package vn.edu.tdtu.lab9_10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.tdtu.lab9_10.model.Product;
import vn.edu.tdtu.lab9_10.repository.ProductRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        Optional<Product> result = productRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(int id, Product product) {
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()) {
            Product existingProduct = result.get();
            existingProduct.setCode(product.getCode());
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setIllustration(product.getIllustration());
            existingProduct.setDescription(product.getDescription());
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    @Override
    public Product partialUpdate(int id, Map<String, Object> updates) {
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()) {
            Product existingProduct = result.get();
            for (Map.Entry<String, Object> entry : updates.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();
                switch (fieldName) {
                    case "code":
                        existingProduct.setCode((String) fieldValue);
                        break;
                    case "name":
                        existingProduct.setName((String) fieldValue);
                        break;
                    case "price":
                        existingProduct.setPrice((int) fieldValue);
                        break;
                    case "illustration":
                        existingProduct.setIllustration((String) fieldValue);
                        break;
                    case "description":
                        existingProduct.setDescription((String) fieldValue);
                        break;
                    default:
                        break;
                }
            }
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
