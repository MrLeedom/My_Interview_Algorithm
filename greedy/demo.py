'''
贪心算法求解:
在对问题求解时,总是做出当前看来是最好的选择,也就是说,不从整体最优上加以考虑,他所做出的是在某种意义上的局部最优解
案例:
0-1背包问题:有一个50kg的背包,现有三种物品,分别是:
A物品,重量6kg,价值8元
B物品,重量8kg,价值13元
C物品,重量10kg,价值15元
===>有经验的朋友可以想到,我肯定拿物品既轻然后价值又高的物品,也就是人们口中常说的"性价比"
=====>转换过来就是单位重量价值:A=8/6    B=13/8    C=15/10
'''
#coding=utf-8
def choose():
    beg = 50     #背包50kg
    value = 0    #已经获得的价值
    choice = []
    while beg > 0:      #如果背包还有空位,则递归
        if beg >= 8:
            beg = beg - 8
            value = value + 13
            choice.append('B')
        elif beg >= 10:   #要是选择不了B商品,则退而求其次,选择A物品
            beg = beg - 10
            value = value + 15
            choice.append('A')
        elif beg >= 6:   #常规理解中的'差'商品
            beg = beg - 6
            value = value + 8
            choice.append('C')
        else:
            break    #所有物品都选择不了的话,就强行退出
    print('remaining weight:',beg)
    print('get total value:',value)
    print('sequence:',choice)
if __name__ == "__main__":
    choose()

'''
结果是:
remaining weight: 2
get total value: 78
sequence: ['B', 'B', 'B', 'B', 'B', 'B']
显然,如果最后选择A物品,用完最后剩余的重量,获得的价值是80,所以贪心算法得到的只是次优解
'''