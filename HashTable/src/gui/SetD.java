
package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mandy.unil.gui.IllegalInput;
import baseLogic.LinerHT;

/** 
 * 创建时间：2012-2-14 下午01:54:34 
 * 项目名称：HashTable 
 * @author daniel 
 * @version 1.0  
 * @since JDK 1.6.0_21 
 * 文件名称：HashTable1.java 
 * 类说明： 
 */
/**
 * @author Mengdi
 * 
 */
public class SetD implements ActionListener {

	/**
	 * @param owner
	 */
	private int D;
	JFrame frame;
	JButton go;
	JTextField d;
	JLabel lb;
	JPanel p1, p2;

	/**
	 * @return the d
	 */
	public int getD() {
		return D;
	}

	public SetD() {
		frame = new JFrame("散列初始化");
		lb = new JLabel("请设置散列表的大小D");
		d = new JTextField();
		d.setColumns(2);
		d.addActionListener(this);
		go = new JButton("Go");
		go.addActionListener(this);

		p1 = new JPanel();
		p1.add(lb);
		p1.add(d);
		p2 = new JPanel();
		p2.add(go);

		frame.setLayout(new GridLayout(2, 1));
		frame.add(p1);
		frame.add(p2);
		frame.setTitle("HashTable Set D");
		frame.setBounds(500, 300, 250, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		// if(obj instanceof JTextField){
		// String s=d.getText();
		// if(Integer.getInteger(s) instanceof Integer) 合法输入
		// D=Integer.getInteger(s);
		// }
		if (obj instanceof JButton) {
			String s = d.getText();
			if(!IllegalInput.checkInt1(s)){
			IllegalInput.wornDialog("请输入正整数！");
			d.setText("");
			}else{
				D = Integer.parseInt(d.getText());
				LinerHT lht = new LinerHT(D);
				ShowHashTabel ht3 = new ShowHashTabel(lht);
				frame.dispose();
				ht3.show();	
			}
			
//			if (s != null) {
//				if (IllegalInput.checkInt2(s)) {
//					D = Integer.parseInt(d.getText());
//					LinerHT lht = new LinerHT(D);
//					HashTabelShow3 ht3 = new HashTabelShow3(lht);
//					this.frame.dispose();
//					ht3.show();	
//				}else{
//					JDialog dialog = new JDialog(frame, "提示");
//					dialog.add(new JLabel("输入的函数值必须为正整数！"));
//					d.setText("");
//				}
//			} else {
//				JDialog dialog = new JDialog(frame, "提示");
//				dialog.add(new JLabel("输入的函数值不能为空！"));
//			}

		
		}
	}

	public static void main(String[] args) {
		new SetD();
	}
}
