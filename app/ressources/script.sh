#!/bin/bash
clear
mkdir folders
unzip '*zip' -d folders/
# mkdir ../src/main/res/drawable-hdpi
# mkdir ../src/main/res/drawable-mdpi
# mkdir ../src/main/res/drawable-xhdpi
# mkdir ../src/main/res/drawable-xxhdpi
# mkdir ../src/main/res/drawable-xxxhdpi
cp */*/android/drawable-hdpi/*.png    ../src/main/res/drawable-hdpi
cp */*/android/drawable-mdpi/*.png    ../src/main/res/drawable-mdpi
cp */*/android/drawable-xhdpi/*.png   ../src/main/res/drawable-xhdpi
cp */*/android/drawable-xxhdpi/*.png  ../src/main/res/drawable-xxhdpi
cp */*/android/drawable-xxxhdpi/*.png ../src/main/res/drawable-xxxhdpi
rm -r folders/
rm *.zipx
