# Class Assignment 1

**Name:** Inês Lourenço Martins

**Discipline:** DEVOPS

**Date:** 14-28 March


----------------------------------------------------------------------

### Description

This assignment has the main purpose of integrating students' 
knowledge with Git, the most commonly used and know Version Control System.

During this assignment and according to previous indications, the learning goals to attain are:

- First Week
  - use basic Git commands (clone, add, commit, push, pull) and its variations
  - tags implementation to track versions within commits

- Second Week
  - create and manipulate branches
    - cover several types of merges (Fast-Foward and Three Way Merge)

This class assignment is based on this 
[project](https://ineslourencom@bitbucket.org/ineslourencom/devops-21-22-abt-1211767.git/CA1/basic) - Git.
To see the Mercurial developed version,
the [project](https://1211767isepipppt@helixteamhub.cloud/summer-candy-7300/projects/devops-21-22-abt-1211767/repositories/mercurial/tut-react-spring)



## 1. Analysis
###1.1. Distributed vs. Centralized 
When deciding which VCS to choose an alternative, one of the option was SVN, precisely because it 
was opposite equivalent.
This way you would have more contact with the different technologies used. 
Unfortunately, there were some major complications due to incompatibilities with MACOS and SVN.

Git (and others distributed VCS) confers an essential safety regarding saving repositories due to its "snapshot" system saving, 
that compares versions and holds its modifications. Another feature is every user/developer has a copy (initialized by 'git clone')
of the project. Means that in case of database failure a distributed copy of the project is saved among all that shares
the repository. 

Distributed VCS isn't just roses: they also have their downsides such as: higher probability of conflicts during code
merging into repository (due to multiple changes charged simultaneously); administrators systems might not have a clear view
and on demand on what's being developed at that moment.

On the other hand, a centralized system (such as SVN) does not share the repository with other users. The information and
the repository are saved in a central database, which can cause a disruption between project and users in case of connection failure. 
There are also another downsizes that include data loss in case of the centralized repository fails (and no backup mechanism present).


###1.2. Git 
Git was launched in 2005 and was developed in C, C++, Python and Perl. Git is one of the existing offers that rely on the open-source and free concepts. It's one of the most used VCS in 
the software development field. It works as snapshots, since it saves how the information is organized (just like a picture, 
instead of saving and store all data) everytime a commit is uploaded. 



###1.3. Mercurial

Such as Git, Mercurial is also an open-source project, launched in a sooner moment (2005) and developed in C, Python and C.

We can refer Mercurial as a simpler version of Git, although being challengeable to do a recoversion from Git 


###1.4. Git vs. Mercurial

The main diferences seen between these two VCS relies on how branches operates. For Mercurial, "the term "branch" may 
thus refer to a "diverged line of development". For Mercurial, a "line of development" is a linear sequence of
consecutive changesets", as it referenced in their official website (https://www.mercurial-scm.org/wiki/Branch). From an beguinner
user experience, Mercurial could be a good introduction to VCS, but after git usage, might be a bit difficult to manage. 



## 2. Design

*1. Create JobYears column:*

In week 0, the practice suggestion was to implement a new column and a new employee. 
In this case, was added a column Start Date and a new Employee called "Lino Ribeiro", establishing version v1.1.0. Later on, during week 1,
we added JobYears (calculated from start date), methods validation Employee input data and respective tests (v.1.2.0).

This task involved:
- updating repository
- creating tags

*2. Creating Email field:*
During week 2, we'd to create two branches to solve two distinct but related problems (v1.3.0), by creating a new column Email Field.
The solenly validations applied was to be input string type and not null.
This task involved:
- creating new branch email-field
- merging through fast foward merge (in git)

*3. Creating Specific validations in Email:*
During week 2, we'd to create two branches to solve two distinct but related problems (v1.3.1).
The validations have changed to accepting '@' item. Also, we've added the validation of accepting only isep emails (@isep.ipp.pt).
This task involved:
- creating new branch fix-email-field
- merging through three-way merge (in git)



## 3. Implementation

### 3.1. Git <-> BitBucket
[project](https://ineslourencom@bitbucket.org/ineslourencom/devops-21-22-abt-1211767.git/CA1/basic)

**1. Create a Repository**


We start by defining the directory intended to start our Project. In this case,"devops-21-22-abt-1211767" will be home to our repository.
  
Start a Repository from local:

    $ git init 

Clone Remote Repository (BitBucket):
        
    $ git clone https://ineslourencom@bitbucket.org/ineslourencom/devops-21-22-abt-1211767.git

**2. Adding files in from local to remote**

Add file to staging area:
this '.' in particular adds all files in the working area 

    $ git add . 

Add files from the staging area to commit:

    $ git commit -a -m "Initial commit"

Push to origin Branch:

    $ git push origin master


**3. Tagging Versions**
Create a tag:

    $ git tag "v1.1.0"

List existing tags:

    $ git tag -l

Push Tags to Remote Repository:
    
    $ git push origin --tags


**4. Creating and manipulation branches:**

***Fast Foward Merge***

Create branch

    $ git branch email-field

Change to branch "email-field"

    $ git checkout 

Change to master branch
    
    $ git checkout master

Merge branch 'email-field' with master

    $ git merge email-field

Delete branch email-field

    $ git branch -d email-field

Push all changes to repository

    $ git push origin master


***Three-way Merge***

Create branch

    $ git branch fix-invalid-email

Change to branch "fix-invalid-email"

    $ git checkout fix-invalid-email

*(Here we made the changes needed)*

    $ git commit -a -m "solve issue #7 fix bugs in email field"

Change to master branch

    $ git checkout master

*(Here we made the changes needed so the branch master can be different from branch 'fix-invalid-email')*

    $ git commit -a -m "solve issue #4 test coverage"

Merge branch 'fix-invalid-email' with master

    $ git merge fix-invalid-email

*(Here we have to solve conflicts by taking <<<<<<<< ========== >>>>>>>> signs and leave it as we wish)*

    $ git diff

    $ git merge tool 

    $ git rebase continue

Delete branch 'fix-invalid-email'

    $ git branch -d fix-invalid-email

Push all changes to repository

    $ git push origin master


### 3.2. Mercurial <-> Perforce

[project](https://1211767isepipppt@helixteamhub.cloud/summer-candy-7300/projects/devops-21-22-abt-1211767/repositories/mercurial/tut-react-spring)

Downsizes:
 - hard configuration in the beginning: we must set extensions.
   - In the case of push command, in order to avoid constant repetition of the link, 
   we can set a specific repository as default. Although that doesn't avoid the password 
   request every time we want to push something to the repository
 - Dificulty in closing an issue through command lines (by referering the number);
 - Quite diferent model from git in branching. Might be a bit difficult in the beguinning.



**1. Create a Repository**


We start by defining the directory intended to start our Project. In this case,"devops-21-22-abt-1211767" will be home to our repository.

Start a Repository from local:

    $ hg init

Clone Remote Repository (BitBucket):

    $ hg clone https://helixteamhub.cloud/summer-candy-7300/projects/devops-21-22-abt-1211767/repositories/mercurial/tut-react-spring

**2. Adding files in from local to remote**

Add file to staging area:

    $ hg add 

Add files from the staging area to commit:

    $ hg commit -m "Initial commit"

Push to origin Master:
Here we can configure in .hgsc file from Mercurial the default path to the ropsitory, 
so we can no longer use constantly the repository https link.

    $ hg push [<repository http link>]

Verify the working tree:
    
    $ hg status

**3. Tagging Versions**
Create a tag:

    $ hg tag "v1.1.0"

List existing tags:

    $ hg tags

Push Tags to Remote Repository:

    $ hg push [<repository http link>]

**4. Creating Branches**

Create branch

    $ hg branch email-field

 In here, we push the brand-new branch to remote repository

    $ hg push --new-branch -b email-field

List branches

    $ hg branches


Merge branch back again to default

    $ hg update default

    $ hg merge <acessory-branch>

    $ hg commit -m "Commit for merge"

    $ hg push

    

## 4. Conclusions and Observations:

This exercise was quite usefull in learning the whole dimension of Git. Through errors and mistakes, 
we could understand the main mechanisms of Git and have a glimpse of its complexity. 



















