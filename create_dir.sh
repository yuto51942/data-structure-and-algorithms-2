#!/bin/bash

for i in {1..13}; do
  dir=section${i}
  if [ ! -d $dir ] ; then
    mkdir $dir
    echo "create directory: ${dir}"
  fi
done
