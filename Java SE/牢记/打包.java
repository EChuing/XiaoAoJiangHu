
�� jar ������Ҫʹ�õ�jdk�Ŀ������� �� jar.exe �� 

jar���÷�

ʹ�ø�ʽ��
		jar cvf jar�ļ������� class�ļ��������ļ���


		ע�⣺
				1.һ���������jar֮�� ����Ҫ���嵥�ļ���ָ�������  ��ʽ�� Main-class: ����.����
				2.jar��˫�����н�����ͼ�λ�����ĳ��������ã��Կ���̨�ĳ���������

jar�ļ������ã�		
				1.�����û���������һ����Ŀ
				2.�ṩ�����������ʹ��

���ʹ��jar��������� ����Ҫ������ classpath ·��

jre = jvm + �������

package qq;
import javax.swing.*; 
class Love002
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("QQ����");
		frame.setSize(400,500);
		frame.setVisible(true);// ���ô��ڿɼ�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


�ȱ���� .class �ļ��� �� .class �ļ� �����jar ��
{
}
 
F:\Tufo>javac Love002.java

F:\Tufo>javac -d . Love002.java

F:\Tufo>java qq.Love002

F:\Tufo>jar cvf qq.jar qq
������嵥
�������: qq/(���� = 0) (��� = 0)(�洢�� 0%)
�������: qq/Love002.class(���� = 482) (��� = 360)(ѹ���� 25%)

