inTouch
=======
MainActivity, UserProfile, and Group.java all go in the same directory: src/com/example/intouch.
Layout folder goes in /res.
divider.xml also goes in res. Put one copy in each of the 5 drawable folders

I commented the important bits of code, I hope it helps.

UserProfile and Group are classes I created. It's the structure that comes to mind when I think of them, but they could be changed if it doesn't work out. In android apps apparently a thing that happens a lot is linking class files with activity files. I haven't done that, but we'll see if we have to when the time comes I guess. 

Output is a screenshot of what it looks like on my phone when I run it. If only I could make a video of me scrolling through it instead of having to take a picture. Alas, Google is a cunt.



Push #2 11/26 
Updated MainActivity, added drawables, updated Layout

Made changes to MainActivity:
Replace your MainActivity with the one in this update.
Added reactions to clicking and tapping the contacts. When you tap them they should toggle between a plus sign
and a checkmark.

Added checkmark and plus icons.

I think it's easier to just copy the whole res folder into the project. Inside the inTouch project folder, just
replace the res folder with the one here. The checkmark and plus icons are in there and some other xml files.
Let me know if it doesn't work.

Push #3 11/27
Huge update to activity_main.xml
Replace the current one. Can be found in inTouch > res > layout

Push #4 12/9
Added a bunch of Java files for the different screens.
Added more layout xml files to go along with the new screens.
In MainActivity, I divided searchContacts() into two separate functions: searchContacts() and displayContacts(contactList) to make it easier to understand.

As usual, replace the "res" folder in eclipse with the one in this git. Take all the source java files and copy them to src/com/example/inTouch (or whatever you called your project).

The order of activites loaded as you go through the app is:
MainActivity -> CreateGroupActivity -> NameGroupActivity -> SelectContactsForGroup -> UserProfileActivity

The most important thing to note about this is that this setup is temporary. I only used it to get it to work and implement a very basic version of what it'll be like in the final product. There are several problems:

Problem 1:
In MainActivity, contacts are stored in a data structure, then sent to the other activities as they're needed along the way. Unfortunately, this means that if I save something in Activity1 (MainActivity), and I want to see that data in Activity5 (UserProfileActivity), I have to pack the data in Activity1 and unpack it in Activity2. Re-pack it in Activity2, unpack in Activity3, and so on (There might be a better way to implement this process, but that's how I did it). But no matter how you implement it, this approach doesn't allow for adding/removing contacts and groups because they're not saved anywhere. So to fix this we have to find out how to store stuff in the phone's memory, and we have to decide how we want to do it (Database, simple file, etc).

Problem 2:
I don't know how to call a function in one activity from a different activity. Specifically, both MainActivity and SelectContactsForGroup have a displayContacts function that does the exact same thing. The next button should be different, but there has to be a way to call the original displayContacts from SelectContactsForGroup while simultaneously overriding the nextButton handler. I looked for a while but eventually just copied the code because I couldn't figure it out. So fixing that would be dope.

Problem 3:
Efficiency. There's a very slight lag during the initial load of contacts from the database on my phone. It pulls 186 contacts, so ideally there wouldn't be any lag at all with so few contacts. I searched and searched for the fastest way and implemented a version of what I found, but in the end I'm still not 100% sure how the database query works, so I can't tell if it's the fastest it could be. I'm imagining a worst case scenario of 2000-4000 contacts. I think the lag should be AT MOST 1.5 seconds to be acceptable, and only if the number of contacts is that high. It should be instantaneous with 186 (assuming decent hardware). I hope that's possible. Definitely check on your phones and see if you notice lag.

That's all I remember right now, I'll let you know if I remember anything else. Ask me if something's not clear or not working. I think the first problem is the most important to solve next because it will dictate how we structure our app's code from here on out.

In sum, next steps:
Save contacts to phone memory somehow rather than passing the list activity by activity.
Find out how to call one activity's function from another
Make initial query more efficient
