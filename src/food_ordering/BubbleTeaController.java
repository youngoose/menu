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

public class BubbleTeaController implements Initializable
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
   private RadioButton jasmine;
   @FXML
   private RadioButton black;
   @FXML
   private RadioButton earl;

   @FXML
   private CheckBox milk;
   @FXML
   private CheckBox cream;
   @FXML
   private CheckBox honey;
   @FXML
   private CheckBox hazelnut;
   @FXML
   private CheckBox javachip;
   @FXML
   private CheckBox fruit;

   @FXML
   private TextField tquantity;
   @FXML
   private GridPane bubbleTeaGrid;

   @FXML
   public void addBubbleTea ()
   {
      int quantity = Integer.parseInt(tquantity.getText());
      BubbleTea tea = new BubbleTea(quantity);

      if (small.isSelected()) {
         tea.setSelectedSize(small.getText().substring(0, 5));
         System.out.println("Small size selected");
      }
      if (medium.isSelected()) {
         tea.setSelectedSize(medium.getText().substring(0, 6));
         System.out.println("Medium size selected");
      }
      if (large.isSelected()) {
         tea.setSelectedSize(large.getText().substring(0, 5));
         System.out.println("Large size selected");
      }

      if (jasmine.isSelected()) {
         tea.setSelectedTea(jasmine.getText());
         System.out.println("Jasmine selected\n");
      }
      if (black.isSelected()) {
         tea.setSelectedTea(black.getText());
         System.out.println("Black selected\n");
      }
      if (earl.isSelected()) {
         tea.setSelectedTea(earl.getText());
         System.out.println("Earl selected\n");
      }

      if (milk.isSelected()) {
         tea.setSelectedFlavour(milk.getText());
      }
      if (cream.isSelected()) {
         tea.setSelectedFlavour(cream.getText());
      }
      if (honey.isSelected()) {
         tea.setSelectedFlavour(honey.getText());
      }
      if (hazelnut.isSelected()) {
         tea.setSelectedFlavour(hazelnut.getText());
      }
      if (javachip.isSelected()) {
         tea.setSelectedFlavour(javachip.getText().substring(0, 9));
         tea.addJavaChipToSubtotal();
      }
      if (fruit.isSelected()) {
         tea.setSelectedFlavour(fruit.getText().substring(0, 14));
         tea.addTropicalFruitToSubtotal();
      }

      OrderList.food.add(tea);
      tquantity.clear();
      small.setSelected(false);
      medium.setSelected(false);
      large.setSelected(false);
      jasmine.setSelected(false);
      black.setSelected(false);
      earl.setSelected(false);
      milk.setSelected(false);
      cream.setSelected(false);
      honey.setSelected(false);
      hazelnut.setSelected(false);
      javachip.setSelected(false);
      fruit.setSelected(false);

   }

   @FXML
   public void GoToNoodlePage (ActionEvent event) throws IOException
   {
      Order.show2();
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
