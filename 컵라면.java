import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 컵라면
 */
/**
 * Inner컵라면
 */
class Schedule implements Comparable<Schedule>{
    int deadLine;
    int cupNoodle;

    public Schedule(int deadLine, int cupNoodle)
    {
        this.deadLine = deadLine;
        this.cupNoodle = cupNoodle;
    }

    @Override
    public int compareTo(Schedule o) {
        return Integer.compare(this.deadLine, o.deadLine);
    }
    
}

public class 컵라면 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Schedule[] scheduleArray;
        st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        scheduleArray = new Schedule[N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            scheduleArray[i] = new Schedule(parseInt(st.nextToken()), parseInt(st.nextToken()));
        }
        Arrays.sort(scheduleArray);

        for(int i=0; i<N; i++)
        {
            pq.add(scheduleArray[i].cupNoodle);
            if(pq.size()>scheduleArray[i].deadLine)
            {
                pq.poll();
            }
        }
        int answer= 0;
        while(!pq.isEmpty())
        {
            answer += pq.poll();
        }
        System.out.println(answer);
    }

    public static int parseInt(String st)
    {
        return Integer.parseInt(st);
    }
}

/*
7
1 6
1 7
3 2
3 1
2 4
2 5
6 1

*/