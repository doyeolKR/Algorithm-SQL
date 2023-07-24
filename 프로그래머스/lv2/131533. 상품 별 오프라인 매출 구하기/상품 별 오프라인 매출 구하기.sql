SELECT
    a.product_code,
    sum(a.price * b.sales_amount) as sales
FROM product a
JOIN offline_sale b
ON a.product_id = b.product_id
GROUP BY a.product_code
ORDER BY sum(a.price * b.sales_amount) desc, a.product_code