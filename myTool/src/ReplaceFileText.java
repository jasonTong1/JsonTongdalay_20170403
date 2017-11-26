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
            //1、创建输入流对,负责读取D:/ 我的青春谁做主.txt文件  
//            fis = new FileInputStream("D:/我的青春谁做主.txt");  
//            //2、创建输出流对象  
//            fos = new FileOutputStream("D:/我的青春谁做主2.txt",true);  
//            //3、创建中转站数组,存放每次读取的内容  
//            byte[] words=new byte[1024];  
//            //4、通过循环实现文件读取  
//            while((fis.read())!=-1){  
//                fis.read(words);  
//                fos.write(words, 0, words.length);  
        	
        	  FileReader fr = new FileReader("D:\\我的青春谁做主.txt");
        	   BufferedReader bf = new BufferedReader(fr);
        	   String valueString = null;
        	   while ((valueString=bf.readLine())!=null){
        	    
        	    
        	    System.out.println(valueString);
        	   }
//            }  
            System.out.println("复制完成，请查看文件！");        
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            //5、关闭流  
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

