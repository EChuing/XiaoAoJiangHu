USE llp;     ѡ��һ�ű�

SHOW	TABLES;


�鿴���б�
		SHOW TABLES;


����
		CREATE TABLE student(
		s_id INT primary key auto_increment,                             PRIMARY KEY   AUTO_INCREMENT
		s_name VARCHAR(20),
		s_gender VARCHAR(20),
		s_age INT
		)��

		DESC student;    �鿴



��������

   ����У�
	  ��ӵ���λ
	  alter table student add column age varchar(20) not null first;

	  ָ��λ�����   age �� XXX ����
	  ALTER TABLE student ADD COLUMN age VARCHAR(20) not null AFTER XXX
      
	  ��ӵ�ĩβ
	  alter table student add column age varchar(20) not null;



	����У�

		(in set )
		INSERT INTO student VALUES(8,'¹С��','Ů',21,18,78,NULL);
	                  ����

		���������ֶ� ���ΰ�˳��  �����ٻ�� �ֶ�

		���벿���ֶ�

		INSERT INTO student(s_id,s_name) VALUES(2,'����');
		�����������ָ������ s_id ��s_name ��         


--------insert into  (in se ,  intui)




----------------------------------------------------------------------------------



ɾ������ 


ɾ����������
		DELETE FROM student

��������ɾ��
		DELETE FROM student WHERE s_id=1;

		��һ��ɾ��  ɾ���������������
		TRUNCATE TABLE student;


-----------------------------------------------------------------
-- delete from;													|
--																|		
-- 		���Դ�����ɾ��										|
-- 		����ɾ��������ݣ�������ɾ�����Լ��				|		
-- 		ɾ�����ݿ��Իع� ��������ʱɾ��						|
--																|
-- truncate table												|
--	�� kea														|
-- 		�����Դ�����ɾ��										|
-- 		����ɾ��������ݺ�Լ��   Լ����������֮���			|
-- 		�����Իع�												|
-----------------------------------------------------------------

			
			
---------------------------------------------------------------------------------------------
�޸�����


	alter table	 student  add   column   sgender  varchar��2��
	�޸�   ��      ����   ���  �ֶ�		�ֶ���	���� �����ȣ�
	alter table  student   drop  column   sgender ;
						   ɾ��	  �ֶ�		����
	
	'ע�⣺ ���޸����Ƶ����� ������  ���ܸ���Ϊ��ͬ����������
		alter table student modify column remark varchar(100);     �����޸���������
						   �޸�   �ֶ�		����       ֵ
		alter table student change column aaa   bbb   varchar(10);
						 �޸��ֶ�����  ��ǰ  �ĺ�	
	
	alter table student rename to llp	;   //rename to		��V nin te��		������Ϊ									
								�޸ı� ������

drop table ������  ��zuapu tei bo�� ɾ��ָ����

ע�⣺ column ���Բ�д


distinct		(dis dink) :��ͬ��


�޸���������  
		UPDATE student SET s_gender='Ů';
		e dei
�������޸�
		UPDATE student SET s_id=2 WHERE address='���忪';
	                               ����ָ������   				
�޸Ķ���ֶ�
		UPDATE student SET S_gender='��',s_age=30 WHERE s_id=1; 
		             һ��SET ���ֵ�� , ����

			

------------------------------------------------------------------------------------------------
			
			
			
			��ѯ����

��ѯ��������б�
		 show databases;
��ѯ(�����)��������
		SELECT * FROM student;
��ѯ�����ģ�ָ����
		SELECT s_id,s_name,s_gender FROM student;
��ѯʱ ָ������
		SELECT s_id AS '���',s_name AS '����' FROM student AS s;
		 as + ����    ��� ��ͷ����
		 ���ڶ���ѯ



-��ѯʱ��ӳ�����
		���󣺲�ѯstudent�� ���һ���༶�У�����Ϊ��Java��ҵ�ࡱ
		SELECT s_id ,s_name,s_age,'Java��ҵ��'AS '�꼶' FROM student AS s;

��ѯʱ�ϲ���
		���󣺲�ѯÿ��ѧ����servlet��jsp���ܳɼ�
		SELECT s_id,s_name,(servlet+jsp)AS'�ܷ�' FROM student;
		��ʾ��id��name����ӵ��ܺ͡�
		ע�⣺ֻ���Ժϲ� ��ֵ���� ���ֶ�


'��ѯʱȥ���ظ���¼ (DISTINCT)          (dis dink) :��ͬ��
		���� ��ѯѧ�����Ա�
		SELECT DISTINCT s_gender FROM student;
		��һ���﷨
		SELECT DISTINCT(s_gender)FROM student;	
		��ѯѧ�����ڵĵ���

		SELECT DISTINCT address FROM student;
������ѯ ��where��

	�߼������� and���룩 or����
		���󣺲�ѯidΪ2��������Ϊ���忪��ѧ��
		SELECT * FROM student WHERE s_id=2 AND s_name='���忪';
		���󣺲�ѯidΪ2��������Ϊ�϶��ѧ��
		SELECT * FROM student WHERE s_id=2 OR s_name='�϶�';

	�Ƚϵ������� >�� <�� >=�� <=��==��<>(������)��
		���󣺲�ѯservlet�ɼ�����70�ֵ�ѧ��
		SELECT * FROM student WHERE servlet>70;
---------------------------------------------------------------------------------------------------------------------------
	�ж�������null ���ַ�������is null��   is not null,  =''(���ڿ��ַ���),  <>''�������ڿ��ַ�����
		���󣺲�ѯ��ַΪ�յ�ѧ�������ַ� �� �� ��ַ��
		null��	û��ֵ 	�ж϶��ã�	is null�� is not null, 
		���ַ�����	 ��ֵ	�ж϶��ã�	=''    �� <>''
		SELECT * FROM student WHERE address IS NULL OR address='';

	ģ�������� like
		 % ����ʾ�����ַ�
			���󣺲�ѯ�ա�С����ѧ��
			SELECT * FROM student WHERE s_name LIKE 'С%';
	
		��ѯ�� '¹'�������� ֻ�������� ��ѧ��
			SELECT * FROM student WHERE s_name LIKE '¹_';
		��	¹ _ _ �� һ���»��߱�ʾ���� ��ʲô �� ���ٸ�������

�ۺϲ�ѯ��ʹ�þۺϺ����Ĳ�ѯ��
	
	���õľۺϺ����� sum()���  avg()ƽ��  max()���ֵ  min()��Сֵ  count()ͳ���ܺ�
		
		���� ��ѯѧ����servlet���ܳɼ� (sum() :��ͺ���)
			SELECT SUM(servlet) AS 'servlet���ܳɼ�' FROM student;
		
		���� ��ѯѧ����servlet��ƽ����
			SELECT AVG(servlet) AS 'servlet��ƽ����' FROM student;
		
		����: ��ѯ��ǰservlet��߷�
			SELECT MAX(servlet) AS '��߷�' FROM student;
		
		���� ��ѯ��ͷ�
			SELECT MIN(servlet) AS '��ͷ�' FROM student;
		
		���� ͳ�Ƶ�ǰ�ж���ѧ��(count(�ֶ�))
			SELECT COUNT(*) FROM student;
			SELECT COUNT(s_id) FROM student;
		
		ע�⣺count��������ͳ�Ƶ�����������null������
		ʹ��countͳ�Ʊ�ļ�¼����Ҫʹ�ò�����nullֵ���ֶ�
			SELECT COUNT(s_age) FROM student;     //ѡ���ҹ��е�ֵ ͳ��



��ҳ��ѯlimit 
					         "n-1"
	��ʼ�� n ��0��ʼ

	��ҳ����ǰҳ  ÿҳ��ʾ������
	��ҳ��ѯ��ǰҳ�����ݵ�sql: SELECT * FROM student LIMIT (��ǰҳ-1)*ÿҳ��ʾ������,ÿҳ��ʾ������;
		
		���󣺹�30�����ݣ���ҳ��ѯ��ÿҳʮ����¼
		
		��һҳ	select * from student limit 0,10		(��ѯ��������-1��ÿҳ��ʾ������) 
		�ڶ�ҳ	select * from student limit 9,10
		����ҳ	select * from student limit 29,10


��ѯ����order by ��
	�﷨ ��order by �ֶ� asc/desc
	asc: ˳������	��ֵ����������ĸ����Ȼ˳��a-z��
	desc: ���򣬷���	��ֵ���ݼ�����ĸ����Ȼ����(z-a)

	Ĭ������£����ղ����¼˳������
	SELECT * FROM student;

		���� ����id˳������
		SELECT * FROM student ORDER BY id ASC;
		SELECT * FROM student ORDER BY id; -- Ĭ������
	
		SELECT * FROM student ORDER BY id DESC;-- ����

		ע�⣺�����������
		���� ����servlet���򣬰���jsp�ĵ���
		SELECT * FROM student ORDER BY servlet ASC,jsp DESC;



�����ѯ(group by)
		���� ��ѯ��Ů������
		Ԥ�ڽ����
		��   3
		Ů   2

	 1) ��ѧ�������Ա����(GROUP BY gender)
	 2) ͳ��ÿ�������(COUNT(*))
	SELECT gender,COUNT(*) FROM student GROUP BY gender;
	�ȸ��Ա�֣���ͳ������



�����ѯ��ɸѡ									where��������ѯ
		���� ��ѯ����������2���Ա�						group by:�����ѯ
		1) ��ѯ��Ů������									having��ɸѡ	
		2)ɸѡ����������2�ļ�¼(having)
		ע�⣺ ����֮ǰ����ʹ��where�ؼ��֣�����֮ǰ����ʹ��having�ؼ���

		SELECT s_gender,COUNT(*) FROM student WHERE GROUP BY gender HAVING COUNT(*)>2;
