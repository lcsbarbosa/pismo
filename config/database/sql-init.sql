CREATE TABLE accounts (
     id bigint,
     document_number varchar(255)
);

CREATE TABLE operations_types (
    id bigint,
    Description varchar(255)
);

CREATE TABLE transactions (
     id bigint,
     account_id bigint,
     operation_type_id bigint,
     amount float,
     event_date timestamp
);

INSERT INTO
    accounts (id, document_number)
VALUES
    ('1', '312412455'),
    ('2', '677312454'),
    ('3', '546757445'),
    ('4', '790877549'),
    ('5', '458739222');

INSERT INTO
    public.operations_types (id, description)
VALUES
    ('1', 'COMPRA A VISTA'),
    ('2', 'COMPRA PARCELADA'),
    ('3', 'SAQUE'),
    ('4', 'PAGAMENTO');

INSERT INTO
    transactions (id, amount, event_date, account_id ,operation_type_id)
VALUES
('1', '99.99', '2019-04-26T23:53:54Z', 1, 1),
('2', '109.50', '2020-07-26T11:33:54Z', 2, 2);