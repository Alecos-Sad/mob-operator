create table client
(
    id      bigint not null auto_increment,
    version bigint,
    name    VARCHAR(100),
    surname varchar(10),
    primary key (id)
) engine = InnoDB;

create table tariff
(
    id               bigint not null auto_increment,
    version          bigint,
    name             VARCHAR(100),
    free_minutes     integer,
    price            double precision,
    subscription_fee double precision,
    primary key (id)
) engine = InnoDB;

create table user_operator
(
    id               bigint not null auto_increment,
    version          bigint,
    operator_balance double precision,
    phone_number     varchar(255),
    client_id        bigint,
    primary key (id)
) engine = InnoDB;

create table user_operator_tariffs
(
    user_operator_id bigint not null,
    tariffs_id       bigint not null
) engine = InnoDB;

# alter table user_operator_tariffs
#     add constraint UK_2253ostv3477n7n1qnt1iko9t unique (tariffs_id);
alter table user_operator
    add constraint FKrckrt2cvqdqs58dj1aafa71fx foreign key (client_id) references client (id);

alter table user_operator_tariffs
    add constraint FKfgys1c8ymja9fyu57krwdafnc foreign key (tariffs_id) references tariff (id);

alter table user_operator_tariffs
    add constraint FKfc7s9eb7srh8mkvht9s6xqew3 foreign key (user_operator_id) references user_operator (id);