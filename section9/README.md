# 第9回目  SGML, HTML, XML

2021年06月15日（火曜日）
[参考資料](http://edu.net.c.dendai.ac.jp/ad2/2021/9)

## マークアップ言語

- 組版などの仕上がりの指示を出すための記号の手法の集まり。
- SGML
- HTML...

## XML

- マークアップのメタ言語

```xml
<要素名 属性1="値1" 属性2="値2">
    内容
</要素名>

<要素名 属性1="値1" 属性2="値2" />
```

例:

```xml
<!-- case1: PCDATA -->
<授業>
    <担当>坂本直志</担当>
    <科目名>データ構造とアルゴリズムⅡ</科目名>
    <日時>火曜日2限</日時>
</授業>

<!-- case2: CDATA -->
<授業>
    <担当 name="坂本直志"/>
    <科目名 name="データ構造とアルゴリズムⅡ" />
    <日時 day="火曜日" period="2限"/>
</授業>

<!-- case3 -->
<授業 担当="坂本直志" 科目名="データ構造とアルゴリズムⅡ" 日時="火曜日2限" />
```

### XMLのデータ型

#### 文字

- XML宣言

  ```xml
  <?xml version"1.0" encoding="utf-8"?>
  ```

|  実体参照  | 表示される文字 |
| :--------: | :------------: |
|  `&amp;`   |     &amp;      |
|   `&lt;`   |      &lt;      |
|   `&gt;`   |      &gt;      |
|  `&quot;`  |     &quot;     |
|  `&apos;`  |     &apos;     |
|  `&copy;`  |     &copy;     |
| `&trade;`  |    &trade;     |
| `&alpha;`  |    &alpha;     |
| `&spades;` |    &spades;    |
|  `&euro;`  |     &euro;     |

## HTML Standard

```html
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>演習1</title>
    </head>
    <body>
    ここにマークアップされたドキュメントを記述する
    </body>
</html>
```

### 内容の種類

- Metadata content
- Flow content
- Sectioning content
- Heading content
- Phrasing content
- Embedded content
- Interactive content

### HTMLのJS API

#### Window object

- document
  - Documentオブジェクトを返す
- alert
  - メッセージをポップアップウインドウに表示
- confirm
  - メッセージをポップアップウインドウに表示し、OKかcancelかユーザーに選ばせる
- prompt
  - メッセージをポップアップウインドウに表示し、入力ボックスを表示し、文字を入力させる
