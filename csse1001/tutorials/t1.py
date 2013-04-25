print "Intermediate:"

hours = 8 * 5
weekly_pay = 12 * hours
print weekly_pay, "dollars per week"

print "Advanced:"

def calculate_pay(hours, pay_rate):
    return hours * pay_rate

print calculate_pay(8 * 5, 12), "dollars per week"

print "Challenge:"

def calculate_tax(pay_rate):
    """Calculate the worker's tax, given their hourly pay rate

    calculate_tax(int/float) -> float
    """
    annual_pay = calculate_pay(40, pay_rate) * 52
    if annual_pay <= 6000:
        return 0.0
    elif annual_pay <= 37000:
        return 0.15 * (annual_pay - 6000)
    elif annual_pay <= 80000:
        return 4650 + 0.3 * (annual_pay - 37000)
    elif annual_pay <= 180000:
        return 17550 + 0.37 * (annual_pay - 80000)
    else:
        return 54550 + 0.45 * (annual_pay - 180000)

print "$12 / hour:", calculate_tax(12), "tax"
print "$20 / hour:", calculate_tax(20), "tax"
