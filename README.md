# tenmax-assignment
The only way to prove you can code is code.

# 使用方法
### 本機執行
```sh
./gradlew bootRun
```  

### 或在容器執行
```sh
./gradlew build && docker-compose up --build
```

```sh
# 連線至透過容器啟動的 mysql, 預設偵聽 3306
mysql -h 127.0.0.1 -D tenmax -u ten -p (密碼預設是 max)
```

### 測試並產生報告
```./gradlew test```   

在目錄 projectDir/build/reports/tests 觀看測試報告

