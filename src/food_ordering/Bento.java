package food_ordering;

public class Bento implements Food
{
   private final double PRICE_KIMCHI = 1.0;
   private final double PRICE_CURRY = 1.5;
   private final double PRICE_SMALL_SIZE = 8.25;
   private final double PRICE_MEDIUM_SIZE = 9.15;
   private final double PRICE_LARGE_SIZE = 9.79;

   private String selectedSize;
   private String selectedBento;
   private String selectedSauce = "";
   private String specialTopping = "";

   private int quantity = 0;
   private double selectedSizePrice = 0.0;
   private double subtotal = 0.0;

   public Bento ()
   {
   }

   public Bento (int quantity)
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

   public double getPRICE_KIMCHI ()
   {
      return PRICE_KIMCHI;
   }

   public double getPRICE_CURRY ()
   {
      return PRICE_CURRY;
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

   public void setSelectedBento (String Bento)
   {
      this.selectedBento = Bento;
   }

   public String getSelectedBento ()
   {
      return this.selectedBento;
   }

   public void setSelectedSauce (String sauce)
   {
      switch (sauce) {
         case "SOY":
            this.selectedSauce += sauce + ",  ";
            break;
         case "HOISIN":
            this.selectedSauce += sauce + ",  ";
            break;
         case "GARLIC":
            this.selectedSauce += sauce + ",  ";
            break;
         case "VEGETERIAN":
            this.selectedSauce += sauce + ",  ";
            break;
         case "KIMCHI":
            this.selectedSauce += sauce + ",  ";
            break;
         case "CURRY":
            this.selectedSauce += sauce + ",  ";
            break;
      }
      this.setSubtotal();
   }

   public String getSelectedSauce ()
   {
      return this.selectedSauce;
   }

   public void addKimchiToSubtotal ()
   {
      this.subtotal += PRICE_KIMCHI;
   }

   public void addCurryToSubtotal ()
   {
      this.subtotal += PRICE_CURRY;
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
              + " Bento                            $" + String.format("%.2f", this.getSubtotal()) + ","
              + " *" + this.selectedBento
              + ", "
              + " " + this.selectedSauce;
      return output;
   }
}
