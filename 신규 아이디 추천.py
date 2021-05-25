import re 
def solution(new_id):

    a = re.sub('[^a-z\d\-\_\.]','',new_id.lower())
    a = re.sub('\.\.+','.',a)
    a = re.sub('^\.|\.$','',a)
    
    if a=="":
        a=a+"a"
        
    a = re.sub('\.$','',a[:15])
    
    while len(a)<=2:
        a=a+a[len(a)-1]
        
    return a