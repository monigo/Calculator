import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import java.util.*; 

class Solve
{ 
	public static String solve(String str) 
	{ 
		char[] arr = str.toCharArray(); 

        
	
		Stack<Double> Num_Stack = new Stack<Double>(); 

		
		Stack<Character> Op_Stack = new Stack<Character>(); 
        try{

        
            for (int i = 0; i < arr.length; i++) 
            { 
            
                if (arr[i] == ' ') 
                    continue; 
    
                StringBuilder sb = new StringBuilder();
                if (arr[i] >= '0' && arr[i] <= '9' || arr[i]=='.') { 
                    
                    while (i < arr.length && arr[i] >= '0' && arr[i] <= '9'){
                        sb.append(arr[i]); 
                        i++;
                    } 
                
                    Num_Stack.push(Double.parseDouble(sb.toString())); 
                    
                    sb.setLength(0);
                } 
    
            
                if (i<arr.length && arr[i] == '(') 
                    Op_Stack.push(arr[i]); 
    
                
                if (i<arr.length && arr[i] == ')') 
                { 
                    while (Op_Stack.peek() != '(') 
                    Num_Stack.push(resultOf(Op_Stack.pop(), Num_Stack.pop(), Num_Stack.pop())); 
                    Op_Stack.pop(); 
                } 
                if (i<arr.length && (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/')){
                   
                    while(!Op_Stack.empty() && Precedence(arr[i], Op_Stack.peek())){
                        Double I1=Num_Stack.pop();
                        Double I2=Num_Stack.pop();
                        Character CHAR=Op_Stack.pop();
                       
                        Double LC=resultOf(CHAR, I1, I2);
                        Num_Stack.push(LC);
                        
                    }
                    Op_Stack.push(arr[i]); 
                } 
            }  
            while (!Op_Stack.empty())
			Num_Stack.push(resultOf(Op_Stack.pop(), Num_Stack.pop(), Num_Stack.pop())); 
            return Num_Stack.pop().toString();
        }
        catch(Exception E){
            
            String s=new String("Error");
            return s;
        }
	} 

	
	public static boolean Precedence(char op1, char op2) 
	{ 
		if (op2 == '(' || op2 == ')') 
			return false; 
		if ((op1 == '*' || op1 == '/' || op1=='%') && (op2 == '+' || op2 == '-')) 
			return false; 
		else
			return true; 
	} 

	
	public static Double resultOf(char op, Double b, Double a) 
	{ 
		switch (op) 
		{ 
		case '+': 
			return a + b; 
		case '-': 
			return a - b; 
		case '*': 
			return a * b; 
		case '/': 
			if (b == 0) 
				throw new
				UnsupportedOperationException("Cannot divide by zero"); 
			return a / b; 
        case '%': 
			if (b == 0) 
				throw new
				UnsupportedOperationException("Cannot divide by zero"); 
			return a % b; 
		} 
		return 0.0; 
	} 

}


class Cal extends JFrame {
	
	Cal(){
		
	}
	Cal (String s){
		super(s);
	}
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    JButton plus,minus,mul,div,modulo,brackt1,brackt2,del,clear,result,square,dot,cube,root;
	JTextField t1,t2;
    JLabel l1,l2,l3,l4;
    
public void setComponents(){

	
	
	t1=new JTextField();
    t2=new JTextField();
    Font font = new Font("Courier", Font.BOLD,25);
    t1.setFont(font);
    t2.setFont(font);

    
    b0=new JButton("0");
	b1=new JButton("1");
	b2=new JButton("2");
	b3=new JButton("3");
    b4=new JButton("4");
    b5=new JButton("5");
    b6=new JButton("6");
    b7=new JButton("7");
    b8=new JButton("8");
    b9=new JButton("9");
    plus=new JButton("+");
    minus=new JButton("-");
    mul=new JButton("x");
    div=new JButton("/");
    modulo=new JButton("%");
    clear=new JButton("C");
    del = new JButton("del");
    brackt1=new JButton("(");
    brackt2=new JButton(")");
    //root=new JButton("ROOT");
    result=new JButton("=");
    //square=new JButton("^2");
    //cube=new JButton("^3");dot=new JButton(".");
	

	
	setLayout(null);
	
	

	

	
    t1.setBounds(50,200,400,50);
    t2.setBounds(50,250,400,50);

    //root.setBounds(50,350,100,50);
	clear.setBounds(150,350,100,50);
    del.setBounds(250,350,100,50);
    //modulo.setBounds(350,350,100,50);
    
	b1.setBounds(50,400,100,50);
	b2.setBounds(150,400,100,50);
	b3.setBounds(250,400,100,50);   plus.setBounds(350,400,100,50);
    b4.setBounds(50,450,100,50);
    b5.setBounds(150,450,100,50);
	b6.setBounds(250,450,100,50);   minus.setBounds(350,450,100,50);
	b7.setBounds(50,500,100,50);
    b8.setBounds(150,500,100,50);
    b9.setBounds(250,500,100,50);   mul.setBounds(350,500,100,50);
    b0.setBounds(150,550,100,50);
    brackt1.setBounds(50,550,100,50);
    brackt2.setBounds(250,550,100,50); div.setBounds(350,550,100,50);
    modulo.setBounds(50,350,100,50);
    //square.setBounds(150,600,100,50);
    //cube.setBounds(250,600,100,50);
    result.setBounds(350,350,100,50);


	
	
	add(b1);
	add(b2);
	add(b3);
    add(b4);
    add(b5);
	add(b6);
	add(b7);
    add(b8);
    add(b9);
    add(b0);
    add(brackt1);
    add(brackt2);
    add(result);add(modulo);add(div);add(mul);add(minus);add(plus);
    add(clear);add(del);

	add(t1);
	add(t2);
	
    result.addActionListener(new HandlerClass());
    b0.addActionListener(new HandlerClass0());
    b1.addActionListener(new HandlerClass1());
    b2.addActionListener(new HandlerClass2());
    b3.addActionListener(new HandlerClass3());
    b4.addActionListener(new HandlerClass4());
    b5.addActionListener(new HandlerClass5());
    b6.addActionListener(new HandlerClass6());
    b7.addActionListener(new HandlerClass7());
    b8.addActionListener(new HandlerClass8());
    b9.addActionListener(new HandlerClass9());
    plus.addActionListener(new HandlerClass10());
    minus.addActionListener(new HandlerClass11());
    mul.addActionListener(new HandlerClass12());
    div.addActionListener(new HandlerClass13());
    modulo.addActionListener(new HandlerClass14());
    clear.addActionListener(new HandlerClass15());
    brackt1.addActionListener(new HandlerClass16());
    brackt2.addActionListener(new HandlerClass17());
    //dot.addActionListener(new HandlerClass18());
    del.addActionListener(new HandlerClass21());
    
    
	
	
}
    StringBuilder sb=new StringBuilder("");
    String s;


class HandlerClass implements ActionListener{
	public void actionPerformed(ActionEvent e){
        //s=t2.getText();
        /*System.out.println(sb);
        EvaluateString es=new EvaluateString();
        int ans=es.evaluate(sb.toString());
        String ans_string=Integer.toString(ans);
        t1.setText(ans_string);*/
        //sb.setLength(0);
      
        t1.setText(new Solve().solve(sb.toString()));
	}
}

class HandlerClass0 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("0");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass1 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("1");
        t2.setText(sb.toString());
        
    }
}

class HandlerClass2 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("2");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass3 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("3");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass4 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("4");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass5 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("5");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass6 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("6");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass7 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("7");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass8 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("8");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass9 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("9");
        t2.setText(sb.toString());
        
    }
}

class HandlerClass10 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("+");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass11 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("-");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass12 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("*");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass13 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("/");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass14 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("%");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass15 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.setLength(0);
        t2.setText(sb.toString());
        t1.setText(sb.toString());
    }
}
class HandlerClass16 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append("(");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass17 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append(")");
        t2.setText(sb.toString());
        
    }
}
class HandlerClass18 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        sb.append(".");
        t2.setText(sb.toString());
        
    }
}


class HandlerClass21 implements ActionListener{
	public void actionPerformed(ActionEvent e){
        //del button
        int n=sb.length();
        if(n>=1){
            String str=sb.substring(0,n-1);
            sb.setLength(0);
            sb.append(str);
            t2.setText(sb.toString());
        }
    }
}

	public static void main(String[] args) {
		
		Cal jf = new Cal("MY FIRST WINDOW");
		
		jf.setVisible(true);
		
		jf.setSize(500,800);
		
		jf.setComponents();
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}