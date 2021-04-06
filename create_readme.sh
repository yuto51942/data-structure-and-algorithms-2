#!/bin/bash

if [ $1 ] ; then
date=`date +'%Y年%m月%d日（%A）'`
cd section${1} && touch README.md \
&& echo "# 第${1}回目 [タイトル]\n\n${date}" > README.md \
&& echo "[教科書](http://edu.net.c.dendai.ac.jp/ad2/2021/${1})" >> README.md
else
echo "Please section number"
echo "example:"
echo "\tsh create_readme.sh 4"
fi
