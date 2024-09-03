## 项目技术栈
#### 后端
 springboot3.0.2 + openJDK17 + mybatisPlus + mysql + druid + Knife4j + lombok + mapstruct + docker
#### 前端
 react + antd
#### 容器
 nginx 前后端分离

## 接口文档
地址：http://127.0.0.1:8099/doc.html#/home
![1725326285394.png](images%2F1725326285394.png)
![1725326325628.png](images%2F1725326325628.png)
![1725326221688.png](images%2F1725326221688.png)

## 前端页面
TODO: 此处为demo数据，代码中可通过请求方法进行替换<br>
function: const handlePostJSON = async () =>{}
![1725326575143.png](images%2F1725326575143.png)

## 后端项目包路径说明
```
com.mty.food.truck
├ common        公共基础设施
├ config        配置
├ controller    控制层，对外接口
├ converter     mapstruct 对象转换
├ dto.request   请求入参封装
├ entity        实体对象
├ enums         枚举类
├ exception     异常global处理
├ manager      业务编排
├ mapper        DAO封装
├ schedule      定时任务Task
├ service       业务实现接口
├ ├ impl        业务实现
├ utils         工具类封装
├ vo            对外输出层
```

## 项目构建打包
### 项目初始化&数据更新
#### 1.sql初始化
[init.sql](src%2Fmain%2Fresources%2Fsql%2Finit.sql)
#### 2.初次导入cvs文件
[Mobile_Food_Facility_Permit.csv](src%2Fmain%2Fresources%2Ffile%2FMobile_Food_Facility_Permit.csv)
#### 3.定时任务同步网站数据更新
[MobileFoodSyncTask.java](src%2Fmain%2Fjava%2Fcom%2Fmty%2Ffood%2Ftruck%2Fschedule%2FMobileFoodSyncTask.java)

#### 4.技术可能性 TODO
1. 前端页面做导入导出 <br />
2. 热点数据做三级缓存 <br />
3. 做多数据源配置支持, 支持多种db2 <br />

### 项目部署
#### 1.打包jar直接进行服务器部署
 nohup java -Xms256m -Xmx512m -jar mty-backend-1.0.0.jar --spring.profiles.active=prod > ./logs/mty-backend.log 2>&1 &
#### 2.采用docker进行部署
[Dockerfile](Dockerfile)