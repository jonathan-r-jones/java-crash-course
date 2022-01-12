 class FirstUniqueCharacter {
    public static void main (String[] args) {
      Boolean iIsUniqueCharacter = true;
      String s = "loveleetcode";
      for (int i = 0; i < s.length(); i++) {
        iIsUniqueCharacter = true;
        System.out.println("-------- I Character at Position " + i + " = " + s.charAt(i));
        for (int j = 0; j < s.length(); j++) {
          System.out.println("J Character at Position " + j + " = " + s.charAt(j));
          if (i == j) {
            continue;
          }
          if (s.charAt(i) == s.charAt(j)) {
            System.out.println("**** I equals J at Position (a duplicate) " + j + " = " + s.charAt(j));
            iIsUniqueCharacter = false;
            continue;
          }
        } // for j
        if (iIsUniqueCharacter) {
          System.out.println("************************************** Unique I at Position " + i + " = " + s.charAt(i));
          break;
        }
      } // for i
      if (iIsUniqueCharacter == false) {
        System.out.println("************************************** No unique characters found.");
      }
    }
}