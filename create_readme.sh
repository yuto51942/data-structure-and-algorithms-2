#!/bin/bash

if [ $1 ] ; then
  date=`date +'%Y年%m月%d日（%A）'`
  url=http://edu.net.c.dendai.ac.jp/ad2/2021/${1}
  dir=section${1}

  title=`curl -L ${url} | pup 'h1 text{}'`

  if [ ! -d $dir ] ; then
    mkdir $dir
  fi

  cd $dir && touch README.md \
  && echo "# 第${1}回目 ${title:6}\n\n${date}" > README.md \
  && echo "[参考資料](${url})" >> README.md

  echo Create README! title: ${title:6}
else
  echo "Please section number"
  echo "example:"
  echo "\tsh create_readme.sh 4"
fi
