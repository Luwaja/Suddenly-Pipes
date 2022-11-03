// Luke James
// 30 September 2022
// Assignment 3 - Pipe.java
// Function: Create a pipe

public class Pipe 
{
     int x, y, w, h;

     public Pipe(int x, int y)
     {
          this.x = x;
          this.y = y;
          this.w = 55;
          this.h = 500;
     } 

     boolean clickingOnPreExisting(int mousex, int mousey)
     {
          if(mousex >= x && mousex <= x+w && mousey >= y && mousey <= y+h)
               return true;
          else
               return false;
     }

     public Pipe(Json ob)
     {
          x = (int)ob.getLong("x");
          y = (int)ob.getLong("y");
          w = 55;
          h = 500;
     }
     
     Json marshal()
     {
          Json ob = Json.newObject();
          ob.add("x", x);
          ob.add("y", y);
          return ob;
     }

}
