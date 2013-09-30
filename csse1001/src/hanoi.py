def hanoi(n):
    _hanoi_helper(n, 'A', 'C')

def _hanoi_helper(n, A, C):
    if n == 0:
        return
    _hanoi_helper(n-1, A, C)
    print A, "to B"
    _hanoi_helper(n-1, C, A)
    print "B to", C
    _hanoi_helper(n-1, A, C)
