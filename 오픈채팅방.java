import java.util.HashMap;
import java.util.LinkedList;

class SolutionOpenChat {
    
    public String[] solution(String[] record) {
        HashMap<String, String> nameCard = new HashMap<>();
        LinkedList<String>chatLog = new LinkedList<>();

        for(int i=0; i<record.length; i++)
        {
            String[] splitedRecord = record[i].split(" ");
            if(splitedRecord[0].equals("Enter"))
            {
                chatLog.add(splitedRecord[1] + "님이 들어왔습니다.");
                if(!nameCard.containsKey(splitedRecord[1])) //아이디가 존재하지 않을 경우
                {
                    nameCard.put(splitedRecord[1], splitedRecord[2]);
                    continue;
                }
                if(!nameCard.get(splitedRecord[1]).equals(splitedRecord[2]))//아이디가 존재하는 경우
                {
                    nameCard.replace(splitedRecord[1], splitedRecord[2]);
                }
            }
            else if(splitedRecord[0].equals("Leave"))
            {
                chatLog.add(splitedRecord[1] + "님이 나갔습니다.");
            }
            else
            {
                nameCard.replace(splitedRecord[1], splitedRecord[2]);
            }
        }
        String[] answer = new String[chatLog.size()];
        int ansIndex = 0;
        for(String str : chatLog)
        {
            int endOfId = str.indexOf("님");
            String userId = str.substring(0, endOfId);

            answer[ansIndex++] = str.replace(userId, nameCard.get(userId));
        }
        
        return answer;
    }   

    public static void main(String[] args) {
        SolutionOpenChat solution = new SolutionOpenChat();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        for(String str : solution.solution(record))
        {
            System.out.println(str);
        }
    }
}   