create table if not exists tb_announcement (
  id_announcement int(6) unique key AUTO_INCREMENT,
  situation varchar(10) not null,
  title varchar(40) NOT NULL,
  description varchar(1000) NOT NULL,
  price decimal(10,2) DEFAULT NULL,
  phone varchar(13) DEFAULT NULL,
  uf varchar(2) DEFAULT NULL,
  city varchar(50) DEFAULT NULL,
  id_user int(60) NOT NULL
);
alter table tb_announcement add constraint fk_tb_user_id_user foreign key (id_user) references tb_user(id_user);
