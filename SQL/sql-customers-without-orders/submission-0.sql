-- Write your query below

Select name from customers where customers.id not in (select customer_id from orders);
