package food_ordering;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Order extends Application
{
   static Stage stage1 = new Stage();
   static Stage stage2 = new Stage();
   static Stage stage3 = new Stage();

   static BubbleTeaController c1;
   static NoodleController c2;
   static BentoController c3;

   @Override
   public void start (Stage stage) throws Exception
   {
      FXMLLoader r1 = new FXMLLoader(getClass().getResource("BubbleTea.fxml"));
      FXMLLoader r2 = new FXMLLoader(getClass().getResource("Noodle.fxml"));
      FXMLLoader r3 = new FXMLLoader(getClass().getResource("Bento.fxml"));

      Parent root1 = r1.load();
      Parent root2 = r2.load();
      Parent root3 = r3.load();

      c1 = r1.getController();
      c2 = r2.getController();
      c3 = r3.getController();

      Scene scene1 = new Scene(root1);
      Scene scene2 = new Scene(root2);
      Scene scene3 = new Scene(root3);

      stage1.setScene(scene1);
      stage2.setScene(scene2);
      stage3.setScene(scene3);

      show1();
   }

   public static void main (String[] args)
   {
      launch(args);
   }

   public static void show1 ()
   {
      stage1.show();
      stage2.hide();
      stage3.hide();
   }

   public static void show2 ()
   {
      stage1.hide();
      stage2.show();
      stage3.hide();
   }

   public static void show3 ()
   {
      stage1.hide();
      stage2.hide();
      stage3.show();
   }

}
