import java.io.BufferedReader;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.FileReader;
import java.io.IOException;  
  
public class ReplaceFileText {  
    public static void main(String[] args) {  
        FileInputStream fis=null;  
        FileOutputStream fos=null;
        
        try {  
            //1��������������,�����ȡD:/ �ҵ��ഺ˭����.txt�ļ�  
//            fis = new FileInputStream("D:/�ҵ��ഺ˭����.txt");  
//            //2���������������  
//            fos = new FileOutputStream("D:/�ҵ��ഺ˭����2.txt",true);  
//            //3��������תվ����,���ÿ�ζ�ȡ������  
//            byte[] words=new byte[1024];  
//            //4��ͨ��ѭ��ʵ���ļ���ȡ  
//            while((fis.read())!=-1){  
//                fis.read(words);  
//                fos.write(words, 0, words.length);  
        	
        	  FileReader fr = new FileReader("D:\\�ҵ��ഺ˭����.txt");
        	   BufferedReader bf = new BufferedReader(fr);
        	   String valueString = null;
        	   while ((valueString=bf.readLine())!=null){
        	    
        	    
        	    System.out.println(valueString);
        	   }
//            }  
            System.out.println("������ɣ���鿴�ļ���");        
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            //5���ر���  
            try {  
                if(fos!=null)  
                    fos.close();  
                if(fis!=null)  
                    fis.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
              
        }  
    }  
} 

