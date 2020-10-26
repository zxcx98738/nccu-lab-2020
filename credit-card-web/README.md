# CreditCardWeb

LAB的前端應用，基於Angular框架開發，用於呈現信用卡產品以及推薦結果。

## URL
```
http://credit-card-web-nccu-lab2-common.nccu-lab-teacher-4c2f3918c1e51a612ffc44c361c1a42f-0000.jp-tok.containers.appdomain.cloud/
```

## 佈署方式
佈署前請先安裝nodejs、angular cli
1.使用 git clone nccu-lab-2020至本機，並切換至 credit-card-web 目錄3
2.安裝npm 套件
```
npm i 
```
3.建置應用
```
ng build 
```
4.佈署至RedHat OpenShift
- 產生 build config，基底映像檔使用httpd
```
oc new-build --name=credit-card-web httpd:latest --binary=true
```
- 產生 deploymnet config
```
oc new-app credit-card-web  --allow-missing-imagestream-tags
```
- 產生 route 供外部存取
```
oc expose dc  credit-card-web --port 8080 
```
- 設定語系、時間
```
# 設定為台灣時間
oc set env dc/credit-card-web TZ=Asia/Taipei
# 設定語系
oc set env dc/credit-card-web LC_ALL=en_US.utf8
```
