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

## Dictionaries

## Simulation

## Fill-in-the-blanks

## Method Resolution Order

## GUIs

## Recursion (Q37)

## Complexity (Q38-39)

This one's a bit long, so there's a discussion in the file `time_complexity.md`,
and in the course notes.

## Lambdas, List comprehensions (Q40)
