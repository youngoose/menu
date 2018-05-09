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

public class NoodleController implements Initializable
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
   private RadioButton chowmein;
   @FXML
   private RadioButton udon;
   @FXML
   private RadioButton mifen;

   @FXML
   private CheckBox extraspicy;
   @FXML
   private CheckBox sesameoil;
   @FXML
   private CheckBox cilantro;
   @FXML
   private CheckBox vegeterian;
   @FXML
   private CheckBox shrimp;
   @FXML
   private CheckBox fish;

   @FXML
   private TextField tquantity;
   @FXML
   private GridPane noodleGrid;

   @FXML
   public void addNoodle ()
   {
      int quantity = Integer.parseInt(tquantity.getText());
      Noodle noodle = new Noodle(quantity);

      if (small.isSelected()) {
         noodle.setSelectedSize(small.getText().substring(0, 5));
         System.out.println("Small size selected");
      }
      if (medium.isSelected()) {
         noodle.setSelectedSize(medium.getText().substring(0, 6));
         System.out.println("Medium size selected");
      }
      if (large.isSelected()) {
         noodle.setSelectedSize(large.getText().substring(0, 5));
         System.out.println("Large size selected");
      }

      if (chowmein.isSelected()) {
         noodle.setSelectedNoodle(chowmein.getText());
         System.out.println("Chow Mein selected\n");
      }
      if (udon.isSelected()) {
         noodle.setSelectedNoodle(udon.getText());
         System.out.println("Udon selected\n");
      }
      if (mifen.isSelected()) {
         noodle.setSelectedNoodle(mifen.getText());
         System.out.println("Fen Ssu selected\n");
      }

      if (extraspicy.isSelected()) {
         noodle.setSelectedFlavour(extraspicy.getText());
      }
      if (sesameoil.isSelected()) {
         noodle.setSelectedFlavour(sesameoil.getText());
      }
      if (cilantro.isSelected()) {
         noodle.setSelectedFlavour(cilantro.getText());
      }
      if (vegeterian.isSelected()) {
         noodle.setSelectedFlavour(vegeterian.getText());
      }
      if (shrimp.isSelected()) {
         noodle.setSelectedFlavour(shrimp.getText().substring(0, 6));
         noodle.addShrimpToSubtotal();
      }
      if (fish.isSelected()) {
         noodle.setSelectedFlavour(fish.getText().substring(0, 4));
         noodle.addFishToSubtotal();
      }

      OrderList.food.add(noodle);
      tquantity.clear();
      small.setSelected(false);
      medium.setSelected(false);
      large.setSelected(false);
      chowmein.setSelected(false);
      udon.setSelected(false);
      mifen.setSelected(false);
      extraspicy.setSelected(false);
      sesameoil.setSelected(false);
      cilantro.setSelected(false);
      vegeterian.setSelected(false);
      shrimp.setSelected(false);
      fish.setSelected(false);
   }

   @FXML
   public void GoToTeaPage (ActionEvent event) throws IOException
   {
      Order.show1();
   }

   @FXML
   public void GoToBentoPage (ActionEvent event) throws IOException
   {
      Order.show3();
   }

   @FXML
   public void GoToCheckOut (ActionEvent event) throws IOException
   {
      OrderList.writeToFile();
      System.out.println("Receipt created!");
   }

}
