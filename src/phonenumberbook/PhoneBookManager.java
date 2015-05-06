package phonenumberbook;
import java.util.Scanner;

class PhoneBookInfo{
	String name;
	String number;
	String birth;
	public PhoneBookInfo(String name, String number, String birth)
	{
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
	public void ShowPhoneBookInfo()
	{
		System.out.println("name: "+name);
		System.out.println("number:"+number);
		if (birth!=null)
		System.out.println("birth"+birth);
		
		System.out.println("");
	}
	
}
	
class PhoneBookManager{
	final int Max=100;
	PhoneBookInfo[] infostrage=new PhoneBookInfo[Max];
	int index=0;
	public void inputData()
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
		index++;
		
	}
	
	public void searchData()
	{
		int dataidx;
		Scanner keyboard=new Scanner(System.in);
		System.out.println("�����Ͱ˻��� �����մϴ�.");
		System.out.print("�̸�: ");
		String name=keyboard.nextLine();
		dataidx=search(name);
		if(dataidx>=0)
			infostrage[dataidx].ShowPhoneBookInfo();
		else
			System.out.println("ã�� �����Ͱ� �����ϴ�.");
		System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�.");
		
	}
	public void deleteData()
	{
		Scanner keyboard=new Scanner(System.in);
		System.out.println("������ ������ �����մϴ�.");
		System.out.print("�̸�: ");
		String name=keyboard.nextLine();
		int idx=search(name);
		for(;idx<index;idx++)
		{
			infostrage[idx]=infostrage[idx+1];
		}
		index--;
		System.out.println("������ ������ �Ϸ��Ͽ����ϴ�.");
	}
	private int search(String name)
	{
		
		
		for(int idx=0; idx<index; idx++)
		{
			PhoneBookInfo comp=infostrage[idx];
			if((comp.name).equals(name))
			{
				return idx;
			}
			
		}
		return -1;
	}
}
class ShowPhoneBookMenu
{
	public static void ShowPhoneBookMenu()
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
	
	 
	 public static void main(String[] args)
	 {
		 PhoneBookManager manager=new PhoneBookManager();
		 int choice=0;
		 while(true)
		 {
			 ShowPhoneBookMenu.ShowPhoneBookMenu();
			 Scanner sc=new Scanner(System.in);
			 choice=sc.nextInt();
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
 


