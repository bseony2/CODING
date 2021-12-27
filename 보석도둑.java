import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석도둑 {
    
    public static void main(String[] args) throws Exception{
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석의 개수
        int K = Integer.parseInt(st.nextToken()); // 가방의 개수

        Jewel[] jewelList = new Jewel[N];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            jewelList[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(jewelList);
        
        int[] bag = new int[K];
        for(int i=0; i<K; i++)
        {
            st = new StringTokenizer(br.readLine());
            bag[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bag);
        //i는 보석., j는 가방
        for(int i=0, j=0; j<K; j++)
        {
            while(i<N && jewelList[i].weight <= bag[j])
            {
                pq.offer(jewelList[i++].value);
            }

            if(!pq.isEmpty())
            {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }
    
}


class Jewel implements Comparable<Jewel>{
    int weight;
    int value;

    public Jewel(int weight, int value)
    {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Jewel j) {
        //무게 오름차순, 무게 같으면 가치 내림차순
        if(this.weight == j.weight)
        {
            return j.value - this.value;
        }
        else
        {
            return this.weight - j.weight;
        }
    }
    
}