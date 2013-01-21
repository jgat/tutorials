# Solving Time Compexity

<blockquote>
Comment: This was originally a newsgroup post I wrote in November 2011 to answer a student's question about time complexity questions on the exam. After this post, I wrote a more detailed discussion in the <a href="http://itee.uq.edu.au/~csse1001/_notes/complexity.html#calculating">course notes</a>, based on this one.
</blockquote>

_This document aims to show how to classify the time complexity of a function, as is usually required in CSSE1001 exams._

* If the function has no loops of any kind (this includes places where loops can be disguised, like a list comprehension or the builtin 'sorted' and 'max' functions), then it is __constant__ time.

* If the function has a single loop, or multiple loops that are not nested inside each other, then the running time is __linear__ in whatever is being looped over. For example, if the loop goes over every element (or most elements) in a list, or it is a while loop that counts from 1 to N. Something like

```python
for i in range(N):
    print i
```

* If the function has two nested loops inside each other, and the "size" of each loop is roughly proportional to the size of the input, then it is __quadratic__. For example, both of these are quadratic:

```python
for i in range(N):
    for j in range(N):
        do_something(i,j)
```

```python
for i in range(N):
    for j in range(i):
    do_something(i,j)
```

Note that the size of the inner loop in the second example is actually based on the loop variable in the outer loop (i), but 'i' is roughly proportional to N (with lots of hand-waving), so it's still quadratic.

* If the function is a recursive function that makes multiple recursive calls at each step, then it is __exponential__ . AFAIK (and you have access to all past exams, so you can check this yourself), complexity of recursive functions hasn't come up in past exams, so you might be safe without it, but here's an example:

```python
def fibonacci(n):
    if n in (1, 2):
        return 1
    return fibonacci(n-1) + fibonacci(n-2)
```

As a side note, if the function makes a _single_ recursive call at each step, then the running time is the number of recursive calls it takes to get to the base case, generally linear, e.g. this is linear:

```python
def triangle(n):
    if n == 1:
        return 1
    return n + triangle(n-1)
```

* If the function decreases its "remaining distance" (for want of a better term) by a multiple factor at each step, then it is __logarithmic__. For example, Q38 on 2010 Semester 1 has a 'low' and 'hi' that start off at opposite ends of the list, and at each step, one of  them moves half of the way between the two, which halves the 'distance left to search'. Q37 on 2009 Semester 2, at each step, the number n gets halved, which makes n 'twice as close to 0'. This idea of "halving at each step" is a common trait to logarithmic functions

