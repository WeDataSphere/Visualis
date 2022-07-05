Visualis 1.0.0-rc1 升级到 1.0.0 使用文档
---

## 1. 升级步骤主要分为：
- 服务停止
- 执行数据库升级脚本
- visualis部署目录替换为新版本包
- 配置文件添加，修改
- 服务启动

#### 1. 服务停止
进入到Visualis的部署目录，在目录下执行命令停止服务：
```shell
cd ${VISUALIS_INSTALL_PATH}

sh bin/stop-visualis-server.sh
```
#### 2. 执行数据库升级sql脚本

链接上visualis数据库后，执行如下SQL：

```sql
alter table linkis_user rename to visualis_user;
```

#### 3. Visualis部署目录替换为新版本包

- 备份Visualis旧版本的部署目录，以该目录为例：/appcom/Install/VisualisInstall
```shell
mv /appcom/Install/VisualisInstall/lib /appcom/Install/VisualisInstall/lib-bak
```
- 参考[Visualis安装部署文档](./Visualis_deploy_doc_cn.md)，编译打包后，替换lib即可。

#### 4. 修改配置
- Visualis1.0.0-rc1版本为了兼容DSS1.0.1和Linkis1.1.1，对cookie的做了兼容，需要删除一下参数，使用代码默认配置的linkis_user_session_ticket_id_v1值。
```properties
# 删除以下配置
wds.linkis.session.ticket.key=bdp-user-ticket-id
wds.dss.visualis.ticketid=bdp-user-ticket-id
```
- 在配置修改完成后，需要在DSS侧重新安装Visualis AppConn，安装Visualis1.0.0 AppConn可以参考[Visualis AppConn安装](./Visualis_appconn_install_cn.md)。


#### 5. 服务启动
现在可以启动Visualis新版本的服务了，执行命令启动服务：

```shell
sh bin/start-visualis-server.sh
```
