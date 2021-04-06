#!/bin/bash

if [ $1 ] ; then
cd section${1} && touch README.md
else
echo "Please section number"
echo "example:"
echo "\tsh create_readme.sh 4"
fi
