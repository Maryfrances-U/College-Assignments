# Course: CSCI 450, Section 1
# Student Name: Maryfrances Umeora
# Student ID: 10820099
# Homework #6
# Due Date:
# In keeping with the Honor Code of UM, I have neither given nor received assistance
# from anyone other than the TA or the instructor.
# Program Description: Display all leap years in between (10 years per line) and the count of leap years


print("Enter a year: ")
year1 = gets.to_i
print("Enter another year: ")
year2 = gets.to_i

print("\nThe leap years in between are: \n")
num = 0 #variable to keep track of number of leap years

for year in year1..year2
    if (year % 4 == 0 && year % 100 != 0) || year % 400 == 0
        num = num+1
        print(year)
        print(" ")
        # print a new line for every tenth year
        if (num%10 == 0)
            print("\n")
        end
    end
end

# making sure to print exactly one line before final statement
if (num%10 != 0)
    print("\n")
end
printf("\nThe number of leap years is %d. \n", num)
