  create table shopreple(
		idx smallint auto_increment primary key,
        num smallint,
        star smallint,
        message varchar(500),
        writeday datetime,
        foreign key(num) references shop(num) on delete cascade
    );