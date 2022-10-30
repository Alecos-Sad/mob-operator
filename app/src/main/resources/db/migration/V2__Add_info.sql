insert into client (id, version, name, surname)
    VALUE (1, 0, 'Alexander', 'SadovNick'),
    (2, 0, 'Sergey', 'Nemchinsky'),
    (3, 0, 'Evgeniy', 'Borisov');

insert into tariff (id, version, name, free_minutes, price, subscription_fee)
    VALUE (1, 0, 'Light', 500, 1500, 5000),
    (2, 0, 'Medium', 800, 2000, 6000),
    (3, 0, 'Strong', 1000, 2500, 8000),
    (4, 0, 'Super', 1500, 4000, 12000);

insert into user_operator (id, version, operator_balance, phone_number, client_id)
    VALUE (1, 0, 50000, '+375445919125', 1),
    (2, 0, 60000, '+375296015480', 2),
    (3, 0, 40000, '+375297563011', 3);

insert into user_operator_tariffs (user_operator_id, tariffs_id)
    VALUE (1, 1), (1, 2), (2, 3);
