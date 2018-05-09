package food_ordering;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class BentoController implements Initializable
{
   @Override
   public void initialize (URL url, ResourceBundle rb)
   {

   }

   @FXML
   private RadioButton small;
   @FXML
   private RadioButton medium;
   @FXML
   private RadioButton large;
   @FXML
   private RadioButton bulgogi;
   @FXML
   private RadioButton chicken;
   @FXML
   private RadioButton tofu;

   @FXML
   private CheckBox soy;
   @FXML
   private CheckBox hoisin;
   @FXML
   private CheckBox garlic;
   @FXML
   private CheckBox vegeterian;
   @FXML
   private CheckBox kimchi;
   @FXML
   private CheckBox curry;

   @FXML
   private TextField tquantity;
   @FXML
   private GridPane bentoGrid;

   @FXML
   public void addBento ()
   {
      int quantity = Integer.parseInt(tquantity.getText());
      Bento bento = new Bento(quantity);

      if (small.isSelected()) {
         bento.setSelectedSize(small.getText().substring(0, 5));
         System.out.println("Small size selected");
      }
      if (medium.isSelected()) {
         bento.setSelectedSize(medium.getText().substring(0, 6));
         System.out.println("Medium size selected");
      }
      if (large.isSelected()) {
         bento.setSelectedSize(large.getText().substring(0, 5));
         System.out.println("Large size selected");
      }

      if (bulgogi.isSelected()) {
         bento.setSelectedBento(bulgogi.getText());
         System.out.println("Bulgogi selected\n");
      }
      if (chicken.isSelected()) {
         bento.setSelectedBento(chicken.getText());
         System.out.println("Chicken selected\n");
      }
      if (tofu.isSelected()) {
         bento.setSelectedBento(tofu.getText());
         System.out.println("Tofu selected\n");
      }

      if (soy.isSelected()) {
         bento.setSelectedSauce(soy.getText());
      }
      if (hoisin.isSelected()) {
         bento.setSelectedSauce(hoisin.getText());
      }
      if (garlic.isSelected()) {
         bento.setSelectedSauce(garlic.getText());
      }
      if (vegeterian.isSelected()) {
         bento.setSelectedSauce(vegeterian.getText());
      }
      if (kimchi.isSelected()) {
         bento.setSelectedSauce(kimchi.getText().substring(0, 6));
         bento.addKimchiToSubtotal();
      }
      if (curry.isSelected()) {
         bento.setSelectedSauce(curry.getText().substring(0, 4));
         bento.addCurryToSubtotal();
      }

      OrderList.food.add(bento);
      tquantity.clear();
      small.setSelected(false);
      medium.setSelected(false);
      large.setSelected(false);
      bulgogi.setSelected(false);
      chicken.setSelected(false);
      tofu.setSelected(false);
      soy.setSelected(false);
      hoisin.setSelected(false);
      garlic.setSelected(false);
      vegeterian.setSelected(false);
      kimchi.setSelected(false);
      curry.setSelected(false);
   }

   @FXML
   public void GoToTeaPage (ActionEvent event) throws IOException
   {
      Order.show1();
   }

   @FXML
   public void GoToNoodlePage (ActionEvent event) throws IOException
   {
      Order.show2();
   }

   @FXML
   public void GoToCheckOut (ActionEvent event) throws IOException
   {
      OrderList.writeToFile();
      System.out.println("Receipt created!");
   }

}
