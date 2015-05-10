package phonenumberbook;
import java.util.Scanner;

class PhoneBookInfo{//������ ������ ��� �����ִ°� ���� ������ Ŭ�����̴�.
	String name;//��ü������ ����� ��Ʈ���������Ѵ�.
	String number;
	String birth;
	public PhoneBookInfo(String name, String number, String birth)// �Է¹��� ��Ʈ�������� �����ϴ�
	{									//�Լ��ε� �Ʒ����� ���� ������ �ȹ޾Ƶ� �ǵ��� overload�Ͽ���.
		this.name=name;
		this.number=number;
		this.birth=birth;
	}
	public PhoneBookInfo(String name, String number)
	{
		this.name=name;
		this.number=number;
		this.birth=null;
	}
	public void ShowPhoneBookInfo()//�� Ŭ������ ����� ���� �����ִ� �Լ��̴�.
	{
		System.out.println("name: "+name);
		System.out.println("number:"+number);
		if (birth!=null)
		System.out.println("birth"+birth);
		
		System.out.println("");
	}
	
}
	
class PhoneBookManager{
	final int Max=100;//�ִ��ο��� ����� �����ش�.
	PhoneBookInfo[] infostrage=new PhoneBookInfo[Max];//������ �迭�� �����ؼ� ���°� �ƴ϶� Ŭ������ �迭�� �Ͽ�
	int index=0;									//�������� ������ �����Ѵ�.
	public void inputData()//���� �Է��ϰ� �����ϴ� �Լ��̴�.
	{
		Scanner keyboard=new Scanner(System.in);
		
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.print("�̸�: ");
		String name=keyboard.nextLine();
		System.out.print("��ȭ��ȣ: ");
		String number=keyboard.nextLine();
		System.out.print("�������: ");
		String birth=keyboard.nextLine();
		System.out.println();
		infostrage[index]=new PhoneBookInfo(name, number, birth);
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
		index++;//������� �����ؾߵǱ⿡ count���ش�.
		
	}
	
	public void searchData()//�̸��� ���Ͽ� ���� ���ϴ� ����� ������ ã�� �Լ��̴�.
	{
		int dataidx;
		Scanner keyboard=new Scanner(System.in);
		System.out.println("�����Ͱ˻��� �����մϴ�.");
		System.out.print("�̸�: ");
		String name=keyboard.nextLine();
		dataidx=search(name);//search�Լ����� �Է¹��� �̸��� ���° ������� ���� ��ȯ�޴´�.
		if(dataidx>=0)
			infostrage[dataidx].ShowPhoneBookInfo();//��ȯ���� ���� ����� ������ �����ش�.
		else
			System.out.println("ã�� �����Ͱ� �����ϴ�.");//��ġ�ϴ� ����� ������ -1�� ��ȯ�Ͽ� Ʋ������ �˷��ش�.
		System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�.");
		
	}
	public void deleteData()//�����͸� �����ϴ� �����̴�.
	{
		Scanner keyboard=new Scanner(System.in);
		System.out.println("������ ������ �����մϴ�.");
		System.out.print("�̸�: ");
		String name=keyboard.nextLine();
		int idx=search(name);//ã�°Ͱ� ���� search���ش�.
		for(;idx<index;idx++)
		{
			infostrage[idx]=infostrage[idx+1];//�߰��� ���� �����ؼ� ��ĭ�� ���ܼ� ������ �Ű��ش�.
		}
		index--;//��ü���� �پ������� �̰� ���� ���ش�.
		System.out.println("������ ������ �Ϸ��Ͽ����ϴ�.");
	}
	private int search(String name)//�Է¹��� �̸���  ����� ����� ���ؼ� ��ġ�ϴ°��� ã�� �Լ��̴�.
	{
		
		
		for(int idx=0; idx<index; idx++)
		{
			PhoneBookInfo comp=infostrage[idx];
			if((comp.name).equals(name))//equal�� ������ ���Ͽ� ����Ȱ��� boolen���� ��ȯ�ϴµ�
			{							//��ġ�ϸ� true ��ġ������ false�� ��ȯ�Ѵ�.
				return idx;				//���� if������ true�� ����Ǿ� ������ idx�� ��ȯ���ش�.
			}
			
		}
		return -1;
	}
}
class ShowPhoneBookMenu
{
	public static void ShowPhoneBookMenu()//���ø޴��� �����ش�.
	{
		System.out.println("�����ϼ���...");
		System.out.println("1.������ �Է�");
		System.out.println("2.������ �˻�");
		System.out.println("3.������ ����");
		System.out.println("4.���α׷� ����");
		System.out.print("����: ");
	}
}
 class PhoneBook
 {
	
	 
	 public static void main(String[] args)//�����ϴ� �����̴�
	 {
		 PhoneBookManager manager=new PhoneBookManager();
		 int choice=0;
		 while(true)// ���α׷� ���Ḧ ���������� ���ѹݺ��Ѵ�.
		 {
			 ShowPhoneBookMenu.ShowPhoneBookMenu();
			 Scanner sc=new Scanner(System.in);
			 choice=sc.nextInt(); // choice���� �Է� �޴´�.
			 switch(choice)
			 {
			 case 1:
				 manager.inputData();
				 break;
			 case 2:
				 manager.searchData();
				 break;
			 case 3:
				 manager.deleteData();
				 break;
			 case 4:
				 System.out.println("���α׷��� �����մϴ�.");
				 return ;
			 }
				 
			}
			 
		}
	}
 


