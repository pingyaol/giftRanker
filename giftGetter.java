import java.util.Scanner;
import java.util.ArrayList; 

class giftGetter {
  private static String[][] lists = new String[20][2]; 
  private static int gift_num = 0; 
  public static void main(String[] args) {
    System.out.println("How many gifts would you like? "); 
    Scanner in = new Scanner(System.in);
    String string_num_gifts = in.nextLine(); 
    System.out.println(); 
    int total_gifts = Integer.valueOf(string_num_gifts);
    gift_num = total_gifts;
    getGifts(gift_num); 
    showRankedGifts(lists); 
  }
  
  public static void getGifts(int num_gifts) {
    Scanner in = new Scanner(System.in);
    for (int i = 0; i < num_gifts; i++) {
      // get the name of the gift 
      System.out.println("What gift would you like to receive? "); 
      String gift = in.nextLine(); 

      // get the ranking of the gift 
      System.out.println("Rank this gift on a scale of 1 through " + String.valueOf(num_gifts) + " (1 is best, 5 is worst)"); 
      String string_ranking = in.nextLine(); 
      
      try {
          int int_string_ranking = Integer.parseInt(string_ranking);
          // is a valid integer
          while (Integer.parseInt(string_ranking) > num_gifts || string_ranking.equals("0")) {
            System.out.println("Sorry, invalid number! Rank this gift on a scale of 1 through " + String.valueOf(num_gifts) + " (1 is best, 5 is worst)"); 
            string_ranking = in.nextLine(); 
          }
      }
      catch (NumberFormatException e) {
          // not a valid integer
        System.out.println("Sorry, invalid number! How much do you want this gift on a scale of 1 through " + String.valueOf(num_gifts)); 
        string_ranking = in.nextLine(); 
      }
      
      lists[i][0] = gift.toLowerCase(); 
      lists[i][1] = string_ranking; 
      System.out.println("The gift you added was " + lists[i][0] + " with a ranking of " + string_ranking); 
    }
    in.close();
  }
  
  public static void showRankedGifts(String[][] gifts) {
    String[][] toSort = gifts;
    
    for (int i = 0; i < gift_num - 1; i++) {
      for (int j = 0; j < gift_num - 1 - i; j++) {
        if (Integer.valueOf(toSort[j][1]) > Integer.valueOf(toSort[j + 1][1])) {
          String temp = toSort[j][0];
          toSort[j][0] = toSort[j + 1][0];
          toSort[j + 1][0] = temp;
          temp = toSort[j][1];
          toSort[j][1] = toSort[j + 1][1];
          toSort[j + 1][1] = temp;
        }
      }
    }
    System.out.println("Here is your list of gifts in order by rank:");
    for (int i = 0; i < gift_num; i++)  {
      System.out.print(toSort[i][1] + ". ");
      System.out.println(toSort[i][0]); 
    }  
  }
}

/*

// another method of writing the method getGifts 

public static void getGifts(int num_gifts) {
  Scanner in = new Scanner(System.in);
  int i = 0; 
  while (i < num_gifts) {
    // get the name of the gift 
    System.out.println("What gift would you like to receive? "); 
    String gift = in.nextLine(); 

    // get the ranking of the gift 
    System.out.println("Rank this gift on a scale of 1 through " + String.valueOf(num_gifts) + " (example: 1 is best, 5 is worst)"); 
    String string_ranking = in.nextLine(); 

    try {
        int int_string_ranking = Integer.parseInt(string_ranking);
        // is a valid integer
        while (Integer.parseInt(string_ranking) > num_gifts) {
          System.out.println("Sorry, invalid number! Rank this gift on a scale of 1 through " + String.valueOf(num_gifts) + " (example: 1 is best, 5 is worst)"); 
          string_ranking = in.nextLine(); 
        }
        while (string_ranking.equals("0")) {
          System.out.println("Sorry, invalid number! Rank this gift on a scale of 1 through " + String.valueOf(num_gifts) + " (example: 1 is best, 5 is worst)"); 
          string_ranking = in.nextLine(); 
        }
    }
    catch (NumberFormatException e) {
        // not a valid integer
      System.out.println("Sorry, invalid number! How much do you want this gift on a scale of 1 through " + String.valueOf(num_gifts)); 
      string_ranking = in.nextLine(); 
    }

    lists[i][0] = gift.toLowerCase(); 
    lists[i][1] = string_ranking; 
    System.out.println("The gift you added was " + lists[i][0] + " with a ranking of " + string_ranking); 
    i++; 
  }
  in.close();
}
*/ 
