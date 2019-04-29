'''
主成分分析:
主要就是降维的思想,就是用较少的指标能够清晰表达事物就已经很好了,尽量减少指标,更加清晰直观,这也是现实场景中比较常见的思想
PCA的思想是将n维特征映射到k维上(k<n),这k维是全新的正交特性.这k维特征称为主成分,是重新构造出来的k维特征
基本步骤:
1.对数据进行归一化处理(代码中并非这么做,而是直接减去均值)
2.计算归一化后的数据集的协方差矩阵
3.计算协方差矩阵的特征值和特征向量
4.保留最重要的k个特征(通常k<n),可以自己制定,也可以选择个阈值,然后通过前k个特征值之和减去后面n-k个特征值之和大于这个阈值,找到这个k
5.找出k个特征值对应的特征向量
6.将m*n的数据集乘以k个n维的特征向量(n*k),得到最后降维的数据
'''
# -*- coding: utf-8 -*-
'''
 @author:leedom
 Created on Mon Jan 14 19:54:14 2019
 description:
'''


import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

#计算均值,要求输入数据为numpy的矩阵格式，行表示样本数，列表示特征    
def meanX(dataX):
    return np.mean(dataX,axis=0)#axis=0表示按照列来求均值，如果输入list,则axis=1


#计算方差,传入的是一个numpy的矩阵格式，行表示样本数，列表示特征    
def variance(X):
    m, n = np.shape(X)
    mu = meanX(X)
    muAll = np.tile(mu, (m, 1))    
    X1 = X - muAll
    print(X1)
    variance = 1./m * np.diag(X1.T * X1)
    return variance

#标准化,传入的是一个numpy的矩阵格式，行表示样本数，列表示特征    
def normalize(X):
    m, n = np.shape(X)
    mu = meanX(X)
    muAll = np.tile(mu, (m, 1))    
    X1 = X - muAll
    X2 = np.tile(np.diag(X.T * X), (m, 1))
    XNorm = X1/X2   #相当于除以矩阵平方
    return XNorm

"""
参数：
	- XMat：传入的是一个numpy的矩阵格式，行表示样本数，列表示特征    
	- k：表示取前k个特征值对应的特征向量
返回值：
	- finalData：参数一指的是返回的低维矩阵，对应于输入参数二
	- reconData：参数二对应的是移动坐标轴后的矩阵
"""  
def pca(XMat, k):
    average = meanX(XMat) 
    m, n = np.shape(XMat)
    data_adjust = []
    avgs = np.tile(average, (m, 1))
    data_adjust = XMat - avgs      #步骤1
    covX = np.cov(data_adjust.T)   #步骤2,计算协方差矩阵
    featValue, featVec=  np.linalg.eig(covX)  #步骤3,求解协方差矩阵的特征值和特征向量
    index = np.argsort(-featValue) #按照featValue进行从大到小排序
    finalData = []
    if k > n:
        print("k must lower than feature number")
        return
    else:
        #注意特征向量时列向量，而numpy的二维矩阵(数组)a[m][n]中，a[1]表示第1行值
        selectVec = np.matrix(featVec.T[index[:k]]) #所以这里需要进行转置,这一块比较村名
        finalData = data_adjust * selectVec.T    #降维后的数据
        reconData = (finalData * selectVec) + average  
    return finalData, reconData

def loaddata(datafile):
    return np.array(pd.read_csv(datafile,sep="\s+",header=-1)).astype(np.float)


def plotBestFit(data1, data2):	  
    dataArr1 = np.array(data1)
    dataArr2 = np.array(data2)
    
    m = np.shape(dataArr1)[0]
    axis_x1 = []
    axis_y1 = []
    axis_x2 = []
    axis_y2 = []
    for i in range(m):
        axis_x1.append(dataArr1[i,0])
        axis_y1.append(dataArr1[i,1])
        axis_x2.append(dataArr2[i,0]) 
        axis_y2.append(dataArr2[i,1])				  
    fig = plt.figure()
    ax = fig.add_subplot(111)
    ax.scatter(axis_x1, axis_y1, s=50, c='red', marker='s')
    ax.scatter(axis_x2, axis_y2, s=50, c='blue')
    plt.xlabel('x1'); plt.ylabel('x2');
    plt.savefig("outfile.png")
    plt.show()	

#简单测试
#数据来源：http://www.cnblogs.com/jerrylead/archive/2011/04/18/2020209.html
def test():
    X = [[2.5, 0.5, 2.2, 1.9, 3.1, 2.3, 2, 1, 1.5, 1.1],
         [2.4, 0.7, 2.9, 2.2, 3.0, 2.7, 1.6, 1.1, 1.6, 0.9]]
    XMat = np.matrix(X).T  
    k = 2
    result1,result2 = pca(XMat, k)
    plotBestFit(result1, result2)
    return 

#根据数据集data.txt
def main():    
    datafile = "data.txt"
    XMat = loaddata(datafile)
    k = 2
    return pca(XMat, k)
    
if __name__ == "__main__":
    finalData, reconMat = main()
    plotBestFit(finalData, reconMat)
    # test()

