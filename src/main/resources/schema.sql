drop table if exists candy_delivery;

drop table if exists candy;
create table candy
(id bigint not null, name nvarchar(255), price decimal(12,4), primary key (id));

--create table candy_delivery(candy_id bigint not null,delivery_id bigint not null,
--foreign key (candy_id) references candy(id),foreign key (delivery_id) references delivery(id) on delete cascade );
