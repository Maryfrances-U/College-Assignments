import json
from flask import Flask, render_template

app = Flask(__name__)

# https://flask.palletsprojects.com/en/1.0.x/api/#flask.Flask.open_resource
with app.open_resource("users.json", 'r') as fin:
	users = json.load(fin)

@app.route("/users/<int:uid>")
def raw(uid):
	user = users.get(str(uid), "none")
	
	if(user == "none"):
		return f"That user does not exist"

	friends = {}
	friendsJSON = user.get("friends")

	for i in friendsJSON:
		#friends[str(i)] = "http://127.0.0.1:5000/users/" + str(i)
		myFriend = users.get(str(i))
		friends[str(i)] = myFriend.get("fname")
		#print(friends[str(i)])

	return render_template("UserProfiles.html", user = user, friends = friends)


app.run()