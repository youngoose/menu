package food_ordering;

public class BubbleTea implements Food
{
   private final double PRICE_JAVA_CHIP = 0.5;
   private final double PRICE_TROPICAL_FRUIT = 0.8;
   private final double PRICE_SMALL_SIZE = 2.99;
   private final double PRICE_MEDIUM_SIZE = 3.39;
   private final double PRICE_LARGE_SIZE = 3.79;

   private String selectedSize;
   private String selectedTea;
   private String selectedFlavour = "";
   private String specialTopping = "";

   private int quantity = 0;
   private double selectedSizePrice = 0.0;
   private double subtotal = 0.0;

   public BubbleTea ()
   {
   }

   public BubbleTea (int quantity)
   {
      this.quantity = quantity;
   }

   public void setQuantity (int quantity)
   {
      this.quantity = quantity;
   }

   public int getQuantity ()
   {
      return this.quantity;
   }

   public double getPRICE_JAVA_CHIP ()
   {
      return PRICE_JAVA_CHIP;
   }

   public double getPRICE_TROPICAL_FRUIT ()
   {
      return PRICE_TROPICAL_FRUIT;
   }

   public double getPRICE_SMALL_SIZE ()
   {
      return PRICE_SMALL_SIZE;
   }

   public double getPRICE_MEDIUM_SIZE ()
   {
      return PRICE_MEDIUM_SIZE;
   }

   public double getPRICE_LARGE_SIZE ()
   {
      return PRICE_LARGE_SIZE;
   }

   public void setSelectedSize (String size)
   {
      this.selectedSize = size;
      switch (this.selectedSize) {
         case "Small":
            this.selectedSizePrice = this.PRICE_SMALL_SIZE;
            break;
         case "Medium":
            this.selectedSizePrice = this.PRICE_MEDIUM_SIZE;
            break;
         case "Large":
            this.selectedSizePrice = this.PRICE_LARGE_SIZE;
            break;
      }
   }

   public String getSelectedSize ()
   {
      return this.selectedSize;
   }

   public double getSelectedSizePrice ()
   {
      return selectedSizePrice;
   }

   public void setSelectedTea (String tea)
   {
      this.selectedTea = tea;
   }

   public String getSelectedTea ()
   {
      return this.selectedTea;
   }

   public void setSelectedFlavour (String flavour)
   {
      switch (flavour) {
         case "MILK":
            this.selectedFlavour += flavour + ",  ";
            break;
         case "CREAM":
            this.selectedFlavour += flavour + ",  ";
            break;
         case "HONEY":
            this.selectedFlavour += flavour + ",  ";
            break;
         case "HAZELNUT":
            this.selectedFlavour += flavour + ",  ";
            break;
         case "JAVA CHIP":
            this.selectedFlavour += flavour + ",  ";
            break;
         case "TROPICAL FRUIT":
            this.selectedFlavour += flavour + ",  ";
            break;
      }
      this.setSubtotal();
   }

   public String getSelectedFlavour ()
   {
      return this.selectedFlavour;
   }

   public void addJavaChipToSubtotal ()
   {
      this.subtotal += PRICE_JAVA_CHIP;
   }

   public void addTropicalFruitToSubtotal ()
   {
      this.subtotal += PRICE_TROPICAL_FRUIT;
   }

   public void setSubtotal ()
   {
      this.subtotal = this.getSelectedSizePrice() * this.getQuantity();
   }

   @Override
   public double getSubtotal ()
   {
      return this.subtotal;
   }

   @Override
   public String toString ()
   {
      String output = "";
      output = " " + this.selectedSize
              + " Bubble Tea                       $" + String.format("%.2f", this.getSubtotal()) + ","
              + " *" + this.selectedTea + ", "
              + " " + this.selectedFlavour;
      return output;
   }
}
