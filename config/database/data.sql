INSERT INTO
    accounts (id, document_number)
VALUES
('1', '312412455'),
('2', '677312454'),
('3', '546757445'),
('4', '790877549'),
('5', '458739222');

INSERT INTO
    operations_types (id, description)
VALUES
('1', 'COMPRA A VISTA'),
('2', 'COMPRA PARCELADA'),
('3', 'SAQUE'),
('4', 'PAGAMENTO');

INSERT INTO
    transactions (id, amount, event_date, account_id ,operation_type_id)
VALUES
    ('1', '999,99', '2019-04-26T23:53:54Z', 1, 1),
    ('2', '560,50', '2020-07-26T11:33:54Z', 4, 2);



