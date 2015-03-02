
package gui;

/** 
 * 创建时间：2012-2-13 上午12:08:29 
 * 项目名称：HashTable 
 * @author  Mandy
 * @version 1.0  
 * @since JDK 1.6.0_21 
 * 文件名称：HashTabelShow3.java 
 * 类说明： 
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import mandy.unil.gui.IllegalInput;
import baseLogic.LinerHT;

/** 
 * 创建时间：2012-2-11 上午12:48:17 
 * 项目名称：HashTable 
 * @author daniel 
 * @version 1.0  
 * @since JDK 1.6.0_21 
 * 文件名称：HashTableShow2.java 
 * 类说明： 演示和操作在同一窗口内分左右两块
 */
public class ShowHashTabel implements ActionListener {

	private static final long serialVersionUID = 8971155185655422572L;
	JFrame frame;
	LinerHT lht;
	JPanel p1, p2, show, control;
	JLabel contain;
	JButton resetD, run,reStart;
	JTextField num;
	JComboBox operate;
	// JCheckBox singalStep,oneStep;
	JRadioButton singalStep, oneStep;
	ButtonGroup step;
	JPanel show1, show2, bottom;
	JLabel label1, label2, note;
	JButton next;
	String Search = "Search", Insert = "Insert", Delete = "Delete";

	String operateMsg = Search, numMsg, buttonMsg,stepMsg = "Run in One Step";
	String []currentStep,currentContain;
	
	int[] Num;
	int stepNum;
	private int totalStep;

	ShowHashTabel() {

	}

	ShowHashTabel(LinerHT lht) {
		this.lht = lht;
		this.lht.ht3=this;
	}

	
	public void show() {
		frame = new JFrame();

		// p1
		p1 = new JPanel();
		show = new JPanel();
		control = new JPanel();
		contain = new JLabel();
		contain.setText(lht.show());// 如何设置字体大小????
		run = new JButton("Run");
		run.addActionListener(this);
		resetD = new JButton("Reset D");
		resetD.addActionListener(this);
		reStart=new JButton("ReStart");
		reStart.addActionListener(this);
		num = new JTextField();
		num.setColumns(10);
		num.addActionListener(this);
		note = new JLabel("(请输入关建字,当插入多个关键字时请以空格隔开！)");
		// 单选按钮
		oneStep = new JRadioButton("Run in One Step", true);
		singalStep = new JRadioButton("Run by Singal Step", false);
		oneStep.addActionListener(this);
		singalStep.addActionListener(this);
		// 按钮组
		step = new ButtonGroup();
		step.add(oneStep);
		step.add(singalStep);
		// 下拉选框
		operate = new JComboBox();
		operate.addItem(Search);
		operate.addItem(Insert);
		operate.addItem(Delete);
		operate.setEditable(false);
		operate.addActionListener(this);

		JPanel pa1 = new JPanel();
		JPanel pa2 = new JPanel();
		JPanel pa3 = new JPanel();
		pa1.add(operate);
		pa1.add(num);
		pa1.add(note);
		pa2.add(oneStep);
		pa2.add(singalStep);
		pa3.add(run);
		pa3.add(resetD);
		pa3.add(reStart);
		control.setLayout(new GridLayout(3, 1));
		control.add(pa1);
		control.add(pa2);
		control.add(pa3);
		control.setBorder(new LineBorder(Color.black));
		// show.setLayout(new BorderLayout());
		//补一个label
		JLabel l=new JLabel("多步执行下当前散列状态：");
		show.setLayout(new GridLayout(2, 1));
		show.add(l);
		JPanel p=new JPanel();
		p.add(contain);
		show.add(p);
		show.setBorder(new LineBorder(Color.black));

		p1.setLayout(new GridLayout(2, 1));
		p1.add(show);
		p1.add(control);
		p1.setBorder(new LineBorder(Color.black));

		// p2
		p2 = new JPanel();

		bottom = new JPanel();
		next = new JButton("NextStep");
		next.setEnabled(false);
		next.addActionListener(this);
		bottom.add(next);
		label1 = new JLabel();
		label2 = new JLabel();
		show1 = new JPanel();
		show2 = new JPanel();
		JLabel ll=new JLabel("单步执行下当前散列状态：");
		JPanel pp=new JPanel();
		label1.setText("");
		pp.add(label1);
		show1.setLayout(new GridLayout(2, 1));
		show1.add(ll);
		show1.add(pp);
		show2.add(label2);
		show1.setBorder(new LineBorder(Color.black));
		show2.setBorder(new LineBorder(Color.black));
		bottom.setBorder(new LineBorder(Color.black));

		p2.setLayout(new GridLayout(3, 1));
		p2.add(show1);
		p2.add(show2);
		p2.add(bottom);
		p2.setBorder(new LineBorder(Color.black));

		frame.setLayout(new GridLayout(1, 2));
		frame.add(p1);
		frame.add(p2);
		frame.setTitle("HashTable");
		frame.setBounds(300, 150, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	public void drawStep(String s1,String s2){
		label1.setText(s1);
		label2.setText(s2);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		// 读取单选按钮值
		if (obj instanceof JRadioButton) {
			stepMsg = e.getActionCommand();
		}
		// 读取操作operate
		if (obj instanceof JComboBox) {
			operateMsg = (String) operate.getSelectedItem();
		}

		if (obj instanceof JButton) {
			buttonMsg = e.getActionCommand();
			System.out.println(buttonMsg);

			if (buttonMsg.equals("Run")) {
				// 读取关键值Num
				numMsg = num.getText();
				String str = numMsg.replace(" ", "");
				if (!IllegalInput.checkInt1(str)) {
					IllegalInput.wornDialog("请输入正整数！");
					num.setText("");
				} else {
					String[] key = numMsg.split(" ");
					Num = new int[key.length];
					for (int i = 0; i < key.length; i++) {
						Num[i] = Integer.parseInt(key[i]);
					}

					if (stepMsg.equals("Run in One Step")) {
						// 一步执行
						next.setEnabled(false);
						lht.operate(operateMsg, Num);
						lht.currentStep="";
						lht.currentContain="";
					} else {
						// 单步执行
						next.setEnabled(true);
						lht.operate(operateMsg, Num);
						currentStep=lht.currentStep.split("!");

						currentContain=lht.currentContain.split("!");//
						totalStep=(currentStep.length-currentContain.length>0?currentStep.length:currentContain.length );
						stepNum=1;
						label1.setText(currentStep[1]);
						label2.setText(operateMsg+"“"+numMsg+"”");
					}
					contain.setText(lht.show());
				}
			} else {
			//重置D
			if (buttonMsg.equals("Reset D")) {
				frame.dispose();
				new SetD();
			}
			//清空散列
            if(buttonMsg.equals("ReStart")){
				lht = new LinerHT(lht.D);
				ShowHashTabel ht3 = new ShowHashTabel(lht);
				frame.dispose();
				ht3.show();	
            }
			if (buttonMsg.equals("NextStep")) {// 单步执行
				if(stepNum<totalStep){
					label1.setText(currentStep[stepNum]);
					label2.setText(currentContain[stepNum]);
					stepNum++;
				}else{
					label1.setText(lht.show());
					label2.setText("本次"+operateMsg+"操作完成");
					next.setEnabled(false);
					lht.currentStep="";
					lht.currentContain="";
				}
				
			}
			}
		}
	}

	public static void main(String[] args) {
		ShowHashTabel ht = new ShowHashTabel(new LinerHT(10));
		ht.show();
		
		
		// for(int i:ht.Num){
		// System.out.println(i+" ");
		// }
		
		
		//String.split()不能识别特殊字符“*”,“$”...能识别“ ”,“!”,“[a-z]”...
		
//		String s="*[ ][( )][ ][ ][ ][ ][ ][ ][ ][ ]*[ ][( )][ ][ ][ ][ ][ ][ ][ ][ ]*[ ][(1)][ ][ ][ ][ ][ ][ ][ ][ ]*[ ][1][( )][ ][ ][ ][ ][ ][ ][ ]*[ ][1][( )][ ][ ][ ][ ][ ][ ][ ]*[ ][1][(2)][ ][ ][ ][ ][ ][ ][ ]*[ ][(1)][2][ ][ ][ ][ ][ ][ ][ ]*";
		/*String s="as!a!d!f";
		String []a=s.split("!");
		for(int i=0;i<a.length;i++){
		System.out.println(a[i]);
		}*/
	}

}
