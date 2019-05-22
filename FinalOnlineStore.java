
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class FinalOnlineStore 
{
	static ArrayList<Book> booklist; //declares booklist ArrayList that takes only Book objects 
	static ArrayList<DVD> dvdlist; //declares dvdlist ArrayList that takes only DVD objects
	static Scanner input = new Scanner(System.in);
	static Validator validate = new Validator();
	public static void displayManagerMenu()
	{
		System.out.println("**Welcome to the Comets Books and DVDs Store (Catalog Section)**");
		System.out.println("Choose from the following options:");
		System.out.println("1 – Add Book");
		System.out.println("2 – Add AudioBook");
		System.out.println("3 – Add DVD");
		System.out.println("4 – Remove Book");
		System.out.println("5 – Remove DVD");
		System.out.println("6 – Display Catalog");
		System.out.println("7 - Create Backup File");
		System.out.println("9 - Exit store");
	}
	public static void displayCustomerMenu()
	{
		System.out.println("**Welcome to the Mustangs Books and DVDs Store**\n");
		System.out.println("Choose from the following options:");
		System.out.println("1 - Browse book inventory (price low to high)");
		System.out.println("2 - Browse DVD inventory (price low to high)");
		System.out.println("3 – Add a book to the cart");
		System.out.println("4 – Add a DVD to the cart");
		System.out.println("5 - Delete a book from cart");
		System.out.println("6 – Delete a DVD from cart");
		System.out.println("7 - View cart");
		System.out.println("8 - Checkout");
		System.out.println("9 - Done Shopping");
	}
	public static void addBook()
	{
		//definition of variables used for books
		String title;
		int isbn;
		String author;
		double price;
		
		//asks the user to input the required attributes for the Book object
		System.out.print("Enter the book title: ");
		title = input.nextLine();
		while(!validate.isNonEmptyString(title))
		{
			System.out.print("Please enter valid title: ");
			title = input.nextLine();
		}
		System.out.print("Enter the book ISBN: ");
		isbn = Integer.parseInt(input.nextLine());
		while(!validate.isPositive(isbn))
		{
			System.out.println("Please enter valid ISBN: ");
			isbn = Integer.parseInt(input.nextLine());
		}
		System.out.print("Enter the author of the book: ");
		author = input.nextLine();
		while(!validate.isNonEmptyString(author))
		{
			System.out.print("Please enter valid author: ");
			author = input.nextLine();
		}
		System.out.print("Enter the price of the book: ");
		price = Double.parseDouble(input.nextLine());
		while(!validate.isPositive(price))
		{
			System.out.println("Please enter valid price: ");
			price = Double.parseDouble(input.nextLine());
		}
		
		Book book = new Book(title, price, author, isbn); //declares new Book object with inputed values
		boolean value = true; //declares value as true
		for(int i = 0; i < booklist.size(); i++) //iterates through booklist 
		{
			if(booklist.get(i).getIsbn() == book.getIsbn()) //if a object in book list is equal to current book isbn then it tells user that object is in the catalog
			{
				System.out.println("\nThis book is already in the catalog.\n");
				value = false; //value is set to false
			}
		}
		if(value == true) //if value is true then current book object is added to booklist
		{
			booklist.add(book);
			System.out.println("\nThe book has been successfully added to the catalog!\n");
			
		}
	}
	public static void addAudioBook()
	{
		//definition of variables used for audiobooks
		String title;
		int isbn;
		String author;
		double price;
		double runningTime;
		
		//asks the user to input the required attributes for the AudioBook object
		System.out.print("Enter the audiobook title: ");
		title = input.nextLine();
		while(!validate.isNonEmptyString(title))
		{
			System.out.print("Please enter valid title: ");
			title = input.nextLine();
		}
		System.out.print("Enter the ISBN of the audiobook: ");
		isbn = Integer.parseInt(input.nextLine());
		while(!validate.isPositive(isbn))
		{
			System.out.println("Please enter valid ISBN: ");
			isbn = Integer.parseInt(input.nextLine());
		}
		System.out.print("Enter the author of the audiobook: ");
		author = input.nextLine();
		while(!validate.isNonEmptyString(author))
		{
			System.out.print("Please enter valid author: ");
			author = input.nextLine();
		}
		System.out.print("Enter the price of the audiobook: ");
		price = Double.parseDouble(input.nextLine());
		while(!validate.isPositive(price))
		{
			System.out.println("Please enter valid price: ");
			price = Double.parseDouble(input.nextLine());
		}
		System.out.print("Enter the running time of the audiobook: ");
		runningTime = Double.parseDouble(input.nextLine());
		while(!validate.isPositive(runningTime))
		{
			System.out.println("Please enter valid running time: ");
			runningTime = Double.parseDouble(input.nextLine());
		}
		AudioBook audioBook = new AudioBook(title, price, author, isbn, runningTime); //declares new AudioBook object with inputed values
		boolean value = true; //declares value as true
		for(int i = 0; i < booklist.size(); i++) //iterates through booklist
		{
			if(booklist.get(i).getIsbn() == audioBook.getIsbn())//if a object in book list is equal to current book ISBN then it tells user that object is in the catalog
			{
				System.out.println("\nThis audiobook is already in the catalog.\n");
				value = false; //sets value to false
			}
		}
		if(value == true) //if value is true then current audioBook object is added to booklist
		{
			booklist.add(audioBook);
			System.out.println("\nThe audiobook has been successfully added to the catalog!\n");
		}
	}
	public static void addDVD()
	{
		//definition of variables for DVD object
			String title;
			double price;
			String director;
			int year;
			int dvdcode;
			
			//asks the user to input the required attributes for the DVD object
			System.out.print("Enter the DVD title: ");
			title = input.nextLine();
			while(!validate.isNonEmptyString(title))
			{
				System.out.print("Please enter valid title: ");
				title = input.nextLine();
			}
			System.out.print("Enter the price of the DVD: ");
			price = Double.parseDouble(input.nextLine());
			while(!validate.isPositive(price))
			{
				System.out.println("Please enter valid price: ");
				price = Double.parseDouble(input.nextLine());
			}
			System.out.print("Enter the DVD director: ");
			director = input.nextLine();
			while(!validate.isNonEmptyString(director))
			{
				System.out.print("Please enter valid director: ");
				director = input.nextLine();
			}
			System.out.print("Enter the year the DVD was made: ");
			year = Integer.parseInt(input.nextLine());
			while(!validate.isPositive(year))
			{
				System.out.println("Please enter valid year: ");
				year = Integer.parseInt(input.nextLine());
			}
			System.out.print("Enter the DVD code: ");
			dvdcode = Integer.parseInt(input.nextLine());
			while(!validate.isPositive(dvdcode))
			{
				System.out.println("Please enter valid dvd code: ");
				dvdcode = Integer.parseInt(input.nextLine());
			}
			DVD dvd = new DVD(title, price, director, year, dvdcode); //
			boolean value = true;
			for(int i = 0; i < dvdlist.size(); i++) //iterates through dvdlist
			{
				if(dvdlist.get(i).getDvdCode() == dvd.getDvdCode()) //if a object in book list is equal to current DVD DVD code then it tells user that object is in the catalog
				{
					System.out.println("\nThis DVD is already in the catalog.\n");
					value = false; //sets value to false
				}
			}
			if(value == true) //if value is true then current DVD object is added to dvdlist
			{
				dvdlist.add(dvd);
				System.out.println("\nThe DVD has been successfully added to the catalog!\n");
			}
		}
	public static void removeBook(ArrayList<Book> list)
	{
		System.out.print("\nPlease enter the book ISBN for the book you want to remove: "); //asks user to input ISBN for book that needs to be removed
		int code;
		code = Integer.parseInt(input.nextLine());
		while(!validate.isPositive(code))
		{
			System.out.println("Please enter valid ISBN: ");
			code = Integer.parseInt(input.nextLine());
		}
		boolean found = false; //sets found to false
		for(int i = 0; i < list.size(); i++) //iterates through list
		{
			if(list.get(i).getIsbn() == code) //if list contains object with corresponding ISBN it gets removed from list
			{
				list.remove(i);
				System.out.println("\nBook has been removed successfully!\n");
				found = true; //sets found to true
			}
		}
		if(found == false) //if found is false it tells user that the book cannot be found
		{
			System.out.println("\nThe book or audiobook could not be found.\n");
		}
	}
	public static void removeDVD(ArrayList<DVD> list)
	{
		System.out.print("\nPlease enter the DVD code for the DVD you want to remove: "); //asks user for DVD code for DVD they want removed
		int code;
		code = Integer.parseInt(input.nextLine());
		while(!validate.isPositive(code))
		{
			System.out.println("Please enter valid code: ");
			code = Integer.parseInt(input.nextLine());
		}
		boolean found = false; //sets found to false
		for(int i = 0; i < list.size(); i++) //iterates through list
		{
			if(list.get(i).getDvdCode() == code) //if list contains DVD object with corresponding DVD code then object is removed from list
			{
				list.remove(i);
				System.out.println("\nDVD has been removed successfully!\n");
				found = true; //found is set to true
			}
		}
		if(found == false) //if found is false then it tells the user that DVD could not be found
		{
			System.out.println("\nThe DVD could not be found.\n");
		}
	}
	public static void displayCatalog()
	{
		System.out.print("\nCurrent Catalog:\n");
		
		System.out.print("\nBooks:\n");
		for(Book book : booklist) //iterates through booklist
		{
			if(!(book instanceof AudioBook)) //if book is not an instance of AudioBook the the book.toString() method is called
				System.out.println(book.toString());
			
		}
		System.out.print("\nAudioBooks:\n");
		for(Book book : booklist) //iterates through booklist
		{
			if(book instanceof AudioBook) //if book is instanceof AudioBook then book.toString() is called
				System.out.println(book.toString());
			
		}
		
		System.out.print("\nDVDs:\n");
		
		for(DVD dvd : dvdlist) //iterates through dvdlist
			System.out.println(dvd.toString()); //prints the dvd.toString() method
		
		System.out.println();
	}
	

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		booklist = new ArrayList<Book>(); //sets booklist to new ArrayList object that only takes book objects
        dvdlist = new ArrayList<DVD>(); //sets dvdlist to new ArrayList object that only takes DVD objects
        ArrayList<CatalogItem> bookCart = new ArrayList<CatalogItem>();
        ArrayList<CatalogItem> dvdCart = new ArrayList<CatalogItem>();
		boolean running = true;
		String fileName = "Credentials.txt";
		
		while(running)
		{
			System.out.println("**Welcome to the Comets Books and DVDs Store**\n");
			System.out.println("Please select your role:");
			System.out.println("A – store manager");
			System.out.println("B – customer");
			System.out.println("C – exit store");
		
			System.out.print("Please enter a option: ");
		
			char menuOption = input.next().charAt(0);
		
			if(menuOption == 'A' || menuOption == 'a')
			{
				System.out.print("Please enter your username: ");
				input.nextLine();
				String username = input.nextLine();
				
				System.out.print("Please enter your password: ");
				String password = input.nextLine();
				
				String usernameAndPassword = username + "," + password;
				
				Scanner fileInput = new Scanner(new File(fileName));
				
				List<String> credentialList = new ArrayList<String>();
				while(fileInput.hasNext())
				{
					credentialList.add(fileInput.next());
				}
				fileInput.close();
				
				System.out.println();
				
				if(credentialList.contains(usernameAndPassword))
				{
			        
			        boolean loop = true; //sets loop to true
			        
			        int choice; //declares choice variable
			        
			        while(loop == true) //while loop is true
					{
						displayManagerMenu(); //calls displayMenu() method
						
						System.out.print("Please enter your choice: "); //asks user to input menu choice
						choice = Integer.parseInt(input.nextLine());
						
						if(choice == 1) //if choice is equal to 1
						{
							addBook(); //calls addBook() method
						}
						else if(choice == 2) //if choice is equal to 2
						{
							addAudioBook(); //calls addAudioBook() method
						}
						else if(choice == 3) //if choice is equal to 3
						{
							addDVD(); //calls addDVD() method
						}
						else if(choice == 4) //if choice is equal to 4
						{
							removeBook(booklist); //calls removeBook() method and passes booklist
						}
						else if(choice == 5) //if choice is equal to 5
						{
							removeDVD(dvdlist); //calls removeDVD() method and passes dvdlist
						}
						else if(choice == 6) //if choice is equal to 6
						{
							displayCatalog(); //calls displayCatalog() method 
						}
						else if(choice == 7)
						{
							String year = new SimpleDateFormat("yyyy").format(new Date());
							String month = new SimpleDateFormat("MM").format(new Date());
							String day = new SimpleDateFormat("dd").format(new Date());
							String hour = new SimpleDateFormat("HH").format(new Date());
							String minute = new SimpleDateFormat("mm").format(new Date());
							String second = new SimpleDateFormat("ss").format(new Date());
							
							String fileDate = "catalog_backup_" + year + "_" + month + "_" + day + "_" + hour + "_" + minute
									+ "_" + second;

							PrintWriter writer = new PrintWriter(fileDate, "UTF-8");
							
							//writes catalog to text file
							writer.write("\nBooks:\n");
							for(Book book : booklist) //iterates through booklist
							{
								if(!(book instanceof AudioBook)) //if book is not an instance of AudioBook the the book.toString() method is called
								{	
									writer.write(book.toString() + "\n");
								}
								
							}
							writer.write("\nAudioBooks:\n");
							for(Book book : booklist) //iterates through booklist
							{
								if(book instanceof AudioBook) //if book is instanceof AudioBook then book.toString() is called
								{
									writer.write(book.toString() + "\n");
								}
							}
							writer.write("\nDVDs:\n");
							for(DVD dvd : dvdlist) //iterates through dvdlist
							{	
								writer.write(dvd.toString() + "\n"); //prints the dvd.toString() method
							}
							writer.close();
							
							System.out.println("\nBackup File Created!\n");
						}
						else if(choice == 9) //if choice is equal to 9
						{
							System.out.println("Exiting store...\n");
							loop = false; //sets loop false
						}
						else //this is when user inputs an invalid input
						{
							System.out.println("\nInvalid choice."); 
							System.out.println("Please look at the menu and choose a valid menu option.\n");
						}
					}
				}
				else //if credentials aren't in text file
				{
					System.out.println("\nUnrecognized Credentials\n");
				}		
				
			}
			else if(menuOption == 'B' || menuOption == 'b')
			{
				
				boolean loop = true; //loop checker
				
				while(loop  == true) //while loop keeps running until loop is false
				{
					displayCustomerMenu(); //calls menu display
					
					//asks user to enter menu choice
					System.out.print("Please enter a menu choice: ");
					int customerChoice = input.nextInt();
					
					//calls validate object
					while(!validate.isPositive(customerChoice))
					{
						System.out.println("Please enter valid menu option: ");
						customerChoice = Integer.parseInt(input.nextLine());
					}
					
					if(customerChoice == 1) //if customer enter 1
					{
						int n = booklist.size(); //n is size of booklist
						
						//sorts the array
						for (int i = 1; i < n; i++)
						{
							Book key = booklist.get(i);
							int j = i - 1;
							while(j >= 0 && (booklist.get(j).getPrice() > key.getPrice()))
							{
								booklist.set(j+1, booklist.get(j));
								j--;
							}
							booklist.set(j+1, key);
						}
						
						//outputs the books
						System.out.println();
						System.out.println("Inventory #     Books               	Prices");
						System.out.println("------------------------------------------------");
						for(int i = 0; i < booklist.size(); i++)
						{
							int n1 = i;
							System.out.printf("%d\t\t%-20s\t$%3.2f\n", n1 + 1, booklist.get(i).getTitle(), booklist.get(i).getPrice());
						}
						System.out.println("------------------------------------------------");
						System.out.println("");
					}
					else if(customerChoice == 2)
					{
						int n = dvdlist.size(); //n is size of dvdlist
						
						//sorts array
						for(int i = 1; i < n; i++)
						{
							DVD key = dvdlist.get(i);
							int j = i - 1;
							while(j >= 0 && (dvdlist.get(j).getPrice() > key.getPrice()))
							{
								dvdlist.set(j+1, dvdlist.get(j));
								j--;
							}
							dvdlist.set(j+1, key);
						}
						//outputs the dvds
						System.out.println();
						System.out.println("Inventory #     Books               	Prices");
						System.out.println("------------------------------------------------");
						for(int i = 0; i < dvdlist.size(); i++)
						{
							int n1 = i;
							System.out.printf("%d\t\t%-20s\t$%3.2f\n", n1 + 1, dvdlist.get(i).getTitle(), dvdlist.get(i).getPrice());
						}
						System.out.println("------------------------------------------------");
						System.out.println("");
					}
					
					else if(customerChoice == 3) //if customer enters 3
					{
						System.out.println("Enter the inventory item you would like to purchase");
						System.out.println("(Enter -1 to display the menu)");
						int inventoryNumber = input.nextInt();
						
						//if inventoryNumber is not -1 then it progresses
						if(inventoryNumber != -1)
						{
							String title = booklist.get(inventoryNumber-1).getTitle(); //sets book title to title
							double price = booklist.get(inventoryNumber-1).getPrice(); //sets book price to price
							
							CatalogItem cartItem = new CatalogItem(title, price); //makes new CatalogItem object
							
							bookCart.add(cartItem); //adds to cart arraylist
							
						}
						else 
							continue;
					}
					else if(customerChoice == 4)
					{
						System.out.println("Enter the inventory item you would like to purchase");
						System.out.println("(Enter -1 to display the menu)");
						
						//if inventoryNumber is not -1 then it progresses
						int inventoryNumber = input.nextInt();
		
						if(inventoryNumber != -1)
						{
							String title = dvdlist.get(inventoryNumber-1).getTitle(); //sets book title to title
							double price = dvdlist.get(inventoryNumber-1).getPrice(); //sets book price to price
							
							CatalogItem cartItem = new CatalogItem(title, price); //makes new CatalogItem object
							
							dvdCart.add(cartItem); //adds to cart arraylist
						}
						else 
							continue;
					}
					else if(customerChoice == 5)
					{
						//outputs books in cart
						if(bookCart.size() != 0)
						{
							System.out.println();
							System.out.println("Inventory #     Books               	Prices");
							System.out.println("------------------------------------------------");
							for(int i = 0; i < bookCart.size(); i++)
							{
								int n1 = i;
								System.out.printf("%d\t\t%-20s\t$%3.2f\n", n1 + 1, bookCart.get(i).getTitle(), bookCart.get(i).getPrice());
							}
							System.out.println("------------------------------------------------");
							System.out.println("");
							
							//asks user to enter inventory number
							System.out.print("Please enter inventory number (-1 will return back to the menu): ");
							int inventoryNumber = input.nextInt();
							
							if(inventoryNumber != -1)
							{
								bookCart.remove(inventoryNumber-1); //removes item
								System.out.println("Book successfully removed from shopping cart.");
							}
							else 
								continue;
						}
						else
						{
							System.out.println("\nThere are no books in your cart.\n");
						}
						
					}
					else if(customerChoice == 6)
					{
						//outputs books in cart
						if(dvdCart.size() != 0)
						{
							System.out.println();
							System.out.println("Inventory #     DVDs               	 Prices");
							System.out.println("------------------------------------------------");
							for(int i = 0; i < dvdCart.size(); i++)
							{
								int n1 = i;
								System.out.printf("%d\t\t%-20s\t$%3.2f\n", n1 + 1, dvdCart.get(i).getTitle(), dvdCart.get(i).getPrice());
							}
							System.out.println("------------------------------------------------");
							System.out.println("");
							
							//asks user to enter inventory number
							System.out.print("Please enter inventory number (-1 will return back to the menu): ");
							int inventoryNumber = input.nextInt();
							if(inventoryNumber != -1)
							{
								dvdCart.remove(inventoryNumber-1);
								System.out.println("DVD successfully removed from shopping cart.");
							}
							else
								continue;
							
						}
						else
						{
							System.out.println("\nThere are no DVDs in your cart.\n");
						}
					}
					else if(customerChoice == 7) //outputs the cart
					{
						double total = 0;
						System.out.println();
						System.out.println("Item               	Price");
						System.out.println("-------------------------------");
						for(int i = 0; i < bookCart.size(); i++)
						{
							total += bookCart.get(i).getPrice();
							System.out.printf("%-20s\t$%3.2f\n", bookCart.get(i).getTitle(), bookCart.get(i).getPrice());
						}
						for(int i = 0; i < dvdCart.size(); i++)
						{
							total += dvdCart.get(i).getPrice();
							System.out.printf("%-20s\t$%3.2f\n", dvdCart.get(i).getTitle(), dvdCart.get(i).getPrice());
						}
						System.out.println("-------------------------------");
						total = total * 1.0825;
						System.out.printf("Total + tax\t\t$%4.2f\n", total);
					}
					else if(customerChoice == 8) //outputs the cart and deletes all elements in the cart
					{
						double total = 0;
						System.out.println();
						System.out.println("Item               	Price");
						System.out.println("-------------------------------");
						for(int i = 0; i < bookCart.size(); i++)
						{
							total += bookCart.get(i).getPrice();
							System.out.printf("%-20s\t$%3.2f\n", bookCart.get(i).getTitle(), bookCart.get(i).getPrice());
						}
						for(int i = 0; i < dvdCart.size(); i++)
						{
							total += dvdCart.get(i).getPrice();
							System.out.printf("%-20s\t$%3.2f\n", dvdCart.get(i).getTitle(), dvdCart.get(i).getPrice());
						}
						System.out.println("-------------------------------");
						total = total * 1.0825;
						System.out.printf("Total + tax\t\t$%4.2f\n", total);
						
						bookCart.clear();
						dvdCart.clear();
						
						System.out.println("Successfully purchased items in shopping cart!");
					}
					else if(customerChoice == 9)
					{
						loop = false;
					}
					else
						System.out.println("Invalid Option. Please try again.");
				}
					
			}
			else if(menuOption == 'C' || menuOption == 'c') //if c is entered
			{
				System.out.println("Terminating program...");
				running = false; //sets running to false
			}
			else //if option is not recognizable
			{
				System.out.println("Invalid Option. Please try again.");
			}
		}	
	}
}
