def sum2(xs):
    n = len(xs)
    if n == 0:
        return 0
    elif n == 1:
        return xs[0]
    else:
        m = n / 2
        return sum2(xs[:m]) + sum2(xs[m:])
