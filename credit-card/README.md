# credit-card

信用卡微服務，基於Spring boot框架開發，提供新增/查詢/修改/刪除信用卡產品之功能。

## Swagger URL
```
http://credit-card-nccu-lab2-common.nccu-lab-teacher-4c2f3918c1e51a612ffc44c361c1a42f-0000.jp-tok.containers.appdomain.cloud/swagger-ui.html#/credit-card-controller
```

## H2 Console
```
http://credit-card-nccu-lab2-common.nccu-lab-teacher-4c2f3918c1e51a612ffc44c361c1a42f-0000.jp-tok.containers.appdomain.cloud/h2-console/
```

## 佈署方式
1.使用 git clone nccu-lab-2020至本機，並切換至 credit-card 目錄  
2.登入OpenShift  
3.切換目錄至 nccu-lab2-common
```
oc project nccu-lab2-common
```
4.
```
oc new-build --name=credit-card openjdk-11-rhel7:latest --binary=true
```
