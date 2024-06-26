use hw22;

create table homework(
                         id int primary key auto_increment,
                         name varchar(50),
                         description varchar(150)
);

create table lesson(
                       id int primary key auto_increment,
                       name varchar(50),
                       updated_at timestamp,
                       homework_id int,
                       foreign key (homework_id) references homework(id)
);

create table schedule(
                         id int primary key auto_increment,
                         name varchar(50),
                         updatedAt timestamp
);

create table lesson_x_schedule(
                                  lesson_id int,
                                  schedule_id int,
                                  unique (lesson_id, schedule_id),
                                  foreign key (lesson_id) references lesson(id),
                                  foreign key (schedule_id) references schedule(id)
);