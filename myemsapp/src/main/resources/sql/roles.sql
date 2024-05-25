USE myemsapp;

# mysecretpassword

set @EN_PASSWORD = '$2a$12$AlmwFO6GXq5U6iPgew.97e6JGwzMFg3RhaCHUQFa5OrPs5bbxg5my';

insert into users (user_id, username, password) values (1, 'admin', @EN_PASSWORD);

insert into users (user_id, username, password) values (2, 'user1', @EN_PASSWORD);  

insert into roles (role_id, name) values (1, 'NORMAL_USER');
insert into roles (role_id, name) values (2, 'ADMIN_USER');    

insert into users_roles (user_id, role_id) values (
	    	(select user_id from users where username = 'admin'),
	    	(select role_id from roles where name = 'ADMIN_USER')
	);


insert into users_roles (user_id, role_id) values (
    		(select user_id from users where username = 'user1'),
    		(select role_id from roles where name = 'NORMAL_USER')
    );    


