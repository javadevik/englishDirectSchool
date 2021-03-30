insert into usr (id, username, password, active)
    values (1, 'admin', 'admin', true);

insert into user_role (user_id, roles)
    values (1, 'ADMIN');

insert into person (id, user_id, name, last_name, address, passport_number, tax_number, email, phone)
    values (1, 1, 'English', 'School', 'Hlinki st.', '329472982344', '329474365444', 'englishdirectua@gmail.com', '+380975469515')
