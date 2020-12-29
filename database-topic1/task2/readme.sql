select expenses.num, paydate, name, value from expenses, receivers
where value > 10000 and receiver = receivers.num;