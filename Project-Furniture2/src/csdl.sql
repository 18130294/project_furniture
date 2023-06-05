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

create table product(
idProduct int primary key,
idCategory char(30) references categories(idCategories),
idSubCategories char(30) references subCategories(subCategories),
nameProduct varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
price double,
images varchar(50),
soluongtrongkho int,
describes text CHARACTER SET utf8 COLLATE utf8_unicode_ci);
SELECT * FROM product LIMIT 3;

create table users(
idUser char(30) primary key,
email char(40),
sdt char(10),
pass varchar(30),
nameUser varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
isAdmin int,
diachi varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci);
insert into users values("123","saurieng1166@gmail.com","0342500003","123456","Nguyễn Thị Như Ý",0,"Bình Thạnh");
insert into users values("124","19130069@st.hcmuaf.edu.vn","0354528545","NhanTaiTrongLaU","Huỳnh Minh Hiếu",0,"Bình Thạnh");
insert into users values("125","18130294@st.hcmuaf.edu.vn","0335979175","123456","Như Ý",1,"Đồng Tháp");


truncate table users;
select*from users;
create table orders(
idOrder char(50) primary key,
idUser char(10) references users(idUser),
address varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
phoneNumber char(10),
invoiceDate datetime,
payForm varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci);

insert into orders values("abc","123","Quận Bình Thạnh","0342500003","2022-2-24","Thanh toán khi nhận hàng");

create table ordersDetail(
idOrderDetail int primary key,
idOrder char(50) references orders(idOrder),
idProduct int references product(idProduct),
quantity int,
price double,
statuss varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
total float,
nameUser varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci
);
insert into ordersDetail value (123,"abc","123",1,945000.0,"Đang xử lý",945000.0,"Nguyễn Thị Như Ý");
select invoiceDate,nameProduct,images,d.price,total,statuss from
orders o join ordersDetail d on o.idOrder= d.idOrder join users  u on o.idUser = u.idUser
join product p on d.idProduct =p.idProduct where u.idUser="123";
select*from ordersDetail;
truncate table ordersDetail ;
-- drop table ordersDetail
 --  drop table categories
--  drop table subCategories
 -- drop table product
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

-- ---------USER-------------------------------- 
insert into users values ('user1','saurieng1166@gmail.com','0342500003','Nhuy1411','Nguyễn Thị Thu Hoài',0,'Tp. Hồ Chí Minh');

-- --------PRODUCT-- -------------------------

-- ---------BÀN-----
insert into product values (123,'NTGO','BAN','BÀN ĂN HATHEN',945000.0,'ban_an_hathen.jpg',150,'Đơn giản và hiện đại, 
bàn ăn HATHEN là lựa chọn hợp lý cho phòng ăn của gia đình bạn. Bàn được làm từ nguyên liệu gỗ cao su, bề mặt phủ lớp sơn màu sẫm đẹp mắt.
Chân bàn thu hút với thiết kế lạ mắt,là điểm nhấn ấn tượng cho không gian bàn ăn thêm sang trọng. Hãy kết hợp bàn với ghế ăn trong cùng bộ sưu tập HATHEN');
insert into product values (124,'NTGO','BAN','BÀN ĂN ANNE',550000.0,'ban_an_anne.jpg',150,'Chất liệu gỗ, phù hợp từ 4-6 người ngồi');
insert into product values (125,'NTGO','BAN','BÀN ĂN BILBO',1450000.0,'ban_an_bilbo.jpg',150,'Chất liệu gỗ Aluminum.Thiết kế tối giản, không cồng kềnh, có thể dễ dàng mang vác đi khi có nhu cầu di chuyển.
Bền bỉ, có thể chịu đựng được thời tiết khắc nghiệt, tồn tại lâu dài theo thời gian. Có thể dùng làm bàn ăn ở ngoài trời hoặc ở trong nhà.');
insert into product values (126,'NTGO','BAN','BÀN ĂN VENICE',1050000.0,'ban_an_venice.jpg',150,'Bàn ăn VENICE là một thiết kế đặc biệt theo phong cách hiện đại và ấn tượng. Sản phẩm được làm từ gỗ thông/MDF phủ veneer sồi cao cấp. Bàn phối màu gỗ đậm với hoạ tiết vân gỗ tự nhiên độc đáo, sang trọng thích hợp với nhiều không gian dùng bữa khác nhau. Hãy kết hợp với các sản phẩm khác trong bộ sưu tập phòng ăn để hoàn thiện nội thất cho tổ ấm của bạn.');
insert into product values (127,'NTGO','BAN','BÀN ĂN VERONE',1850000.0,'ban_an_verone.jpg',150,'Bàn ăn VERONA nổi bật với màu sắc trang nhã được làm từ gỗ công nghiệp bền chắc.Rất phù hợp với những gia đình ít người và không gian phòng bếp hạn chế.Mặt bàn được xử lý kỹ càng, mang vẻ đẹp tinh xảo.Chân bàn làm từ kim loại, cho độ cứng cáp và chắc chắn cao.Bạn có thể kết hợp bàn cùng các sản phẩm khác trong cùng bộ sưu tập VERONA để hoàn thiện nội thất phòng ăn của gia đình bạn.');
insert into product values (128,'NTGO','BAN','BÀN CÀ PHÊ CHESTER',550000.0,'ban_ca_phe_chester.jpg',100,'Chất liệu: Gỗ thông cao cấp với màu gỗ cà phê sữa đậm sẽ làm nền cho những vật trang trí khác như lọ hoa trở nên nổi bật hơn.Thiết kế: 2 tầng lệch nhau, một lớn một nhỏ giúp gia tăng diện tích lưu trữ đồng thời chính là tâm điểm của sự phá cách thiết kế.');
insert into product values (129,'NTGO','BAN','BÀN LÀM VIỆC CHESTER',550000.0,'ban_lam_viec_chester.jpg',50,'Chất liệu: Gỗ thông cao cấp, độ bền cao.Thiết kế: Gồm 1 hộc kéo bên dưới và một hộc cửa lùa bên trên. Với hộc cửa lùa, bạn có thể tận dụng làm kệ sách nhỏ, phần trống trên kệ làm nơi.');
insert into product values (130,'NTGO','BAN','BÀN TRANG ĐIỂM CARINE',980000.0,'ban_trang_diem.jpg',150,'Chất liệu Sồi veneer / Sồi / MDF.');

-- -------GHẾ-----------------
insert into product values (230,'NTGO','GHE','GHẾ ĂN COBRA',480000.0,'ghe_an_cobra.jpg',150,'Chất liệu: Ghế được làm hoàn toàn từ gỗ sồi đặc có độ bền cao so với các loại gỗ thông thường.');
insert into product values (231,'NTGO','GHE','GHẾ ĂN SACRAMENTO',580000.0,'ghe_an_sacramento.jpg',10,'Chất liệu: Rubber-Wood-Plywood-100%-Polyester. Mẫu ghế ăn SACRAMENTO được thiết kế với phần đệm ngồi rộng, tựa lưng cao và bao trọn lưng người ngồi giúp giảm thiểu những áp lực tại các bộ phần từ cổ, vai gáy, lưng người ngồi.');
insert into product values (232,'NTGO','GHE','GHẾ ĂN PRINCETON',590000.0,'ghe_an_princeton.jpg',150,'Chất liệu gỗ cao su với phần chân và khung ghế vô cùng dẻo dai, được mài phẳng mịn và phủ một lớp sơn nâu tự nhiên càng làm tăng độ bóng đẹp. Ngoài ra, ghế ăn PRINCETON có phần lưng tựa cùng đệm ngồi được làm từ vải tổng hợp êm ái, dễ chịu, gợi nét đẹp hiện đại, đơn giản, tinh tế.');


-- -----------GIƯỜNG------------------
insert into product values (330,'NTGO','GIUONG','GIƯỜNG RALLY 1M2',2480000.0,'giuong_rally_1m2.jpg',50,'Chất liệu: Gỗ cao su/ ván ép. Thiết kế tinh tế dành cho những ai ưa chuộng phong cách sống tối giản mà vẫn không kém phần sang trọng.');
insert into product values (331,'NTGO','GIUONG','GIƯỜNG KITKA 1M2',3400000.0,'giuong_kitka_1m2.jpg',130,'Kích thước nhỏ gọn: 1m2 x 2m (rộng x dài). Phù hợp để sử dụng cho 1 người. Màu gỗ đậm mang đến vẻ đẹp truyền thống, ấm cúng. Chất liệu gỗ cao su bền đẹp kết hợp ván ép');
insert into product values (332,'NTGO','GIUONG','GIƯỜNG HARRIS 1M2',2480000.0,'giuong_harris.jpg',180,'Chất liệu: Sồi veneer / Sồi / MDF');

-- -----------GƯƠNG------------------
insert into product values (430,'NTGO','GUONG','GƯƠNG TREO TƯỜNG MIRAMAR',280000.0,'guong_treo_tuong_miramar.jpg',50,'Gương hình mái vòm MIRAMAR tráng bạc dày 3mm; khung bằng nhôm mạ vàng đánh xước cao cấp; trang trí phòng khách, phòng ngủ, phòng tắm sang trọng, quý phái');

-- -----------TỦ KỆ------------------
insert into product values (530,'NTGO','TUKE','KỆ TV ICONICO',540000.0,'ke_tv_iconico.jpg',40,'Kệ TV ICONICO được thiết kế theo phong cách tối giản, tân cổ điển nhưng vẫn mang đậm chất sang trọng, thượng lưu, toát lên sự khác biệt. Với 2 màu cơ bản dành cho khách hàng lựa chọn là màu trắng mờ và màu gỗ sồi tự nhiên, sản phẩm được hứa hẹn sẽ đem lại sự tiện nghi và đem đến không gian đẳng cấp cho gia chủ.');


-- -----------SOFA------------------
insert into product values (630,'SOFA_NIEM','SOFA','SOFA DALLAS',1800000.0,'sofa_dallas.jpg',20,'Sofa DALLAS mang một thiết kế cổ điển có độ giá trị cao về mặt thẩm mỹ, mang vẻ đẹp sang trọng, quý phái.');

-- -----------GHẾ PHÒNG KHÁCH------------------
insert into product values (730,'SOFA_NIEM','GHEPK','GHẾ NẰM CONNEMARA',890000.0,'ghe_pk_CONNEMARA.jpg',20,'Ghế nằm CONNEMARA là một thiết kế đặc biệt của BAYA, lấy cảm hứng từ phong cách Art Deco hiện đại và ấn tượng. Sản phẩm được bọc vải nhung mềm mịn; với màu sắc và kiểu dáng cá tính, quyến rũ cho bạn thoải mái thư giãn, nghỉ ngơi');

-- -----------NIỆM------------------
insert into product values (830,'SOFA_NIEM','NIEM','NIỆM SELENE 1M2',1090000.0,'niem_selene.jpg',50,'Nệm SELENE được sản xuất trên dây chuyền công nghệ hiện đại, sử dụng nguồn nguyên liệu cao cấp an toàn cho sức khỏe. Cấu tạo nệm: Khung lò xo túi được làm bằng thép nhập khẩu 2.15 ly đã được xử lý qua nhiệt luyện nghiêm ngặt. Thép không rỉ, chịu lực và đàn hồi cao, không ồn, mỗi lò xo riêng biệt bọc túi vải riêng biệt, thoáng khí, chống ẩm và diệt khuẩn.');

-- -----------ĐÈN------------------
insert into product values (930,'DTT','DEN','ĐÈN NGỦ KOPPA',950000.0,'den_koppa.jpg',50,'Đèn bàn KOPPA từ nội thất BAYA mang phong cách hiện đại, tối giản. Thân đèn làm từ kim loại uốn khung cho đèn phom dáng lạ mắt, vững chãi và bền chắc. Các chi tiết phối màu trắng thanh lịch và màu đồng sáng bóng giúp tôn lên vẻ sang trọng, ấm áp cho không gian.');


--  select*from categories;
--   select*from subCategories;
  select *from product;

