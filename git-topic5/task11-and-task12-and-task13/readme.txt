Создал условный веб проект webproject.txt в папке jd2_hw, которая уже отслеживается репозиторием
git add webproject.txt
git commit
git push

git branch dev1
git checkout dev1
Внес изменения в webproject.txt
git status показывает, что в webproject.txt были внесены изменения и надо бы сделать add
git add webproject.txt
git commit
git push origin dev1
git checkout master
git merge dev1
git push origin master

git branch dev2
git checkout dev2
Внес изменения в webproject.txt
git add webproject.txt
git commit
git push origin dev2
git checkout master
git merge dev2
git push origin master

Внес изменения в webproject.txt
git add webproject.txt
git commit
git push
git log
git revert хэш коммита
git push
