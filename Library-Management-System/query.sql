

INSERT INTO user (username, user_password) VALUES
    ('user', '$2a$12$oaseMjre9QA0gXQR72ur0eO4BEnPe4wRruk9gvhr7xFYU/L7q7fSS'),
    ('admin', '$2a$12$speYKs9Y8ehV6D.4XGb9SuP9BeUXsDtbx9i5.Pdpc/Nfqi4RG9II.'),
    ('manager', '$2a$12$M2AW/rTEiZ3nqpavSw22L.PiHYZDNbrsi8yXOyl9CSLvGbHJHEgvO');


INSERT INTO authorities (username, authority) VALUES
    ('user', 'ROLE_USER'),     
    ('admin', 'ROLE_ADMIN'),   
    ('manager', 'ROLE_MANAGER'); 




