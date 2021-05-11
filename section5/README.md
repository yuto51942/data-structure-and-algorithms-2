# 第5回目 コンパイラコンパイラ

2021年05月04日（火曜日）
[参考資料](http://edu.net.c.dendai.ac.jp/ad2/2021/5)

## 前期レポート課題

電卓。優先順位付き

## Run

```bash
cd sample
mvn exec:java
```

### JavaCCのビルド

```bash
mvn javacc:javacc
```

### run

```bash
cd target/generated-sources/javacc
javac [name].java
java [name]
```

## 拡張バッカスナウア記法

```text
(表現)*
表現の 0 回以上の繰り返し
{表現}
表現の 0 回以上の繰り返し
(表現)?
表現を 0 回または 1 回
[表現]
表現は記述しても省略してもよい(0 回または 1 回)
(表現)+
表現の 1 回以上の繰り返し
```

## JavaCC

javaのコンパイラコンパイラ。

### 例

- 入力した文字分`Hello World.`を表示する

```java
PARSER_BEGIN(Rei)
import java.io.*;
public class Rei {
  public static void main(String[] arg) throws ParseException {
    final Rei parser = new Rei(new InputStreamReader(System.in));
    parser.start();
  }
}
PARSER_END(Rei)
SKIP: {
  " "
  | "\n"
  | "\r"
}
TOKEN: { <MOJI : ~[] > }
private void start() : {} {
  (<MOJI> { System.out.println("Hello World.");})*
}
```

### 基本構造

```java
PARSER_BEGIN(パーサクラス名)
宣言したパーサクラスの定義
PARSER_END(パーサクラス名)
生成ルール
```

- パーサのクラス名がPの場合

```java
PARSER_BEGIN(P)
class P {
}
PARSER_END(P)
生成ルール
```

### トークンの登録

```java
TOKEN: {
   <トークン名1 : 正規表現1 >
 | <トークン名2 : 正規表現2 >
 | ...
}
```

- 正規表現ルール
  1. 文字列は`"`で囲む。
  2. 文字クラスでは角カッコの中の要素はすべて`"`で囲み、`,`で区切る。 また、文字の範囲に関しては`"`で囲んだ文字同士を`-`でつなぐ。
  3. 除外を表す文字クラスは文字クラスの角カッコの前に`~`を付ける。 とくに任意の一文字は`~[]`で表す。
  4. 繰り返しを表す *, +, ? などを指定する場合は丸カッコで括る。

- 自然数NUM、名前をNAMEという名称のトークン

```java
TOKEN: {
  <NUM : ["1"-"9"] (["0"-"9"])* >
  |<NAME : ["A"-"Z","a"-"z"] (["0"-"9","A"-"Z","a"-"z"])* >
}
```

- 空白など文法ではとくに処理しない、読み飛ばすための表現のために、 TOKEN キーワードの他に SKIP というキーワードが用意されています。 SKIP でトークン名称は指定しない。

```java
SKIP: {
  " "
  | "\n"
  | "\r"
}
```

### バッカスナウア記法の指定

```java
メソッドのシグネチャ : {
メソッド内のアクションで共通で使用する変数などの宣言
} {
   <トークン名1>あるいは非終端記号に対応するメソッドの呼び出しの列
       { Java 構文によるアクション1 }
   <トークン名2>あるいは非終端記号に対応するメソッドの呼び出しの列
       { Java 構文によるアクション2 }
 ...
}
```

#### 例1

$$
始 → (名前)*
$$

```java
options {
  static = false;
}
PARSER_BEGIN(Parser)
class Parser {
}
PARSER_END(Parser)
TOKEN: {
    <NAME : ["A"-"Z","a"-"z"] (["A"-"Z","a"-"z","0"-"9"])*>
}
SKIP: {
    " "
| "\n"
| "\r"
}
public void start() : {} {
    (<NAME>)*
}
```

```java
import java.io.*;
class Rei {
  public static void main(String[] arg) throws ParseException {
    final Parser parser = new Parser(new InputStreamReader(System.in));
    try{
        parser.start();
        System.out.println("Accept");
    }catch(Exception e){
        System.out.println("Reject");
    }
  }
}
```
