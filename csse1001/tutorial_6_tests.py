class A(object):
    """Class A
    This is the docstring for class A

    """

    def __init__(self, x):
        self._x = x

    def get_x(self):
        """Get the x attribute"""
        return self._x

    def set_x(self, new_x): # This is a comment
        """Update the x attribute"""
        self._x = new_x

def function():
    """This function is not a method."""
    return 0

class B(A):
        '''Class B, inherits from A.
        This is the docstring for class B. It uses triple ' quotes.

        '''
        # def method(self):

        def plus(x, y):
         """Do something"""
         x.set_x(x.get_x() + y)

        def __str__(self):
                return "I have value {0}".format(self.get_x())

class C(object):
    """ This class has no method definitions """
    three = 3

a = A(2)
print a.get_x() # 2
b = B(8.2)
b.plus(1.8)
print b         # I have value 10.0
print C.three   # 3
