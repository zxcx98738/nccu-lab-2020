
# LAB1 手動佈署推薦服務
手動佈署推薦服務，體驗一下程式碼集成、佈署的繁瑣步驟吧!  
1.先至以下網頁右上角輸入你的學號，可以看到目前有的信用卡產品，但下方還沒有推薦結果顯示，推薦結果要在你部署完成後才會顯示。
```
http://credit-card-web-nccu-lab2-common.nccu-lab-teacher-4c2f3918c1e51a612ffc44c361c1a42f-0000.jp-tok.containers.appdomain.cloud/
```
![Image lab-env](https://raw.githubusercontent.com/j3ffk3/nccu-lab-2020/main/imgs/lab1-before.PNG)

2.抓取程式碼至你的工作機  
3.單元測試
```
mvn test
```
4.程式碼品質掃描
```
mvn clean package sonar:sonar -Dsonar.projectKey=recommendation-${你的學號} -Dsonar.projectName=recommendation-${你的學號}
```

5.編譯Java程式
```
mvn clean package -DskipTests
```

6.佈署
- 登入OpenShift
- 佈署應用程式
```
# 推薦
oc new-build --name=recommendation openjdk-11-rhel7:latest --binary=true
# 產生dc
oc new-app recommendation  --allow-missing-imagestream-tags
# 產生service
oc expose dc  recommendation --port 8080 
# 產生route
oc expose svc recommendation
# 設定為台灣時間
oc set env dc/recommendation TZ=Asia/Taipei
# 設定 GC_MAX_METASPACE_SIZE
oc set env dc/recommendation GC_MAX_METASPACE_SIZE=500
# 設定語系
oc set env dc/recommendation LC_ALL=en_US.utf8
```

7.至以下網頁右上角輸入你的學號，查看推薦內容是否出現，若出現則表示LAB1 已完成
```
http://credit-card-web-nccu-lab2-common.nccu-lab-teacher-4c2f3918c1e51a612ffc44c361c1a42f-0000.jp-tok.containers.appdomain.cloud/
```
![Image lab-env](https://raw.githubusercontent.com/j3ffk3/nccu-lab-2020/main/imgs/lab1-after.PNG)
