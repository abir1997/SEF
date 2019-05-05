# SEFAssignmentProject - Supermarket Support System 
A new self-checkout system is introduced in a supermarket, which only allows payments for sales to be made through the company debit card. 
Currently purchasing and topping up these cards are handled manually using a sales staff. The company has also introduced a scheme to promote 
loyalty; customers using the card get 1 point, for every $10 spent. Customers are automatically discounted $5 for every 20 points. The system 
should store the product, customer and employee related details allowing necessary reports to be generated. Data may be stored in relational 
database or flat files or through serialization.  The system should store product, customer and employee related details allowing necessary 
reports to be generated. GUI is optional for this project. 
## Getting Started
These instructions will get you a copy of the project up and running on your local machine for collaboration purposes.
### Prerequisite
* Computer
* [Git](https://git-scm.com/) (For Windows)

For **Mac** users, git should be readily available in your terminal.  

# Git Basics
## Cloning the project
Type the following commands into your terminal (or git bash for windows) :
```
git clone https://github.com/rmit-s3667551-cheeboon-khoo/SEFAssignmentProject.git
```
**Make Sure** you are in the right directory before you run this command because this will download the project into your current directory  

After cloning, typing `git status` will show you the current status of your project, whether you have uncommited changes or if the remote 
version have new changes. For now, the following message will be shown :
```
On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean
```
## Making your own branch
Before you make any changes to the project, make sure you make a new branch so your changes won't interfere with the master branch. To do this,
simply type these in:
```
git checkout -b <Your Branch Name>
```
Replace <Your Branch Name> to your desired branch name eg :  `git checkout -b Khoo` 
Your current branch will be shown at the end of your git terminal :
```
User@machine MINGW64 /your/directory/here (Your Branch Name)
```
## Setting up Name and Email
Before you commit any changes, you'll need to configure the name and email for the commits. If this is not configured, your computer name and 
default email will be used, so make sure to do this!
```
git config user.name "Your name here"
git config user.email "Your email here"
```
## Commiting changes
When you made some changes to your branch, you will need to commit and push it to the remote (aka this repository). Below are the steps to do just 
that :
```
git add .
git status
git commit -m 'Your message here'
```
You have now successfully commited changes on your local computer.

## Pushing to remote
Commiting to your local computer won't make it magically appear on the remote, so here are the steps to make that happen :  
```
(For the first time / after changing branch)
git push -u origin <your branch name>

(Subsequent pushes)
git push
```
## Rebasing your branch
Follow these steps everytime when you are ready to push / pull changes from other group members.
```
git checkout master
git pull
git checkout <Your Branch Name>
git rebase master
```
To this point, you may have a conflict with the changes already on the remote. Sometimes this will happen because similar changes have 
been made to the same file.  
[Here are the steps you'll need to follow to resolve conflicts](https://help.github.com/articles/resolving-merge-conflicts-after-a-git-rebase/)  

_Remember_ to do this everytime you want to make a pull request!

## Making pull request
Pull request is basically making a merge request on the master branch, which is the 'stable' version for our project. The purpose of making a
branch above is to prevent any bad code get into the main branch, so you can do whatever tests you want in your own branch without 
interfering with the master branch. After confirming that your code works, you can create a pull request to let your group members have a final
look before merging with the master branch. Below are the steps for doing this :  

* [Follow the steps mentioned here](https://help.github.com/articles/creating-a-pull-request/)

# Recommended readings
You can read in more detail on how git works by downloading the ebook [here](https://git-scm.com/book/en/v2)  
Alternatively, you can just ask me (Khoo) if you have any problems.
