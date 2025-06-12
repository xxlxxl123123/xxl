N = 8  # 棋盘大小
M = 9
x = 0  # 坐标
y = 0
D = 0  # 方向
count = 0  # 走法数
s = []  # 栈

def push():
    s.append({'x': x, 'y': y, 'D': D})

def pop():
    global x, y, D
    last = s.pop()
    x = last['x']
    y = last['y']
    D = last['D']

def zou():
    global x, y
    if D == 0:
        x += 1
        y += 2
    elif D == 1:
        x += 2
        y += 1
    elif D == 2:
        x += 2
        y -= 1
    elif D == 3:
        x += 1
        y -= 2

while len(s) > 0 or D < 4:
    if D < 4:
        push()
        zou()
        if x > N or y > M or x < 0 or y < 0:
            pop()
            D += 1
        else:
            if x == N and y == M:
                count += 1
                print(s)
            else:
                D = 0
    else:
        pop()
        D += 1

print(count)
