create database if not EXISTS id7780538_basketballcoachdb;
use id7780538_basketballcoachdb;

create table if not exists players(
    player_id VARCHAR(5) not null,
    player_name VARCHAR(20) not null,
    birthday date not null,
    height decimal(2,2),
    weight decimal(3,2),
    status enum('beginer', 'moderate', 'proffesional') not null,
    PRIMARY KEY(player_id)
);

CREATE TABLE IF not EXISTS updates(
    player_id VARCHAR(5) not null,
    session_id VARCHAR(5) not null,
    datetime datetime,
    shoot_type enum('jump', 'hook', 'free'),
    distance_basket decimal(3,2),
    shooting_angle decimal(2,2),
    shooting_speed decimal(3,2),
    foot_angle decimal(2,2),
    arm_angle decimal(2,2),
    releasing_height decimal(2,2),
    PRIMARY KEY (player_id, session_id, datetime),
    FOREIGN KEY (player_id) REFERENCES players(player_id)
);

CREATE TABLE if not EXISTS feedback(
    player_id VARCHAR(5) not null,
    session_id VARCHAR(5) not null,
    datetime datetime,
    feedback VARCHAR(100),
    PRIMARY KEY(player_id,session_id,datetime),
    FOREIGN key(player_id) REFERENCES players(player_id),
    FOREIGN key(session_id) REFERENCES updates(session_id),
    FOREIGN key(datetime) REFERENCES updates(datetime)
);
