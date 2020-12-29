select name as receiver, SUM(value) as sum from expenses, receivers 
where receivers.num = receiver group by receiver;

select paydate, name as receiver, SUM(value) as sum from expenses, receivers 
where paydate = (select paydate from expenses where value = (select MAX(value) from expenses)) 
and receivers.num = receiver;

select num, paydate, value from expenses 
where paydate = (select x.paydate from (select paydate, SUM(value) as sum 
from expenses group by paydate order by sum desc limit 1) x)  order by value desc limit 1;