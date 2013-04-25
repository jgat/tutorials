print "Introductory:"

def calculate_power(n, p):
    result = 1
    while p > 0:
        result *= n
        p -= 1
    return result

print "2 ** 4 ==", calculate_power(2, 4)
print "3 ** 3 ==", calculate_power(3, 3)

print "Intermediate:"

def collatz(n):
    while n != 1:
        print str(n) + ',',
        if n % 2 == 0:
            n = n / 2
        else:
            n = 3 * n + 1
    print n

print "collatz(17):"
collatz(17)

def collatz_length(n):
    length = 1
    while n != 1:
        length += 1
        if n % 2 == 0:
            n = n / 2
        else:
            n = 3 * n + 1
    return length

print "Length", collatz_length(17)

print "Advanced:"

best_length = 0
n = 1
while n <= 150:
    length = collatz_length(n)
    if length > best_length:
        best_length = length
        best_start = n
    n += 1

print "Starting with", best_start, "gives a sequence of length", best_length
