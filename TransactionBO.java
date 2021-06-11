import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import com.ntu.*;


class TransactionBO extends JFrame
{
	public ShowTransactionBO(Vector vec, Vector v)
	{
		JTable jt = new JTable(vec,v);
       		JScrollPane jsp = new JScrollPane(jt);
		add(jsp);
        	setTitle("List of Transactins");
		setVisible(true);
		setSize(900,400);
	}
}


