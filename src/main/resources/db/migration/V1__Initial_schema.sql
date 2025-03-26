CREATE TABLE book
(
    id    UUID         NOT NULL,
    title VARCHAR(255) NOT NULL,
    isbn  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_book PRIMARY KEY (id)
);

CREATE TABLE copy
(
    id        UUID         NOT NULL,
    book_id   UUID         NOT NULL,
    bar_code  VARCHAR(255) NOT NULL,
    available BOOLEAN      NOT NULL,
    CONSTRAINT pk_copy PRIMARY KEY (id)
);

CREATE TABLE loan
(
    id                   UUID NOT NULL,
    copy_id              UUID NOT NULL,
    user_id              UUID NOT NULL,
    start_at             TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    expected_return_date DATE NOT NULL,
    returned_at          TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_loan PRIMARY KEY (id)
);