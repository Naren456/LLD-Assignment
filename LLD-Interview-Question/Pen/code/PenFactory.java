public  class PenFactory{

  static Pen getPen(String type , String color , String open){
        OpenCloseStrategy strategy = getOpenCloseStrategy(open);
        Refill refill = getRefill(type);
        if(type.equals("gel")){
          return new GelPen( type, color, 100, false, strategy, refill);
        }
        
        throw new IllegalArgumentException("Pen with type : " + type + " is not available");
    }
  public  static  OpenCloseStrategy getOpenCloseStrategy(String open){
      if(open.equals("cap")){
          return new Cap();
      }
      else if(open.equals("click")){
        return new Click();
      }

      throw new IllegalArgumentException("Pen with openType : " + open + " is not available");
     }

     public static Refill getRefill(String type){
        if(type.equals("gel")){
            return new GelRefill();
        }
        else if(type.equals("ballpoint")){
            return new BallPointRefill();
        }
        throw new IllegalArgumentException("Pen with refillType : " + type + " is not available");
     }
  

}