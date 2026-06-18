package com.stockEvaluator.Stock.Re_order.Evaluator;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StockRepository extends JpaRepository<Stock, Integer> {
    
}
