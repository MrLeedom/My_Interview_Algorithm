'''
青蛙跳问题:一只青蛙一次可以跳一级台阶,也可以跳2级台阶,求一只青蛙上n级台阶总共有多少种跳法
'''
class Frog(object):
    def __init__(self, n):
        self.mark = [0 for _ in range(n+1)]   #定义一个一维数组,初始化全为0,用来做备忘录
        print(self.dp(n))                     #开始递归
    
    def dp(self, n):
        self.m = 0          #m的含义是当前n个台阶有m种跳法
        if self.mark[n] != 0:   #先从备忘录虚招n,若不等于0,表示曾经计算过,便不用计算
            self.m = self.mark[n]    
        elif n <= 0:  #边界的处理
            if n == 0:
                self.m = 1  #这是一种可行的跳法
            else:
                self.m = 0
        else:     #以下两行用于规划转移方程式
            self.m = self.dp(n-2) + self.dp(n-1)  #当前n层台阶的解个数等于n-1台阶的解 + n-2台阶的解
        self.mark[n] = self.m   #把m放入备忘录,下次若要再次是n层台阶,则不用计算直接取备忘录的数
        return self.m
if __name__ == "__main__":
    dp = Frog(10)

        