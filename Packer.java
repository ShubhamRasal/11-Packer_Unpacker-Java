import java.lang.*;
import java.io.*;
import java.security.*;
/*
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
*/
import java.util.LinkedList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Packer     
{
    public FileOutputStream out=null;
    public FileInputStream instream=null;
    LinkedList<String> chk_Sum_list;
    
    public Packer(String dname,String opname) throws Exception
    {
        out=new FileOutputStream(opname);    
        chk_Sum_list=new LinkedList<String>();// list for checksum
       // System.setProperty("user.dir",dname);
       addHeader();
        list(dname); 
     }

    public static void main(String arg[])
    {
        try{
        Packer pobj=new Packer("JAVA","shubham.txt");
        }
        catch(Exception e)
        {
            System.out.println("something went wrong !!!1");
            System.out.println(e);
            //System.out.println(e.printStacktrace());
        }
    }


    public void list(String dname ) throws Exception
    {
        File folder=new File(dname);
        String filepath=folder.getAbsolutePath();
        if(!folder.exists())
        {
            System.out.println("Folder does not exists!!");
            return ;
        }
        String arr[]=folder.list();
        for(int i=0;i<arr.length;i++)
        {
            String filepath1=filepath.concat("\\"+arr[i]);
            File temp=new File(filepath1);
            if((temp.isFile())&&(chkext(arr[i])==true)&&(chksum(filepath1)==true))
            {
                 pack(filepath1);
                filepath1=null;
            }//chkext if closed
        }//for closed
    }


    public boolean chkext(String filename)
    {
     String extension[]={".txt",".c",".cpp",".java",".pdf"};
            for(int i=0;i<extension.length;i++)
            {
                if(filename.contains(extension[i]))
                {
                    return true;            // return true if it has valid extension otherwise return false
                }
            }
            return false;           // if it has not valid extension return false
    }

    public boolean chksum(String filepath)throws Exception
    {
        String result=null;
        try{
        result=checksum(filepath);             // call to method which return checksum of file
          }catch(IOException eobj)
          {
            System.out.println("unbale to find checkSum of file \n"+eobj);            
          }
          
          if(!chk_Sum_list.contains(result))           // if checksum is not already available then goes in if
        {                                             // filter for not copy duplicate file <data_wise>
            chk_Sum_list.add(result);
            System.out.println(result);
            return true;
        }
        else                                                        // return false if checksum is duplicated
        {
            System.out.println("duplicate checksum "+result);
            return false;
        }
    }

    public String checksum(String filepath) throws IOException ,NoSuchAlgorithmException{

        MessageDigest md=MessageDigest.getInstance("MD5");
        // DigestInputStream is better, but you also can hash file like this.
        try (InputStream fis = new FileInputStream(filepath)) {
            byte[] buffer = new byte[1024];
            int nread;
            while ((nread = fis.read(buffer)) != -1) {
                md.update(buffer, 0, nread);
            }
        }

        // bytes to hex
        StringBuilder result = new StringBuilder();
        for (byte b : md.digest()) {
            result.append(String.format("%02x", b));
        }
        return result.toString();

    }


public void pack(String fname)// throws Exception
{
    
    byte buffer[]=new byte[1024];
    byte temp[]=new byte[100];
    int length;
    StringBuffer header;
    
    try{
   // System.out.println("inside pack");
    File fobj=new File(fname);
  //  System.out.println(fname);
   // String filepath=fobj.getAbsolutePath();
   // header=fobj.getPath()+" "+fobj.length();
    header=new StringBuffer(fobj.getPath()+" "+fobj.length());
    for(int i=header.length();i<100;i++)
    {
           header.append(" ");                 //     header+=" ";
    }
    String head=header.toString();
    temp=head.getBytes();
    instream =new FileInputStream(fname);
    out.write(temp,0,temp.length);
    while((length=instream.read(buffer))>0)
    {
        out.write(buffer,0,length);
       }
        instream.close();
    }catch(Exception e){System.out.println(e);}
    //System.out.println("at end of pack");
}

    public void addHeader() throws Exception    
    {
        byte temp[]=new byte[100];
        StringBuffer header=new StringBuffer("/~Marvellous~/");
        for(int i=header.length();i<100;i++)
        {
               header.append(" ");                 //     header+=" ";
        }
        String head=header.toString();
        temp=head.getBytes();
        out.write(temp,0,temp.length);
        
    }




}

