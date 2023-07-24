SELECT animal_type, if(name is null, 'No name', name), sex_upon_intake 
FROM animal_ins
ORDER BY animal_id;