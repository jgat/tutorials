"""Tutorial 4 Test cases

Your program should output this list:
[(13, 'identity', ('x',)),
 (17, 'print_', ('things1', things2')),
 (22, 'f1', ('a', 'b', 'c')),
 (32, 'f2', ()),
 (42, 'applicator', ('fs',)),
 (44, '_helper', ('*args', '**kwargs'))]

"""

def identity(x):
    """Return the given argument."""
    return x

def print_(things1, things2):
    "Print each of the things"
    for x, y in zip(things1, things2):
        print x, y

def    f1(a, b,   c):
    '''Return True if a < b < c.

    f1(int, int, int) -> boolean
    '''
    for i in range(a+1, c):
        if i == b:
            return True
    return False

def f2():
    string = """this is not a docstring"""
    return string

#def f3(x):

"def f4(x):"

def_ = "f5(x):"

def applicator(fs):
    """ the applicator function """
    def _helper(*args, **kwargs):
        """ the helper function """
        for f in fs: yield f(*args, **kwargs)
    return _helper

''' To correctly parse the functions below, you'll need
    some more advanced parsing tricks which are beyond
    the scope of this course, so you can ignore these.
    But you might like to think about how you would
    correctly parse them. '''

def f6(a, (b, (c, d), e, f), g=0):
    return a + b + c + d + e + f + g

"""
def f7(x):
    """ # hello """

def \
   f8(a,
      b, # here is a comment
      c=4,    d={}, \
 e=None): pass