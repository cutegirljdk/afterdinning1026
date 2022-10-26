select * from member;

update member set password='b',name='아이유3',address='종로' where id='java';

insert into member(id,password,name,address) values('web1','a','이강인1','마요르카');

commit

-- id가 존재하는 지 유무 
-- java id가 존재하면 1 , 없으면 0 
select count(*) from member where id='java';










