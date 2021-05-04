# 第5回目 コンパイラコンパイラ

2021年05月04日（火曜日）
[参考資料](http://edu.net.c.dendai.ac.jp/ad2/2021/5)

## 前記レポート課題

電卓。優先順位付き

## Run

```bash
cd sample
mvn exec:java
```

## JavaCC

```bash
mvn javacc:javacc
```

### run

```bash
cd target/generated-sources/javacc
javac [name].java
java [name]
```
