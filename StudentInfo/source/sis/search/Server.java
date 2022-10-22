
package sis.search;
import java.util.*;
public class Server extends Thread {
   private List<Search> queue = new LinkedList<Search>(); // flaw!
    private final ResultsListener listener;
    public Server(ResultsListener listener) {
      this.listener = listener;
      start(); // start background thread, will execute "run()" method
   }

   public void run() {
      while (true) {
         if (!queue.isEmpty())
            execute(queue.remove(0));
         Thread.yield();
      }
   }

   public void add(Search search) {
      queue.add(search);
   }
   private void execute(Search search) {
      search.execute();
      listener.executed(search);
   }
}