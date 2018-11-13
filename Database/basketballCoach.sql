create database if not EXISTS id7780538_basketballcoachdb;
use id7780538_basketballcoachdb;

create table if not exists players(
    player_id varchar(5) not null,
    player_name varchar(20) not null,
    birthday date not null,
    height decimal(2,2),
    weight decimal(3,2),
    status enum('beginer', 'moderate', 'proffesional') not null,
    PRIMARY KEY(player_id)
);

CREATE TABLE IF not EXISTS parameters(
    player_id VARCHAR(5) not null,
    session_id VARCHAR(5) not null,
    date date,
    time time,
    shoot_type enum('jump', 'hook', 'free'),
    distance_basket decimal(3,2),
    shooting_angle decimal(2,2),
    shooting_speed decimal(3,2),
    foot_angle decimal(2,2),
    arm_angle decimal(2,2),
    releasing_height decimal(2,2),
    PRIMARY KEY (player_id, session_id, date, time),
    FOREIGN KEY (player_id) REFERENCES players(player_id)
);

CREATE TABLE if not EXISTS feedback(
    player_id VARCHAR(5) not null,
    session_id VARCHAR(5) not null,
    date date,
    time time,
    feedback VARCHAR(100),
    PRIMARY KEY(player_id,session_id,date, time),
    FOREIGN key(player_id) REFERENCES players(player_id),
    FOREIGN key(session_id) REFERENCES parameters(session_id),
    FOREIGN key(date) REFERENCES parameters(date),
    FOREIGN key(time) REFERENCES parameters(time)
);
