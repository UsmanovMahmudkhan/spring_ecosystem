create table movie(
 id bigint primary key ,
 title char(200) not null ,
 description char(200),
 release_year date,
 duration bigint not null ,
 date_added datetime
);