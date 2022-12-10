import json
from flask import Flask, render_template, redirect, url_for, request

from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField, DateField
from wtforms.validators import DataRequired, Email
from datetime import datetime


app = Flask(__name__)
app.config["SECRET_KEY"] = "ThisIsHereCosINeedItNotBecauseIWantIt"

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


#class to update form
class UpdatedForm(FlaskForm): 
	fname = StringField("First Name", validators = [DataRequired()])
	lname = StringField("Last Name", validators = [DataRequired()])
	email = StringField("Email Address", validators = [DataRequired(), Email()])
	dob = DateField("Date of Birth", format='%Y-%m-%d', validators = [DataRequired()])
	submit = SubmitField("Submit")


#route
@app.route("/update/users/<int:uid>", methods = ['GET', 'POST'])
def update(uid):
	form = UpdatedForm()
	user = users.get(str(uid), "none")
	
	if(user == "none"):
		return f"That user does not exist"
	
	if request.method == "POST":
		if form.validate():
			user["fname"] = form.fname.data
			user["lname"] = form.lname.data
			user["email"] = form.email.data
			user["dob"] = str(form.dob.data)
			return redirect(url_for("raw", uid=uid))
		else:
			return "Invalid Form", 400
	else:
		print(user.get("fname"))
		form.fname.data = user.get("fname") 
		form.lname.data = user.get("lname")
		form.email.data = user.get("email")
		#form.dob.data = user.get("dob")
		form.dob.data = datetime.date(datetime.strptime(user.get("dob"), '%Y-%m-%d'))
		return render_template("UserEdit.html", form = form);
	


app.run()