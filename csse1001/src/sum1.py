def sum1(xs):
    n = len(xs)
    if n == 0:
        return 0
    else:
        m = n / 2  # $m = \floor{\frac{n}{2}}$
        return sum1(xs[:m]) + sum1(xs[m:])
