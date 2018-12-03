# about Algorithms and Data Structures
算法和数据结构学习

# 1.排序
## 1.1冒泡排序
BubbleSort

时间复杂度O(N*N)，额外空间复杂度O(1)

## 1.2选择排序
SelectionSort

时间复杂度O(N*N)，额外空间复杂度O(1)

## 1.3插入排序
InsertionSort

时间复杂度和数据的原始状况有关：

    1.最理想的状态原始数据就是按照从小到大排序的，这时时间复杂度为O(N);
    2.最差的状态是原始数据按照从大到小排序，这时时间复杂度度为O(N*N).
额外空间复杂度O(1)

## 1.4归并排序
MergeSort

时间复杂度O(N*logN)【以2为底N的对数】，额外空间复杂度O(N)【数组拷贝】

## 1.5小和问题
SmallSumUseMergeSort

##1.6荷兰国旗问题
NetherlandsFlag

##1.7快速排序
QuickSort

随机快速排序 时间复杂度O(N*logN)，额外空间复杂度O(logN)【以2为底N的对数，用来记录中间位置方便递归时可以找到开始位置，因此空间浪费在了划分点；长期期望】
##1.8堆排序
HeapSort

时间复杂度O(N*logN)，额外空间复杂度O(1)
##1.9比较器
MyComparator
##1.10桶排序
MaxGap
