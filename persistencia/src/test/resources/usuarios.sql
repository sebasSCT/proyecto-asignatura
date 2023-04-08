insert into ciudad values(1, "Armenia");
insert into ciudad values(2, "Pereira");

insert into usuario values ("123", "2000/09/10", "MASCULINO", "FER", "fer@gmail.com", "hola1", 1);
insert into usuario values ("124", "2000/09/11", "FEMENINO", "FAR", "far@gmail.com", "hola2", 1);
insert into usuario values ("125", "2000/09/12", "MASCULINO", "FOR", "for@gmail.com", "hola3", 2);
insert into usuario values ("126", "2000/09/13", "FEMENINO", "FIR", "fir@gmail.com", "hola4", 2);

insert into usuario_num_telefonos values ("123", "987", "casa");
insert into usuario_num_telefonos values ("123", "3434", "trabajo");

insert into libro values ("abcd1", 2005, "TERROR", "cinco noches con alfredo", 2);
insert into libro values ("abcd2", 2005, "HISTORIA", "el origen del sexo", 5);
insert into libro values ("abcd3", 2010, "CIENCIA_FICCION", "sexo 2077", 189);
insert into libro values ("abcd4", 2011, "ANIME", "cinco noches con alfredo future location", 5);

insert into autor values ("autor1", "2000/09/05", "MASCULINO", "el pepe", 2000);
    insert into autor values ("autor2", "1/09/05", "MASCULINO", "floppa", 1);
insert into autor values ("autor3", "1998/10/12", "FEMENINO", "a", 1998);

insert into libro_autores values ("abcd1", "autor1");
insert into libro_autores values ("abcd2", "autor2");
insert into libro_autores values ("abcd3", "autor2");
insert into libro_autores values ("abcd4", "autor1");
insert into libro_autores values ("abcd4", "autor2");