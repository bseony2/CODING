import sys
input = sys.stdin.readline

form = input()
temp =''
minus = False
result = 0
form = form.replace("\n", "")
for i in form:
    if(i != '-' and i != '+') :temp += i
    elif(i=='+' and minus == False): 
        result += int(temp)
        temp = ''
    elif(i=='+' and minus == True):
        result -= int(temp)
        temp =''
    elif(i=='-' and minus == False):
        result += int(temp)
        minus = True
        temp = ''
    else:
        result -= int(temp)
        temp = ''
if(minus == False) : result += int(temp)
else:result -= int(temp)
print(result)