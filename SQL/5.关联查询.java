
4. �����Ĳ�ѯ




		USE day16;


���� ��ѯԱ���������ڲ��ţ���ʾԱ���������������ƣ�
4.1 �������Ӳ�ѯ �����Ƽ��������ѿ������˻�����: 3 * 3 = 9 ; ��Щ���ظ���¼��
		SELECT empName, deptName FROM employee, dept;

SELECT * FROM employee;
SELECT * FROM dept;



���� ��ѯԱ���������ڲ��ţ���ʾԱ���������������ƣ�
����ѯ���� 1��ȷ����ѯ��Щ��  2��ȷ����Щ�ֶ�  3��ȷ����������ӵ�����
4.2 �����Ӳ�ѯ

		SELECT empName,deptName       -- 2��ȷ����Щ��Щ�ֶ�
		FROM employee,dept    -- 1��ȷ����ѯ��Щ��
		WHERE employee.deptId=dept.id  -- 3�������֮����������


-- �����ӵ���һ���﷨
		SELECT empName,deptName
		FROM employee
		INNER JOIN dept
		ON employee.deptId=dept.id;
	
-- ʹ�ñ���
		SELECT e.empName,d.deptName
		FROM employee AS e     -- AS ������ʡ�Բ�д 
		INNER JOIN dept AS d
		ON e.deptId=d.id;

-- ���� ��ѯÿ�����ŵ�Ա��
-- Ԥ�ڽ����
 --  ���������  ����
 --  ���������  ����
 --  Ӧ��ά����  ����
 --  ���鲿      null
 --  �ܾ���      null 
 
4.3 ��[��]���Ӳ�ѯ��ʹ����߱������ȥƥ���ұ߱������   ���������������������   �����ϾͲ�����
	��ע�⣺ �������ӣ� ��ߵ�����һ���������ʾ����   û����Ҳ����ʾ������ɨ������
		SELECT d.deptName,e.empName
		FROM dept d
		LEFT OUTER JOIN employee e
		ON d.id=e.deptId;
	��[��]���Ӳ�ѯ��ʹ���ұ߱������ȥƥ����߱������     ���෴��
		SELECT d.deptName,e.empName
		FROM employee e
		LEFT OUTER JOIN dept d
		ON d.id=e.deptId;
	
	



		ALTER TABLE employee ADD bossId INT;
		-- �����˾ID
		UPDATE employee SET bossId=1 WHERE id=2;
		UPDATE employee SET bossId=2 WHERE id=3;
2.4 �����Ӳ�ѯ
		SELECT e.empName, b.empName
		FROM employee e
		LEFT OUTER JOIN employee b
		ON e.bossId=b.id

SELECT * FROM employee;
SELECT * FROM dept;
		
