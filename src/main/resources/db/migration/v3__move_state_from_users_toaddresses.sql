alter table users
    drop column state;
alter table addresss
    add state   varchar(255) not null;
