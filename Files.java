import java.io.*;
import java.util.Scanner;
import java.io.*;

public class Files {

   
	public static void main(String args[]){
	
	 try{
		BufferedReader reader = new BufferedReader(new FileReader("ques.txt"));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		System.out.println(lines);
		String text = lines + " 2+2 = 4-1 = 3 ... Quick Maths";
       		 FileWriter fWriter;
       		 BufferedWriter writer;
        
	try {
          	fWriter = new FileWriter("ques.txt", true);
          	writer = new BufferedWriter(fWriter);
          	writer.write(text);
          	writer.newLine();
         	 writer.close();
        }catch(Exception e)
	{
		System.out.println("Error");
	}
	

	}catch(Exception e)
	{
		System.out.println("Error");
	}
	

}
}

/*public class Files {

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        String text = "2+2 = 4-1 = 3 ... Quick Maths";
        FileWriter fWriter;
        BufferedWriter writer;
        try {
          fWriter = new FileWriter("text.txt");
          writer = new BufferedWriter(fWriter);
          writer.write(text);
          writer.newLine();
          writer.close();
          System.err.println("Your input of " + text.length() + " characters was saved.");
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

} */

/*public class AppendToFileExample {

	private static final String FILENAME = "E:\\test\\filename.txt";

	public static void main(String[] args) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String data = " This is new content";

			File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}

}*/




/*****************************************************************************TO FIND THE NUMBER OF LINES *************************************************


BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
int lines = 0;
while (reader.readLine() != null) lines++;
reader.close();

 		or

while (file.hasNextLine()) {
  count++;
  file.nextLine();
}*/
