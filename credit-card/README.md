# credit-card

信用卡微服務，基於Spring boot框架開發，提供新增/查詢/修改/刪除信用卡產品之功能。  
![Image lab-env](https://raw.githubusercontent.com/j3ffk3/nccu-lab-2020/main/imgs/credit-card-svc.PNG)
## Swagger URL
```
http://credit-card-nccu-lab2-common.nccu-lab-teacher-4c2f3918c1e51a612ffc44c361c1a42f-0000.jp-tok.containers.appdomain.cloud/swagger-ui.html#/credit-card-controller
```
![Image lab-env](https://raw.githubusercontent.com/j3ffk3/nccu-lab-2020/main/imgs/credit-card-swagger.PNG)
## H2 Console
JDBC URL
```
jdbc:h2:mem:testdb
```
Console url
```
http://credit-card-nccu-lab2-common.nccu-lab-teacher-4c2f3918c1e51a612ffc44c361c1a42f-0000.jp-tok.containers.appdomain.cloud/h2-console/
```
![Image lab-env](https://raw.githubusercontent.com/j3ffk3/nccu-lab-2020/main/imgs/credit-card-h2-console.PNG)

## 佈署方式
1.使用 git clone nccu-lab-2020 至本機，並切換至 credit-card 目錄  
2.利用 maven 打包 jar 檔
```
mvn clean package
```
3.登入OpenShift  
4.切換專案至 nccu-lab2-common
```
oc project nccu-lab2-common
```
5.佈署至RedHat OpenShift
- 產生 build config，基底映像檔使用 openjdk-11
```
oc new-build --name=credit-card openjdk-11-rhel7:latest --binary=true
```
- 產生 deploymnet config
```
oc new-app credit-card --allow-missing-imagestream-tags
```
- 產生 route 供外部存取
```
oc expose dc credit-card --port 8080 
```
- 設定語系、時間
```
# 設定為台灣時間
oc set env dc/credit-card-web TZ=Asia/Taipei
# 設定語系
oc set env dc/credit-card-web LC_ALL=en_US.utf8
```
- 佈署應用
```
oc start-build bc/credit-card --from-file ./target/credit-card-0.0.1-SNAPSHOT.jar
```
