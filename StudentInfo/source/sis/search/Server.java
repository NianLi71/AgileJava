
package sis.search;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Server extends Thread {
   private BlockingQueue<Search> queue = new LinkedBlockingQueue<>(); // flaw!
    private final ResultsListener listener;
    public Server(ResultsListener listener) {
      this.listener = listener;
      start(); // start background thread, will execute "run()" method
   }

   public void run() {
      while (true) {
         try {
             execute(queue.take());
         } catch (InterruptedException e) {
             break;
         }
      }
   }

   public void add(Search search) throws Exception {
      queue.put(search);
   }

   public void shutdown() {
        this.interrupt();
   }

   private void execute(Search search) {
        search.execute();
        listener.executed(search);
   }
}