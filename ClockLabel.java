import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.*;
import java.io.*;

public class ClockLabel extends JLabel implements ActionListener
{
    String type;
    SimpleDateFormat sdf;
    


    public ClockLabel(String type)
    {
        this.type=type;
        setForeground(Color.green);

        switch(type)
        {
            case "date":sdf=new SimpleDateFormat("dd MMMM YYYY");
            setFont(new Font("sans-serif",Font.PLAIN , 12));
            setHorizontalAlignment(SwingConstants.LEFT);
            break;

            case "time":sdf=new SimpleDateFormat("hh:mm:ss a");
            setFont(new Font("sans-serif",Font.PLAIN , 40));
            setHorizontalAlignment(SwingConstants.CENTER);
            break;

            case "day":sdf=new SimpleDateFormat("EEEE");
            setFont(new Font("sans-serif",Font.PLAIN , 16));
            setHorizontalAlignment(SwingConstants.RIGHT);
            break;

            default:sdf=new SimpleDateFormat();
            break;
        }

        Timer t=new Timer(1000,this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae)
    {
        Date d=new Date();
        setText(sdf.format(d));

    }


}
