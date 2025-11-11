#### 创建pytorch--虚拟环境

1.安装anaconda

2.在anaconda的控制台输入：

2.1创建虚拟环境：

```
conda create -n <env_name> python=<version> # 将<env_name>替换为您喜欢的环境名称，例如“myenv”
conda create -n myenv python=3.8
```

2.2激活虚拟环境

```
conda activate <env_name>
```

2.3.安装各种包

2.4cuda的安装：

2.4.1先看显卡版本

官网地址：[CUDA Toolkit Archive | NVIDIA Developer](https://developer.nvidia.com/cuda-toolkit-archive)	-->  在里面选择对应的版本小于显卡的版本即可 

在win的控制台里输入：

```
查看cuda的版本：nvidia-smi
查看cuda是否安装成功：nvcc  -V
```

2.4安装pytorch时，一定要先安装cuda（GPU），然后在pytorch的官网里去找对应cuda的pytorch版本

3.pytorch-cuda安装验证：

```
import torch
 
print(torch.__version__)
print(torch.version.cuda)
print(torch.cuda.is_available())  #输出为True，则安装成功
```



#### 删除虚拟环境

1、退出当前环境（如果已激活）

```
conda deactivate
```

2、删除虚拟环境

```
conda remove -n pytorch-img2img --all
```

3.查看虚拟环境

```
conda env list
```

