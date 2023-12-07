### GitHub的使用

#### 1. 注册 GithHub 账号并登录（访问慢的则就需要特殊魔法啦）

#### 2. SSH Key 设置

由于本地 Git 仓库和 GitHub 仓库之间的传输是通过 **SSH** 加密的，所以，需要一点设置：



**【第 1 步】**	创建 **SSH Key**。通常在 C 盘的 user (用户)目录下，进入主目录，会有一个 .ssh 的文件夹，进入后可以看到 id_rsa 和 id_rsa.pub 这两个文件，如果找到了这两个文件，如下图所示，可以直接跳过第一步（一般情况下是没有创建的）

没有的话：

打开 `Windows`下打开 `Git Bash`（Linux 中需要打开 Shell），执行下面命令，以创建 `SSH Key：`

```Git
ssh-keygen -t rsa -C "youremail@example.com"
```

一路回车，使用默认值即可，因为这个 Key 也不是用于军事目的，所以也无需设置密码。

然后就可以到显示的目录下找到 .ssh，里面有 id_rsa 和 id_rsa.pub 两个文件，这两个就是 SSH Key 的秘钥对，**id_rsa** 是私钥，不能泄露出去，**id_rsa.pub 是公钥**，可以放心地告诉任何人。

【**第 2 步**】首先创建 GitHub 账号并登陆，打开 Setting 进行设置，新建 `SSH key`

【**第 3 步**】点 `New SSH key` 后，填上任意 `Title`，在 `Key` 文本框里粘贴**`id_rsa.pub** 文件的所有内容：



##### 目的：

因为 GitHub 需要识别出你推送的提交确实是你推送的，而不是别人冒充的，而 **Git 支持 SSH 协议**，所以，GitHub 只要知道了你的公钥，就可以确认只有你自己才能推送。

#### 3. 添加远程库

由于我是零基础小白，我是从头开始将项目添加到GitHub上的

1、在GitHub上 有个加号，选择 **new repostory** 取好自己的想的名字(**记得勾选 read.md说明文件，其他默认**)

2、在电脑找到当前项目的文件夹，右键 -> git bash  

2.1

```
 git init 
```

2.2

```
 git remote add origin <ssh>地址
```

2.3

```
git add .
```

2.4

```
git commit -m "描述提交的名称"
```

2.5

```
git push -u origin master 
//这里的master是本机仓库默认分支名称，执行完这条指令后，github上如果在你创建的仓库名下会去找有没有叫master的，没有的话会自动创建master分支，目的是本机分支名和远程分支名称一致
```

执行好这些步骤项目就能提交到github上的自定义仓库了



如果是第一次使用git,执行2.3就会出错，是因为git无法识别是谁发出的指令的，使用需要执行登录git的用户名和邮箱的指令

**在本地设置你的用户名和邮箱地址：**

```
git config --global user.email "你的邮箱地址"

git config --global user.name "你的用户名"
```



##### 要修改本地仓库的分支名，可以按照以下步骤进行操作：

1. **查看当前的分支**: 使用以下命令查看当前所在的分支：

   ```
   git branch
   ```

2. **切换到其他分支（可选）**: 如果你要修改的分支不是当前所在的分支，可以使用以下命令切换到目标分支：

   ```
   git checkout <branch_name>
   ```

3. **重命名分支**: 使用以下命令来重命名分支：

   ```
   git branch -m <new_branch_name>
   ```

   这将把当前分支重命名为新的分支名。

4. **推送到远程仓库（可选）**: 如果你希望将修改后的分支名同步到远程仓库，可以使用以下命令将新分支名推送到远程仓库：

   ```
   git push origin <new_branch_name>
   ```



#### 4、原理

git原理就是：

##### 本机仓库  --  暂存区  --  远程仓库

本机仓库的分支要和远程仓库名称保持一致，并且需要保持一致的更新



#### 5、常见报错

 **non-fast-forward**：译为‘不能快速前进’，**远程仓库更新了**，你没有及时同步到本地，提交的时候添加了新的内容，提交的时候，然后检测到远程和本地不一样。为了安全起见，报了这个错误。

可以先合并之前的历史，在进行提交

1、

```
git fetch origin master
 
git merge origin FETCH_HEAD
```

2、

```
git pull --rebase origin master
```

