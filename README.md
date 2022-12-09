# Phone-Book
Program that reads a text file with first and last names, and a phone number. After reading the file a Person class record is created
for each 'person' in the text file. The Person record contains the first and last name and phone nubmer.

The PhoneDirectory class contains 3 different TreeMaps, a HashMap that is sorted according to the natural ordering of its keys. One for first names,
another for last names, and one more for phone numbers. The Key-Value pair for each TreeMap is a String and a Set<Person> respectively.

The idea is when you search up a person by either of the 3 parameters, the program returns all the people that have those parameters.
So if you search by first name "Adam", it will return all the people that have Adam as their first name and the people whose first 4 letters of their first
name are "Adam".
