import java.io.*;
import java.util.*;
public class 코드트리채점기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int Q, turn = 0;
	static final int MAX_DOMAIN = 300;
	static int N;
	static PriorityQueue<Integer> judgers = new PriorityQueue<>();
	static PriorityQueue<Domain>[] waitingQueue = new PriorityQueue[MAX_DOMAIN];
	static PriorityQueue<Integer>[] domainPerId = new PriorityQueue[MAX_DOMAIN];
	static Map<String, Integer> domainToIdxMap = new HashMap<>();
	static boolean[] judgingDomain = new boolean[MAX_DOMAIN];
	static int[] judgerToDomainIdx = new int[MAX_DOMAIN];
	static int[] domainStart = new int[MAX_DOMAIN];
	static int[] domainEnd = new int[MAX_DOMAIN];
	static int readyCnt = 0;

	public static void main(String[] args) throws IOException {
		Q = Integer.parseInt(br.readLine());
		while (++turn <= Q) {
			st = new StringTokenizer(br.readLine(), " ");
			int order = Integer.parseInt(st.nextToken());

			switch (order) {
				case 100 :
					getReady();
					break;
				case 200 :
					require();
					break;
				case 300 :
					tryJudge();
					break;
				case 400 :
					finish();
					break;
				case 500 :
					print();
			}
		}
	}

	static void getReady() {
		N = Integer.parseInt(st.nextToken());
		String url = st.nextToken();
		String[] seperatedUrl = url.split("/");

		for (int i = 1; i <= N; i++) {
			judgers.add(i);
		}
		domainToIdxMap.put(seperatedUrl[0], domainToIdxMap.size());

		int idx = domainToIdxMap.size() - 1;
		waitingQueue[idx] = new PriorityQueue<Domain>();
		domainPerId[idx] = new PriorityQueue<>();

		waitingQueue[idx].add(new Domain(0, Integer.parseInt(seperatedUrl[1]), 0, 1));
		domainPerId[idx].add(Integer.parseInt(seperatedUrl[1]));

		readyCnt += 1;
	}

	static void require() {
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String u = st.nextToken();
		String[] seperatedUrl = u.split("/");

		String domain = seperatedUrl[0];
		int domainId = Integer.parseInt(seperatedUrl[1]);
		int idx;
		if (!domainToIdxMap.containsKey(domain)) {
			domainToIdxMap.put(domain, domainToIdxMap.size());
			idx = domainToIdxMap.size() - 1;
			waitingQueue[idx] = new PriorityQueue<Domain>();
			domainPerId[idx] = new PriorityQueue<>();
		} else {
			idx = domainToIdxMap.get(domain);
			if (domainPerId[idx].contains(domainId))
				return;
		}

		waitingQueue[idx].add(new Domain(idx, domainId, t, p));
		domainPerId[idx].add(domainId);
		readyCnt += 1;
	}

	static void tryJudge() {
		int t = Integer.parseInt(st.nextToken());

		Domain domain = null;
		for (int i = 0; i < domainToIdxMap.size(); i++) {
			if (judgingDomain[i])
				continue;
			if (t < domainStart[i] + 3 * (domainEnd[i] - domainStart[i]))
				continue;
			if (waitingQueue[i].isEmpty())
				continue;

			if (domain == null) {
				domain = waitingQueue[i].peek();
				continue;
			}

			if (waitingQueue[i].peek().p != domain.p) {
				domain = waitingQueue[i].peek().p < domain.p ? waitingQueue[i].peek() : domain;
			} else {
				domain = waitingQueue[i].peek().t < domain.t ? waitingQueue[i].peek() : domain;
			}
		}

		if (domain != null && judgers.size() != 0) {
			int judger = judgers.poll();

			judgingDomain[domain.idx] = true;
			judgerToDomainIdx[judger] = domain.idx;
			waitingQueue[domain.idx].poll();
			domainStart[domain.idx] = t;
			domainPerId[domain.idx].remove(domain.id);
			readyCnt -= 1;
		}
	}

	static void finish() {
		int t = Integer.parseInt(st.nextToken());
		int judger = Integer.parseInt(st.nextToken());

		if (judgers.contains(judger))
			return;

		int idx = judgerToDomainIdx[judger];

		judgingDomain[idx] = false;
		judgerToDomainIdx[judger] = -1;
		judgers.add(judger);
		domainEnd[idx] = t;
	}

	static void print() {
		st.nextToken();
		System.out.println(readyCnt);
	}

	static class Domain implements Comparable<Domain> {

		int idx, id, t, p;

		public Domain(int idx, int id, int t, int p) {
			this.idx = idx;
			this.id = id;
			this.t = t;
			this.p = p;
		}
		@Override
		public int compareTo(Domain domain) {
			if (this.p != domain.p)
				return this.p - domain.p;
			return this.t - domain.t;
		}
	}
}
