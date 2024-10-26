# Consul数据配置
本文件夹专门用于 Consul 的持久化数据配置

### 启动代码
```
consul agent -server -bootstrap-expect=1 -data-dir=/Users/Ahsoka/Spring-Cloud/Commons/src/main/java/com/example/Consul/Data -ui
```
或者以 DeBug 模式启动
```
consul agent -server -bootstrap-expect=1 -data-dir=/Users/Ahsoka/Spring-Cloud/Commons/src/main/java/com/example/Consul/Data -ui -log-level=DEBUG
```