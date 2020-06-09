-- PROCESS INSERT
INSERT INTO process (status, system_name)
VALUES (0, 'santanderway');

-- CUSTOMER INSERT
INSERT INTO customer (card, email, name, password, username, id_process)
VALUES (1234567890123456, 'pablo@email.com', 'pablo', '1234', 'pablo', 1);

-- PAYMENT INSERTS
INSERT INTO payment (category, date, description, value, id_customer)
VALUES ('health', '2000-11-13', 'pizza', 50.10, 1);

INSERT INTO payment (category, date, description, value, id_customer)
VALUES ('work', '2000-11-14', 'mouse', 110.20, 1);

INSERT INTO payment (category, date, description, value, id_customer)
VALUES ('gift', '2000-11-13', 'skirt', 69.99, 1);
