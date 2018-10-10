## Overview

This repo is to practice code refactoring. There are several tags, 
each of which identify a starting point.

### Working with this repo

#### Cloning Project

Clone this project as usual and review the branches:
```terminal
git clone git clone git@github.com:schuchert/rpn_exercises.git
cd rpn_exercises
git tag -l
```

#### Confirm Your Environment
While in the `rpn_exercsies` directory, verify your environment is working:
```terminal
./gradlew test # if you are using CMD, use .\gradlew.bat test
```

You should have a successful build with a number of unit tests passing.

#### Branch to an exercise
In the repo directory, use git branch with a tag to create a branch based on one of the exercises:
```terminal
git checkout -b <new_branch_name> <tag_name>
```

For example, to work on the (recommended) first exercise:
```termainl
git checkout -b wrap_collection_exercise wrap-collection-start
```

You can now make commits to this branch as you normally would use git.

## More details
For further instructions, have a look at [Rpn Exercise Description](https://schuchert.github.io/wikispaces/pages/java/rpnexercises/RpnExercises.html).
