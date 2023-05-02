INSERT INTO user_info (id, name, email, password, is_active) VALUES(random_uuid(), 'Andres Pena', 'afpena44@gmail.com', '$2a$10$jxAKcR2u3Bn81Km04kUsv.faU6ThzL4YBM4bRFuULVumk0Vf83d3G', true)
INSERT INTO phone (id, user_id, number, city_code, contry_code) VALUES(random_uuid(), (SELECT id FROM user_info WHERE email = 'afpena44@gmail.com'), '304 387 34 96', '604', '57')
