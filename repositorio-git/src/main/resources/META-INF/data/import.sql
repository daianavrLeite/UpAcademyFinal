INSERT INTO Unit (nameUnit) VALUES ('Unidade A');
INSERT INTO Unit (nameUnit) VALUES ('Unidade B');
INSERT INTO Unit (nameUnit) VALUES ('Unidade C');
INSERT INTO Unit (nameUnit) VALUES ('Unidade D');
INSERT INTO Unit (nameUnit) VALUES ('Unidade E');
INSERT INTO Unit (nameUnit) VALUES ('Unidade F');
INSERT INTO Unit (nameUnit) VALUES ('Lisboa');
INSERT INTO Unit (nameUnit) VALUES ('Porto');
INSERT INTO Unit (nameUnit) VALUES ('Faro');

INSERT INTO Client (nipc, potentialRevenue, name) VALUES (501591109, 100, 'Continente');
INSERT INTO Client (nipc, potentialRevenue, name) VALUES (501199993, 200, 'Microsoft');
INSERT INTO Client (nipc, potentialRevenue, name) VALUES (508141966, 300, 'Apple');
INSERT INTO Client (nipc, potentialRevenue, name) VALUES (505350173, 400, 'Visionbox');
INSERT INTO Client (nipc, potentialRevenue, name) VALUES (509815316, 500, 'HRB');


INSERT INTO Client (nipc, potentialRevenue, name) VALUES (0000001, 100, 'Bnp Paribas');
INSERT INTO Client (nipc, potentialRevenue, name) VALUES (0000002, 200, 'Santander');
INSERT INTO Client (nipc, potentialRevenue, name) VALUES (0000003, 300, 'Sibs');
INSERT INTO Client (nipc, potentialRevenue, name) VALUES (0000004, 400, 'Cellfocus');
INSERT INTO Client (nipc, potentialRevenue, name) VALUES (0000005, 500, 'Sky');
INSERT INTO Client (nipc, potentialRevenue, name) VALUES (0000005, 500, 'EDP');
INSERT INTO Client (nipc, potentialRevenue, name) VALUES (0000005, 500, 'Accenture');


INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('Joaquim@aubay.com', '1gfhf', 'Joaquim Marques', 'director', 'salt1' ,'Joaq', 1);
INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('AntonioDuarte@gmail.com', '2fghfgh', 'Antonio Duarte', 'manager','salt2', 'Anto',2);
INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('Jose76@aubay.com', '3fghfgh', 'Jose Alves', 'manager','salt3','Jose', 3);
INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('Paulo@hotmail.com', '4fghff', 'Paulo Morim', 'manager','salt4','Paul', 2);
INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('Joao1984@gmail.com', '5gfghf', 'Joao Martins', 'manager' ,'salt5','Joao', 1);


INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('COO@gmail.com','ShVOBO+A','COO', 'SuperUser', '7yaYTHQ4RI2Yd3KUwTiMezw3pIKe417EMPU51pGidPefqzs40Cp+1UBPaozGvyFnsmY=','coo', 1);
INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('manA@gmail.com', 'tmPfdYmE','Manager A', 'manager','hQFcM1z6ld3eYZPGKOFcdBSFNcGezFDonNbI0i3zwj7hJH/pxd6pJ3ZsufbjzRBDHhA=','managerA', 2 );
INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('manB@gmail.com', 'iefgh2K9','Manager B', 'manager','RRK8yVxdZeuNzcwFJ1aDteMsbr7KwH9P8J+ng5BXhdgm+7Hj7YmrSwe2UcHLBxw44p8=', 'managerB',4);
INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('manC@gmail.com', 'RdM3ro6P','Manager C', 'manager','1KOSGjIv5gfAHy8kjJLP6eNVNoMNoAtciqd/GMTox2nWPgdYRznruGy8bxkQz3TPInY=', 'managerC',3);

INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('a@a', '1gfhf', 'Joaquim', 'director', 'salt1' ,'Joaq2', 1);
INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('b@b', '2fghfgh', 'Antonio', 'manager','salt2', 'Anto2',2);
INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('c@c', '3fghfgh', 'Jose', 'manager','salt3','Jose2', 5);
INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('d@d', '4fghff', 'Paulo', 'manager','salt4','Paul2', 2);
INSERT INTO Person(email, hashcode, name, role, salt, username, unit_id) VALUES ('e@e', '5gfghf', 'Joao', 'manager' ,'salt5','Joao2', 4);


INSERT INTO InteractionType(interactionType) VALUES ('Proposta aceite');
INSERT INTO InteractionType(interactionType) VALUES ('Aprovacao');
INSERT INTO InteractionType(interactionType) VALUES ('Proposta Recusada');
INSERT INTO InteractionType(interactionType) VALUES ('Pedido');
INSERT INTO InteractionType(interactionType) VALUES ('CV enviado');
INSERT INTO InteractionType(interactionType) VALUES ('Entrevista');
INSERT INTO InteractionType(interactionType) VALUES ('Saida');
INSERT INTO InteractionType(interactionType) VALUES ('Ponto de Situacao');
INSERT INTO InteractionType(interactionType) VALUES ('Realocacoes - Receber');
INSERT INTO InteractionType(interactionType) VALUES ('Realocacoes - Dar');
INSERT INTO InteractionType(interactionType) VALUES ('Reunioes Cliente');
INSERT INTO InteractionType(interactionType) VALUES ('Negocio abaixo de 32');



INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('1', 1, 1, 5, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('1', 1, 3, 5, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('2', 1, 3, 5, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('5', 1, 3, 5, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('1', 2, 2, 6, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('2', 2, 2, 5, 2);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('3', 3, 1, 7, 3);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('4', 4, 1, 6, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('5', 5, 4, 7, 4);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('6', 2, 5, 7, 6);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('7', 6, 4, 8, 6);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('8', 6, 6, 9, 7);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('9', 5, 7, 9, 8);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('10', 4, 11,5, 4);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('11', 1, 12, 6, 4);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('13', 2, 9, 6, 2);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('1', 2, 8, 7, 4);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('3', 4, 8, 7, 3);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('3', 2, 7, 8, 3);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('11', 5, 7, 8, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('21', 6, 6, 5, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('1', 1, 5, 6, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('2', 4, 4, 6, 2);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('3', 3, 3, 7, 8);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('4', 1, 1, 6, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('5', 1, 4, 5, 4);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('6', 4, 1, 5, 8);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('7', 1, 2, 6, 4);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('8', 5, 1, 6, 8);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('9', 1, 2, 7, 4);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('10', 3, 4,7, 7);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('11', 1, 2, 9, 7);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('13', 2, 9, 9, 2);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('1', 3, 10, 10, 7);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('3', 1, 1, 10, 4);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('3', 4, 2, 5, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('11', 5, 2, 5, 3);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('21', 2, 5, 5, 1);


INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('4', 1, 3, 5, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('5', 1, 3, 5, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('6', 1, 3, 5, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('7', 1, 3, 5, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('7', 1, 3, 5, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('8', 2, 3, 6, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('9', 2, 3, 5, 2);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('10', 3, 3, 7, 3);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('11', 4, 3, 6, 1);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('13', 5, 3, 7, 4);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('21', 2, 3, 7, 6);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('21', 6, 3, 8, 6);
INSERT INTO Interaction(dateInteraction, client_id, interactionType_id, person_id, unit_id) VALUES ('2', 6, 3, 8, 6);
