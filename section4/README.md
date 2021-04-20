# 第4回目 文脈自由文法と構文解析木

2021年04月20日（火曜日）
[参考資料](http://edu.net.c.dendai.ac.jp/ad2/2021/4)

## 文脈自由文法

### 文法とルール

- S+V
  - 例: I ski. It rains. I have returned. This class has begun.
- S+V+C
  - 例: This is a pen. I am a student. You look tired.
- S+V+O
  - 例: I love you. I am studying programming.
- S+V+O+O
  - 例: I teach you theories of programming.
- S+V+O+C
  - 例: I find you asleep.

### バッカス・ナウア記法

4つ組、$G=(V_N, V_T, P, S)$で表す。

1. 開始記号を左辺に含むルールを1つ選ぶ
2. 開始記号をそのルールの右辺に置き換える
3. 置き換えらものの中から非終端記号を1つ選ぶ
4. その非終端記号を左辺に含むルールを1つ選ぶ
5. その非終端記号を右辺に置き換える
6. すべてが終端記号なら終了、そうでない場合は3に戻る
