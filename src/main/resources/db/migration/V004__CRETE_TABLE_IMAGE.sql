create table if not exists tb_image(
	id_image int(10) not null primary key auto_increment,
    url_image varchar(1000) not null,
    id_announcement int(6)
);

alter table tb_image add constraint fk_tb_announcement_id_announcement foreign key(id_announcement) references tb_announcement(id_announcement);