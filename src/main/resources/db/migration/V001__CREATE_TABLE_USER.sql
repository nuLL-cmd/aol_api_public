create table if not exists tb_user(
	id_user int(6) not null primary key auto_increment,
    uid varchar(100) not null,
    phone varchar(13) not null,
    first_name varchar(60) not null,
    last_name varchar(60) not null,
    email varchar(100) not null,
    url_photo varchar(200) not null,
    city varchar(50) not null,
    uf varchar(2) not null,
    date_since date not null
    
);