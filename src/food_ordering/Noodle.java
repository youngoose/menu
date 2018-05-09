package food_ordering;

public class Noodle implements Food
{
   private final double PRICE_SHRIMP = 2.5;
   private final double PRICE_FISH = 2.0;
   private final double PRICE_SMALL_SIZE = 7.25;
   private final double PRICE_MEDIUM_SIZE = 8.50;
   private final double PRICE_LARGE_SIZE = 9.50;

   private String selectedSize;
   private String selectedNoodle;
   private String selectedFlavour = "";
   private String specialTopping = "";

   private int quantity = 0;
   private double selectedSizePrice = 0.0;
   private double subtotal = 0.0;

   public Noodle ()
   {
   }

   public Noodle (int quantity)
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

   public double getPRICE_SHRIMP ()
   {
      return PRICE_SHRIMP;
   }

   public double getPRICE_FISH ()
   {
      return PRICE_FISH;
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

   public void setSelectedNoodle (String noodle)
   {
      this.selectedNoodle = noodle;
   }

   public String getSelectedNoodle ()
   {
      return this.selectedNoodle;
   }

   public void setSelectedFlavour (String flavour)
   {
      switch (flavour) {
         case "EXTRA SPICY":
            this.selectedFlavour += flavour + ",  ";
            break;
         case "SESAME OIL":
            this.selectedFlavour += flavour + ",  ";
            break;
         case "CILANTRO":
            this.selectedFlavour += flavour + ",  ";
            break;
         case "VEGETERIAN":
            this.selectedFlavour += flavour + ",  ";
            break;
         case "SHRIMP":
            this.selectedFlavour += flavour + ",  ";
            break;
         case "FISH":
            this.selectedFlavour += flavour + ",  ";
            break;
      }
      this.setSubtotal();
   }

   public String getSelectedFlavour ()
   {
      return this.selectedFlavour;
   }

   public void addShrimpToSubtotal ()
   {
      this.subtotal += PRICE_SHRIMP;
   }

   public void addFishToSubtotal ()
   {
      this.subtotal += PRICE_FISH;
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
              + " Noodle                           $" + String.format("%.2f", this.getSubtotal()) + ","
              + " *" + this.selectedNoodle
              + ", "
              + " " + this.selectedFlavour;
      return output;
   }
}
