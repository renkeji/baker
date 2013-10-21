# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table company (
  company_id                bigint auto_increment not null,
  name                      varchar(255),
  country                   varchar(255),
  description               varchar(255),
  constraint pk_company primary key (company_id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table company;

SET FOREIGN_KEY_CHECKS=1;

