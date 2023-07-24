SELECT left(product_code, 2) as category, count(product_id) FROM product
GROUP BY category
