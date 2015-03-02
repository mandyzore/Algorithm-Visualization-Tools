/**
 * 
 */  
package mandy.unil.gui;  

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/** 
 * 创建时间：2012-2-14 下午03:42:50 
 * 项目名称：mandy.unil 
 * @author Mengdi 
 * @version 1.0  
 * @since JDK 1.6.0_21 
 * 文件名称：IllegalInput.java 
 * 类说明： java GUI 合法输入
 */

public class IllegalInput {//默认输入为String

	
	public static boolean checkSpecial(String s){//判断这个字符串只含有数字，a-z,A-Z,空格，下划线，中划线
			  if(s.replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*",  "").length()==0){
			   System.out.println("input correct");
			    return true;
			  }
			  else {
			   System.out.println("input incorrect");
			  return false;
			  }
	}
	
	public static boolean checkString(String s){//字母合法
		  if(s.replaceAll("[a-z]*[A-Z]", "").length()==0){
		   System.out.println("input correct");
		   return true;
		  }
		  else {
		   System.out.println("input incorrect");
		   return false;
		  }
		  
		  
}
public static boolean checkEmpty(String s){//空输入检验  捕捉异常

	if(s==null || "".equals(s.trim())){
		return true;
		}else return false;
}
	public static boolean checkInt1(String s){//数字合法输入检验  捕捉异常
		try{
		    int x=0;
			x  = Integer.parseInt(s);
			
		       } catch (NumberFormatException ex) {
                      return false;
		        }
		   return true;
	}
	public static boolean checkInt2(String s){//同上 正则表达式
		for (int i=0;i<s.length();i++) {
			  char ch = s.charAt(i);
			  if(Character.isDigit(ch)==false)
				  return false;
		}
		return true;
	}
	
	public static boolean checkInt3(String s){//同上 0-9匹配
		
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(s.trim());
			if(isNum.matches()){
			System.out.println("是一个数字");
			return true;
			}else{
			System.out.println("不是一个数字");
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
 