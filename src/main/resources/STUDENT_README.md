_Optional README file to write up your code explanation/reflection_

In addition to the comments in my code, a challenge I faced when i tested my code in main includeded the isComplete() method when checking if total number of carts got changed when breakfast Essential and Dormrun were returned. I realized it only returned 1 when it was supposed to return 2 total carts returned

This statement:

if (isCompleted() && missionComp == false)

in my return method was a critical part in my code. This if statement meant that a cart can only be returned if it was completed and it wasn't returned already. I realized that I forgot to set missionComp as true once it was confirmed that the ShoppingList was completed. Being able to narrow down the issues to a single issue helped me find out exactly where I went wrong. I also figured that I could simplify this statement and the missionComp == false is redundant since the missionComp I modified it now so it would be set to true under the isCompleted method.
