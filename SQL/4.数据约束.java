����Լ��
	���û����������Լ��

�̶��� ENUM
	gender enum('��','Ů') not null;




	�� name �к������ gender ö������ Ĭ��Ϊ Ů
	ALTER TABLE practice ADD COLUMN gender ENUM('��','Ů')DEFAULT'Ů' NOT NULL AFTER name

1.1
Ĭ��ֵ  (DEFAULT)
		����һ�Ŵ���Ĭ��ֵ�� ��
		CREATE TABLE student (
				id INT,
				NAME VARCHAR (20),
				address VARCHAR (20) DEFAULT '�������'
		) -- Ĭ��ֵ 
	
		��������
		insert into student(id,name) values(1,'����');
		�鿴���	
		SELECT * FROM student;        
		
		���ã��Զ���� Ĭ��ֵ�� ������NULL Ĭ���ֶ�����Ϊ��


1.2 
�ǿ� (NOT NULL)
	CREATE TABLE feikong (
				id INT,
				NAME VARCHAR (20),
				address VARCHAR (20) NOT NULL)  -- �ǿ�
		
		������ַ�
		INSERT INTO student(id,NAME) VALUES(1,'');
		��cmd �� ����  �����п����ƹ� 	

		���ã��ǿ��ֶα��븳ֵ ���ܲ��� NULL 

1.3
Ψһ ��UNIQUE��  
	CREATE TABLE weiyi (
				id INT UNIQUE,  -- Ψһ
				NAME VARCHAR (20)
				)
		
		���ã����������ظ��ַ� ���Բ���null  Ҳ���Բ���Ը�null
				

1.4
����  primary key       ���ǿ�+Ψһ��
		CREATE TABLE zhujian (
				id INT  PRIMARY KEY -- ����,
				NAME VARCHAR (20),
				address VARCHAR (20) )

		ע�⣺ һ��һ���������ÿ����¼��Ψһ��
				������Ҫ����ҵ���� ͨ��ѡ�� ID ��Ϊ

1.5
������	��AUTO_INCREMENT��
	
	CREATE TABLE zz (
				id INT  PRIMARY KEY   AUTO_INCREMENT,-- ���� ������  
				NAME VARCHAR (20),
				address VARCHAR (20) )
	
	�������ֶο��Բ���ֵ���Զ�����
	insert into zz(name) varchar('����');
	

	ɾ����������
		delete  from zz		������ɾ��Լ��
		truncate table zz	����ɾ��Լ��

1.6 
���	Լ�����ֱ������ 
'  CONSTRAINT emloyee_dept_fk FOREIGN KEY (deptId) REFERENCES dept(id)  ' 
	
'	�������������
		�����������ߵ����⣬ ������һ�ű�
		���� �� ���ű� �� Ա����
'	�������⣺
		�ٲ���Ա�������ݵ�ʱ��Ա����Ĳ���ID�ֶο��������� 
		ʹ�����Լ�������Կ���
	
CREATE TABLE employee(
	id INT PRIMARY KEY,
	empName VARCHAR(20),
	deptName VARCHAR(20)   -- ��������
	)
	
	INSERT INTO employee VALUES(1,'����','���������');
	INSERT INTO employee VALUES(2,'����','���������');
	INSERT INTO employee VALUES(3,'����','Ӧ��ά����');
	
'	���Ա��   ���ڲ������Ƶ������    �� �������   �ַ�Խ�� �����Խ��
	INSERT INTO employee VALUES(4,'����','���������')
	
	------------------------------------------
	DROP TABLE employee;


'	���   �������һ�ű�  ��������    
'	��Ӳ��ű�       (����)
	CREATE TABLE dept(
		id INT PRIMARY KEY,
		deptName VARCHAR(20)
		)
'		�޸�Ա����    (����)
	CREATE TABLE employee(
		id INT PRIMARY KEY,
		empName VARCHAR(20),
		deptId INT -- �Ѳ������Ƹ�Ϊ����ID
	)	
		
		INSERT INTO dept ( id,deptNAME) VALUES (1,'���������');
		INSERT INTO dept ( id,deptNAME) VALUES (2,'���鲿');	
		INSERT INTO dept ( id,deptNAME) VALUES (3,'Ӧ��ά����');
		
		INSERT INTO employee VALUES(1,'����',1); --  ��Ӧ����� ����  ��Ϊһ������  ����������
		INSERT INTO employee VALUES(2,'����',1);
		INSERT INTO employee VALUES(3,'����',3);	
		
'		���� ����һ�� �����ڵ� ������
	INSERT INTO employee VALUES(4,'����',4);
'		��� ��ʱ��ʹ�����	�Բ���IDʹ��
'		�޸�Ա����
	CREATE TABLE employee(
		id INT PRIMARY KEY,
		empName VARCHAR(20),
		deptId INT, -- �Ѳ������Ƹ�Ϊ����ID
		-- ����һ�����Լ��
"		CONSTRAINT emloyee_dept_fk FOREIGN KEY (deptId) REFERENCES dept(id)  --------���Լ��-------------------------
	) 	-- ����		�������      �ؼ���	���	�ο�   ���ο��ֶΣ�			
	
	
	
'	�����������Լ���� 
'			������ݵ�˳�� ���������  ����Ӹ�������
			INSERT INTO dept ( id,deptNAME) VALUES (1,'���������');
			INSERT INTO employee VALUES(1,'����',1);
		
'			�޸����ݵ�˳�� ���޸ĸ���  ���޸�����
			UPDATE employee SET deptId=2 wheere id=4;
			UPDATE dept SET id=4 WHERE id=3;
		
'			ɾ������; �ȸ������� 
			DELETE FROM employee WHERE deptId=2;
			DELETE FROM dept WHERE id=2;
	
	
	SELECT * FROM dept;
	SELECT * FROM employee;


1.7
��������  (on  update   cascade)

���⣺�����������Լ��ʱ���������޸Ļ�ɾ�����й��������ݣ������޸Ļ�ɾ������


���ã� �������Լ�� ֱ�Ӳ���

'�����޸ģ�on update cascade

'����ɾ����on delete cascade 

