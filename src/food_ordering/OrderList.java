package food_ordering;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class OrderList
{
   private static final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
   public static ArrayList<Food> food = new ArrayList<Food>();

   public static void writeToFile ()
   {
      try {
         File myFile = new File("receipt.txt");
         if (!myFile.exists()) {
            myFile.createNewFile();
         }
         FileWriter fw = new FileWriter(myFile.getAbsoluteFile());
         BufferedWriter bw = new BufferedWriter(fw);

         bw.write("                Chop Chop Express");
         bw.newLine();
         bw.write("                 1123 Town Ave");
         bw.newLine();
         bw.write("                  Toronto, ON");
         bw.newLine();
         bw.write("                    T8H 5L2");
         bw.newLine();
         bw.newLine();

         Date date = new Date();
         bw.write(" Date: ");
         bw.write(dateFormat.format(date));
         bw.newLine();
         bw.write(" Cashier: Eddy");
         bw.newLine();

         for (int i = 0; i < food.size(); i++) {
            bw.write(" ----------------------------------------------");
            bw.newLine();
            bw.write(" Order#:" + (i + 1));
            bw.newLine();

            String[] tokens = food.get(i).toString().split(",");
            for (int j = 0; j < tokens.length - 1; j++) {
               bw.write(tokens[j]);
               bw.newLine();
            }
         }
         bw.write(" **********************************************");

         double subtotal = 0.0;
         for (int i = 0; i < food.size(); i++) {
            subtotal += food.get(i).getSubtotal();
         }

         bw.newLine();
         bw.write(" Subtotal                               $" + String.format("%.2f", subtotal));
         bw.newLine();
         bw.write(" Taxes(13%)                             $" + String.format("%.2f", subtotal * 0.13));
         bw.newLine();
         bw.write(" Total                                  $" + String.format("%.2f", subtotal + (subtotal * 0.13)));
         bw.newLine();
         bw.newLine();
         bw.newLine();
         bw.write("	      Thank you very much.");
         bw.newLine();
         bw.write("	         Comeback again");

         bw.close();
         fw.close();
      }
      catch (IOException e) {
         System.out.println(e);
      }
   }

}
