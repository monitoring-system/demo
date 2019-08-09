### 1. install baidu uid-generator

```
sh> git clone https://github.com/baidu/uid-generator.git 
sh> cd uid-generator
sh> mvn install -Dmaven.test.skip
```

### 2. create table

login TiDB and running sql:

```
mysql> source ./init.sql
```

### 3. run main in DemoApplication


using IDE run it 

or 


```
sh> mvn package
sh> cd target
sh> java -jar demo-0.0.1-SNAPSHOT.jar
```

### 4. change param

modify Test.java 

```
    public void test() throws Exception {
        int concurrency = 4;
        int repeat = 10000;
```