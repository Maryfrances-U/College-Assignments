from flask import Flask, request
app = Flask(__name__)

@app.route('/')
def default():
	return f"Hello World", 200

@app.route("/hello", defaults = {'name': 'Stranger'}, methods =["GET"])
@app.route("/hello/<string:name>", methods = ["GET"])
def hello(name):
	return f"Hello {name}!"

@app.route('/goodbye', defaults = {'name': 'Stranger'}, methods =["GET"])
@app.route('/goodbye/<string:name>', methods =["GET"])
def goodbye(name):
	return f"Goodbye {name}!", 200


app.run()