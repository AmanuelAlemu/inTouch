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