package ds;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SelectionPanel extends JPanel{
	private int nos[],pos1,pos2,pass;
	private boolean flag;

	public SelectionPanel(int x[]){
		nos = x;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(flag){
			int w = getWidth();
			int cw = w/10 - 4;
			g.setColor(Color.PINK);
			g.fillRect(pos1*cw+4,20,cw,cw);
			g.setColor(Color.CYAN);
			g.fillRect(pos2*cw+4,20,cw,cw);
			g.setColor(Color.BLACK);
			for(int i=0;i<10;i++){
				g.drawRect(i*cw+4,20,cw,cw);
				g.drawString(Integer.toString(nos[i]),
					i*cw+10,20+cw/2);
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

class SelectionSort extends JFrame{
	private SelectionPanel panCenter;
	private JPanel panSouth;
	private JButton btnStart,btnClose;
	private MyThread t;
	private int nos[];

	public SelectionSort(){
		nos = new int[10];

		btnStart = new JButton("Start");
		btnClose = new JButton("Close");
		
		panCenter = new SelectionPanel(nos);
		
		panSouth = new JPanel();
		panSouth.setLayout(new GridLayout(1,2));
		panSouth.add(btnStart);
		panSouth.add(btnClose);

		setTitle("Selection Sort");
		setSize(450,200);
		add(panCenter,"Center");
		add(panSouth,"South");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		ButtonHandler bh = new ButtonHandler();
		btnStart.addActionListener(bh);
		btnClose.addActionListener(bh);

	}

	public void generateNos(){
		for(int i=0;i<10;i++){
			nos[i] = (int)(Math.random()*100)+1;
		}
	}

	class MyThread extends Thread{
		public void run(){
			int n = 10;
			for(int i=0;i<n-1;i++){
				panCenter.setPass(i+1);
				int jMin=i;
				for(int j=i+1;j<n;j++){
					if(nos[j]<nos[jMin]){
						jMin = j;
					}
				}
				panCenter.setPos(i,jMin);
				int t = nos[i];
				nos[i] = nos[jMin];
				nos[jMin] = t;
				panCenter.repaint();
				try{
					Thread.sleep(1000);
				}
				catch(Exception e){}
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
		}
	}

	public static void main(String args[]){
		new SelectionSort();
	}
}
