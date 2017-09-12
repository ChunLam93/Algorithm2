import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class dbManagement {

	//--------------------------------------------------
	// Attribute
	//--------------------------------------------------

	myList<myPlayer> DB;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	public dbManagement(int mode){

		if(mode == 1)
		{
			this.DB = new myListArrayList<>();
		}
		else if (mode == 2)
		{
			this.DB= new myListLinkedList<>();

		}
		else if (mode == 3)
			this.DB = new myListDoubleLinkedList<>();
	}
	
	//-------------------------------------------------------------------
	// 1. Problem Specific Operation --> Load a MyList from file: load_file
	//-------------------------------------------------------------------
	public void load_file(String s){
		try {
			//1. We create the file variable
			File my_file = new File(s);
			Scanner sc = new Scanner(my_file);
			//2. We empty the list
			int size = DB.my_get_length();
			for (int i = 0; i < size; i++)
				DB.my_remove_element(0);

			//3. We fill MyList with the content of the file
			int count = 0;
			while (sc.hasNext()){
				myPlayer player = new myPlayer(sc.next(), sc.nextInt());
				DB.my_add_element(count, player);
				count = count + 1;
			}

			//4. We close the scanner
			sc.close();

			System.out.println("Load Operation Completed");
		}
		catch (Exception e) {
			System.out.println("Sorry but there is not such file");
		}
	}

	//-------------------------------------------------------------------
	// 2. Problem Specific Operation --> Display MyFile content: show_elements
	//-------------------------------------------------------------------
	public void show_elements(){
		for(int i = 0; i < DB.my_get_length() ; i++)
		{
			DB.my_get_element(i).print_info();
		}
	}
	
	//-------------------------------------------------------------------
	// 3. Problem Specific Operation --> Check if element is in MyList: find_element
	//-------------------------------------------------------------------
	public int find_element(String s){
		int i = 0;

		if(DB instanceof myListDoubleLinkedList)
		{
			System.out.println("hi");
		}

		for(int z = 0; z < DB.my_get_length() ; z++)
		{
			if(DB.my_get_element(z).get_name().equals(s))
			{
				i = 0;
				z = DB.my_get_length();
			}
			else
			{
				i=-1;
			}

		}


		return i;
	}

	//-------------------------------------------------------------------
	// 4. Problem Specific Operation --> Show info of element in MyList: show_info
	//-------------------------------------------------------------------
	public void show_info(String s){
		int x = 0;
		for(int z = 0; z < DB.my_get_length() ; z++)
		{
			if(DB.my_get_element(z).get_name().equals(s))
			{	x = 1;
				DB.my_get_element(z).print_info();
			}
		}
		if(x == 0)
		{
			System.out.println("Player do not exist");
		}

	}
	
	//-------------------------------------------------------------------
	// 5. Problem Specific Operation --> Add new element to MyList: add_by_keyboard
	//-------------------------------------------------------------------
	public void add(String s, int i){
		myPlayer p = new myPlayer(s,i);
		DB.my_add_element(DB.my_get_length(),p);

	}

	//-------------------------------------------------------------------
	// 6. Problem Specific Operation --> Update element of MyList: update
	//-------------------------------------------------------------------
	public void update(String s, int g){
		int x = 0;
		for(int z = 0; z < DB.my_get_length() ; z++)
		{
			if(DB.my_get_element(z).get_name().equals(s))
			{
				x = 1;
				DB.my_get_element(z).set_goals(g);
			}
		}
		if(x == 0)
		{
			System.out.println("Player do not exist");
		}
	}
	
	//-------------------------------------------------------------------
	// 7. Problem Specific Operation --> Remove element of MyList: remove_element
	//-------------------------------------------------------------------
	public void remove(String s){
		int x = 0;
		for(int z = 0; z < DB.my_get_length() ; z++)
		{
			if(DB.my_get_element(z).get_name().equals(s))
			{
				x = 1;
				DB.my_remove_element(z);
			}
		}
		if(x == 0)
		{
			System.out.println("Player do not exist");
		}

	}
	
	//-------------------------------------------------------------------
	// 8. Problem Specific Operation --> sort elements of MyList: bubble_sort
	//-------------------------------------------------------------------
	public void bubble_sort(){
		for(int z = 0 ; z < DB.my_get_length(); z++){
			for (int i = 0; i < DB.my_get_length()-1; i++) {

				if (DB.my_get_element(i + 1) != null) {
					if (DB.my_get_element(i).get_goals() > DB.my_get_element(i + 1).get_goals()) {
						myPlayer temp = new myPlayer(DB.my_get_element(i).get_name(), DB.my_get_element(i).get_goals());

						DB.my_get_element(i).set_name(DB.my_get_element(i + 1).get_name());
						DB.my_get_element(i).set_goals(DB.my_get_element(i + 1).get_goals());
						DB.my_get_element(i + 1).set_name(temp.get_name());
						DB.my_get_element(i + 1).set_goals(temp.get_goals());
					}
				}
			}
		}
	}
	
	//-------------------------------------------------------------------
	// 9. Problem Specific Operation --> Write a MyList to file: write_file
	//-------------------------------------------------------------------
	public void write_file(String s) throws IOException {
		File file = new File(s);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for(int i = 0 ; i < DB.my_get_length() ; i++) {
			writer.write(DB.my_get_element(i).get_name() + " " + DB.my_get_element(i).get_goals() + "\n" );
		}
		writer.close();
	}
	}		
	

