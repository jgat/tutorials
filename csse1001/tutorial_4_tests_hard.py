''' To correctly parse the functions below, you'll need
    some more advanced parsing tricks which are beyond
    the scope of this course, so you can ignore these.
    But you might like to think about how you would
    correctly parse them. '''

def f6(a, (b, (c, d), e, f), g=0):
    "docstrings don't need triple quotes"
    return a + b + c + d + e + f + g

"""
def f7(x):
    """ # hello """

def \
   f8(a,
      b, # here is a comment
      c=4,    d={}, \
 e=None): pass
