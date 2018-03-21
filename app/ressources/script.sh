#!/bin/bash
clear
mkdir folders
unzip '*zip' -d folders/
mkdir ../src/main/res/drawable/drawable-hdpi
mkdir ../src/main/res/drawable/drawable-mdpi
mkdir ../src/main/res/drawable/drawable-xhdpi
mkdir ../src/main/res/drawable/drawable-xxhdpi
mkdir ../src/main/res/drawable/drawable-xxxhdpi
cp */*/android/drawable-hdpi/*.png    ../src/main/res/drawable/drawable-hdpi
cp */*/android/drawable-mdpi/*.png    ../src/main/res/drawable/drawable-mdpi
cp */*/android/drawable-xhdpi/*.png   ../src/main/res/drawable/drawable-xhdpi
cp */*/android/drawable-xxhdpi/*.png  ../src/main/res/drawable/drawable-xxhdpi
cp */*/android/drawable-xxxhdpi/*.png ../src/main/res/drawable/drawable-xxxhdpi
rm -r folders/
rm *.zipx
