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
		
		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름: ");
		String name=keyboard.nextLine();
		System.out.print("전화번호: ");
		String number=keyboard.nextLine();
		System.out.print("생년월일: ");
		String birth=keyboard.nextLine();
		System.out.println();
		infostrage[index]=new PhoneBookInfo(name, number, birth);
		System.out.println("데이터 입력이 완료되었습니다.");
		index++;
		
	}
	
	public void searchData()
	{
		int dataidx;
		Scanner keyboard=new Scanner(System.in);
		System.out.println("데이터검색을 시작합니다.");
		System.out.print("이름: ");
		String name=keyboard.nextLine();
		dataidx=search(name);
		if(dataidx>=0)
			infostrage[dataidx].ShowPhoneBookInfo();
		else
			System.out.println("찾는 데이터가 없습니다.");
		System.out.println("데이터 검색이 완료되었습니다.");
		
	}
	public void deleteData()
	{
		Scanner keyboard=new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름: ");
		String name=keyboard.nextLine();
		int idx=search(name);
		for(;idx<index;idx++)
		{
			infostrage[idx]=infostrage[idx+1];
		}
		index--;
		System.out.println("데이터 삭제를 완료하였습니다.");
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
		System.out.println("선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.프로그램 종료");
		System.out.print("선택: ");
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
				 System.out.println("프로그램을 종료합니다.");
				 return ;
			 }
				 
			}
			 
		}
	}
 


