���룺

create table student(
	id int,
	name varchar(20),
	chinese float,
	english float,
	math float
);

insert into student(id,name,chinese,english,math) values(1,'��С��',89,78,90);
insert into student(id,name,chinese,english,math) values(2,'���',67,53,95);
insert into student(id,name,chinese,english,math) values(3,'����',87,78,77);
insert into student(id,name,chinese,english,math) values(4,'��һ',88,98,92);
insert into student(id,name,chinese,english,math) values(5,'������',82,84,67);
insert into student(id,name,chinese,english,math) values(6,'�Ž���',55,85,45);
insert into student(id,name,chinese,english,math) values(7,'����',75,65,30);







��Ŀ��

1.����һ��Ա����
	�ֶ�     ����
	id        ����(int)
	name     �ַ���(varchar)������Ϊ20��
	gender    �ַ���������Ϊ2��
	birthday  ������(date)
	email	   �ַ���������Ϊ10��
	remark     �ַ���������Ϊ50��

2.�޸ı���ϰ

	����Ϊ���
			��Ա�������������age��
			�޸�email�г���Ϊ50     '�������������ݸĲ��˱�����
			ɾ��remark��
			����name�޸�Ϊusername

3.��Ա��������ϰ���ݵ���ɾ�Ĳ���

	
------------------------------------------------------------------
��Ա�������������age��
		ALTER TABLE studen ADD sge VARCHAR(2);


-- ��ѯ���е�ѧ��
SELECT * FROM student;																	select  ��ѯ

-- ��ѯ��������ѧ���������Ͷ�Ӧ��Ӣ��ɼ���
SELECT NAME,english FROM student;

-- ���˱���Ӣ��ɼ����ظ�����
SELECT DISTINCT(english) FROM student ;																		distinct  Ψһ

-- ʹ�ñ�����ʾѧ������
SELECT chinese AS yuwen,english AS yingyu,math AS shuxue FROM student;

-- ��ѯ����Ϊ��һ��ѧ���ɼ�
SELECT * FROM student WHERE NAME='��һ';                                                            where   ��������

-- ��ѯӢ��ɼ����ڵ���90�ֵ�ͬѧ
SELECT * FROM student WHERE english>90;

-- ��ѯ�ִܷ���200�ֵ�����ͬѧ
SELECT * ,(chinese+english+math) AS '�ܳɼ�' FROM student WHERE (chinese+english+math)>200;

-- ��ѯ���������ѧ��Ӣ��ɼ���
SELECT * FROM student WHERE NAME LIKE '��%';                                                         like       ����

-- ��ѯӢ��>80�����ܷ�>200��ͬѧ
SELECT * FROM student WHERE english>80 OR (chinese+english+math)>200;											or ��

-- ͳ��ÿ��ѧ�����ܷ֡�
SELECT * ,(chinese+english+math) AS '�ܳɼ�' FROM student;										

-- ������ѧ���ܷ����ϼ�10���س��֡�
SELECT * ,(chinese+english+math) AS '�ܳɼ�', (chinese+english+math)+10 AS 
'�س���' FROM student;






 
	
	