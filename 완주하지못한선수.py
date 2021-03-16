def solution(participant, completion):
    participant.sort()
    completion.sort()
    for i in range(len(participant)):
        if participant[i] != completion[i]:
            return participant[i]
        if i == len(participant)-2:
            return participant[i+1]

participant = []
completion = []

participant.append('marina')
participant.append('josipa')
participant.append('nikola')
participant.append('vinko')
participant.append('filipa')

completion.append('vinko')
completion.append('filipa')
completion.append('marina')
completion.append('josipa')

print(solution(participant, completion))