all: practice.pdf

practice.pdf: practice.tex sample.tex
	pdflatex practice.tex

sample.tex: sample.java
	pygmentize -o sample.tex sample.java
