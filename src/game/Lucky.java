package game;

import java.util.Random;
import java.util.Scanner;

public class Lucky {
	static int userSel;
	static String[] userName=new String[3];          //��ע��ɹ����û���
	static String[] userPass=new String[3];          //��ע��ɹ�������
	static String userLogName;                       //��½ʱ������û���
	static String userLogPass;                       //��½ʱ���������
	static int[] vipId=new int[3];                   //ע��ɹ����û������Ļ�Ա����
	static int[] luckyId=new int[5];                 //���յ����˿���
	static Random random=new Random();
	static String op="y";                            //�Ƿ��˳�ϵͳ�Ĳ���
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		do{
			System.out.println("******��ӭ���뽱�͸���ϵͳ******");
			System.out.println("          1.ע��  ");
			System.out.println("          2.��¼  ");
			System.out.println("          3.�齱  ");
//			System.out.println("          0.�˳�  ");
			System.out.println("*******************************");
			System.out.print("��ѡ��˵���");

			userSel=input.nextInt();
			switch (userSel) {
			case 1:
				//ע��
				System.out.println("[���͸���ϵͳ>ע��]");
				System.out.println("����д����ע����Ϣ��");
				
				for(int i=0;i<3;i++){
					if(userName[i]==null){
						System.out.println("�û�����");
							userName[i]=input.next();
						for (int j = 0; j < i; j++) {
							if(userName[i].equals(userName[j])){
								System.out.println("���û����ѱ�ע��");
								System.out.println("�û�����");
								userName[i]=input.next();
								j=-1;
							}
						}
						System.out.println("���룺");
						userPass[i]=input.next();
						vipId[i] = new Random().nextInt(9);
						for (int k = 0; k < i; k++) {
							if(vipId[i]==vipId[k]){
								vipId[i]=random.nextInt(9);
								k=-1;
							}
						}
						System.out.println("ע��ɹ�����Ǻ����Ļ�Ա����");
						System.out.println("�û���\t����\t��Ա����");
						System.out.println(userName[i]+"\t"+userPass[i]+"\t"+vipId[i]);
						
						break;
					}
					else if(i==2){
						System.out.println("ע������������лл");
					}
				}
				break;
           
			case 2:
				//��¼
				System.out.println("[���͸���ϵͳ>��¼]");
				boolean flag=true;
				int failCount=0;
				while(flag){
					System.out.println("�������û�����");
					userLogName=input.next();
					System.out.println("���������룺");
					userLogPass=input.next();
				    for (int i = 0; i < 3; i++) {
				    	if(failCount==3){
							System.out.println("�û��������������3��");
							flag=false;
							break;
						}
						if(userLogName.equals(userName[i])&&userLogPass.equals(userPass[i])){
							System.out.println("��ӭ����"+userLogName);
							flag=false;
							break;
						}
						else if(userLogName.equals(userName[i])&&!userLogPass.equals(userPass[i])){
							System.out.println("���벻��ȷ");
							failCount++;
							break;
							}
						else if(i==2&&!userLogName.equals(userName[i])){
							System.out.println("�û�������ȷ");
							break;
							}
						
							
//						if(i==2&&!userLogName.equals(userName[i])){
//							   System.out.println("�û�������ȷ");
//							   
//						}
//						int failCount=0;
//						while(userLogName.equals(userName[i])){
//							if(failCount==3){
//								System.out.println("���������3��");
//								flag=false;
//								break;
//							}
//							System.out.println("���������룺");
//							userLogPass=input.next();
//							if(userLogPass.equals(userPass[i])){
//								System.out.println("��ӭ����"+userLogName);
//								flag=false;
//								break;
//							}
//							else{
//								System.out.println("���벻��ȷ");
//								failCount++;
//								}
//						}		
				    	
				    }
				}
				
				
				break;
			
			case 3:
				//�齱
				System.out.println("[���͸���ϵͳ>�齱]");
				System.out.println("���Ŀ����ǣ�");
  				int id=input.nextInt();
//				for (int j = 0; j < 3; j++) {
//					if(id==vipId[j]){
//						break;
//					}
//					else{
//						if(j==2){
//							System.out.print("��������ȷ���ţ�");
//							id=input.nextInt();
//						}
//					}
//				}
				System.out.print("�������������Ϊ��");
				//������������
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
				//�ж��Ƿ��н�
				boolean flag2=false;
				for (int i = 0; i < 5; i++) {
					if(id==luckyId[i]){
						flag2=true;
						break;
					}
				}
				if(flag2)
					System.out.println("��ϲ�����Ǳ��յ����˹��ڣ�");
				else
					System.out.println("��Ǹ�������Ǳ��յ����˹��ڣ�");
				break;
				
//			case 0://�˳�ϵͳ
//				op="n";
//				break;
				
			default:
				System.out.println("��������Чѡ��");
				break;
			}
			System.out.print("�����𣿣�y/n����");
			op=input.next();
//			if(op.equals("n"))
//				System.out.println("ϵͳ�˳���ллʹ�ã�");break;

		}while(op.equals("y"));
		System.out.println("ϵͳ�˳���ллʹ�ã�");
	}
//	public static int menu(){
//		
//		return userSel;
//	}
	
//	public static void zhuCe(){
//		//ע��
//
//	}
	
//	public static void dengLu(){
//		//��¼
//
//	}
	
//	public static void chouJiang(){   
//		//�齱
//
//	}
	


}
