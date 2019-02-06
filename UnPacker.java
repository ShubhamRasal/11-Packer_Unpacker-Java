/*******************************************************************
* Class NAME :            UnPacker
*
* DESCRIPTION :     Makes New Folder and Create Files in that Folder from PackedFile(.txt)
*
* Methods :
*            1.readHeader()
*              PARAMETERS:     --
*               OUTPUTS :    It Checks Whether Inputed File Is Right For UnPacking Files
*                              It Matches Header And Return In Boolean
*               RETURN :
                 Type:   boolean             true/false
*                Type:   int                    Error code
*            
*                PROCESS :
*                   [1]  equals()
*                   [2]  trim()
*                  
*               NOTES :   Wrong File For Unpacking Migth Not Accpted.
*                
*      @Author : Shubham Dharma Rasal
*       Date:   21 DEC 2018 
* 
*/
import java.lang.*;
import java.io.*;

public class UnPacker
{
    public FileOutputStream ostream=null;
    public FileInputStream instream=null;

    public UnPacker(String fname) throws Exception
    {

        instream=new FileInputStream(fname);
        if(readHeader())
        {   int temp=fname.lastIndexOf(".");
        System.out.println("temp:"+temp);
            String new_folder_name=fname.substring(0,temp);
            System.out.println("inside const"+new_folder_name);
            unPack(new_folder_name);
        }
        else{
            //System.out.println("wrong File!!");
        }
    }

    public static void main(String arg[])
    {
        try{
        UnPacker pobj=new UnPacker("packedonfend.txt");
        }
        catch(Exception e)
        {
            System.out.println(e);
    System.out.println("inside catch main");
        }
    }

    public void unPack(String new_folder_name) throws Exception
    {
        byte header[]=new byte[100];
        int size=0;
        byte data[];
         int length;

         System.out.println("222"); 
         File theDir = new File(new_folder_name+"Unpacked");
         System.out.println(theDir); 
         int i=1;
         while(true)
         {
            
             // if the directory does not exist, create it
                if (!theDir.exists()) {
                  //  System.out.println("creating directory: " + theDir.getName());
                            try{
                                theDir.mkdir();
                                i++;
                                break;
                                } 
                            catch(SecurityException se){
                                System.out.println("unbale to create!"); 
                                }      
                }
                else              // if folder of that name already exists then create new folder with another name ex: 1_Unpacked_Demo
                {
                    theDir = new File(new_folder_name+"_"+i+"_Unpacked");
                     i++;
                }
            }

        while((length=instream.read(header,0,100))>0)   // fetch 100 bytes from file into String header
        {
            System.out.println("555");
                String temp=new String(header); // 
                String temp2=temp.substring(temp.lastIndexOf("\\"));   //gives Exact fileName location from path
                 temp2=temp2.substring(1); // otherwise we get the extra '/' [example -> /file.txt 11]
                                
                String word[]=temp2.split(" "); //temp2.split("\\s");
                /*for(int i=0;i<word.length;i++){System.out.println(word[i]);}*/
               
                size=Integer.parseInt(word[1]);
                data=new byte[size];
              
                try{    
                    String filename2=theDir.getPath().concat("\\"+word[0]); 
                    ostream =new FileOutputStream(filename2);
                filename2=null;
                   }catch(Exception eobj)
                {
                    eobj.printStackTrace();
                }
                instream.read(data,0,size);
                ostream.write(data);
               
            }

    }//unPack closed
    
    public boolean readHeader()
    {
        byte firstHeader[]=new byte[100];
        try{

        instream.read(firstHeader,0,100);
       String myHeader="/~Marvellous~/";
       //
        if((myHeader.equals(new String(firstHeader).trim())))
        {
            return true;
        } 
    }catch(StringIndexOutOfBoundsException eobj)
    {
        System.out.println(eobj);
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    return false;
    }    

    
}// class closed



                //int rem=0;
                /*if(size>8000)
                {   int length1;
                    System.out.println(size);
                          while((length1=instream.read(data,0,8000))>0)
                          {
                              rem=size-length1;
                              System.out.println(size-length);
                              ostream.write(data,0,length1);
                              
                          }

                }
                else
                {*/
              

                      //}
                    /*int length1;while((length1=instream.read(data,0,size))>0){ostream.write(data);}*/
              