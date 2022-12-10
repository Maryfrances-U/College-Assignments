import os
from datetime import date
from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)

# determine the directory of the script so that the sqlite database
# file can be referenced with a relative path ("library.db")
appdir = os.path.abspath(os.path.dirname(__file__))

# configure app’s database access
app.config["SQLALCHEMY_DATABASE_URI"] = \
    f"sqlite:///{os.path.join(appdir, 'library.db')}"
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False

# initialize the SQLAlchemy database adaptor
db = SQLAlchemy(app)

join = db.Table('join',
                db.Column('Author', db.Integer, db.ForeignKey('Author.id')),
                db.Column('Book', db.Integer, db.ForeignKey('Book.id')),
                )


class Author(db.Model):
    __tablename__ = "Author"
    id = db.Column(db.Integer(), primary_key=True, autoincrement=True)
    firstN = db.Column(db.Unicode(64), nullable=False)
    middleN = db.Column(db.Unicode(64), nullable=False)
    lastN = db.Column(db.Unicode(64), nullable=False)
    dob = db.Column(db.Date(), nullable=False)
    books = db.relationship('Book', secondary='join', backref=db.backref('Writer'))


class Book(db.Model):
    __tablename__ = "Book"
    id = db.Column(db.Integer(), primary_key=True, autoincrement=True)
    title = db.Column(db.Unicode(120), nullable=False)
    isbn = db.Column(db.Unicode(64))
    publisher = db.Column(db.Unicode(120))
    year = db.Column(db.Integer())
    writer_id = db.Column(db.Unicode(5), db.ForeignKey('Author.id'))


# drop any existing tables in the database
db.drop_all()

# create all the tables necessary according to my db.Model subclasses
db.create_all()

# define all of your books
book_1 = Book(title="Throne of Glass", isbn="1599906953", publisher="Bloomsbury", year=2012, writer_id="1")
book_2 = Book(title="A Court of Thorns and Roses", isbn="1408857863", publisher="Bloomsbury", year=2015, writer_id="1")
book_3 = Book(title="Mind Games", isbn="0061985864", publisher="HarperTeen", year=2013, writer_id="2")
book_4 = Book(title="Paranormalcy", isbn="1408857863", publisher="HarperTeen", year=2011, writer_id="2")
book_5 = Book(title="Illusions of Fate", isbn="0062135899", publisher="HarperTeen", year=2014, writer_id="2")
book_6 = Book(title="Heartless", isbn="1250148189", publisher="MacMillian", year=2016, writer_id="3")
book_7 = Book(title="The Spiderwick Chronicles", isbn="031631031X", publisher="LittleBrownBooks", year=2015,
              writer_id="4, 5")

# define all of your authors (pointing to books)
author_1 = Author(firstN="Sarah", middleN="J", lastN="Maas", dob=date(1986, 3, 5), books=[book_1, book_2])
author_2 = Author(firstN="Kiersten", middleN="K", lastN="White", dob=date(1983, 6, 27), books=[book_3, book_4, book_5])
author_3 = Author(firstN="Marissa", middleN="M", lastN="Meyer", dob=date(1984, 2, 19), books=[book_6])
author_4 = Author(firstN="Holly", middleN="H", lastN="Black", dob=date(1971, 11, 10), books=[book_7])
author_5 = Author(firstN="Tony", middleN="M", lastN="DiTerlizzi", dob=date(1969, 9, 6), books=[book_7])

# add all of these items to the database session
db.session.add_all([book_1, book_2, book_3, book_4, book_5, book_6, book_7])
db.session.add_all([author_1, author_2, author_3, author_4, author_5])

# commit these changes to the database
db.session.commit()

# Before you hand in your script, double check the contents of library.db to
# make sure that it matches the examples you added.
