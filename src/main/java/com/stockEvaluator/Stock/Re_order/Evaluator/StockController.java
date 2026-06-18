package com.stockEvaluator.Stock.Re_order.Evaluator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StockController {
    @Autowired
    StockRepository stockRepository;
    @PostMapping("/stock")
    public Stock addStock(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }
    @GetMapping("/stock")
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }
    @PutMapping("/stock/{id}")
    public Stock updateStock(@PathVariable int id, @RequestBody Stock stock) {
        stock.setId(id);
        return stockRepository.save(stock);
    }
    @PutMapping("/stock/add/{id}/{addQty}")
    public String addStockQuantity(@PathVariable int id, @PathVariable int addQty) {
    Stock stock = stockRepository.findById(id).orElse(null);
    if (stock == null) {
        return "Product Not Found";
    }
    stock.setQuantity(stock.getQuantity() + addQty);
    stockRepository.save(stock);
    return "Stock Added Successfully. Current Stock = " + stock.getQuantity();
}
    @PutMapping("/stock/sell/{id}/{soldQty}")
    public String sellStock(@PathVariable int id, @PathVariable int soldQty) {
    Stock stock = stockRepository.findById(id).orElse(null);
    if (stock == null) {
        return "Product Not Found";
    }
    stock.setQuantity(stock.getQuantity() - soldQty);
    stockRepository.save(stock);
    if (stock.getQuantity() <= stock.getReorderlevel()) {
        return "Reorder Required! Current Stock = "+stock.getQuantity();
    }
    return "Stock Updated Successfully . Current Stock = "+stock.getQuantity();
}
    @DeleteMapping("/stock/{id}")
    public String deleteStock(@PathVariable int id) {
        stockRepository.deleteById(id);
        return "Stock Deleted Successfully";
    }
}
