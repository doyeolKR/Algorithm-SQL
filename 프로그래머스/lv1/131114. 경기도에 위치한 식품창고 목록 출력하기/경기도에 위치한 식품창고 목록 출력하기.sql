SELECT warehouse_id, warehouse_name, address, if(freezer_yn is null, 'N', freezer_yn)
FROM food_warehouse
WHERE address like '경기도%';