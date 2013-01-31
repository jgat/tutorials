# CSSE1001 Exam Walkthrough

<blockquote>
This document aims to give a walkthrough of content which has appeared on past
exams for CSSE1001. At the time of writing, the past ten CSSE1001 exams have
been very similar in nature, and students have found past exams to be good study
material.

There's no guarantee that the exam will stay in the same format, but if it does,
here's some of the important things to know.

This is not intended to be a complete list. For a complete set of assessable
content, see the official course material.
</blockquote>

## Basic Expressions (Q1-5)

The first few questions are always the easiest: "what's `7/2+1.0`?" Things to
watch out for include:

* Integer and floating point arithmetic, particularly division. Apply the order
  of operations; e.g. `7 / 2 + 1.0 == 3 + 1.0 == 4.0`.
* Operations on lists and strings: You can add two lists or two strings together,
  and multiply a list/string by an integer.
* The `int()`, `str()`, `list()`, etc. constructors. For instance, you can only
  call `list()` on an iterable object, like a string.

## Indexing and slicing

A few questions of the form "here is a string/list. How do I get this substring/
sublist?" A few simple things to remember here:

* Indexing and slicing count the start of the string as position 0.
* A slice takes from the start position, up to _but not including_ the end
  position. A backwards slice (e.g. `[_:_:-1]`) goes from the end back to but
  not including the start.

## String and list operations

* Just know things, like `str.split`, `str.split`, `str.join`, `list.append`, `list.pop`, etc. Also know what the optional arguments do.
* Be careful with list mutations, and remember that an assignment operation (e.g. `xs = xs[1:]`) is not a mutation. If a list is being mutated, keep track of other places that the list is being references.

## Dictionaries

Sometimes a question about facts you should know; and questions along the lines of "what is the result of this dictionary access?"

* Know facts about dictionaries, e.g. that dictionary keys must be immutable (as far as we're concerned in this course), and the values can be anything.
* Know how dictionary access (`my_dict['key']`) and the `.get` method work, including the optional second argument to `.get`.

## Simulation and list mutation

Questions of the form "Here is a function, what is the result of this function call?"

* All there is to it is putting in the inputs and evaluating each step of the function in your head (or on rough working paper if you need it). If you're not confident with this, some practice can help speed up your thinking.
* Again, be careful with things like list mutation.

## Fill-in-the-blanks

Questions that look like "Here's a function that's missing a couple of lines, what are they?"

Sometimes, the question will test your understanding of Python syntax: should you `print` or `return`? Should the variable name start with an `_` or not? Other times, the question will test a deeper understanding of what the code should be doing in the context of the function: what variable should you be updating (and why)? Or should you `break`/`continue`? Should there be a `+1` or a `-1` somewhere?

* It's good to try to grasp the approach the function takes. What do the variables in the function represent? What parts of the processing take place in the code that's already given?
* Take a look at the multiple choice options, sometimes they will be similar, and you may be able to figure out what is missing from the function.
* If you get stuck, try evaluating the partially complete function in your head with a small input, thinking about what you're evaluating and how you'll get to the expected result.

## Method Resolution Order

"Here are some classes that inherit from one another, what's the result of this method call?" It's very similar to one of the MyPyTutor tasks (so I hope you actually took the time to understand it, not just get the tutor to tell you the answer).

* The main thing to understand is which method actually gets run when the method call is made. The selection process is to look in the class that the object was created as, and if we can't find the method that's being called, look in its superclass, then the superclass' superclass, and so on.
* I've written about this in more detail, including examples, in the course notes.

## GUIs

## Recursion (Q37)

## Complexity (Q38-39)

This one's a bit long, so there's a discussion in the file [`time_complexity.md`](time_complexity.md),
and in the course notes.

## Lambdas, List comprehensions (Q40)


