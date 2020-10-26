
# LAB2 設定CI/CD Pipeline
自動化程式碼集成、佈署的流程，在此LAB擬將修改recommendation\src\main\resources目錄下既有的 Jenkinsfile 完成CI/CD 流程。 

1.利用文字編輯器打開 Jenkinsfile
2.修改 Stage1 Clone Source Code 下的 url 參數改為你git的位置，範例如下
```
stage('Clone Source Code') {
  steps {
            	echo 'Clone Source Code ...'
		git branch: 'main', url: 'https://github.com/j3ffk3/nccu-lab-2020.git'
         }
}
```
3.查看 Stage2 Unit Test 下的指令，為LAB1單元測試下的指令
```
// Stage2 Unit Test
stage('Unit Test') {
	steps {
        	dir("recommendation") {
			sh """
				mvn test
			"""
		}
	}
}
```
4.查看 Stage3 Code Quality Analysis ，為LAB1程式碼品質分析下的指令，取代${你的學號}的部分為你的學號。
```
// Stage3 Code Quality Analysis
stage('Code Quality Analysis') {
	steps {
		dir("recommendation") {
			sh """
				mvn clean package sonar:sonar -Dsonar.projectKey=recommendation-${你的學號} -Dsonar.projectName=recommendation-${你的學號}
			"""
		}
	}
}
```
5.查看 Stage4 Code Quality Analysis ，為LAB1 編譯Java 的指令。
```
// Stage4 Build Jar file
stage('Build Jar file') {
	steps {
            	dir("recommendation") {
			sh """
				mvn clean package -DskipTests
			"""
		}
	}
}
```
6.查看 Stage5 Build Image & Deploy ，為LAB1 佈署應用的指令，取代${你的學號}的部分為你的學號。

```
// Stage5 Build Image & Deploy
stage('Build Image & Deploy') {
	steps {
            	dir("recommendation/target") {
			sh """
				oc project ${你的學號}
				oc start-build bc/recommendation --from-file recommendation-0.0.1-SNAPSHOT.jar -F
			"""
		}
	}
}
```
7.利用文字編輯器打開 recommendation\pipeline.yaml，將${GIT_URL}取代為你git的位置後存檔。
```
kind: "BuildConfig"
apiVersion: "build.openshift.io/v1"
metadata:
  name: "recommendation-pipeline"
spec:
  source:
    contextDir: recommendation
    git:
      uri: "${GIT_URL}"
      ref: "main"
  strategy:
    jenkinsPipelineStrategy:
      type: JenkinsPipeline
      jenkinsfilePath: /src/main/resources/Jenkinsfile
```
8.於 OpenShift 上建立 Pipeline
```
oc create -f pipeline.yaml
```

