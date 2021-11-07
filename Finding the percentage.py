# if __name__ == '__main__':
def solution():
    n = int(input())
    student_marks = {}
    for _ in range(n):
        name, *line = input().split()
        scores = list(map(float, line))
        student_marks[name] = scores
    query_name = input()
    scores = student_marks.get(query_name)
    print(format(sum(scores)/len(scores), ".2f"))

print(solution())