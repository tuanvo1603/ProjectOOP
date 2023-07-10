package editstring;



public class stringEdit {
    public stringEdit() {}

   public int compareString(String s1, String s2){
        if(s1 == null || s2 ==null) return 0;
        if(s1 == "" || s2 == "" || s1.toLowerCase() == "không có" || s2.toLowerCase() == "không có") return 0;
        if(s1.toLowerCase().contains(s2.toLowerCase())||s2.toLowerCase().contains(s1.toLowerCase())){
            return 1;
        }
       return 0;
   }



}

