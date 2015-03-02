/**
 * 
 */  
package mandy.unil.gui;  

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/** 
 * ����ʱ�䣺2012-2-14 ����03:42:50 
 * ��Ŀ���ƣ�mandy.unil 
 * @author Mengdi 
 * @version 1.0  
 * @since JDK 1.6.0_21 
 * �ļ����ƣ�IllegalInput.java 
 * ��˵���� java GUI �Ϸ�����
 */

public class IllegalInput {//Ĭ������ΪString

	
	public static boolean checkSpecial(String s){//�ж�����ַ���ֻ�������֣�a-z,A-Z,�ո��»��ߣ��л���
			  if(s.replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*",  "").length()==0){
			   System.out.println("input correct");
			    return true;
			  }
			  else {
			   System.out.println("input incorrect");
			  return false;
			  }
	}
	
	public static boolean checkString(String s){//��ĸ�Ϸ�
		  if(s.replaceAll("[a-z]*[A-Z]", "").length()==0){
		   System.out.println("input correct");
		   return true;
		  }
		  else {
		   System.out.println("input incorrect");
		   return false;
		  }
		  
		  
}
public static boolean checkEmpty(String s){//���������  ��׽�쳣

	if(s==null || "".equals(s.trim())){
		return true;
		}else return false;
}
	public static boolean checkInt1(String s){//���ֺϷ��������  ��׽�쳣
		try{
		    int x=0;
			x  = Integer.parseInt(s);
			
		       } catch (NumberFormatException ex) {
                      return false;
		        }
		   return true;
	}
	public static boolean checkInt2(String s){//ͬ�� ������ʽ
		for (int i=0;i<s.length();i++) {
			  char ch = s.charAt(i);
			  if(Character.isDigit(ch)==false)
				  return false;
		}
		return true;
	}
	
	public static boolean checkInt3(String s){//ͬ�� 0-9ƥ��
		
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(s.trim());
			if(isNum.matches()){
			System.out.println("��һ������");
			return true;
			}else{
			System.out.println("����һ������");
			return false;
			} 
	}
	public static void wornDialog(String s){
			JOptionPane.showMessageDialog(null,s,"ERROR",JOptionPane.ERROR_MESSAGE);
	}


	public static void main(String[] args) {
		int x=0;
		new IllegalInput().checkInt1("s");
	}
}
 