insert into employee
    (birthday, first_name, last_name, mail_address, sex)
values
        ('1990-01-31', '타니', '오', 'otani@angels.com', 'male');

insert into employee
(birthday, first_name, last_name, mail_address, sex)
values
    ('1985-02-10', '태용', '신', 'shin@indonesia.com', 'male');

insert into employee
(birthday, first_name, last_name, mail_address, sex)
values
    (null, '은진', '박', null, 'female');


insert into todo(name, created_at, finished) values ('Today; 고양이 목욕시키기', now(), true);
insert into todo(name, created_at, finished) values ('Tomorrow; Vue JS 수업', now(), false);
insert into todo(name, created_at, finished) values ('Daily feed cat', now(), false);