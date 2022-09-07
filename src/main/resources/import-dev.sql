INSERT INTO rumahsakit.users (id,name,username,password,user_type) VALUES (nextval('rumahsakit.user_sequence'::regclass),'super admin 1', 'superadmin1','$2a$10$nHK7SJzUA3NxGWoUf5to8OD.fDsjEuMRHWN6NTg1GiBSm4mHB4/9u','superadmin');
INSERT INTO rumahsakit.users (id,name,username,password,user_type) VALUES (nextval('rumahsakit.user_sequence'::regclass),'super admin 2', 'superadmin2','$2a$10$RyAfruOoZjGoYa6ZsHkivubdb8nhSuhBs6ceWrzvjRJEV9gs6bdWq','superadmin');
insert into rumahsakit.user_permission (id,name, user_id) values (nextval('rumahsakit.user_permission_sequence'::regclass),'superadmin',1);
insert into rumahsakit.user_permission (id,name, user_id) values (nextval('rumahsakit.user_permission_sequence'::regclass),'admin',1);
insert into rumahsakit.user_permission (id,name, user_id) values (nextval('rumahsakit.user_permission_sequence'::regclass),'superadmin',2);
insert into rumahsakit.user_permission (id,name, user_id) values (nextval('rumahsakit.user_permission_sequence'::regclass),'admin',2);
