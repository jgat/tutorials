print "Introductory:"

str1 = 'a lie '
str2 = 'the cake '
str3 = 'is '

str4 = str2 + str3 + str1
print str4

print "Intermediate:"

def output_chars(n, string):
    for i, c in enumerate(string):
        if i % n == 0:
            print c

output_chars(3, 'Every third char')

print "Advanced:"

def get_number(text):
    """Get the first number out of a block of text
    
    get_number(str) -> int
    """
    digits = ""
    for c
