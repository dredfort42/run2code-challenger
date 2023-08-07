drop table if exists users CASCADE;
CREATE TABLE users(
                      id SERIAL PRIMARY KEY,
                      email varchar(50) not null,
                      password varchar(100) not null);
drop table if exists run_data;
drop table if exists run_training;
CREATE TABLE run_training(
                      id serial primary key,
                      user_id int not null,
                      foreign key (user_id) references users(id),
                      distance decimal not null,
                      elapsed_time bigint not null,
                      begin_date_time timestamp not null);