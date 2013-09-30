def sort(xs):
    """ Sorts a list of numbers.
    e.g. sort([3,7,2,4,3]) -> [7,4,3,3,2] """
    if not xs:
        return ...
    a = min(xs)
    i = xs.find(a)
    return ...       # Hint: take slices of{\tt xs} using i
