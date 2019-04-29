'''
经典的金矿问题:
国王派人挖金矿
'''
class GoldHouse(object):
    def __init__(self, n, m,propleneed, gold):  #n是总人数,m是金矿数
        self.peopleneed = peopleneed    #每一个金矿开挖需要的人数
        self.gold = gold                #每一个金矿的金矿数
        self.maxgold = [[-1 for i in range(n)] for i in range(m)]  #初始化备忘录,创建一个m行n列的二维数组
        print(self.getmaxgold(n,m))     #n,m减1是因为数组是从0开始
    
    def getmaxgold(self, n, m):
        if self.maxgold[m-1][n-1] != -1:
            retmaxgold = self.maxgold[m-1][n-1]
        elif m== 0:
            if(n >= self.peopleneed[m-1]):
                retmaxgold = self.gold[m-1]
            else:
                retmaxgold = 0
        elif n >= self.peopleneed[m-1]:
            retmaxgold = max(self.getmaxgold(n-self.peopleneed[m-1], m-1) + self.gold[m-1], self.getmaxgold(n, m-1))
        else:
            retmaxgold = self.getmaxgold(n, m-1)
        self.maxgold[m-1][n-1] = retmaxgold
if __name__ == "__main__":
    peopleneed = []
    gold = []
    string = input("")
    try:
        string = string.split(" ")
        n = int(string[0])
        m = int(string[1])
        for i in range(m):
            goldmount = input("")
            goldmount = goldmount.split(" ")
            peopleneed.append(int(goldmount[0]))
            gold.append(int(goldmount[1]))
    except:
        print("input format error!")
    dp = GoldHouse(n, m, peopleneed, gold)