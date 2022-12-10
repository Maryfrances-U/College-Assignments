from flask import Flask, request
import random
app = Flask(__name__)
#The __name__ variable passed to the Flask class is a Python predefined variable, which is set to the name of the module in which it is used.

@app.route('/')
def default():
	return f"You didn't give me a request", 200


@app.route('/add', methods =["GET"])
def add():
	num1 = int(request.args.get("x", 0))	#default set to 0 ie if user enters only y, x = 0
	num2 = int(request.args.get("y", 0))	#default set to 0 ie if user enters only x, y = 0
	sum = num1+num2
	return f"The sum is {sum}", 200

@app.route('/multiply', methods =["GET"])
def nultiply():
	num1 = int(request.args.get('x', 1))	#default set to 1
	num2 = int(request.args.get('y', 1))	#default set to 1
	product = num1*num2
	return f"The product is {product}", 200

@app.route('/lotto', methods =["GET"])
def lotto():
	#try string concatenation
	k = int(request.args.get('k', 0))	#default set to 0
	n = int(request.args.get('n', 0))	#default set to 0
	if k >= n:
		return f"Invalid Value Submission", 422
	
	set = random.sample(range(1, n), k)
	return f"{set}", 200

app.run()