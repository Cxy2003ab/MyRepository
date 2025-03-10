## c课堂总结：

### 1.%d使用

### 2.库函数文档

### 3.二分查找

### 4.100-200以内的素数

#### 5.最大公约数

#### 6.sizeof()和strlen()

#### 7.二维数组的存储

#### 1.%d的使用

```
#include<stdio.h>
int main(){
int a,b,c;
//这里的&是取地址符
//两种方式：
//1.不加空格。输入的时候每个都空格输入
printf("%d%d%d",&a,&b,&c)；
//2.加了其他字符，那键盘输入的时候也要输入该符号（例如：，* ，#）
printf("%d,%d,%d",&a,&b,&c);
return 0;
}
```

#### 2.库函数不常见的

### ##官网：

### cpprefenrence(c/c++官网)

### cplusplus

#### 头文件：

#include<string.h>

#include<Window.h>

#include<stdlib.h>

##strcmp(,"")  -->用于比较两字符数组是否相等，若等于0，则相等

##strlen();

##Sleep(1000);-->括号里填的是毫秒

##system("cls");

### 3.二分查找

```
//#include<stdio.h>
//int main() {
//	//这种要先排序，在查找
//
//	//二分查找
//	int arr[10] = {1,2,3,4,5,6,7,8,9,10};
//	//先来一次
//	int left = 0;
//	int right = sizeof(arr) / sizeof(arr[0]);
//	//选择要查找的数k
//	int k = 7;
//	while (left<=right)
//	{
//		int mid = (left + right) / 2;
//		if (arr[mid] > k) {
//			right = mid - 1;
//		}
//		else if (arr[mid] < k) {
//			left = mid + 1;
//		}
//		else {
//			printf("找到了,下标是%d\n",mid);
//			break;
//		}
//	}
//	if (left > right) {
//		printf("没有找到\n");
//	}
//	return 0;
//}

```

#### 6.sizeof和strlen

```
sizeof表示数组的内存所占空间大小
char arr[] = {'a','b','c'};
char arr1[]="abc";
#arr1在内存中有4个元素，以‘\0’为结束标志
sizeof(arr) = 3;
sizeof(arr1) = 4
#strlen()是针对字符串而设定的一个库函数，表示字符串的大小
则
strlen(arr1) = 3;
strlen(arr) = rand();
```

#### 7.二维数组的地址

<img src="E:\md文件\image-20230328220308355.png" alt="image-20230328220308355" style="zoom:50%;" />

