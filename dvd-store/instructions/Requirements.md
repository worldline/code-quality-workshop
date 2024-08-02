Please find below the requirements for the workshop "Best practice & code quality"

___

<img src="../media/fire-leaving.jpg" alt="Example image" width="1620" height="400"/>


**It is strongly recommended to implement them in order, as the complexity increases.**

Don't worry if you don't have enough time to finish : Focus on the journey, not the destination

* Req 0 is not very precise and there is several option to implement it, but introducing Movie object will be a huge benefit for the next requirement.
* Req 1 is tougher as you will discover lots of problems, hence lots of refactoring on top of the requirement itself

To help you, some hints are available in the requirements, but don't hesitate to ask for more.

As hiring a PO was too expensive, and his job can't be too complicated, the owner of the shop will be your PO for the day.


___

 ##  Requirement 0 : Refactor and introduce Movie concept 


<div style="display: flex; align-items: center;">
<img src="../media/movies.jpg" alt="Example image" width="80" height="80" style="margin-right: 10px;"/>
<p style="margin-bottom: 0; margin-top: 0;">The future is in content... so the business doesn't know the difference between a DVD and a VideoTape... everything you can watch will now be a Movie !
All next requirements will be for Movies from now on</p>
</div>

 <br>
<details> <summary>Hint</summary>
Movie could be a new interface,or a new abstract class, you may also need a new enum for the type of movie (DVD, VideoTape).
This is a good opportunity to get rid of all the petty details slowing you down:

* Confusing names
* Lack of unit-tests
* Language barrier
</details>

___

 ## Requirement 1 : new pricing logic


<div style="display: flex; align-items: center;">
<img src="../media/money.jpg" alt="Example image" width="80" height="80" style="margin-right: 10px;"/>
<p style="margin-bottom: 0; margin-top: 0;"> We're running out of business because we're not making enough money! 
 We're gonna change the way we price :
 The quality of a DVD will drop down with each renting..... so the value should decrease as well.</p>
</div>

 ### Here are the pricing rules :

 * Price for a DVD = 10 if it was released more than 10 years ago
 * Actual logic other case , max price is 23 for any movie
 * Oh, and I'm a huge fan of Tom Cruise, every movie is a masterpiece ! Then price when Tom is within a movie should be 15
 
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

<details> <summary>Hint</summary>
Add unit-test for the existing and the new pricing rules. I'm not sure the owner realized some of his instructions are contradictory...
</details>
