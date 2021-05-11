import java.io.*;
class Rei {
  public static void main(String[] arg) throws ParseException {
    final Parser parser = new Parser(new InputStreamReader(System.in));
    try{
        parser.start();
        System.out.println("Accept");
    }catch(Exception e){
        System.out.println("Reject");
    }
  }
}
