package game;

import java.util.Random;
import java.util.Scanner;

public class Lucky {
	static int userSel;
	static String[] userName=new String[3];          //已注册成功的用户名
	static String[] userPass=new String[3];          //已注册成功的密码
	static String userLogName;                       //登陆时输入的用户名
	static String userLogPass;                       //登陆时输入的密码
	static int[] vipId=new int[3];                   //注册成功的用户给定的会员卡号
	static int[] luckyId=new int[5];                 //今日的幸运卡号
	static Random random=new Random();
	static String op="y";                            //是否退出系统的参数
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		do{
			System.out.println("******欢迎进入奖客富翁系统******");
			System.out.println("          1.注册  ");
			System.out.println("          2.登录  ");
			System.out.println("          3.抽奖  ");
//			System.out.println("          0.退出  ");
			System.out.println("*******************************");
			System.out.print("请选择菜单：");

			userSel=input.nextInt();
			switch (userSel) {
			case 1:
				//注册
				System.out.println("[奖客富翁系统>注册]");
				System.out.println("请填写个人注册信息：");
				
				for(int i=0;i<3;i++){
					if(userName[i]==null){
						System.out.println("用户名：");
							userName[i]=input.next();
						for (int j = 0; j < i; j++) {
							if(userName[i].equals(userName[j])){
								System.out.println("此用户名已被注册");
								System.out.println("用户名：");
								userName[i]=input.next();
								j=-1;
							}
						}
						System.out.println("密码：");
						userPass[i]=input.next();
						vipId[i] = new Random().nextInt(9);
						for (int k = 0; k < i; k++) {
							if(vipId[i]==vipId[k]){
								vipId[i]=random.nextInt(9);
								k=-1;
							}
						}
						System.out.println("注册成功，请记好您的会员卡号");
						System.out.println("用户名\t密码\t会员卡号");
						System.out.println(userName[i]+"\t"+userPass[i]+"\t"+vipId[i]);
						
						break;
					}
					else if(i==2){
						System.out.println("注册名额已满，谢谢");
					}
				}
				break;
           
			case 2:
				//登录
				System.out.println("[奖客富翁系统>登录]");
				boolean flag=true;
				int failCount=0;
				while(flag){
					System.out.println("请输入用户名：");
					userLogName=input.next();
					System.out.println("请输入密码：");
					userLogPass=input.next();
				    for (int i = 0; i < 3; i++) {
				    	if(failCount==3){
							System.out.println("用户名或密码已输错3次");
							flag=false;
							break;
						}
						if(userLogName.equals(userName[i])&&userLogPass.equals(userPass[i])){
							System.out.println("欢迎您："+userLogName);
							flag=false;
							break;
						}
						else if(userLogName.equals(userName[i])&&!userLogPass.equals(userPass[i])){
							System.out.println("密码不正确");
							failCount++;
							break;
							}
						else if(i==2&&!userLogName.equals(userName[i])){
							System.out.println("用户名不正确");
							break;
							}
						
							
//						if(i==2&&!userLogName.equals(userName[i])){
//							   System.out.println("用户名不正确");
//							   
//						}
//						int failCount=0;
//						while(userLogName.equals(userName[i])){
//							if(failCount==3){
//								System.out.println("密码已输错3次");
//								flag=false;
//								break;
//							}
//							System.out.println("请输入密码：");
//							userLogPass=input.next();
//							if(userLogPass.equals(userPass[i])){
//								System.out.println("欢迎您："+userLogName);
//								flag=false;
//								break;
//							}
//							else{
//								System.out.println("密码不正确");
//								failCount++;
//								}
//						}		
				    	
				    }
				}
				
				
				break;
			
			case 3:
				//抽奖
				System.out.println("[奖客富翁系统>抽奖]");
				System.out.println("您的卡号是：");
  				int id=input.nextInt();
//				for (int j = 0; j < 3; j++) {
//					if(id==vipId[j]){
//						break;
//					}
//					else{
//						if(j==2){
//							System.out.print("请输入正确卡号：");
//							id=input.nextInt();
//						}
//					}
//				}
				System.out.print("今天的幸运数字为：");
				//生成幸运数组
				for (int i = 0; i < 5; i++) {
					luckyId[i]=random.nextInt(9);
					for (int j = 0; j < i; j++) {
						if(luckyId[i]==luckyId[j]){
							luckyId[i]=random.nextInt(9);
							j=-1;
						}
					}
					System.out.print(luckyId[i]+"  ");
				}
				//判断是否中奖
				boolean flag2=false;
				for (int i = 0; i < 5; i++) {
					if(id==luckyId[i]){
						flag2=true;
						break;
					}
				}
				if(flag2)
					System.out.println("恭喜！您是本日的幸运观众！");
				else
					System.out.println("抱歉！您不是本日的幸运观众！");
				break;
				
//			case 0://退出系统
//				op="n";
//				break;
				
			default:
				System.out.println("请输入有效选择！");
				break;
			}
			System.out.print("继续吗？（y/n）：");
			op=input.next();
//			if(op.equals("n"))
//				System.out.println("系统退出，谢谢使用！");break;

		}while(op.equals("y"));
		System.out.println("系统退出，谢谢使用！");
	}
//	public static int menu(){
//		
//		return userSel;
//	}
	
//	public static void zhuCe(){
//		//注册
//
//	}
	
//	public static void dengLu(){
//		//登录
//
//	}
	
//	public static void chouJiang(){   
//		//抽奖
//
//	}
	


}
