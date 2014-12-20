Push 12/19 - Adrian

I chose to use a SQLite Database to store the Contact and Group objects. I read a lot about it, and there's definitely more than one way to save stuff. I don't know that much about all these options, even after reading, so I'm not sure what the best way is. I chose a database because I'm slightly familiar with them from the simple Python web stuff I did a month ago. Also, I'm pretty sure that the system uses a database to store contacts. One thing I noticed (I think this is right, not 100% sure), is that a database doesn't actually store the objects, it just stores their representations. So that made me wonder if we even need to create objects. Maybe we can just store their would-be fields in the database and read/write to them as necessary. Just an idea. If we go the route of saving the objects themselves, that's totally new to me.

So right now, if you run the app on your phone or an emulator, it should run with 5 screens to navigate:
1. Shows you a list of your contacts. You can click on which ones you want to keep in touch with. Click Next.
2. You're taken to a screen where you can either create a group or click done because you don't want to create one. If you click    done, it will take you to your "profile page," (#5) which should be empty because you didn't create any groups.
3. If you clicked "Create Group," it'll take you to this screen where you name your group.
4. Select contacts to add to the group you're creating.
5. Profile Page. If you've create a group, you should see the group's name on the screen. If you click on the group name, it       will toggle between showing the contacts in the group and hiding them.
