SELECT * FROM food_product
WHERE price = 
(select max(price) from food_product)