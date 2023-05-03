  package AdmissionMonitor;
import java.sql.*;
import java.util.*;
public class AllFunctions{
	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		Methods.display();
		outerloopmain:
		while (true)
		{
		String nu=sc.next();
		int n=Methods.twoNumber(nu);
		int k=0;
		
		 if (n==1)
		{
			Methods.departmentDetails();
			Methods.display();
		}
		else if (n==2)
		{
			Methods.staffDetails();
			Methods.display();
		}
		else if (n==3)
		{
			System.out.println("DeptId  Name          Cutoff     Fees concession");
			System.out.println("------  ----          ------     ---- ----------");
			ResultSet rs= Jdbc.st.executeQuery("Select * from scholarship");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"      "+rs.getString(2)+"      "+rs.getString(3)+"      "+rs.getString(4));
				System.out.println();
			}
			Methods.display();
		}
		else if(n==4)
		{
			System.out.println("PLEASE ENTER PASSWORD:                 [To quit - 9]");
			int p=0;
			while (p==0)
			{
				String pass=sc.next();
				int password=Methods.twoNumber(pass);
				if (password==7410)
				{
					Methods.details();
					outerloop3:
					while(true)
					{
						String detail=sc.next();
						int details=Methods.twoNumber(detail);
						if (details==11)
						{
							int c=0;
							ResultSet temp1=Jdbc.st.executeQuery("select numOfSeatsAvailable from departmentDetails");
							while(temp1.next())
							{
								if (temp1.getInt("numOfSeatsAvailable")!=0)
								{
									c=1;
								}
							}
							if (c==1)
							{
								int count=0;
								System.out.println("                          PLEASE FILL THE FOLLOWING DETAILS");
								System.out.println("                          ------ ---- --- --------- -------");
								System.out.println("[Start with the StudentId : "+(StudentId.currId()+1)+"]");
								System.out.println();
								System.out.println("ENTER THE STUDENT ID");
								System.out.println("----- --- ------- --");
								int studentId=0;
								String stuId=sc.next();
								while (true)
								{
									int method=Methods.twoNumber(stuId);
									if (stuId.equals("9"))
									{
										System.out.println("                                 If yes - press 9 again");
										System.out.println("Are you sure want to quit");
										System.out.println("                                 If not - Enter Correct StudentId");
										String stuId2=sc.next();
										
										if (stuId2.equals("9"))
										{
											Methods.details();
											continue outerloop3;
								
										}
										else
										{
											stuId=stuId2;
										}
									}
									else if (method!=StudentId.currId()+1)
									{
										System.out.println("Please enter correct StudentId");
										String stuId1=sc.next();
										stuId=stuId1;
									}
									else
									{
										studentId=method;
										break;
									}
								}
								System.out.println("ENTER YOUR NAME   [within 20 characters]");
								System.out.println("----- ---- ----");
								int c1=0;
								String name=sc.next();
								int g=0;
								while (g==0)
								{
									if(name.equals("9"))
									{
										break;
									}
									else if(name.length()<=20)
									{
										int total=0;
										for(int i=0;i<name.length();i++)
										{
											if(((int)Character.toLowerCase(name.charAt(i))>=97 && (int)Character.toLowerCase(name.charAt(i))<=122)==false)
											{
												total+=1;
											}
										}
										if (total==0)
										{
											while(name.length()<20)
											{
												name+=' ';
											}
											g=1;
										}
										else
										{
											System.out.println("Enter Only Alphabets, other characters are allowed");
											String name1=sc.next();
											name=name1;
											continue;
										}
									}
									else
									{
										System.out.println("Please enter within 20 characters");
										String name1=sc.next();
										name=name1;
										continue;
									}
								}
								if(name.equals("9"))
								{
									Methods.details();
									k=1;
									continue outerloop3;
								}
								System.out.println("ENTER YOUR GENDER (M/F)");
								System.out.println("----- ---- ------ -----");
								String gender = sc.next();
								
								while(true)
								{
									if (gender.equals("9"))
									{
										break;
									}
									else if (gender.length()==1)
									{
										int f=(int)gender.charAt(0);
										if(f!=77 && f!= 109 && f!=70 && f!=102)
										{
											System.out.println("Please enter valid gender (M/F)");
											String gender1= sc.next();
											gender=gender1;
										}
										else
										{
											gender=String.valueOf(Character.toUpperCase(gender.charAt(0)));
											break;
										}
									}
									else
									{
										System.out.println("Please enter valid gender (M/F)");
										String gender1= sc.next();
										gender=gender1;
									}
								}
								if(gender.equals("9"))
									{
										Methods.details();
										continue;
									}
								System.out.println("ENTER YOUR AGE (--only betweeen 18 to 50--)");
								System.out.println("----- ---- --- ----------------------------");
								int age=0;
								while (true)
								{
									String s1=sc.next();
									if(s1.equals("9"))
									{
										age=Integer.parseInt(s1);
										break;
									}
									else if (s1.length()<2 || s1.length()>2)
									{
										System.out.println("Please enter valid age");
										continue;
									}
									else
									{
										int cnt=0;
										String  str="";
										for (int i=0;i<2;i++)
										{
											if (Character.isAlphabetic(s1.charAt(i))!=true)
											{
												str+=s1.charAt(i);
												cnt+=1;
											}
											else
											{
												break;
											}
										}
										if(cnt!=2)
										{
											System.out.println("Please enter valid age");
											continue;
										}
										else 
										{
											 age=Integer.parseInt(str);
											 if (age<18 || age>50)
											 {
												 System.out.println("Your age should be between 18 to  50");
												continue;
											 }
											 else {
												 break;
											 }
										}
									}
								}
								if(age==9)
								{
									Methods.details();
									continue;
								}
								System.out.print("ENTER YOUR MARKS (--only between 300 to 600--)");
								System.out.println();
								int marks=0;
								while (true)
								{
									String s2=sc.next();
									if(s2.equals("9"))
									{
										marks=Integer.parseInt(s2);
										break;
									}
									else if (s2.length()<3 || s2.length()>3)
									{
										System.out.println("Please enter valid marks");
										continue;
									}
									else
									{
										int cnt=0;
										String  str="";
										for (int i=0;i<3;i++)
										{
											if (Character.isAlphabetic(s2.charAt(i))!=true)
											{
												str+=s2.charAt(i);
												cnt+=1;
											}
											else
											{
												continue;
											}
										}
										if(cnt!=3)
										{
											System.out.println("Please enter valid marks [No alphabets]");
											continue;
										}
										else 
										{
											marks=Integer.parseInt(str);
											 if (marks<300 || marks>600)
											 {
												 System.out.println("Your marks should be between 300 to  600");
												continue;
											 }
											 else {
												 break;
											 }
										}
									}
								}
								if(marks==9)
								{
									Methods.details();
									continue;
								}
								System.out.println("ENTER YOUR CUT-OFF  [Format - 000.0 / 000.00]  (--only between 100 to 200--)");
								System.out.println("----- ---- --- ---  -------   ---------------  -----------------------------");
								String cut="";
								int cutOff=0;
								while (true)
								{
									String s3=sc.next();
									if(s3.equals("9"))
									{
										cutOff=Integer.parseInt(s3);
										break;
									}
									else if (s3.length()<5 || s3.length()>6)
									{
										System.out.println("Please enter valid Cutoff");
										continue;
									}
									else
									{
										int cnt=0;
										String str="";
										String res="";
										for (int i=0;i<s3.length();i++)
										{
											if(i==3)
											{
												if(s3.charAt(i)=='.')
												{
													str+=s3.charAt(i);
													cnt+=1;
												}
											}
											else if ((int)s3.charAt(i)>=48 && (int)s3.charAt(i)<=57)
											{
												if (i!=3)
												{
													str+=s3.charAt(i);
													cnt+=1;
												}
												if(i<3)
												{
													res+=s3.charAt(i);
												}
											}
											else
											{
												continue;
											}
										}
										if(cnt!= s3.length())
										{
											System.out.println("Please enter valid cutOff");
											continue;
										}
										else 
										{
											cutOff=Integer.parseInt(res);
											 if (cutOff<100 || cutOff>200)
											 {
												 System.out.println("Your cut Off should be between 100 to 200");
												 continue;
											 }
											 else 
											 {
												 cut=str;
												 break;
											 }
										}				
									}
								}
								if(cutOff==9)
								{
									Methods.details();
									continue;
								}
								System.out.println("ENTER THE HOSTEL REQUIREMENTS (Y/N)");
								System.out.println("----- --- ------ ------------ -----");
								String hostelNeeded=sc.next();
								while(true)
								{
									if (hostelNeeded.equals("9"))
									{
										break;
									}
									else if (hostelNeeded.length()==1)
									{
										int h= (int)hostelNeeded.charAt(0);
										if(h!=78 && h!=110 && h!=89 && h!=121)
										{
											System.out.println("Please enter valid Letter (Y/N)");
											String hostelNeeded1= sc.next();
											hostelNeeded=hostelNeeded1;
										}
										else
										{
											hostelNeeded=String.valueOf(Character.toUpperCase(hostelNeeded.charAt(0)));
											break;
										}
									}
									else
									{
										System.out.println("Please enter valid Letter (Y/N)");
										String hostelNeeded1= sc.next();
										hostelNeeded=hostelNeeded1;
									}
								}
								if(hostelNeeded.equals("9"))
								{
									Methods.details();
									continue;
								}
								String booked="";
								System.out.println("Which department you will prefer - Enter the DeptId                [To quit - 9]");
								System.out.println("----------------------------------------------------------------------------------------------");
								System.out.println("This is the department details");
								System.out.println();
								Methods.departmentDetails();
								int j=0;
								outerloop:
								while (j==0)
								{
									System.out.println();
									System.out.println("Which department you will prefer - Enter the DeptId                            [To quit - 9]");
									String number1=sc.next();
									int id=Methods.twoNumber(number1);
									if (id==9) 
									{
										Methods.details();
										continue outerloop3;
									}
									ResultSet seats = Jdbc.st.executeQuery("Select * from departmentDetails where deptId="+id);
									if(seats.next())
									{
										int numOfSeats=seats.getInt("numOfSeatsAvailable");
										if (numOfSeats>0)
										{
											System.out.println("----------------------------------------------------------------------------------------------");
											System.out.println("This is your department details");
											System.out.println("---- -- ---- ---------- -------");
											System.out.println("DeptId  DeptName  DeptFees    SeatsAllocated   SeatsFilled   SeatsBlocked  SeatsAvailable");
											System.out.println();
											System.out.println(seats.getString(1)+"      "+seats.getString(2)+"      "+seats.getString(3)+"            "+seats.getString(4)+"                "+seats.getString(5)+"            "+seats.getString(6)+"             "+seats.getString(7));
											System.out.println();
											System.out.println("----------------------------------------------------------------------------------------------");
											ResultSet fees1=Jdbc.st.executeQuery("select * from scholarship where deptId="+id);
											fees1.next();
											System.out.println("This is your department scholarship details");
											System.out.println("---- -- ---- ---------- ----------- -------");
											System.out.println("DeptId  Name          Cutoff     Fees concession");
											System.out.println("------  ----          ------     ---- ----------");
											System.out.println(fees1.getString(1)+"      "+fees1.getString(2)+"      "+fees1.getString(3)+"      "+fees1.getString(4));
											System.out.println("----------------------------------------------------------------------------------------------");
											System.out.println("This is your department staff details");
											System.out.println("---- -- ---- ---------- ----- -------");
										    ResultSet  staff =Jdbc.st.executeQuery ("Select * from staffIncharge where deptId="+id);
										    staff.next();
										    int StaffId =staff.getInt("staffId");
											ResultSet d = Jdbc.st.executeQuery("select * from staffDetails where staffId="+StaffId);
											d.next();
											System.out.println("StaffID    StaffName     StaffMobileNumber     StaffEmailId");
											System.out.println(); 
											System.out.println(d.getString(1)+"          "+d.getString(2)+"       "+d.getString(3)+"       "+d.getString(4));
											System.out.println("----------------------------------------------------------------------------------------------");
											System.out.println();
											ResultSet fees=Jdbc.st.executeQuery("Select * from scholarship where deptId="+ id);
											fees.next();
											float cut_off =fees.getInt("cutOff");
											int i=0;
											while (i==0)
											{
												System.out.println("TO  BLOCK A SEAT - PRESS 1            [TO QUIT - 9]");
												System.out.println();
												System.out.println("TO  BOOK A SEAT  - PRESS 2            [TO GO BACK TO PREVIOUS STEP - 99]");
												System.out.println();
												String number2=sc.next();
												int number=Methods.twoNumber(number2);
												if (number==9)
												{
													Methods.details();
													k=1;
													j=1;
													continue outerloop3;
												}
												else if( number == 99 )
												{
													Methods.departmentDetails();
													continue outerloop;
												}
												else if (number <0 ||number >2){
													System.out.println("OOPS , you entered the wrong number");
													System.out.println("----------------------------------");
												}
												else if (number==1 || number==2)
												{
													ResultSet deptFees=Jdbc.st.executeQuery("Select * from departmentDetails where deptId= "+id);
													deptFees.next();
													int filled = deptFees.getInt("numOfSeatsFilled");
													int blocked = deptFees.getInt("numOfSeatsBlocked");
													int available = deptFees.getInt("numOfSeatsAvailable");
													int actualFees=deptFees.getInt("deptFees");
													ResultSet feesConcession=Jdbc.st.executeQuery("Select * from scholarship where deptId= "+id);
													feesConcession.next();
													int amount =feesConcession.getInt("feesConcession");
													int reducedAmount =actualFees-amount;
													System.out.println();
													if ((cutOff)>=cut_off)
													{
														if (number==1)
														{
															int a= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsBlocked=numOfSeatsBlocked+1 where deptId="+id );
															int b= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsAvailable=numOfSeatsAvailable-1 where deptId="+id);
															Methods.update(studentId,id,actualFees,String.valueOf(amount),reducedAmount,hostelNeeded);
															System.out.println("----------------------------------------------------------------------------------------------");
															System.out.println("YOUR SEAT IS BLOCKED, YOU HAVE SCHOLARSHIP FOR "+amount+" FOR YOUR CUTOFF.");
															i=1;
															booked="BLOCKED";
														}
														else 
														{
															int a= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsFilled=numOfSeatsFilled+1 where deptId="+id);
															int b= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsAvailable=numOfSeatsAvailable-1 where deptId="+id);
															Methods.update(studentId,id,actualFees,String.valueOf(amount),reducedAmount,hostelNeeded);
															System.out.println("----------------------------------------------------------------------------------------------");
															System.out.println("YOUR SEAT IS BOOKED, YOU HAVE SCHOLARSHIP FOR "+amount+" FOR YOUR CUTOFF.");
															i=1;
															booked="BOOKED";
														}
														int a=Jdbc.st.executeUpdate("update amount set scholarshipAmount=scholarshipAmount+"+amount);
														int q=Jdbc.st.executeUpdate("update amount set netProfit=netProfit+"+reducedAmount);
													}
													else
													{
														if (number==1)
														{
															int a= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsBlocked=numOfSeatsBlocked+1 where deptId="+id );
															int b= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsAvailable=numOfSeatsAvailable-1 where deptId="+id);
															Methods.update(studentId,id,actualFees,"  0  ",actualFees,hostelNeeded);
															System.out.println("----------------------------------------------------------------------------------------------");
															System.out.println("YOUR  SEAT IS BLOCKED.");
															i=1;
															booked="BLOCKED";
														}
														else
														{
															int a= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsFilled=numOfSeatsFilled+1 where deptId="+id);
															int b= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsAvailable=numOfSeatsAvailable-1 where deptId="+id);
															Methods.update(studentId,id,actualFees,"  0  ",actualFees,hostelNeeded);
															System.out.println("----------------------------------------------------------------------------------------------");
															System.out.println("YOUR SEAT IS BOOKED.");
															i=1;
															booked="BOOKED";
														}
														int q=Jdbc.st.executeUpdate("update amount set netProfit=netProfit+"+actualFees);
													}
													int e=Jdbc.st.executeUpdate("update amount set totalAmount=totalAmount+"+actualFees);
													int f=Jdbc.st.executeUpdate("update amount set totalSeatsClosed=totalSeatsClosed+1");
													count=1;
												}
												else
												{
													System.out.println("Please enter number");
												}
											}
										}
										else
										{
											System.out.println("This department is filled, please choose another department");
											continue;
										}
										j=1;
									}
									else
									{
										System.out.println();
										System.out.println("----------------------------------------------------------------------------------------------");
										System.out.println();
										Methods.departmentDetails();
										System.out.println();
										System.out.println(                        "OOPS ,YOU ENTERED WRONG DEPT ID, PLEASE ENTER  CORRECTLY                       [To Quit - 9]");
									}
								if (count==1)
								{
									int cnt= Jdbc.st.executeUpdate("insert into studentDetails values ("+studentId+",'"+name+"','"+gender+"',"+age+","+marks+","+cut+",'"+booked+"')");
									System.out.println();
									System.out.println("                                                         YOUR DETAILS");
									System.out.println();
									ResultSet res1=Jdbc.st.executeQuery("select * from studentDetails  where studentId="+studentId);
									res1.next();
									System.out.println("StudentId    StudentName       Gender       Age      Marks      CutOff      DeptId      ActualFees      ReducedFees         FinalFees      Hostel");
									System.out.println("---------    -----------       ------       ---      -----      ------      ------      ----------      -----------         ---------      ------");
									System.out.print("  "+res1.getString(1)+"         "+res1.getString(2)+""+res1.getString(3)+"          "+res1.getString(4)+"       "+res1.getString(5)+"        "+res1.getString(6));
									ResultSet new1=Jdbc.st.executeQuery("select * from admissionStatus where studentId="+studentId);
									new1.next(); 
									System.out.println("        "+new1.getString(2)+"          "+new1.getString(3)+"            "+new1.getString(4)+"             "+new1.getString(5)+"           "+new1.getString(6));
									System.out.println();
									System.out.println("                                                           THANKYOU");
								}
							}
							Jdbc.con.commit();
							}
							else 
							{
								System.out.println("SORRY, ALL DEPARTMENTS ARE FILLED");
								System.out.println();
								Methods.departmentDetails();
							}
							Methods.details();
						}
						else if(details==12)
						{
							int z=0;
							outerloop1:
							while (z==0)
							{
								System.out.println("Enter student Id                      [To Quit - 9]");
								String studentid=sc.next();
								int studentId2=Methods.twoNumber(studentid);
								ResultSet seats = Jdbc.st.executeQuery("Select * from studentDetails where studentId="+studentId2);
								if (studentId2==9)
								{
									Methods.details();
									continue outerloop3;
								}
								else if(seats.next())
								{
									String str=seats.getString("seatStatus");
									ResultSet id = Jdbc.st.executeQuery("select * from admissionStatus where studentId="+studentId2);
									id.next();
									int deptId=id.getInt("deptId");
									System.out.println("TO CONFIRM CANCELLATION  - PRESS 1");
									System.out.println();
									System.out.println("TO QUIT CANCELLATION     - PRESS 9");
									int l=0;
									while(true)
									{
										String confirm=sc.next();
										int proceed=Methods.twoNumber(confirm);
										if(proceed==1)
										{
											ResultSet temp=Jdbc.st.executeQuery("select * from admissionStatus where studentId="+studentId2);
											temp.next();
											int actualFees=temp.getInt("deptFees");
											int decreasedFees=Integer.parseInt(temp.getString("reducedFees").trim());
											int lastFees=temp.getInt("finalFees");
											ResultSet fees=Jdbc.st.executeQuery("Select * from scholarship where deptId="+deptId);
											fees.next();
											float cut_off =fees.getInt("cutOff");
											ResultSet cut=Jdbc.st.executeQuery("select * from studentDetails where studentId="+studentId2);
											cut.next();
											int cutOff = cut.getInt("cutOff");
											if(str.equals("BLOCKED"))
											{
												int a= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsBlocked=numOfSeatsBlocked-1 where deptId="+deptId );
												int b= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsAvailable=numOfSeatsAvailable+1 where deptId="+deptId);
												System.out.println("----------------------------------------------------------------------------------------------");
												System.out.println("YOUR BLOCKED SEAT IS CANCELLED, THANKYOU");
												Methods.details();
											}
											else
											{
												int a= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsFilled=numOfSeatsFilled-1 where deptId="+deptId );
												int b= Jdbc.st.executeUpdate("update departmentDetails set numOfSeatsAvailable=numOfSeatsAvailable+1 where deptId="+deptId);
												System.out.println("----------------------------------------------------------------------------------------------");
												System.out.println("YOUR BOOKED SEAT IS CANCELLED, THANKYOU");
												Methods.details();
											}
											 
											if (cutOff>cut_off)
											{
												int a=Jdbc.st.executeUpdate("update amount set scholarshipAmount=scholarshipAmount-"+decreasedFees);
												int q=Jdbc.st.executeUpdate("update amount set netProfit=netProfit-"+lastFees);
											}
											else
											{
												int q=Jdbc.st.executeUpdate("update amount set netProfit=netProfit-"+actualFees);
											}
											int delete = Jdbc.st.executeUpdate("delete from studentDetails where studentId="+studentId2);
											int clear = Jdbc.st.executeUpdate("delete from admissionStatus where studentId="+studentId2);
											int e=Jdbc.st.executeUpdate("update amount set totalAmount=totalAmount-"+actualFees);
											int f=Jdbc.st.executeUpdate("update amount set totalSeatsClosed=totalSeatsClosed-1");
											break outerloop1;
										}
										else if (proceed==9)
										{
											Methods.details();
											continue outerloop3;
										}
										else
										{
											System.out.println("Please enter correct number ,  Please enter 1 OR 9             [To Quit - 9]");
										}
									}
								}
								else
								{
									System.out.println("                                          To Continue   -  Press 1");
									System.out.println("Sorry , this student iD is not available");
									System.out.println("                                          To  Quit      -  Press 9");
									while(true)
									{
										String process2=sc.next();
										int process=Methods.twoNumber(process2);
										if(process==1)
										{
											continue outerloop1;
										}
										else if (process==9)
										{
											z=1;
											Methods.details();
											continue outerloop3;
										}
										else {
											System.out.println("Sorry, you entered wrong number , Please enter 1 OR 9 ");
											continue;
										}
									}
								}
							}
							Jdbc.con.commit();
						}
						else if(details==13)
						{
							ResultSet details1=Jdbc.st.executeQuery("select * from studentDetails");
				
							System.out.println("StudentId    StudentName       Gender       Age      Marks      CutOff");
							System.out.println("---------    -----------       ------       ---      -----      ------ ");
							while(details1.next())
							{
								System.out.println("  "+details1.getString(1)+"         "+details1.getString(2)+""+details1.getString(3)+"          "+details1.getString(4)+"       "+details1.getString(5)+"        "+details1.getString(6));
							}
						}
						else if(details ==14)
						{
							ResultSet details2=Jdbc.st.executeQuery("select * from admissionStatus");
							System.out.println("StudentId    DeptId      ActualFees      ReducedFees      FinalFees      Hostel");
							System.out.println("---------    ------      ----------      -----------      ---------      ------");
							while(details2.next())
							{
								System.out.println("   "+details2.getString(1)+"         "+details2.getString(2)+"          "+details2.getString(3)+"            "+details2.getString(4)+"           "+details2.getString(5)+"          "+details2.getString(6));
							}
						}
						else if (details==15)
						{
							Methods.departmentDetails();
						}
						else if(details==16)
						{
							System.out.println("Total Seats Closed     Total Amount     Total Scholarship Amount    Net Profit");
							System.out.println("------------------     ------------     ------------------------    ---------- ");
							ResultSet display=Jdbc.st.executeQuery("select * from amount");
							display.next();
							System.out.println("     "+display.getString(1)+"                    "+display.getString(2)+"               "+display.getString(3)+"                   "+display.getString(4));
						}
						else if(details==9)
						{
							p=1;
							Methods.display();
							break;
						}
						else
						{
							System.out.println("YOUR INPUT IS WRONG, PLEASE ENTER CORRECTLY");
						}
					}
				}
				else if(password==9)
				{
					p=1;
					Methods.display();
					break;
				}
				else
				{
					System.out.println("Please enter correct password");
				}
			}
		}
		else if(n==9)
		{
			Methods.display();
		}
		else 
		{
			System.out.println("YOUR INPUT IS WRONG, PLEASE ENTER VALID NUMBER");
		}
		}
	}
  }
