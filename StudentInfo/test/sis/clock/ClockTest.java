package sis.clock;

import junit.framework.TestCase;

import java.util.*;

public class ClockTest extends TestCase {
    private Clock clock;
    private Object monitor = new Object();

    public void testClock() throws Exception {
        final int seconds = 5;
        final List<Date> tics = new ArrayList<>();
        ClockListener listener = new ClockListener() {
            private int count = 0;
            @Override
            public void update(Date date) {
                tics.add(date);
                System.out.println(date);
                if (++count == seconds) {
                    synchronized (monitor) {
                        monitor.notifyAll();
                    }
                }
            }
        };

        clock = new Clock(listener);
        synchronized (monitor) {
            // block住当前Test线程,  等待monitor.notifyAll();
            // 此时Clock线程 is running
            monitor.wait();
        }
        clock.stop();
        verify(tics, seconds);
    }

    private void verify(List<Date> tics, int seconds) {
        assertEquals(seconds, tics.size());
        for (int i = 1; i < seconds; i++)
            assertEquals(1, getSecondsFromLast(tics, i));
    }

    private long getSecondsFromLast(List<Date> tics, int i) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(tics.get(i));
        int now = calendar.get(Calendar.SECOND);
        calendar.setTime(tics.get(i - 1));
        int then = calendar.get(Calendar.SECOND);
        if (now == 0)
            now = 60;
        return now - then;
    }
}
