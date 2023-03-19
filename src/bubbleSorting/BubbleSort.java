package bubbleSorting;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.View;

import javafx.scene.control.Control;

class BubblePanel extends JPanel{
	private int nos[],pos1,pos2,pass;
	private boolean flag;

	public BubblePanel(int x[]){
		nos = x;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(flag){
			int w = getWidth();
			int cw = w/10 - 4;
			g.setColor(Color.PINK);
			g.fillRect(pos1*cw+4,20,cw,cw/2-20);
			g.setColor(Color.CYAN);
			g.fillRect(pos2*cw+4,20,cw,cw/2-20);
			g.setColor(Color.BLACK);
			for(int i=0;i<10;i++){
				g.drawRect(i*cw+4,20,cw,cw/2-20);
				g.drawString(Integer.toString(nos[i]),
					i*cw+10,20+cw/3);
			}
			g.drawString("Pass:"+pass,4,10);
		}	
	}

	public void setFlag(boolean b){
		flag = b;
	}

	public void setPos(int i, int j){
		pos1 = i;
		pos2 = j;
	}

	public void setPass(int i){
		pass = i;
	}
}

class BubbleSort extends JFrame{
	private BubblePanel panCenter;
	private JPanel panSouth;
	private JButton btnStart,btnClose,btnCreate;
	private MyThread t;
	public int length=10 ;
	private int nos[];
	//JScrollBar s=new JScrollBar();  
	JScrollPane jp;


	public BubbleSort(){
		//Sorting();
	}
	public void Sorting() {
		nos = new int[length];

		btnStart = new JButton("Start");
		btnClose = new JButton("Close");
		btnCreate = new JButton("Create");
		panCenter = new BubblePanel(nos);
		
		panSouth = new JPanel();
		panSouth.setLayout(new GridLayout(1,2));
		panSouth.add(btnStart);
		panSouth.add(btnClose);
		panSouth.add(btnCreate);

		setTitle("Bubble Sort");
		setSize(450,200);
	// 	Scrollbar s = new Scrollbar();
	//	add(s);
	//	setLayout(null);
	//  setLayout(new BorderLayout());
	//  panCenter.setLayout(new GridLayout(10, 4, 10, 10));

	//  add(BorderLayout.CENTER, new JScrollPane(panCenter));
		add(panCenter,"Center");
		add(panSouth,"South");
	//  setLocationRelativeTo(null);
		setVisible(true);
		
		//jp =new JScrollPane(panSouth,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//add(s,"East");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		ButtonHandler bh = new ButtonHandler();
		btnStart.addActionListener(bh);
		btnClose.addActionListener(bh);
		btnCreate.addActionListener(bh);
	}

	public void generateNos(){
		for(int i=0;i<10;i++){
			nos[i] = (int)(Math.random()*100)+1;
		}
	}
	
	public void generateNos(int args[]){
		for(int i=0;i<length;i++){
			nos[i] = args[i];
		}
	}

	class MyThread extends Thread{
		public void run(){
			int n = 10;
			int x=0;
			int y = 150;
			int counter=0;
			JPanel[] panelHolder = new JPanel[15];
			BubblePanel[] copy= new BubblePanel[length];
			for(int i=0;i<n-1;i++){
				panCenter.setPass(i+1);
				//BubblePanel test = panCenter;
				copy[counter]=panCenter;
				//JPanel tempPan = new JPanel(); 
				panelHolder[counter] = new JPanel();
				panelHolder[counter].add(copy[counter]);
				//tempPan.add(test);
				panelHolder[counter].setBounds(x,y-150,1500,160);
				//tempPan.setBounds(x,y,450,450);
				add(panelHolder[counter]);
				y=y+80;
				counter++;
				for(int j=0;j<n-1-i;j++){
					panCenter.setPos(j,j+1);
					if(nos[j]>nos[j+1]){
						int t = nos[j];
						nos[j] = nos[j+1];
						nos[j+1] = t;
					}
					panCenter.repaint();
					try{
						Thread.sleep(1000);
					}
					catch(Exception e){}
				}
			}
			JOptionPane.showMessageDialog(null,"Sorting Complete");
			panCenter.setPos(-1,-1);
			panCenter.repaint();
		}
	}

	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(ae.getSource()==btnStart){
				generateNos();
				panCenter.setFlag(true);
				t = new MyThread();
				t.start();
			}
			if(ae.getSource()==btnClose){
				dispose();
			}
			if(ae.getSource()==btnCreate) {
				System.out.println("huh");
			    String CustomInput = JOptionPane.showInputDialog("Enter the input");
			    
			    String[] arr= CustomInput.split(",");
		    	//System.out.println(arr[0]);
		    	int CustAry[]= new int[arr.length];
		    	for(int i=0;i<arr.length;i++)
		    	{
		    		CustAry[i]= Integer.parseInt(arr[i]);
		    	}
		    	length=CustAry.length;
		    	generateNos(CustAry);
		    	panCenter.setFlag(true);
				t = new MyThread();
				t.start();
			}
		}
	}

	public static void main(String args[]){
		BubbleSort runner = new BubbleSort();
		runner.Sorting();
		//new BubbleSort();
//		View view = new View();
//		  Model model = new Model();
//		  Control control = new Control(view, model);

	}
}
