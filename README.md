# TRM

This repository is ONLY for tracking/merging source files. It should NOT be used inside of your workspace.

Begin by cloning the reposity to a location OUTSIDE of your workspace.

Create your own branch! This allows for proper merging of your files!

COPY the files into your project. Maintaining Eclipse and Tomcat configuration is up to you.

When you are done editing your files, put the updated files into the local reposity, commit to your LOCAL repo and MERGE into the Master branch. 

# Steps

git clone https://github.com/Grand251/TRM.git

git branch some_new_brach_name

git checkout some_new_branch_name

#Do Some Editing/Pasting etc

git add .

git commit -m "Some Message About What I Did."

git checkout master

git merge some_new_branch_name

git push
