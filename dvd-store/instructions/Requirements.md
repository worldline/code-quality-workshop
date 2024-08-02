Please find below the requirements for the workshop "Best practice & code quality"

**It is strongly recommended to implement them in order, as the complexity increases.**

Don't worry if you don't have enough time to finish : Focus on the journey, not the destination

Req 0 is not very clear, but introducing Movie object will be a huge benefit for the next requirement.
Req 1 is tougher as you will discover lots of problems, hence lots of refactoring on top of the requirement itself



## ------- Requirement 0  --------

The future is in content... so the business doesn't know the difference between a DVD and a VideoTape... everything you can watch will now be a Movie !
All next requirements will be for Movies from now on.

Hint :
This requirement is a good opportunity to get rid of all the petty details slowing you down : confusing names, lack of unit-tests, language barrier, etc...


 ## ------- Requirement 1  --------

 We're running out of business because we're not making enough money!

 We're gonna change the way we price :

 The quality of a DVD will drop down with each renting..... so the value should decrease as well.

 ### Here are the pricing rules :

 Price for a DVD = 10 if it was released more than 10 years ago

 Actual logic other case , max price is 23 for any movie

 Oh, and I'm a huge fan of Tom Cruise, every movie is a masterpiece ! Then price when Tom is within a movie should be 15
 
 Add an API that gives the price for a movie ( ISBN ), provide the two prices DVD / VideoTape is possible.

 Response example :

 _{
    DVDPrice : xxx,
    VideoPrice : yyy
 }_

 OR

 _[
    { price : xxx, type: DVD },
    { price : yyy, type : Video }
 ]_

Hint :
 - add unit-test for the existing and the new pricing rules