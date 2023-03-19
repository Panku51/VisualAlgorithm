package ds;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class StackImpl{
	private String stk[];
	private int top;
	public final int MAX=5;	

	public StackImpl(){
		stk = new String[MAX];
		top = -1;
	}

	public boolean isEmpty(){
		return top==-1;
	}

	public boolean isFull(){
		return top==MAX-1;
	}

	public void push(String val){
		if(isFull()){
			JOptionPane.showMessageDialog(null,"Stack Overflow.");
			return;
		}
		stk[++top]=val;
	}

	public String pop(){
		if(isEmpty()){
			JOptionPane.showMessageDialog(null,"Stack Empty.");
			return null;
		}
		return stk[top--];
	}

	public String peek(){
		if(isEmpty()){
			JOptionPane.showMessageDialog(null,"Stack Empty.");
			return null;
		}
		return stk[top];
	}

	public String[] getElements(){
		return stk;
	}

     	public int getTop(){
		return top;
	}
}

class StackPanel extends JPanel{
	private StackImpl s;

	public StackPanel(StackImpl s){
		this.s = s;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		int cellwidth = w/2;
		int cellheight = h/5 - 10;
		for(int i=0;i<s.MAX;i++){
			g.drawRect(10,i*cellheight,cellwidth,cellheight);
		}
		String elements[] = s.getElements();
		int j = s.MAX;
		for(int i=0;i<=s.getTop();i++){
			g.drawString(elements[i],20,j*cellheight-cellheight/2);
			j--;
		}
                g.drawString("top",20+cellwidth,
			(s.MAX-s.getTop())*cellheight-cellheight/2);
	}
}

class Stack extends JFrame{
	private JButton btnPush,btnPop,btnPeek,btnClose;
	private JPanel panRight;
	private StackPanel panLeft;
	private StackImpl mystk;

	public Stack(){
		btnPush = new JButton("Push");
		btnPop = new JButton("Pop");
		btnPeek = new JButton("Peek");
		btnClose = new JButton("Close");

		mystk = new StackImpl();
		panLeft = new StackPanel(mystk);

		btnPush.setBounds(10,20,100,30);
		btnPop.setBounds(10,60,100,30);
		btnPeek.setBounds(10,100,100,30);
		btnClose.setBounds(10,140,100,30);

		panRight = new JPanel();
		panRight.setLayout(null);
		panRight.add(btnPush);
		panRight.add(btnPop);
		panRight.add(btnPeek);
		panRight.add(btnClose);

		setTitle("Stack Demo");
		setSize(400,400);
		setLayout(new GridLayout(1,2));
		add(panLeft);
		add(panRight);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		ButtonHandler bh = new ButtonHandler();
		btnPush.addActionListener(bh);
		btnPop.addActionListener(bh);
		btnPeek.addActionListener(bh);
		btnClose.addActionListener(bh);
	}

	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(ae.getSource()==btnPush){
				String val = JOptionPane.showInputDialog(
						"Enter value:");
				mystk.push(val);
			}
			if(ae.getSource()==btnPop){
				String val = mystk.pop();
				if(val!=null)
					JOptionPane.showMessageDialog(null,
						"Popped element:"+val);
			}
			if(ae.getSource()==btnPeek){
				String val = mystk.peek();
				if(val!=null)
					JOptionPane.showMessageDialog(null,
						"Top element:"+val);
			}
			if(ae.getSource()==btnClose){
				dispose();
			}
			panLeft.repaint();
		}
	}

	public static void main(String args[]){
		new Stack();
	}
}

			








	






	















	


	








