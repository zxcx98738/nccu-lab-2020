
# LAB2 設定CI/CD Pipeline
自動化程式碼集成、佈署的流程

1.至recommendation\src\main\resources目錄下查看一個名為Jenkinsfile的檔案，將 Stage1 Clone Source Code 下的 url 參數改為你git的位置。
```
stage('Clone Source Code') {
  steps {
            	echo 'Clone Source Code ...'
		git branch: 'main', url: 'https://github.com/j3ffk3/nccu-lab-2020.git'
         }
}
```
