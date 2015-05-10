package phonenumberbook;
import java.util.Scanner;

class PhoneBookInfo{//개인의 정보를 담고 보여주는것 까지 포함한 클래스이다.
	String name;//전체적으로 사용할 스트링을선언한다.
	String number;
	String birth;
	public PhoneBookInfo(String name, String number, String birth)// 입력받은 스트링값들을 저장하는
	{									//함수인데 아래에는 굳이 생일을 안받아도 되도록 overload하였다.
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
	public void ShowPhoneBookInfo()//이 클래스에 저장된 값을 보여주는 함수이다.
	{
		System.out.println("name: "+name);
		System.out.println("number:"+number);
		if (birth!=null)
		System.out.println("birth"+birth);
		
		System.out.println("");
	}
	
}
	
class PhoneBookManager{
	final int Max=100;//최대인원을 상수로 정해준다.
	PhoneBookInfo[] infostrage=new PhoneBookInfo[Max];//변수를 배열로 선언해서 묶는게 아니라 클래스를 배열로 하여
	int index=0;									//여러명의 정보를 저장한다.
	public void inputData()//값을 입력하고 저장하는 함수이다.
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
		index++;//순서대로 저장해야되기에 count해준다.
		
	}
	
	public void searchData()//이름을 통하여 내가 원하는 사람의 정보를 찾는 함수이다.
	{
		int dataidx;
		Scanner keyboard=new Scanner(System.in);
		System.out.println("데이터검색을 시작합니다.");
		System.out.print("이름: ");
		String name=keyboard.nextLine();
		dataidx=search(name);//search함수에서 입력받은 이름이 몇번째 사람인지 값을 반환받는다.
		if(dataidx>=0)
			infostrage[dataidx].ShowPhoneBookInfo();//반환받은 값의 사람의 정보를 보여준다.
		else
			System.out.println("찾는 데이터가 없습니다.");//일치하는 사람이 없으면 -1을 반환하여 틀린것을 알려준다.
		System.out.println("데이터 검색이 완료되었습니다.");
		
	}
	public void deleteData()//데이터를 삭제하는 변수이다.
	{
		Scanner keyboard=new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름: ");
		String name=keyboard.nextLine();
		int idx=search(name);//찾는것과 같이 search해준다.
		for(;idx<index;idx++)
		{
			infostrage[idx]=infostrage[idx+1];//중간에 값을 삭제해서 한칸씩 땡겨서 값들을 옮겨준다.
		}
		index--;//전체값이 줄어들었으니 이것 역시 세준다.
		System.out.println("데이터 삭제를 완료하였습니다.");
	}
	private int search(String name)//입력받은 이름을  저장된 값들과 비교해서 일치하는것을 찾는 함수이다.
	{
		
		
		for(int idx=0; idx<index; idx++)
		{
			PhoneBookInfo comp=infostrage[idx];
			if((comp.name).equals(name))//equal은 양쪽을 비교하여 저장된값을 boolen으로 반환하는데
			{							//일치하면 true 일치않으면 false로 반환한다.
				return idx;				//따라서 if조건이 true면 실행되어 같을때 idx를 반환해준다.
			}
			
		}
		return -1;
	}
}
class ShowPhoneBookMenu
{
	public static void ShowPhoneBookMenu()//선택메뉴를 보여준다.
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
	
	 
	 public static void main(String[] args)//실행하는 메인이다
	 {
		 PhoneBookManager manager=new PhoneBookManager();
		 int choice=0;
		 while(true)// 프로그램 종료를 누를때까지 무한반복한다.
		 {
			 ShowPhoneBookMenu.ShowPhoneBookMenu();
			 Scanner sc=new Scanner(System.in);
			 choice=sc.nextInt(); // choice값을 입력 받는다.
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
 


