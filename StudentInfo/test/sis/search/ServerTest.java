package sis.search;
import junit.framework.*; import sis.util.*;

public class ServerTest extends TestCase {
   private int numberOfResults = 0;
   private Server server;
   private static final long TIMEOUT = 3000L;
   private static final String[] URLS = {
           SearchTest.URL, SearchTest.URL, SearchTest.URL
   };

   protected void setUp() throws Exception {
      TestUtil.delete(SearchTest.FILE);
      LineWriter.write(SearchTest.FILE, SearchTest.TEST_HTML);

//      ResultsListener listener = new ResultsListener() {
//         public void executed(Search search) {
//            numberOfResults++;
//         }
//      };

      // use lambda
      ResultsListener listener = (search) -> numberOfResults++;

      server = new Server(listener); // 这是callback
   }

   protected void tearDown() throws Exception {
      assertTrue(server.isAlive());
      server.shutdown();
      server.join(3000);
      assertFalse(server.isAlive());

      TestUtil.delete(SearchTest.FILE);
   }

   public void testSearch() throws Exception {
      /**
       * 这里的Test是Client, 也是主线程, 主线程调用server.add方法向queue里发消息,
       * server中启动的子线程不断地从queue中消费消息,
       * 可以看出主线程和子线程通过queue来共享数据
       */
      long start = System.currentTimeMillis();
      for (String url : URLS) {
         server.add(new Search(url, "xxx"));
      }
      long elapsed = System.currentTimeMillis() - start;
      long averageLatency = elapsed / URLS.length;
      assertTrue(averageLatency < 20);
      assertTrue(waitForResults());
   }

   private boolean waitForResults() {
      long start = System.currentTimeMillis();
      while (numberOfResults < URLS.length) {
         try {
            Thread.sleep(1);
         } catch (InterruptedException e) {
         }
         if (System.currentTimeMillis() - start > TIMEOUT) {
            return false;
         }
      }
      return true;
   }
}