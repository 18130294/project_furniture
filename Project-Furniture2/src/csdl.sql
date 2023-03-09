create database project_furniture;
use project_furniture;

create table categories(
idCategories char(30)  primary key,
nameCategories varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci
);
create table subCategories(
idSubcategory varchar(30) primary key,
idcategories char(30) references categories(idCategories),
nameSubcategories varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci);

 --  drop table categories
--  drop table subCategories
insert into categories values ('NTGO','Nội thất gỗ');
insert into categories values ('SOFA_NIEM','Sofa & Niệm');
insert into categories values ('DTT','Đồ trang trí');
insert into categories values ('DDVAi','Đồ dùng vải');
insert into categories values ('DCBEP','Dụng cụ nhà bếp');


insert into subCategories values ('BAN','NTGO','Bàn');
insert into subCategories values ('GHE','NTGO','Ghế');
insert into subCategories values ('GIUONG','NTGO','Giường');
insert into subCategories values ('GUONG','NTGO','Gương');
insert into subCategories values ('TUKE','NTGO','Tủ kệ');

insert into subCategories values ('SOFA','SOFA_NIEM','SOFA');
insert into subCategories values ('GHEPK','SOFA_NIEM','Ghế phòng khách');
insert into subCategories values ('NIEM','SOFA_NIEM','Niệm');

insert into subCategories values ('DEN','DTT','Đèn');
insert into subCategories values ('LOHOA','DTT','Lọ hoa');
insert into subCategories values ('DONGHO','DTT','Đồng hồ');
insert into subCategories values ('KHUNHANH','DTT','Khung ảnh');

insert into subCategories values ('CHANGA','DDVAi','Chân ga & gối');
insert into subCategories values ('REM','DDVAi','Rèm cửa');

insert into subCategories values ('COC','DCBEP','Cốc, tách & ấm trà');
insert into subCategories values ('DIACHEN','DCBEP','Đĩa, tô & chén');




 select*from categories;
  select*from subCategories