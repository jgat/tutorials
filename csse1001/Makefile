.PHONY: all

all: recursion.pdf

recursion.pdf: src/recursion.tex src/sum1.tex src/sum2.tex src/sort.tex src/sort_soln.tex src/hanoi.tex src/pyghead.tex
	pdflatex src/recursion.tex

src/sum1.tex: src/sum1.py
	pygmentize -O linenos,texcomments,mathescape -o src/sum1.tex src/sum1.py

src/sort_soln.tex: src/sort_soln.py
	pygmentize -O linenos,texcomments,mathescape -o src/sort_soln.tex src/sort_soln.py

src/sum2.tex: src/sum2.py
	pygmentize -O linenos,texcomments,mathescape -o src/sum2.tex src/sum2.py

src/sort.tex: src/sort.py
	pygmentize -O linenos,texcomments,mathescape -o src/sort.tex src/sort.py

src/hanoi.tex: src/hanoi.py
	pygmentize -O linenos,texcomments,mathescape -o src/hanoi.tex src/hanoi.py
