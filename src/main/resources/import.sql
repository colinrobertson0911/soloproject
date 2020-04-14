insert into users (userId, firstname, lastname) values (USER_SEQ.nextval, 'Colin', 'Robertson');
insert into users (userId, firstname, lastname) values (USER_SEQ.nextval, 'Peter', 'Wade');

insert into item (itemId, name, description, price, numberInStock) values (ITEM_SEQ.nextval, 'Milk', 'Semi-Skimmed', '1.09', 5);
insert into item (itemId, name, description, price, numberInStock) values (ITEM_SEQ.nextval, 'Bread', 'Brown', '1.45', 2);
insert into item (itemId, name, description, price, numberInStock) values (ITEM_SEQ.nextval, 'Eggs', 'Various size', '1.15', 0);
insert into item (itemId, name, description, price, numberInStock) values (ITEM_SEQ.nextval, 'Apples', 'Golden Delicious', '1.69', 20);
insert into item (itemId, name, description, price, numberInStock) values (ITEM_SEQ.nextval, 'Tomato Soup', '6 pack', '2.99', 10);
insert into item (itemId, name, description, price, numberInStock) values (ITEM_SEQ.nextval, 'Pot Noodle', 'Chicken and Mushroom', '0.89', 20);
insert into item (itemId, name, description, price, numberInStock) values (ITEM_SEQ.nextval, 'Ham', '30 Slices', '1.29', 15);
insert into item (itemId, name, description, price, numberInStock) values (ITEM_SEQ.nextval, 'Mince', '500g', '2.39', 20);
insert into item (itemId, name, description, price, numberInStock) values (ITEM_SEQ.nextval, 'IAms', '2Kg', '5.00', 10);

insert into users_basket(users_userId, basket_itemId) values (1, 1);
insert into users_basket(users_userId, basket_itemId) values (1, 2);
insert into users_basket(users_userId, basket_itemId) values (2, 3);


